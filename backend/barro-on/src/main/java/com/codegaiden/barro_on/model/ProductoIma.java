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


@Getter
@Setter
@Entity
@Table(name = "ProductoIma")
public class ProductoIma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen")
    private Long id;

    @Column(name = "imagen_url")
    private String imagenUrl;
   
    //Relacion de Muchos a uno
    @ManyToOne
    //Evitar recursividad al mandar json
    @JsonIgnore
    //Indica la columna de la llave foranea
    @JoinColumn(name = "id_producto")
    private Producto producto;


}
