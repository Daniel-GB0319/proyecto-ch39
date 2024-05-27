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

// Getter y Setter generados automáticamente por Lombok
@Getter
@Setter
@Entity
@Table(name = "usuario_metodos_pago")
public class Pagos {
    // ID de la tabla
    @Id
    // Estrategia Identity para indicar que MySQL se encarga de generar ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodos_pago")
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "numero_tarjeta")
    private String numeroTarjeta;

    @Column(name = "mes")
    private String mes;

    @Column(name = "anio")
    private String anio;

    @Column(name = "cvv")
    private String cvv;

    @Column(name = "titular")
    private String titular;

    @Column(name = "dir_facturacion")
    private String dirFacturacion;

    // Relación Muchos a uno
    @ManyToOne
    // Evita recursividad al mandar json
    @JsonIgnore
    // Indica la columna de la llave foránea
    @JoinColumn(name = "id_cliente")
    private Usuario usuario;

}
