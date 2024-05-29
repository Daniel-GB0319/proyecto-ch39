package com.codegaiden.barro_on.model;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
 * 1) Anotaciones @Getter y @Setter son de la dependencia Lombok y generan dichos métodos de acceso
       para ahorrarnos el tener que escribirlos.
    2) @Table es para indicar la tabla de SQL sobre la cual trabajaremos
 */

@Getter
@Setter
@Entity
@Table(name = "pedido")

// Clase pedido para la table SQL

public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(name = "fecha_pedido")
    private Date fecPedido;

    @Column(name = "costo_total")
    private float costTotal;
   
    // @Column(name = "id_usuario")
    // private Long idUsuario;

    @ManyToMany
    @JsonIgnore
    @JoinColumn(name = "id_producto",nullable = false)
    Set<productos> productospedido;

    // @Column(name = "id_status")
    // private Long idStatus;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name= "id_estatus",nullable=false)
    private Estatus estatus;
    
    }
