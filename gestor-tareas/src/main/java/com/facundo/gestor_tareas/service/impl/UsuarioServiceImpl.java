package com.facundo.gestor_tareas.service.impl;

import com.facundo.gestor_tareas.entities.Usuario;
import com.facundo.gestor_tareas.repository.UsuarioRepository;
import com.facundo.gestor_tareas.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
    return usuarioRepository.findById(id)
            .map(usuarioExistente -> {
                if (usuarioActualizado.getNombre() != null && !usuarioActualizado.getNombre().isBlank()) {
                    usuarioExistente.setNombre(usuarioActualizado.getNombre());
                }
                if (usuarioActualizado.getEmail() != null && !usuarioActualizado.getEmail().isBlank()) {
                    usuarioExistente.setEmail(usuarioActualizado.getEmail());
                }
                if (usuarioActualizado.getContraseña() != null && !usuarioActualizado.getContraseña().isBlank()) {
                    usuarioExistente.setContraseña(usuarioActualizado.getContraseña());
                }
                if (usuarioActualizado.getRol() != null) {
                    usuarioExistente.setRol(usuarioActualizado.getRol());
                }

                return usuarioRepository.save(usuarioExistente);
            })
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    @Override
    public void eliminarUsuario(Long id) {
        if(!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no existente con el ID: " + id); 
        }
        usuarioRepository.deleteById(id);
    }
    
}