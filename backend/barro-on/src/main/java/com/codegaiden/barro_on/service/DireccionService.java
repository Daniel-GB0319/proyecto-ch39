package com.codegaiden.barro_on.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegaiden.barro_on.model.Direccion;
import com.codegaiden.barro_on.model.Usuario;
import com.codegaiden.barro_on.repository.DireccionRepository;
import com.codegaiden.barro_on.repository.UsuarioRepository;

import java.util.List;
import java.util.ArrayList;

@Service
public class DireccionService {

    // Inyectamos repositorios de Usuario y Direcciones
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    // Obtener todas las direcciones de un usuario
    public List<Direccion> getAllDirecciones(Long idUsuario) {
        // Verificamos que usuario ingresado exista
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            // Si usuario existe, regresa todas las direcciones asociadas
            return new ArrayList<>(usuario.getDireccion());
        }
        // Retorna null si usuario ingresado no existe (se podría cambiar por una
        // exception)
        return null;
    }

    // Obtener una dirección de un usuario
    public Direccion getDireccion(Long idUsuario, Long idDireccion) {
        // Verifica que usuario ingresado existe
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            // Dirección ingresada existe
            return direccionRepository.findById(idDireccion).orElse(null);
        }
        // Regresa null si no existe el usuario
        return null;
    }

    // Crear una dirección para un usuario
    public Direccion createDireccion(Long idUsuario, Direccion direccion) {
        // Verifica que usuario ingresado existe
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            // Usuario existe y asigna su id a la nueva direccion
            direccion.setUsuario(usuario);
            // Guarda la nueva direccion
            return direccionRepository.save(direccion);
        }
        // Regresa null si no existe el usuario
        return null;
    }

    // Actualizar una dirección de un usuario
    public Direccion putDireccion(Long idUsuario, Long idDireccion, Direccion direccionDetails) {
        // Verifica que usuario ingresado existe
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            // Verifica que direccion ingresada exista
            Direccion direccion = direccionRepository.findById(idDireccion).orElse(null);
            if (direccion != null) {
                // Direccion ingresada existe y actualiza sus datos
                direccion.setCalle(direccionDetails.getCalle());
                direccion.setNumExt(direccionDetails.getNumExt());
                direccion.setNumInt(direccionDetails.getNumInt());
                direccion.setColonia(direccionDetails.getColonia());
                direccion.setMunicipio(direccionDetails.getMunicipio());
                direccion.setCiudad(direccionDetails.getCiudad());
                direccion.setEstado(direccionDetails.getEstado());
                direccion.setCp(direccionDetails.getCp());
                return direccionRepository.save(direccion);
            }
        }
        // Retorna null si usuario ingresado no existe
        return null;
    }

    // Eliminar una dirección de un usuario
    public void deleteDireccion(Long idDireccion) {
        // Elimina la dirección
        direccionRepository.deleteById(idDireccion);
    }
}
