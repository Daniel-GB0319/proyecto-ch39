package com.codegaiden.barro_on.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegaiden.barro_on.model.Categoria;
import com.codegaiden.barro_on.model.Producto;
import com.codegaiden.barro_on.model.Usuario;
import com.codegaiden.barro_on.repository.CategoriaRepository;
import com.codegaiden.barro_on.repository.ProductoRepository;
import com.codegaiden.barro_on.repository.UsuarioRepository;

import java.util.List;


@Service
public class ProductoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todos los productos de un usuario
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
        
    }

    // Obtener un producto de un usuario
    public Producto getProducto(Long idProducto) {
        // Producto ingresado existe
        return productoRepository.findById(idProducto).orElse(null);
    }

    // Crear un producto para un usuario
    public Producto createProducto(Producto productoDetails) {
        // Verifica que el usuario y la categoría existen en la base de datos
        Usuario usuario = usuarioRepository.findById(productoDetails.getUsuario().getId()).orElse(null);
        Categoria categoria = categoriaRepository.findById(productoDetails.getCategorias().getId()).orElse(null);
    
        if (usuario != null && categoria != null) {
            // Asigna el usuario y la categoría confirmados al producto
            productoDetails.setUsuario(usuario);
            productoDetails.setCategorias(categoria);
    
            // Guarda el nuevo producto
            return productoRepository.save(productoDetails);
        }
    
        // Regresa null si no existe el usuario o la categoría
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
            producto.setCategorias(productoDetails.getCategorias());            
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
