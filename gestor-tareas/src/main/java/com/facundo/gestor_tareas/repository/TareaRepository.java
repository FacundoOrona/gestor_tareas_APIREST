package com.facundo.gestor_tareas.repository;

import com.facundo.gestor_tareas.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface TareaRepository extends JpaRepository<Tarea, Long> { 
    
    List<Tarea> findByProyecto(Proyecto proyecto);

    List<Tarea> findByResponsable(Usuario responsable);

    List<Tarea> findByEstado(Tarea.Estado estado);

    List<Tarea> findByPrioridad(Tarea.Prioridad prioridad);
}
