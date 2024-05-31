package com.codegaiden.barro_on.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

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

    // Define una vista para las solicitudes GET
     public interface VistaGet {
    }

    // Define una vista para las solicitudes POST/PUT
    public interface VistaPostPut {
    }

    // ID de la tabla
    @Id
    // Estrategia Identity para indicar que MySQL se encarga de generar ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(VistaGet.class)
    @Column(name = "id_direcciones")
    private Long id;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "calle", nullable = false, length = 50)
    private String calle;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "num_ext", nullable = false, length = 3)
    private Integer numExt;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "num_int", length = 3)
    private Integer numInt;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "colonia", nullable = false, length = 50)
    private String colonia;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "municipio", nullable = false, length = 50)
    private String municipio;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "cp", nullable = false, length = 5)
    private String cp;

    // Relación Muchos a uno
    @ManyToOne
    // Evita recursividad al mandar json
    @JsonIgnore
    // Indica la columna de la llave foránea
    @JoinColumn(name = "id_cliente")
    private Usuario usuario;

}
