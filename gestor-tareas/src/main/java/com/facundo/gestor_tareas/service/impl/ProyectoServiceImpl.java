package com.facundo.gestor_tareas.service.impl;

import org.springframework.stereotype.Service;

import com.facundo.gestor_tareas.service.ProyectoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor;
public class ProyectoServiceImpl implements ProyectoService {
    
    private final ProyectoRepository proyectoRepository;
}
