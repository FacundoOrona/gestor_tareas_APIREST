package com.facundo.gestor_tareas.service.impl;

import org.springframework.stereotype.Service;
import com.facundo.gestor_tareas.service.ProyectoService;
import lombok.RequiredArgsConstructor;
import com.facundo.gestor_tareas.repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor;
public class ProyectoServiceImpl implements ProyectoService {
    
    private final ProyectoRepository proyectoRepository;

    @Override
    public List<Proyecto> obtenerTodos() {
        return proyectoRepository.findAll();
    }

    @Override

}
