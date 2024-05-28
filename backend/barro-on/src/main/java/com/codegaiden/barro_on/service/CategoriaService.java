package com.codegaiden.barro_on.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.codegaiden.barro_on.model.Categoria;
import com.codegaiden.barro_on.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todas las categorias
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    // Obtener una categoria en especifico
    public Categoria getCategoria(Long idCategoria) {
        return categoriaRepository.findById(idCategoria).orElse(null);
    }

    // Crear una categoria
    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Actualizar una categoria
    public Categoria updateCategoria(Long idCategoria, Categoria categoriaDetails) {
        // Verifica que la categoria exista
        Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);
        if (categoria != null) {
            // Categoria existe y actualiza sus datos
            categoria.setNombre(categoriaDetails.getNombre());
            categoria.setDescripcion(categoriaDetails.getDescripcion());
        }
        return categoria;
    }

    // Eliminar una categoria
    public void deleteCategoria(Long idCategoria) {
        // Elimina la categoria
        categoriaRepository.deleteById(idCategoria);
    }

}
