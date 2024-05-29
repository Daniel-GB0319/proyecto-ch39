package com.codegaiden.barro_on.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="pedido_producto")
public class PedidoProducto {
    @ManyToMany
    @JoinTable(
        name="pedido_productos"
        joinColumns=@JoinColumn(name="Pedido"),
        inverseJoinColumns=@JoinColumn(name="Producto")
        )
    Set<Pedido> pedidoproducto;
}
