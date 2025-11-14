package com.example.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.models.Usuario;
import com.example.service.IUsuarioService;
import com.example.repo.IUsuarioRepo;
import com.example.dto.LoginRequest;
import com.example.dto.LoginResponse;
import com.example.dto.ErrorResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService service;
    
    @Autowired
    private IUsuarioRepo usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = service.getAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> getUsuario(@PathVariable("id") Integer id) {
        Optional<Usuario> usuario = service.findById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario nuevo = service.create(usuario);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
        Usuario actualizado = service.update(id, usuario);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // 1. Buscar usuario por email
            Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(loginRequest.getEmail());
            
            if (usuarioOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse("Usuario o contraseña incorrectos"));
            }
            
            Usuario usuario = usuarioOpt.get();
            
            // 2. Validar contraseña
            // IMPORTANTE: En producción usa BCrypt.matches()
            // Por ahora comparamos directo (SOLO PARA DESARROLLO)
            if (!usuario.getClave().equals(loginRequest.getClave())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse("Usuario o contraseña incorrectos"));
            }
            
            // 3. Obtener roles del usuario
            List<String> roles = usuario.getUsuarioRoles().stream()
                .map(ur -> ur.getRol().getNombre())
                .collect(Collectors.toList());
            
            // 4. Retornar datos del usuario con roles
            LoginResponse response = new LoginResponse(
                usuario.getIdUsuario(),
                usuario.getEmail(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getEstado(),
                roles
            );
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("Error en el servidor: " + e.getMessage()));
        }
    }
}
