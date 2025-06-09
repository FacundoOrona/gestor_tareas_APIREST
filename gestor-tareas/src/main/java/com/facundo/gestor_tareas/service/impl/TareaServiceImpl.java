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

}
