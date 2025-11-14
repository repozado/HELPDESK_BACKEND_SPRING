package com.example.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.models.Ticket;
import com.example.models.TicketStatus;
import com.example.models.Usuario;

public interface ITicketRepo extends JpaRepository<Ticket, Integer> {
    
    @Query("SELECT t FROM Ticket t WHERE t.usuario_asignado = :usuario")
    List<Ticket> findByUsuarioAsignado(@Param("usuario") Usuario usuario);
    
    @Query("SELECT t FROM Ticket t WHERE t.usuario_creador = :usuario")
    List<Ticket> findByUsuarioCreador(@Param("usuario") Usuario usuario);
    
    List<Ticket> findByStatus(TicketStatus status);
    
    @Query("SELECT t FROM Ticket t WHERE t.usuario_asignado = :usuario AND t.status = :status")
    List<Ticket> findByUsuarioAsignadoAndStatus(@Param("usuario") Usuario usuario, @Param("status") TicketStatus status);
    
    @Query("SELECT t FROM Ticket t WHERE t.usuario_creador = :usuario AND t.status = :status")
    List<Ticket> findByUsuarioCreadorAndStatus(@Param("usuario") Usuario usuario, @Param("status") TicketStatus status);
    
    @Query("SELECT t FROM Ticket t WHERE t.usuario_asignado IS NULL")
    List<Ticket> findByUsuarioAsignadoIsNull();
    
    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.usuario_asignado = :usuario AND t.status = :status")
    int countByUsuarioAsignadoAndStatus(@Param("usuario") Usuario usuario, @Param("status") TicketStatus status);
}
