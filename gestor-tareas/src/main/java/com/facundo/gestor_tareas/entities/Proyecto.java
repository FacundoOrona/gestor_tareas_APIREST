package com.facundo.gestor_tareas.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "proyectos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Tarea> tareas;

    @ManyToOne
    @JoinColumn(name = "creador_id")
    private Usuario creador;


}
