package com.facundo.gestor_tareas.service;

import com.facundo.gestor_tareas.entities.Proyecto;

import java.util.List;
import java.util.Optional;

public interface ProyectoService {
    List<Proyecto> obtenerTodos();
    Optional<Proyecto> obtenerPorId(Long id);
    Proyecto crearProyecto(Proyecto proyecto);
    Proyecto actualizarProyecto(Long id, Proyecto proyectoActualizado);
    List<Proyecto> obtenerProyectosDelUsuario(String email);
}
