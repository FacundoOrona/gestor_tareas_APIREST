package com.facundo.gestor_tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.facundo.gestor_tareas.entities.Proyecto;


public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

}
