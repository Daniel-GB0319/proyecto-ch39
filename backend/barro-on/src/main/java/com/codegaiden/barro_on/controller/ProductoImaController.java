package com.codegaiden.barro_on.controller;

import com.codegaiden.barro_on.model.ProductoIma;
import com.codegaiden.barro_on.service.ProductoImaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Rutas para las imágenes
@RestController
@RequestMapping("/api/productos/{idProducto}/imagenes")
public class ProductoImaController {

    // Inyectamos el servicio de ProductoIma
    @Autowired
    private ProductoImaService productoImaService;

    // Obtener todas las imágenes de un producto
    @GetMapping
    public ResponseEntity<List<ProductoIma>> getAllProductoImas(@PathVariable Long idProducto) {
        try {
            List<ProductoIma> imagenes = productoImaService.getAllProductosIma(idProducto);
            return new ResponseEntity<>(imagenes, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener una imagen en específico
    @GetMapping("/{idImagen}")
    public ResponseEntity<ProductoIma> getProductoIma(@PathVariable Long idProducto, @PathVariable Long idImagen) {
        try {
            ProductoIma productoIma = productoImaService.getProductoIma(idProducto, idImagen);
            return new ResponseEntity<>(productoIma, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva imagen para un producto
    @PostMapping
    public ResponseEntity<?> postProductoIma(@PathVariable Long idProducto, @RequestBody ProductoIma productoIma) {
        try {
            ProductoIma createdProductoIma = productoImaService.createProductoIma(idProducto, productoIma);
            return new ResponseEntity<>(createdProductoIma, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("El producto no existe", HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar una imagen de un producto
    @PutMapping("/{idImagen}")
    public ResponseEntity<?> putProductoIma(@PathVariable Long idProducto, @PathVariable Long idImagen, @RequestBody ProductoIma productoImaDetails) {
        try {
            ProductoIma updatedProductoIma = productoImaService.updateProductoIma(idProducto, idImagen, productoImaDetails);
            return new ResponseEntity<>(updatedProductoIma, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Producto o imagen no encontrada", HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar una imagen
    @DeleteMapping("/{idImagen}")
    public ResponseEntity<String> deleteProductoIma(@PathVariable Long idProducto, @PathVariable Long idImagen) {
        try {
            productoImaService.deleteProductoIma(idProducto, idImagen);
            return new ResponseEntity<>("Imagen eliminada con éxito", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Producto o imagen no encontrada", HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
