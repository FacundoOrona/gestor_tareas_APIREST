package com.facundo.gestor_tareas.controller;

import com.facundo.gestor_tareas.entities.Proyecto;
import com.facundo.gestor_tareas.service.ProyectoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
@RequiredArgsConstructor
public class ProyectoController {

    private final ProyectoService proyectoService;  
    
}
