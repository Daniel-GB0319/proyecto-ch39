package com.codegaiden.barro_on.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegaiden.barro_on.model.Producto;
import com.codegaiden.barro_on.model.Usuario;
import com.codegaiden.barro_on.repository.ProductoRepository;
import com.codegaiden.barro_on.repository.UsuarioRepository;

import java.util.List;
import java.util.ArrayList;


/*
 * En Service se define la funcionalidad de cada una de las rutas o controllers que habrá con respecto al entity.
 * Básicamente se crean los métodos para CRUD y demás operaciones que se necesiten dentro de ellas.
 */
@Service
public class ProductoService {

    //Relación entre los repositorios
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    //Obtener todos los productos de un usuario
    public List<Producto> getAllProductos(Long idUsuario) {
        //Verificar que el usuario ingresado existe
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario!= null) {
            //Si el usuario existe, regresa todos los productos asociados
            //return new ArrayList<>(usuario.getProducto());
        }
        //Retorna null si el usuario ingresado no existe 
        return null;
    }

    //Obtener un producto de un usuario
    public Producto getProducto(Long idUsuario, Long idProducto) {
        //Verificar que el usuario ingresado existe
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario!= null) {
           //Producto ingresado existe
            Producto producto = productoRepository.findById(idProducto).orElse(null);
            if (producto!= null) {
                return producto;
            }
        }
        //Retorna null si el usuario ingresado no existe
        return null;
}

 // Crear un producto para un usuario
 public Producto createProducto(Long idUsuario, Producto producto) {
    //Verifica que un usuario ingresado existe
    Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
    if (usuario != null) {
        //Usuario existe y asigna su id al nuevo producto
        producto.setUsuario(usuario);
        //Guarda el nuevo producto
        return productoRepository.save(producto);
    }
    //Regresa null si no existe el usuario
    return null;
}

    //Actualizar un producto de un usuario
    public Producto putProducto(Long idUsuario, Long idProducto, Producto productoDetails) {
        //Verifica que un usuario ingresado existe
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario!= null) {
            //Verifica que el producto ingresado existe
            Producto producto = productoRepository.findById(idProducto).orElse(null);
            if (producto!= null) {
                producto.setNombre(productoDetails.getNombre());
                producto.setDescripcion(productoDetails.getDescripcion());
                producto.setPrecio(productoDetails.getPrecio());
                producto.setCantidad(productoDetails.getCantidad());
                producto.setDescuento(productoDetails.getDescuento());
                return productoRepository.save(producto);
            }
        }
        //Regresa null si no existe el usuario
        return null;
    }

    // Eliminar un producto por su id
    public void deleteProducto(Long idProducto) {
        productoRepository.deleteById(idProducto);
    }
}