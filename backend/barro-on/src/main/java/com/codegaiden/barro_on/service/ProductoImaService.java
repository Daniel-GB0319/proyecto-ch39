package com.codegaiden.barro_on.service;

import com.codegaiden.barro_on.model.Producto;
import com.codegaiden.barro_on.model.ProductoIma;
import com.codegaiden.barro_on.repository.ProductoImaRepository;
import com.codegaiden.barro_on.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoImaService {

    @Autowired
    private ProductoImaRepository productoImaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todas las imágenes de un producto
    public List<ProductoIma> getAllProductosIma(Long idProducto) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("El producto no existe"));
        return new ArrayList<>(producto.getProductoima());
    }

    // Obtener una imagen de un producto
    public ProductoIma getProductoIma(Long idProducto, Long idProductoIma) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("El producto no existe"));
        return productoImaRepository.findById(idProductoIma)
                .orElseThrow(() -> new IllegalArgumentException("La imagen no existe"));
    }

    // Crear una imagen del producto
    public ProductoIma createProductoIma(Long idProducto, ProductoIma productoIma) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("El producto no existe"));
        productoIma.setProducto(producto);
        return productoImaRepository.save(productoIma);
    }

    // Actualizar una imagen de un producto
    public ProductoIma updateProductoIma(Long idProducto, Long idProductoIma, ProductoIma productoImaDetails) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("El producto no existe"));
        ProductoIma productoIma = productoImaRepository.findById(idProductoIma)
                .orElseThrow(() -> new IllegalArgumentException("La imagen no existe"));
        productoIma.setImagenUrl(productoImaDetails.getImagenUrl());
        return productoImaRepository.save(productoIma);
    }

    // Eliminar una imagen de un producto
    public void deleteProductoIma(Long idProducto, Long idProductoIma) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("El producto no existe"));
        productoImaRepository.deleteById(idProductoIma);
    }
}

