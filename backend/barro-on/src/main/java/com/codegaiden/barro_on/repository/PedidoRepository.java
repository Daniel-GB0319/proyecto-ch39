package com.codegaiden.barro_on.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegaiden.barro_on.model.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido,Long> {

    public Object findAll(Pedido idPedidos);

} 