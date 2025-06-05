package com.facundo.gestor_tareas.security.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String contraseña;
}
