package com.facundo.gestor_tareas.security.auth;

import lombok.*;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String nombre;
}

