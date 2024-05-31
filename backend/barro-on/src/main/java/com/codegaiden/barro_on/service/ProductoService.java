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

    //Crear un nuevo producto
    public Producto postProducto(Producto producto) {
        //Comprobar que el usuario y la categoria existen en la base de datos
        Usuario existingUsuario = usuarioRepository.findById(producto.getUsuario().getId()).orElse(null);
        Categoria existingCategoria = categoriaRepository.findById(producto.getCategorias().getId()).orElse(null);
        // Si el usuario o la categoría no existen, lanzar una excepción
    if (existingUsuario == null) {
        throw new IllegalArgumentException("El usuario no existe");
    }
    if (existingCategoria == null) {
        throw new IllegalArgumentException("La categoría no existe");
    }

    // Asignar el usuario y la categoría existentes al producto
    producto.setUsuario(existingUsuario);
    producto.setCategorias(existingCategoria);

    // Guardar y devolver el producto
    return productoRepository.save(producto);
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
