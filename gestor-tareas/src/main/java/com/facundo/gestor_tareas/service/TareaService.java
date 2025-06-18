package com.facundo.gestor_tareas.service;

import com.facundo.gestor_tareas.entities.Tarea;
import java.util.List;
import java.util.Optional;

public interface TareaService {
    List<Tarea> obtenerTodas();
    Optional<Tarea> obtenerPorId(Long id);
    Tarea crearTarea(Tarea tarea);
    Tarea actualizarTarea(Long id, Tarea tareaActualizada);
}
