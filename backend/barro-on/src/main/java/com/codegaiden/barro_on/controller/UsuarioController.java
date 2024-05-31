package com.codegaiden.barro_on.controller;

import com.codegaiden.barro_on.model.LoginData;
import com.codegaiden.barro_on.model.Usuario;
import com.codegaiden.barro_on.service.UsuarioService;
import com.fasterxml.jackson.annotation.JsonView;

import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

// Rutas para las diferentes peticiones de Usuarios
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    // Inyectamos los servicios de Usuarios
    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    @JsonView(Usuario.VistaGet.class)
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    // Crear un nuevo usuario
    @PostMapping
    @JsonView(Usuario.VistaPostPut.class)
    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario createdUsuario = usuarioService.postUsuario(usuario);
            return new ResponseEntity<>(createdUsuario, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("El correo ya existe", HttpStatus.CONFLICT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener un usuario por id
    @GetMapping("/{id}")
    @JsonView(Usuario.VistaGet.class)
    public ResponseEntity<?> getUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuario(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un usuario por id
    @PutMapping("/{id}")
    @JsonView(Usuario.VistaPostPut.class)
    public ResponseEntity<String> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        Usuario usuario = usuarioService.getUsuario(id);
        if (usuario != null) {
            // Si el usuario existe, actualizar sus datos
            // Pero antes, convertir la contraseña a hash
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(usuarioDetails.getContrasena().getBytes(StandardCharsets.UTF_8));
                String contrasenaHash = Hex.encodeHexString(hash);
                usuarioDetails.setContrasena(contrasenaHash);
            } catch (NoSuchAlgorithmException e) {
                return new ResponseEntity<>("Error al generar el hash de la contraseña",
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
            Usuario updatedUsuario = usuarioService.updateUsuario(id, usuarioDetails);
            return new ResponseEntity<>("Usuario actualizado con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un usuario por id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuario(id);
        if (usuario != null) {
            usuarioService.deleteUsuario(id);
            return new ResponseEntity<>("Usuario eliminado con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    @JsonView(Usuario.VistaPostPut.class)
    public ResponseEntity<Long> login(@RequestBody LoginData loginData) {
        Long id = usuarioService.login(loginData.getCorreo(), loginData.getContrasena());
        if (id != null) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
