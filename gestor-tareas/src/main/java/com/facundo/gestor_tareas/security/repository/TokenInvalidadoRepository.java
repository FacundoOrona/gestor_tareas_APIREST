package com.facundo.gestor_tareas.security.repository;

import com.facundo.gestor_tareas.security.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenInvalidadoRepository extends JpaRepository<TokenInvalidado, Long> {
    boolean existsByToken(String token);
}
