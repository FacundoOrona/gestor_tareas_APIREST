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
    
}
