package com.codegaiden.barro_on.controller;

import com.codegaiden.barro_on.model.Usuario;
import com.codegaiden.barro_on.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * En @RestController se definen las rutas de la API sobre las cuales el front podrá acceder. Se indica 
 * tipo de petición con las anotaciones @GetMapping, @PostMapping, @DeleteMapping,@PutMapping y se asocia
 * a los servicios o métodos del @Service a utilizar.
 * 
 * @RequestMapping es para indicar la ruta que llamara a dicho controller desde la URL.
 * 
 * @PathVariable indica que recibiremos un valor de la URL como parámetro para un @Service.
 * En la URL la variable se indica entre llaves "{variable}".
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    // Crear un usuario
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.postUsuario(usuario);
    }

    // Obtener un usuario por id
    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return usuarioService.getUsuario(id);
    }

    // Actualizar un usuario por id
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(id, usuario);
    }

    // Eliminar un usuario por id
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }

}
