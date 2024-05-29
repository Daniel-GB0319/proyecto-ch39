package com.codegaiden.barro_on.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegaiden.barro_on.model.Pedido;
import com.codegaiden.barro_on.repository.EstatusRepository;
import com.codegaiden.barro_on.repository.PedidoRepository;
import com.codegaiden.barro_on.repository.UsuarioRepository;

import java.util.List;


import com.codegaiden.barro_on.model.Usuario;

@Service
public class PedidoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstatusRepository estatusRepository;
    
    @Autowired
    private PedidoRepository pedidoRepository;

    // Obtener todos los pedidos de la base de datos
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }
    
    // Crear un pedido
    public Pedido postPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    //obtener un pedido de un usuario
    public Pedido getPedido (Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }



    // Actualizar un pedido por de un usuario
    public Pedido putPedido(Long id, Pedido pedidoDetails) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if(usuario == null){
            Pedido pedido = pedidoRepository.findById(id).orElse(null);
            if (pedido!= null) {
                pedido.setFecPedido(pedidoDetails.getFecPedido());
                pedido.setCostTotal(pedidoDetails.getCostTotal());
                pedido.setIdUsuario(pedidoDetails.getIdUsuario());
                pedido.setIdStatus(pedidoDetails.getIdStatus());
                return pedidoRepository.save(pedido);
            }
        }
        return null;
    }

    // Eliminar un pedido por su id
    public void deletePedido(Long id) {
        pedidoRepository.deleteById(idPedido);
    }

}
