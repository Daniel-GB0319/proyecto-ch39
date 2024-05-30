package com.codegaiden.barro_on.controller;

import com.codegaiden.barro_on.model.LoginData;
import com.codegaiden.barro_on.model.Usuario;
import com.codegaiden.barro_on.service.UsuarioService;
import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Crear un usuario
    @PostMapping
    @JsonView(Usuario.VistaPostPut.class)
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.postUsuario(usuario);
    }

    // Obtener un usuario por id
    @GetMapping("/{id}")
    @JsonView(Usuario.VistaGet.class)
    public Usuario getUsuario(@PathVariable Long id) {
        return usuarioService.getUsuario(id);
    }

    // Actualizar un usuario por id
    @PutMapping("/{id}")
    @JsonView(Usuario.VistaPostPut.class)
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(id, usuario);
    }

    // Eliminar un usuario por id
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
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
