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


@Getter
@Setter
@Entity
@Table(name = "producto_imagen")
public class ProductoIma {

    // Define una vista para las solicitudes GET
    public interface VistaGet {
    }

// Define una vista para las solicitudes POST/PUT
    public interface VistaPostPut {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(VistaGet.class)
    @Column(name = "id_imagen")
    private Long id;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "imagen_url", nullable = false, length = 2083)
    private String imagenUrl;
   
    //Relacion de Muchos a uno
    @ManyToOne
    //Evitar recursividad al mandar json
    @JsonIgnore
    //Indica la columna de la llave foranea
    @JoinColumn(name = "id_producto")
    private Producto producto;


}
