package com.codegaiden.barro_on.controller;

import com.codegaiden.barro_on.model.Pedido;
import com.codegaiden.barro_on.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // obtener todos los productos
    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    // Crear un pedido
    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoService.postPedido(pedido);
    }

    // Obtenr un pedido por id
    @GetMapping("/{id}")
    public Pedido getPedido(@PathVariable Long id) {
        return pedidoService.getPedido(id);
    }
    // actualizar un pedido por id
    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido pedido) {        
        return pedidoService.updatePedido(id,pedido);
    }
    // Eliminar un pedido por id
    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
    }
}
