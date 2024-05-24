package com.codegaiden.barro_on.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

/* 
    1) Anotaciones @Getter y @Setter son de la dependencia Lombok y generan dichos métodos de acceso
       para ahorrarnos el tener que escribirlos.
    2) @Table es para indicar la tabla de SQL sobre la cual trabajaremos
    3) @Id es para indicar cual es la llave primaria de la entidad o modelo
    4) @GeneratedValue es para indicar el tipo de generación de la llave primaria, donde identity 
       es para que la llave primaria se genere automáticamente en la base de datos.
    5) @Column es para indicar el nombre de la columna en la tabla de SQL.
*/
@Getter
@Setter
@Entity
@Table(name = "usuario")

// Clase para representar la tabla de SQL de usuarios
public class Usuario {

    @Id
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

}