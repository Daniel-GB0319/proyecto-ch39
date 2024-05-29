package com.codegaiden.barro_on.controller;

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
    public Pedido createPedido(@PathVariable Long idUsuario,@RequestBody Pedido pedido) {
        return pedidoService.createdido(idUsuario,pedido);
    }
    // Obtener todos los pedidos de un usuario
    @GetMapping
    public List<Pedido> getAllPedidos(@PathVariable Long idUsuario) {
        return pedidoService.getAllPedidos(idUsuario);
    }
    // Obtenr un pedido en especifico
    @GetMapping("/{idPedido}")
    public Pedido getPedido(@PathVariable Long idUsuario,@PathVariable Long idPedido) {
        return pedidoService.getPedido(idUsuario,idPedido);
    }
    // actualizar un pedido por id
    @PutMapping("/{idPedido}")
    public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido pedido) {        
        return pedidoService.updatePedido(id,pedido);
    }
    // Eliminar un pedido por id
    @DeleteMapping("/{idPedido}")
    public void deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
    }
}
