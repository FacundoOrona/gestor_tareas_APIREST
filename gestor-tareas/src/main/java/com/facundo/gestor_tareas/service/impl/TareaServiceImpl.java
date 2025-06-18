package com.facundo.gestor_tareas.service.impl;

import com.facundo.gestor_tareas.entities.Tarea;
import com.facundo.gestor_tareas.repository.TareaRepository;
import com.facundo.gestor_tareas.service.TareaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TareaServiceImpl implements TareaService {
    
    private final TareaRepository tareaRepository;

    @Override
    public List<Tarea> obtenerTodas() {
        return tareaRepository.findAll();
    }

    @Override  
    public Optional<Tarea> obtenerPorId(Long id) {
        return tareaRepository.findById(id);
    }

    @Override
    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public Tarea actualizarTarea(Long id, Tarea tareaActualizada) {
        return tareaRepository.findById(id)
                .map(tareaExistente -> {
                if(tareaActualizada.getTitulo() != null && !tareaActualizada.getTitulo().isBlank()){
                    tareaExistente.setTitulo(tareaActualizada.getTitulo());
                }
                if (tareaActualizada.getDescripcion() != null && !tareaActualizada.getDescripcion().isBlank()) {
                    tareaExistente.setDescripcion(tareaActualizada.getDescripcion());
                }
                if (tareaActualizada.getEstado() != null) {
                    tareaExistente.setEstado(tareaActualizada.getEstado());
                }
                if (tareaActualizada.getPrioridad() != null) {
                    tareaExistente.setPrioridad(tareaActualizada.getPrioridad());
                }
                if (tareaActualizada.getFechaLimite() != null) {
                    tareaExistente.setFechaLimite(tareaActualizada.getFechaLimite());
                }
                if (tareaActualizada.getResponsable() != null) {
                    tareaExistente.setResponsable(tareaActualizada.getResponsable());
                }
                if (tareaActualizada.getProyecto() != null) {
                    tareaExistente.setProyecto(tareaActualizada.getProyecto());
                }
                return tareaRepository.save(tareaExistente);
                })
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }
}
