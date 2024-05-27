package com.codegaiden.barro_on.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.codegaiden.barro_on.model.Direccion;
import com.codegaiden.barro_on.service.DireccionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Rutas para las direcciones
@RestController
@RequestMapping("/api/usuarios/{idUsuario}/direcciones")
public class DireccionController {
    // Inyectamos el servicio de las direcciones
    @Autowired
    private DireccionService direccionService;

    // Obtener todas las direcciones de un usuario
    @GetMapping
    public List<Direccion> getAllDirecciones(@PathVariable Long idUsuario) {
        return direccionService.getAllDirecciones(idUsuario);
    }

    // Obtener una dirección en especifico
    @GetMapping("/{idDireccion}")
    public Direccion getDireccion(@PathVariable Long idUsuario, @PathVariable Long idDireccion) {
        return direccionService.getDireccion(idUsuario, idDireccion);
    }

    // Crear una dirección para un usuario
    @PostMapping
    public Direccion postDireccion(@PathVariable Long idUsuario, @RequestBody Direccion direccion) {
        return direccionService.createDireccion(idUsuario, direccion);
    }

    // Actualizar una dirección de un usuario
    @PutMapping("/{idDireccion}")
    public Direccion putDireccion(@PathVariable Long idUsuario, @PathVariable Long idDireccion,
            @RequestBody Direccion direccion) {
        return direccionService.putDireccion(idUsuario, idDireccion, direccion);
    }

    // Borrar una direccion
    @DeleteMapping("/{idDireccion}")
    public void deleteDireccion(@PathVariable Long idDireccion) {
        direccionService.deleteDireccion(idDireccion);
    }
}
