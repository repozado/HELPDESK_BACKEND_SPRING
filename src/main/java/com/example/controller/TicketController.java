package com.example.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Ticket;
import com.example.models.TicketStatus;
import com.example.models.Usuario;
import com.example.repo.ITicketRepo;
import com.example.repo.ITicketStatusRepo;
import com.example.repo.IUsuarioRepo;
import com.example.service.ITicketService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ticket")
public class TicketController {
	@Autowired
	private ITicketService service;
	
	@Autowired
	private ITicketRepo ticketRepository;
	
	@Autowired
	private IUsuarioRepo usuarioRepository;
	
	@Autowired
	private ITicketStatusRepo ticketStatusRepository;
	
	@GetMapping
	public ResponseEntity<List<Ticket>> getAllTicket(){
		List<Ticket> ticket = service.getAll();
		return new ResponseEntity<List<Ticket>>(ticket, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Ticket>> getTicket(@PathVariable("id") Integer id){
		Optional<Ticket> ticket = service.findById(id);
		return new ResponseEntity<Optional<Ticket>>(ticket, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
		Ticket createticket = service.create(ticket);
		return new ResponseEntity<Ticket>(createticket, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Ticket> updateTicket(@PathVariable("id") Integer id,@RequestBody Ticket ticket){
		// Obtener el ticket actual para verificar si cambió el usuario asignado
		Optional<Ticket> ticketActual = service.findById(id);
		
		if (ticketActual.isPresent()) {
			Ticket ticketExistente = ticketActual.get();
			
			// Si cambió el usuario_asignado, guardar quien lo asignó (usuario_asigno)
			if (ticket.getUsuario_asignado() != null && 
			    (ticketExistente.getUsuario_asignado() == null || 
			     !ticketExistente.getUsuario_asignado().getIdUsuario().equals(ticket.getUsuario_asignado().getIdUsuario()))) {
				
				// El usuario_asigno viene del frontend (el admin que está en sesión)
				// El frontend debe enviar ticket.usuario_asigno con el ID del admin logueado
				if (ticket.getUsuario_asigno() != null) {
					Usuario admin = usuarioRepository.findById(ticket.getUsuario_asigno().getIdUsuario()).orElse(null);
					ticket.setUsuario_asigno(admin);
				}
			} else {
				// Si no cambió la asignación, mantener el usuario_asigno original
				ticket.setUsuario_asigno(ticketExistente.getUsuario_asigno());
			}
		}
		
		Ticket updateticket = service.update(id,ticket);
		return new ResponseEntity<Ticket>(updateticket, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTicket(@PathVariable("id") Integer id) {
	    try {
	        service.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	// ==================== NUEVOS ENDPOINTS PARA CONTROL DE ROLES ====================

	/**
	 * Obtener tickets por usuario según su rol
	 * - ADMIN: Todos los tickets
	 * - AGENTE: Solo tickets asignados a él
	 * - CLIENTE: Solo tickets creados por él
	 */
	@GetMapping("/user/{idUsuario}")
	public ResponseEntity<?> getTicketsByUser(@PathVariable Integer idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
		
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<String> roles = usuario.getUsuarioRoles().stream()
			.map(ur -> ur.getRol().getNombre())
			.collect(Collectors.toList());
		
		List<Ticket> tickets;
		
		if (roles.contains("ADMIN")) {
			// Admin ve todos
			tickets = ticketRepository.findAll();
		} else if (roles.contains("AGENTE")) {
			// Agente ve solo sus asignados
			tickets = ticketRepository.findByUsuarioAsignado(usuario);
		} else if (roles.contains("CLIENTE")) {
			// Cliente ve solo los que creó
			tickets = ticketRepository.findByUsuarioCreador(usuario);
		} else {
			tickets = new ArrayList<>();
		}
		
		return ResponseEntity.ok(tickets);
	}

	/**
	 * Obtener tickets pendientes del usuario
	 */
	@GetMapping("/pending/user/{idUsuario}")
	public ResponseEntity<?> getTicketsPendientes(@PathVariable Integer idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
		
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<String> roles = usuario.getUsuarioRoles().stream()
			.map(ur -> ur.getRol().getNombre())
			.collect(Collectors.toList());
		
		Optional<TicketStatus> statusAbierto = ticketStatusRepository.findByNombre("ABIERTO");
		List<Ticket> tickets;
		
		if (statusAbierto.isEmpty()) {
			return ResponseEntity.ok(new ArrayList<>());
		}
		
		if (roles.contains("ADMIN")) {
			tickets = ticketRepository.findByStatus(statusAbierto.get());
		} else if (roles.contains("AGENTE")) {
			tickets = ticketRepository.findByUsuarioAsignadoAndStatus(usuario, statusAbierto.get());
		} else if (roles.contains("CLIENTE")) {
			tickets = ticketRepository.findByUsuarioCreadorAndStatus(usuario, statusAbierto.get());
		} else {
			tickets = new ArrayList<>();
		}
		
		return ResponseEntity.ok(tickets);
	}

	/**
	 * Obtener tickets resueltos del usuario
	 */
	@GetMapping("/resolved/user/{idUsuario}")
	public ResponseEntity<?> getTicketsResueltos(@PathVariable Integer idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
		
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<String> roles = usuario.getUsuarioRoles().stream()
			.map(ur -> ur.getRol().getNombre())
			.collect(Collectors.toList());
		
		Optional<TicketStatus> statusCerrado = ticketStatusRepository.findByNombre("CERRADO");
		List<Ticket> tickets;
		
		if (statusCerrado.isEmpty()) {
			return ResponseEntity.ok(new ArrayList<>());
		}
		
		if (roles.contains("ADMIN")) {
			tickets = ticketRepository.findByStatus(statusCerrado.get());
		} else if (roles.contains("AGENTE")) {
			tickets = ticketRepository.findByUsuarioAsignadoAndStatus(usuario, statusCerrado.get());
		} else if (roles.contains("CLIENTE")) {
			tickets = ticketRepository.findByUsuarioCreadorAndStatus(usuario, statusCerrado.get());
		} else {
			tickets = new ArrayList<>();
		}
		
		return ResponseEntity.ok(tickets);
	}

	/**
	 * Obtener tickets asignados a un agente
	 */
	@GetMapping("/assigned/{idAgente}")
	public ResponseEntity<?> getTicketsAsignados(@PathVariable Integer idAgente) {
		Usuario agente = usuarioRepository.findById(idAgente).orElse(null);
		
		if (agente == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<Ticket> tickets = ticketRepository.findByUsuarioAsignado(agente);
		return ResponseEntity.ok(tickets);
	}

	/**
	 * Obtener tickets creados por un usuario
	 */
	@GetMapping("/created/{idUsuario}")
	public ResponseEntity<?> getTicketsCreados(@PathVariable Integer idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
		
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<Ticket> tickets = ticketRepository.findByUsuarioCreador(usuario);
		return ResponseEntity.ok(tickets);
	}

	/**
	 * Obtener agente con menos carga de trabajo
	 */
	@GetMapping("/agent/least-loaded")
	public ResponseEntity<?> getAgenteConMenosCarga() {
		Optional<TicketStatus> statusAbierto = ticketStatusRepository.findByNombre("ABIERTO");
		
		List<Usuario> agentes = usuarioRepository.findAll().stream()
			.filter(u -> u.getUsuarioRoles().stream()
				.anyMatch(ur -> ur.getRol().getNombre().equals("AGENTE")))
			.collect(Collectors.toList());
		
		if (agentes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(Map.of("message", "No hay agentes disponibles"));
		}
		
		final TicketStatus status = statusAbierto.orElse(null);
		Usuario agenteMenosCarga;
		
		if (status != null) {
			agenteMenosCarga = agentes.stream()
				.min(Comparator.comparingInt(a -> 
					ticketRepository.countByUsuarioAsignadoAndStatus(a, status)))
				.get();
		} else {
			agenteMenosCarga = agentes.get(0);
		}
		
		return ResponseEntity.ok(agenteMenosCarga);
	}

	/**
	 * Obtener agentes disponibles
	 */
	@GetMapping("/agents/available")
	public ResponseEntity<?> getAgentesDisponibles() {
		List<Usuario> agentes = usuarioRepository.findAll().stream()
			.filter(u -> u.getUsuarioRoles().stream()
				.anyMatch(ur -> ur.getRol().getNombre().equals("AGENTE")))
			.collect(Collectors.toList());
		
		return ResponseEntity.ok(agentes);
	}

	/**
	 * Obtener tickets sin asignar
	 */
	@GetMapping("/unassigned")
	public ResponseEntity<?> getTicketsSinAsignar() {
		List<Ticket> tickets = ticketRepository.findByUsuarioAsignadoIsNull();
		return ResponseEntity.ok(tickets);
	}
}
