package com.diogo.santander.controller;

import com.diogo.santander.model.Cliente;
import com.diogo.santander.service.CartaoService;
import com.diogo.santander.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private CartaoService cartaoService;

    @PostMapping(value = "/cadastro-cliente")
    public Cliente cadastroCliente(@RequestBody Cliente cliente) {
        clienteService.salvarCliente(cliente);
        cartaoService.cadastroCartao(cliente);
        return cliente;
    }
}
