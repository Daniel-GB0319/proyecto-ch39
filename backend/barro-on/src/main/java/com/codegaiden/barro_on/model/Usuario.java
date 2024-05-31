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
import com.fasterxml.jackson.annotation.JsonView;

// Getter y Setter generados por Lombok
@Getter
@Setter
@Entity
@Table(name = "usuario")

// Clase para representar la tabla de SQL de usuarios
public class Usuario {

  // Define una vista para las solicitudes GET
  public interface VistaGet {
  }

  // Define una vista para las solicitudes POST/PUT
  public interface VistaPostPut {
  }

  // ID de la tabla
  @Id
  // Estrategia de Spring Boot 3 para indicar que MySQL se encarga de los ID
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonView(VistaGet.class)
  @Column(name = "id_usuario")
  private Long id;

  @JsonView({VistaPostPut.class, VistaGet.class})
  @Column(name = "nombre", nullable = false, length = 20)
  private String nombre;

  @JsonView({VistaPostPut.class, VistaGet.class})
  @Column(name = "ap_paterno", nullable = false, length = 20)
  private String apPaterno;

  @JsonView({VistaPostPut.class, VistaGet.class})
  @Column(name = "ap_materno", nullable = false, length = 20)
  private String apMaterno;

  @JsonView({VistaPostPut.class, VistaGet.class})
  @Column(name = "sexo", nullable = false)
  private char sexo;

  @JsonView({VistaPostPut.class, VistaGet.class})
  @Column(name = "fec_nac", nullable = false)
  private Date fecNac;

  @JsonView({VistaPostPut.class, VistaGet.class})
  @Column(name = "correo", nullable = false, length = 30)
  private String correo;

  @JsonView(VistaPostPut.class)
  @Column(name = "contrasena", nullable = false, length = 64)
  private String contrasena;

  @JsonView({VistaPostPut.class, VistaGet.class})
  @Column(name = "telefono", nullable = false, length = 15)
  private String telefono;

  @JsonView({VistaPostPut.class, VistaGet.class})
  @Column(name = "tipo_usuario", nullable = false, length = 10)
  private String tipoUsuario;

  // Relación uno a muchos con borrado en cascada
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
  // Evita recursividad con JSON de usuario y direcciones
  @JsonIgnore
  private Set<Direccion> direccion;

  // Relación uno a muchos con borrado en cascada
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
  // Evita recursividad con JSON de usuario y pagos
  @JsonIgnore
  private Set<Pagos> pagos;

  // Relación de uno a muchos con borrado en cascada
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
  // Evita recursividad con JSON de usuario y productos
  @JsonIgnore
  private Set<Producto> producto;
}
