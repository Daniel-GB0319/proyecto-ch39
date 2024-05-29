package com.codegaiden.barro_on.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.codegaiden.barro_on.model.ProductoIma;
import com.codegaiden.barro_on.service.ProductoImaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


//Rutas para las imagenes
@RestController
@RequestMapping("/api/productos/{idProducto}/imagenes")

public class ProductoImaController {
    //Inyectamos el servicio de productoima
    @Autowired
    private ProductoImaService productoImaService;

    //Obtenemos todas las imagenes de un producto
    @GetMapping
    public List<ProductoIma> getAllProductoImas(@PathVariable Long idProducto) {
        return productoImaService.getAllProductosIma(idProducto);
    }

    //Obtener una imagen en especifico
    @GetMapping("/{idImagen}")
    public ProductoIma getProductoIma(@PathVariable Long idProducto, @PathVariable Long idImagen) {
        return productoImaService.getProductoIma(idProducto, idImagen);
    }

    //Crear una nueva imagen para un producto
    @PostMapping
    public ProductoIma postProductoIma( @PathVariable Long idProducto,
            @RequestBody ProductoIma productoIma) {
        return productoImaService.createProductoIma(idProducto, productoIma);
    }

    //Actualizar una imagen de un producto
    @PutMapping("/{idImagen}")
    public ProductoIma putProductoIma(@PathVariable Long idProducto, @PathVariable Long idImagen,
            @RequestBody ProductoIma productoIma) {
        return productoImaService.putProductoIma(idProducto, idImagen, productoIma);
    }

    //Borrar una imagen
    @DeleteMapping("/{idImagen}")
    public void deleteProductoIma(@PathVariable Long idProducto, @PathVariable Long idImagen) {
        productoImaService.deleteProductoIma(idProducto, idImagen);
    }

}
