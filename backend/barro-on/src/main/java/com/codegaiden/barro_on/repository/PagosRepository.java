package com.codegaiden.barro_on.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegaiden.barro_on.model.Pagos;

// Interface de entidad Pagos que hereda de JPA para manejo de CRUD
public interface PagosRepository extends JpaRepository<Pagos, Long> {
}
