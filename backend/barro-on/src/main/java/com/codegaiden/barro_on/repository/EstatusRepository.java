package com.codegaiden.barro_on.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegaiden.barro_on.model.Estatus;

public interface EstatusRepository extends JpaRepository<Estatus, Long>{
    
}
