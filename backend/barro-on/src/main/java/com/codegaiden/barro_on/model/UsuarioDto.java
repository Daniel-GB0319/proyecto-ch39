package com.codegaiden.barro_on.model;

import java.util.Date;
import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDto {


  private Long id;

  private String nombre;

  private String apPaterno;

  private String apMaterno;

  private char sexo;

  private Date fecNac;

  private String correo;

  private String contrasena;

  private String telefono;

  private String tipoUsuario;

  private Set<Direccion> direccion;

  private Set<Pagos> pagos;

  private Set<Producto> producto;
    
}
