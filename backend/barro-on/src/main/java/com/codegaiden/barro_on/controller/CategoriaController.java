package com.codegaiden.barro_on.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.codegaiden.barro_on.model.Categoria;
import com.codegaiden.barro_on.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Obtener todas las categorias
    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    // Obtener una categoría en especifico
    @GetMapping("/{idCategoria}")
    public Categoria getCategoria(@PathVariable Long idCategoria) {
        return categoriaService.getCategoria(idCategoria);
    }

    // Crear una categoría
    @PostMapping
    public Categoria postCategoria(@RequestBody Categoria categoria) {
        return categoriaService.createCategoria(categoria);
    }

    // Actualizar una categoria
    @PutMapping("/{idCategoria}")
    public Categoria putCategoria(@PathVariable Long idCategoria, @RequestBody Categoria categoria) {
        return categoriaService.updateCategoria(idCategoria, categoria);
    }

    // Borrar una categoria
    @DeleteMapping("/{idCategoria}")
    public void deleteCategoria(@PathVariable Long idCategoria) {
        categoriaService.deleteCategoria(idCategoria);
    }
}
