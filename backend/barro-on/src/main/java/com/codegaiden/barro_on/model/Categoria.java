package com.codegaiden.barro_on.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class Categoria {

     // Define una vista para las solicitudes GET
    public interface VistaGet {
    }

    // Define una vista para las solicitudes POST/PUT
    public interface VistaPostPut {
    }

    // Id de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(VistaGet.class)
    @Column(name = "id_categoria")
    private Long id;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "nombre", nullable = false, length = 15)
    private String nombre;

    @JsonView({VistaPostPut.class, VistaGet.class})
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    
    @OneToMany(mappedBy = "categorias")  
    @JsonIgnore
    private Set<Producto> producto;
     

}
