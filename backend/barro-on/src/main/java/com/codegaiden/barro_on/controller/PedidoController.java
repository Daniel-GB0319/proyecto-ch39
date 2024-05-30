package com.codegaiden.barro_on.controller;

import com.codegaiden.barro_on.model.Estatus;
import com.codegaiden.barro_on.model.Pedido;
import com.codegaiden.barro_on.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios/{idUsuario}/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // obtener todos los pedidos hechos por el usuario
    @GetMapping
    public List<Pedido> getAllPedidos(@PathVariable Long idUsuario) {
        return pedidoService.getAllPedidos(idUsuario);
    }
    // Obtener un pedido en especifico
    @GetMapping("/{idPedido}")
    public Pedido getPedido(@PathVariable Long idUsuario, @PathVariable Long idPedido) {
        return pedidoService.getPedido(idUsuario, idPedido);
    }

    // Crear un pedido
    @PostMapping
    public Pedido createPedido(@PathVariable Long idUsuario,@RequestBody Pedido idPedido) {
        return pedidoService.createPedido(idUsuario,idPedido);
    }

    // actualizar un pedido por id
    @PutMapping("/{idPedido}")
    public Pedido putPedido(@PathVariable Long idUsuario, @PathVariable Long idPedido, @RequestBody Estatus estatus) {        
        return pedidoService.putPedido(idUsuario,idPedido,estatus);
    }
    // Eliminar un pedido por id
    @DeleteMapping("/{idPedido}")
    public void deletePedido(@PathVariable Long idUsuario) {
        pedidoService.deletePedido(idUsuario);
    }
}
