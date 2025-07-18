package com.facundo.gestor_tareas.service.impl;

import org.springframework.stereotype.Service;
import com.facundo.gestor_tareas.service.ProyectoService;
import lombok.RequiredArgsConstructor;
import com.facundo.gestor_tareas.repository.ProyectoRepository;
import com.facundo.gestor_tareas.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;
import com.facundo.gestor_tareas.entities.Proyecto;
import com.facundo.gestor_tareas.entities.Usuario;

@Service
@RequiredArgsConstructor
public class ProyectoServiceImpl implements ProyectoService {
    
    private final ProyectoRepository proyectoRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Proyecto> obtenerTodos() {
        return proyectoRepository.findAll();
    }

    @Override
    public Optional<Proyecto> obtenerPorId(Long id) {
        return proyectoRepository.findById(id);
    }

    @Override
    public Proyecto crearProyecto(Proyecto proyecto, String emailCreador) {
        Usuario creador = usuarioRepository.findByEmail(emailCreador)
                .orElseThrow(() -> new RuntimeException("Usuario creador no encontrado: " + emailCreador));
        
        proyecto.setCreador(creador);
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto actualizarProyecto(Long id, Proyecto proyectoActualizado) {
        return proyectoRepository.findById(id)
                .map(proyectoExistente -> {
                    if (proyectoActualizado.getNombre() != null && !proyectoActualizado.getNombre().isBlank()) {
                        proyectoExistente.setNombre(proyectoActualizado.getNombre());  
                    }
                    if (proyectoActualizado.getDescripcion() != null && !proyectoActualizado.getDescripcion().isBlank()) {
                    proyectoExistente.setDescripcion(proyectoActualizado.getDescripcion());
                    }
                    return proyectoRepository.save(proyectoExistente);
                })
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
    }

    @Override
    public List<Proyecto> obtenerProyectosDelUsuario(String email){
        return proyectoRepository.findByCreadorEmail(email);
    }

}
