package com.codegaiden.barro_on.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
@Table(name = "estatus")
public class Estatus {
    //id tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estatus")
    private Long id;
    
    @Column(name = "estado")
    private Estados estado;

    @Column(name = "descipción")
    private String descripcion;
    
    @OneToMany(mappedBy = "estatus", cascade= CascadeType.ALL)
    @JsonIgnore 
    private Set<Pedido> pedido;

}

//enums de estados
enum Estados {
    RECIBIDO,
    PREPARANDO,
    ENVIADO
}
