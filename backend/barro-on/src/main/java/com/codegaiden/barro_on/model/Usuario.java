package com.codegaiden.barro_on.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Getter y Setter generados por Lombok
@Getter
@Setter
@Entity
@Table(name = "usuario")

// Clase para representar la tabla de SQL de usuarios
public class Usuario {

  // ID de la tabla
  @Id
  // Estrategia de Spring Boot 3 para indicar que MySQL se encarga de los ID
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuario")
  private Long id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "ap_paterno")
  private String apPaterno;

  @Column(name = "ap_materno")
  private String apMaterno;

  @Column(name = "sexo")
  private char sexo;

  @Column(name = "fec_nac")
  private Date fecNac;

  @Column(name = "correo")
  private String correo;

  @Column(name = "contrasena")
  private String contrasena;

  @Column(name = "telefono")
  private String telefono;

  @Column(name = "tipo_usuario")
  private String tipoUsuario;

  // Relacion uno a muchos con borrado en cascada
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
  // Evita recursividad con JSON de usuario y direcciones
  @JsonIgnore
  private Set<Direccion> direccion;

  // Relacion uno a muchos con borrado en cascada
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
  // Evita recursividad con JSON de usuario y pagos
  @JsonIgnore
  private Set<Pagos> pagos;

  //Relacion de uno a muchos con borrado en cascada
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
  // Evita recursividad con JSON de usuario y productos
  @JsonIgnore
  private Set<Producto> producto;
}
