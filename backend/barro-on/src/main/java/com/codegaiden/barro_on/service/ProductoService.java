package com.codegaiden.barro_on.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegaiden.barro_on.model.Producto;
import com.codegaiden.barro_on.model.Usuario;
import com.codegaiden.barro_on.repository.ProductoRepository;
import com.codegaiden.barro_on.repository.UsuarioRepository;

import java.util.List;
import java.util.ArrayList;

@Service
public class ProductoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos de un usuario
    public List<Producto> getAllProductos(Long idUsuario) {
        // Verificar que el usuario ingresado existe
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            // Si el usuario existe, regresa todos los productos asociados
            return new ArrayList<>(usuario.getProducto());
        }
        // Retorna null si el usuario ingresado no existe 
        return null;
    }

    // Obtener un producto de un usuario
    public Producto getProducto(Long idProducto) {
        // Producto ingresado existe
        return productoRepository.findById(idProducto).orElse(null);
    }

    // Crear un producto para un usuario
    public Producto createProducto(Long idUsuario, Producto producto) {
        // Verifica que un usuario ingresado existe
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            // Usuario existe y asigna su id al nuevo producto
            producto.setUsuario(usuario);
            // Guarda el nuevo producto
            return productoRepository.save(producto);
        }
        // Regresa null si no existe el usuario
        return null;
    }

    // Actualizar un producto de un usuario
    public Producto putProducto(Long idProducto, Producto productoDetails) {
        // Verifica que el producto ingresado existe
        Producto producto = productoRepository.findById(idProducto).orElse(null);
        if (producto != null) {
            producto.setNombre(productoDetails.getNombre());
            producto.setDescripcion(productoDetails.getDescripcion());
            producto.setPrecio(productoDetails.getPrecio());
            producto.setCantidad(productoDetails.getCantidad());
            producto.setDescuento(productoDetails.getDescuento());
            return productoRepository.save(producto);
        }
        // Regresa null si no existe el producto
        return null;
    }

    // Eliminar un producto por su id
    public void deleteProducto(Long idProducto) {
        productoRepository.deleteById(idProducto);
    }
}
