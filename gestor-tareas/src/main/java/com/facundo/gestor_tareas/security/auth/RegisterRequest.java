package com.facundo.gestor_tareas.security.auth;

import lombok.Data;

@Data
public class RegisterRequest {
    private String nombre;
    private String email;
    private String contraseña;    
}
