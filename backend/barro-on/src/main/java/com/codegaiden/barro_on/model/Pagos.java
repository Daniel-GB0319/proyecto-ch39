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

// Getter y Setter generados automáticamente por Lombok
@Getter
@Setter
@Entity
@Table(name = "usuario_metodos_pago")
public class Pagos {

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
    @Column(name = "id_metodos_pago")
    private Long id;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "numero_tarjeta", nullable = false, length = 16)
    private String numeroTarjeta;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "mes", length = 2)
    private String mes;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "anio", length = 2)
    private String anio;

    @JsonView(VistaPostPut.class)
    @Column(name = "cvv", length = 3)
    private String cvv;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "titular", nullable = false, length = 50)
    private String titular;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "dir_facturacion", nullable = false, length = 80)
    private String dirFacturacion;

    // Relación Muchos a uno
    @ManyToOne
    // Evita recursividad al mandar json
    @JsonIgnore
    // Indica la columna de la llave foránea
    @JoinColumn(name = "id_cliente")
    private Usuario usuario;

}
