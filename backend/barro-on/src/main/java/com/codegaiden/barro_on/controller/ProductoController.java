package com.codegaiden.barro_on.controller;

import com.codegaiden.barro_on.model.Producto;
import com.codegaiden.barro_on.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos de un usuario
    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> productos = productoService.getAllProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    // Obtener un producto por su id
    @GetMapping("/{idProducto}")
    public ResponseEntity<?> getProducto(@PathVariable Long idProducto) {
        Producto producto = productoService.getProducto(idProducto);
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Crear un nuevo producto para un usuario
    @PostMapping
    public ResponseEntity<?> postProducto(@RequestBody Producto producto) {
        try {
            Producto createdProducto = productoService.postProducto(producto);
            return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("El usuario o la categoría no existen", HttpStatus.CONFLICT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un producto de un usuario
    @PutMapping("/{idProducto}")
    public ResponseEntity<?> putProducto(@PathVariable Long idProducto, @RequestBody Producto productoDetails) {
        Producto producto = productoService.getProducto(idProducto);
        if (producto != null) {
            Producto updatedProducto = productoService.putProducto(idProducto, productoDetails);
            return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Borrar un producto
    @DeleteMapping("/{idProducto}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long idProducto) {
        Producto producto = productoService.getProducto(idProducto);
        if (producto != null) {
            productoService.deleteProducto(idProducto);
            return new ResponseEntity<>("Producto eliminado con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
