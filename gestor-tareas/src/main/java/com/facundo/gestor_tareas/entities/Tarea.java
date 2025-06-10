package com.facundo.gestor_tareas.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tareas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;

    private LocalDate fechaLimite;

    private String etiquetas;

    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private Usuario responsable;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    @JsonBackReference
    private Proyecto proyecto;

    /*
     * @ManyToOne
     * 
     * @JoinColumn(name = "proyecto_id")
     * private Proyecto proyecto;
     */

    public enum Estado {
        PENDIENTE,
        EN_PROGRESO,
        FINALIZADA,
    }

    public enum Prioridad {
        BAJA,
        MEDIA,
        ALTA,
    }

}
