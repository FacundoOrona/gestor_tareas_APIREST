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

    @GetMapping
    public List<Proyecto> obtenerTodos() {
        return proyectoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> obtenerPorId(@PathVariable Long id) {
        return proyectoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto) {
        return proyectoService.crearProyecto(proyecto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        try {
            Proyecto actualizado = proyectoService.actualizarProyecto(id, proyecto);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
