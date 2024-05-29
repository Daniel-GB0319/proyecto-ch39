package com.codegaiden.barro_on.repository;

import com.codegaiden.barro_on.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


// Interface de entidad Usuario que hereda de JPA para manejo de CRUD
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCorreo(String correo);
}
