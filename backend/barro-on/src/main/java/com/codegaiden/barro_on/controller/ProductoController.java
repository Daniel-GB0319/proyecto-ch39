package com.codegaiden.barro_on.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.codegaiden.barro_on.model.Producto;
import com.codegaiden.barro_on.service.ProductoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
/*
 * En @RestController se definen las rutas de la API sobre las cuales el front podrá acceder. Se indica 
 * tipo de petición con las anotaciones @GetMapping, @PostMapping, @DeleteMapping,@PutMapping y se asocia
 * a los servicios o métodos del @Service a utilizar.
 * 
 * @RequestMapping es para indicar la ruta que llamara a dicho controller desde la URL.
 * 
 * @PathVariable indica que recibiremos un valor de la URL como parámetro para un @Service.
 * En la URL la variable se indica entre llaves "{variable}".
 */

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    //Obtener todos los productos de un usuario
    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    //Obtener un producto por su id
    @GetMapping("/{idProducto}")
    public Producto getProducto(@PathVariable Long idProducto) {
        return productoService.getProducto(idProducto);
    }

    //Crear un nuevo producto para un usuario
    @PostMapping
    public Producto postProducto( @RequestBody Producto producto) {
        return productoService.createProducto(producto);
    }
    
    //Actualizar un producto de un usuario
    @PutMapping("/{idProducto}")
    public Producto putProducto( @PathVariable Long idProducto,
            @RequestBody Producto producto) {
        return productoService.putProducto(idProducto, producto);
    }
    
    //Borrar un producto
    @DeleteMapping("/{idProducto}")
    public void deleteProducto(@PathVariable Long idProducto) {
        productoService.deleteProducto(idProducto);
    }
    
}
