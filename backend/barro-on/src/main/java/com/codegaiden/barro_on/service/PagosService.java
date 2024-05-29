package com.codegaiden.barro_on.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegaiden.barro_on.model.Pagos;
import com.codegaiden.barro_on.model.Usuario;
import com.codegaiden.barro_on.repository.PagosRepository;
import com.codegaiden.barro_on.repository.UsuarioRepository;

import java.util.List;
import java.util.ArrayList;

@Service
public class PagosService {

    // Inyectamos repositorios de Usuario y Pagos
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PagosRepository pagosRepository;

    // Obtener todas las direcciones de un usuario
    public List<Pagos> getAllPagos(Long idUsuario) {
        // Verificamos que usuario ingresado exista
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            // Si usuario existe, regresa todas los metodos de pago asociadas
            return new ArrayList<>(usuario.getPagos());
        }
        // Retorna null si usuario ingresado no existe (se podría cambiar por una
        // exception)
        return null;
    }

    // Obtener un método de pago de un usuario
    public Pagos getPago(Long idUsuario, Long idPago) {
        // Verifica que usuario ingresado existe
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            // Usuario ingresado existe
            return pagosRepository.findById(idPago).orElse(null);
        }
        // Regresa null si no existe el usuario
        return null;
    }

    // Crear un método de pago para un usuario
    public Pagos createPago(Long idUsuario, Pagos pago) {
        // Verifica que usuario ingresado existe
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            // Usuario existe y asigna su id al nuevo método de pago
            pago.setUsuario(usuario);
            // Guarda el nuevo método de pago
            return pagosRepository.save(pago);
        }
        // Regresa null si no existe el usuario
        return null;
    }

    // Actualizar un método de pago de un usuario
    public Pagos putPago(Long idUsuario, Long idPago, Pagos pagoDetails) {
        // Verifica que usuario ingresado existe
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            // Verifica que método de pago ingresado exista
            Pagos pago = pagosRepository.findById(idPago).orElse(null);
            if (pago != null) {
                // Método de pago ingresado existe y actualiza sus datos
                pago.setTipo(pagoDetails.getTipo());
                pago.setNumeroTarjeta(pagoDetails.getNumeroTarjeta());
                pago.setMes(pagoDetails.getMes());
                pago.setAnio(pagoDetails.getAnio());
                pago.setCvv(pagoDetails.getCvv());
                pago.setTitular(pagoDetails.getTitular());
                pago.setDirFacturacion(pagoDetails.getDirFacturacion());
                return pagosRepository.save(pago);
            }
        }
        // Retorna null si usuario ingresado no existe
        return null;
    }

    // Eliminar un método de pago de un usuario
    public void deletePago(Long idPago) {
        // Elimina la dirección
        pagosRepository.deleteById(idPago);
    }
}
