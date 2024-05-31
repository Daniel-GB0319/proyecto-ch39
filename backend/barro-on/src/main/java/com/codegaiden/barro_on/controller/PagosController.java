package com.codegaiden.barro_on.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.codegaiden.barro_on.model.Pagos;
import com.codegaiden.barro_on.model.Usuario;
import com.codegaiden.barro_on.service.PagosService;
import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Rutas para los métodos de pago
@RestController
@RequestMapping("/api/usuarios/{idUsuario}/metodosPago")
public class PagosController {
    // Inyectamos el servicio de los métodos de pago
    @Autowired
    private PagosService pagoService;

    // Obtener todos los métodos de pago de un usuario
    @GetMapping
     @JsonView(Pagos.VistaGet.class)
    public List<Pagos> getAllPagos(@PathVariable Long idUsuario) {
        return pagoService.getAllPagos(idUsuario);
    }

    // Obtener un método de pago en especifico
    @GetMapping("/{idMetodoPago}")
    @JsonView(Pagos.VistaGet.class)
    public Pagos getPago(@PathVariable Long idUsuario, @PathVariable Long idMetodoPago) {
        return pagoService.getPago(idUsuario, idMetodoPago);
    }

    // Crear un método de pago para un usuario
    @PostMapping
    @JsonView(Pagos.VistaPostPut.class)
    public Pagos postPago(@PathVariable Long idUsuario, @RequestBody Pagos pago) {
        return pagoService.createPago(idUsuario, pago);
    }

    // Actualizar un método de pago de un usuario
    @PutMapping("/{idMetodoPago}")
    @JsonView(Pagos.VistaPostPut.class)
    public Pagos putPagos(@PathVariable Long idUsuario, @PathVariable Long idMetodoPago,
            @RequestBody Pagos pago) {
        return pagoService.putPago(idUsuario, idMetodoPago, pago);
    }

    // Borrar un método de pago
    @DeleteMapping("/{idMetodoPago}")
    public void deletePago(@PathVariable Long idMetodoPago) {
        pagoService.deletePago(idMetodoPago);
    }
}
