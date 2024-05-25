package com.codegaiden.barro_on.repository;

import com.codegaiden.barro_on.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;



/*
 * La interfaz JpaRepository toma dos parámetros: la clase de la entidad que manejará (Modelo o Entity) y el tipo de dato del ID de la entidad (Long o Integer según lo definamos en el Entity). Permite hacer el CRUD y Ordenación de elementos
 */
public interface PedidoRepository extends JpaRepository<Pedido,Long> {

} 