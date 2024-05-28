package com.codegaiden.barro_on.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegaiden.barro_on.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
