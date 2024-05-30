package com.codegaiden.barro_on.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegaiden.barro_on.repository.EstatusRepository;
import com.codegaiden.barro_on.repository.PedidoRepository;
import com.codegaiden.barro_on.repository.UsuarioRepository;

@Service
public class PedidoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstatusRepository estatusRepository;
    
    @Autowired
    private PedidoRepository pedidoRepository;

    

}
