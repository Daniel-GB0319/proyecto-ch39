package com.codegaiden.barro_on.service;

import com.codegaiden.barro_on.model.Usuario;
import com.codegaiden.barro_on.repository.UsuarioRepository;

import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        // Comprobar si el correo ya existe en la base de datos
        Usuario existingUsuario = usuarioRepository.findByCorreo(usuario.getCorreo());
        if (existingUsuario != null) {
            // Si el correo ya existe, lanzar una excepción o devolver null
            throw new IllegalArgumentException("El correo ya existe");
        }

        String contrasenaHash = hashPassword(usuario.getContrasena());
        usuario.setContrasena(contrasenaHash);

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

    // Login de un usuario
    public Long login(String correo, String contrasenaIngresada) {
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        if (usuario != null && checkPassword(contrasenaIngresada, usuario.getContrasena())) {
            return usuario.getId();
        }
        return null;
    }

    // Método para crear el hash de la contraseña
    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Metodo para comparar contraseñas en login
    private boolean checkPassword(String contrasenaIngresada, String contrasenaHash) {
        String contrasenaIngresadaHash = hashPassword(contrasenaIngresada);
        return contrasenaIngresadaHash.equals(contrasenaHash);
    }

}