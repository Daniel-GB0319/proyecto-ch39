package com.codegaiden.barro_on.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegaiden.barro_on.model.Direccion;

// Interface de entidad Dirección que hereda de JPA para manejo de CRUD
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}
