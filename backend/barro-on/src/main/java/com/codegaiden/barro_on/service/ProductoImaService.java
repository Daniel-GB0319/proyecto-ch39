package com.codegaiden.barro_on.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegaiden.barro_on.model.ProductoIma;
import com.codegaiden.barro_on.model.Producto;
import com.codegaiden.barro_on.repository.ProductoImaRepository;
import com.codegaiden.barro_on.repository.ProductoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoImaService {
    
    @Autowired
    private ProductoImaRepository productoImaRepository;

    @Autowired
    private ProductoRepository productoRepository;

   //Obtener todas las imagenes de un producto
    public List<ProductoIma> getAllProductosIma(Long idProducto) {
      //Verificamos que el producto ingresado exista
      Producto producto = productoRepository.findById(idProducto).orElse(null);
      if (producto!=null) {
          //Si el producto existe, regresa todas las imagenes asociadas
          return new ArrayList <> (producto.getProductoima());
      }
      //Retorna null si el producto ingresado no existe (se podría cambiar por una exception)
      return null;
    }

    //Obtener una imagen de un producto
    public ProductoIma getProductoIma(Long idProducto, Long idProductoIma) {
        //Verificamos que el producto ingresado exista
        Producto producto = productoRepository.findById(idProducto).orElse(null);
        if (producto!=null) {
            //Imagen ingresada existe
            return productoImaRepository.findById(idProductoIma).orElse(null);
        }
        //Retorna null si el producto ingresado no existe (se podría cambiar por una exception)
        return null;
    }


    //Crear una imagen del producto
    public ProductoIma createProductoIma(Long idProducto, ProductoIma productoIma) {
        //Verificamos que el producto ingresado exista
        Producto producto = productoRepository.findById(idProducto).orElse(null);
        if (producto!=null) {
            productoIma.setProducto(producto);
            return productoImaRepository.save(productoIma);
        }
        //Retorna null si el producto ingresado no existe (se podría cambiar por una exception)
        return null;
    }
    
    //Actualizar una imagen de un producto
    public ProductoIma putProductoIma(Long idProducto, Long idProductoIma, ProductoIma productoImaDetails) {
        //Verificamos que el producto ingresado exista
        Producto producto = productoRepository.findById(idProducto).orElse(null);
        if (producto!=null) {
            ProductoIma productoIma = productoImaRepository.findById(idProductoIma).orElse(null);
            if (productoIma!=null) {
                productoIma.setImagenUrl(productoImaDetails.getImagenUrl());
                return productoImaRepository.save(productoIma);
            }
        }
        //Retorna null si el producto ingresado no existe (se podría cambiar por una exception)
        return null;
    }

    //Eliminar una imagen de un producto
    public void deleteProductoIma(Long idProducto, Long idProductoIma) {
        //Elimina la imagen de la producto
        productoImaRepository.deleteById(idProductoIma);
    }
        


}
