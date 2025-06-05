package com.facundo.gestor_tareas.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(unique = true)
    private String email;

    private String contraseña;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public enum Rol {
        ADMIN,
        MIEMBRO
    }
    
}
