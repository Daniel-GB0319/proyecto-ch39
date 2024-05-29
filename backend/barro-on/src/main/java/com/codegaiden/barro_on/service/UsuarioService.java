package com.codegaiden.barro_on.service;

import com.codegaiden.barro_on.model.Usuario;
import com.codegaiden.barro_on.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Funcionalidad de las distintas peticiones
@Service
public class UsuarioService {
    // Inyectamos el repositorio de Usuario
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios de la base de datos
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Crear un nuevo usuario
    public Usuario postUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Obtener un usuario por su id
    public Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // Actualizar un usuario por su id
    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        // Verifica que el usuario exista
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            // Usuario existe y actualiza sus datos
            usuario.setNombre(usuarioDetails.getNombre());
            usuario.setApPaterno(usuarioDetails.getApPaterno());
            usuario.setApMaterno(usuarioDetails.getApMaterno());
            usuario.setSexo(usuarioDetails.getSexo());
            usuario.setFecNac(usuarioDetails.getFecNac());
            usuario.setCorreo(usuarioDetails.getCorreo());
            usuario.setContrasena(usuarioDetails.getContrasena());
            usuario.setTelefono(usuarioDetails.getTelefono());
            usuario.setTipoUsuario(usuarioDetails.getTipoUsuario());
            return usuarioRepository.save(usuario);
        }
        // Retorna null si el usuario no existe
        return null;
    }

    // Eliminar un usuario por su id
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
