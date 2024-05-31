package com.codegaiden.barro_on.model;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



/* 
    1) Anotaciones @Getter y @Setter son de la dependencia Lombok y generan dichos métodos de acceso
       para ahorrarnos el tener que escribirlos.
    2) @Table es para indicar la tabla de SQL sobre la cual trabajaremos
    3) @Id es para indicar cual es la llave primaria de la entidad o modelo
    4) @GeneratedValue es para indicar el tipo de generación de la llave primaria, donde identity 
       es para que la llave primaria se genere automáticamente en la base de datos.
    5) @Column es para indicar el nombre de la columna en la tabla de SQL.
*/

//Getter y Setter generadas por Lombok
@Getter
@Setter
@Entity
@Table(name = "producto")

// Clase para representar  la tabla de SQL de producto
public class Producto {

   // Define una vista para las solicitudes GET
  public interface VistaGet {
}

// Define una vista para las solicitudes POST/PUT
public interface VistaPostPut {
}

   //ID de la tabla
   @Id
   //Para indicar que MySql se encarga de los ID
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @JsonView(VistaGet.class)
   @Column(name = "id_producto")
   private Long id;

   @JsonView({VistaPostPut.class, VistaGet.class})
   @Column(name = "nombre", nullable = false, length = 30)
   private String nombre;

   @JsonView({VistaPostPut.class, VistaGet.class})
   @Column(name = "descripcion", nullable = false, length = 50)
   private String descripcion;

   @JsonView({VistaPostPut.class, VistaGet.class})
   @Column(name = "precio", nullable = false)
   private Double precio;

   @JsonView({VistaPostPut.class, VistaGet.class})
   @Column(name = "cantidad",nullable = false)
   private Integer cantidad;

   @JsonView({VistaPostPut.class, VistaGet.class})
   @Column(name = "descuento", nullable = false)
   private Double descuento;
    
   //Relación de Muchos a uno
   @ManyToOne
   //Evita recursividad al mandar json
   //@JsonIgnore
   //Indica la columna de la llave foránea
   @JoinColumn(name = "id_vendedor")
   private Usuario usuario;

   //Relación de Muchos a uno
   @ManyToOne
   //Evita recursividad al mandar json
   //@JsonIgnore
   @JoinColumn(name = "id_categoria")
   private Categoria categorias;


   @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
   @JsonIgnore
   private Set<ProductoIma> productoima;

}
