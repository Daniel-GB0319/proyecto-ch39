package com.codegaiden.barro_on.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

// Getter y Setter generados automaticamente por Lombok
@Getter
@Setter
@Entity
@Table(name = "usuario_direcciones")
public class Direccion {
    // ID de la tabla
    @Id
    // Estrategia Identity para indicar que MySQL se encarga de generar ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direcciones")
    private Long id;

    @Column(name = "calle")
    private String calle;

    @Column(name = "num_ext")
    private Integer numExt;

    @Column(name = "num_int")
    private Integer numInt;

    @Column(name = "colonia")
    private String colonia;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cp")
    private String cp;

    // Relación Muchos a uno
    @ManyToOne
    // Evita recursividad al mandar json
    @JsonIgnore
    // Indica la columna de la llave foránea
    @JoinColumn(name = "id_cliente")
    private Usuario usuario;

}
