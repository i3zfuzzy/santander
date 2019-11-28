package com.diogo.santander.service;

import com.diogo.santander.model.Cliente;
import com.diogo.santander.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void salvarCliente(Cliente cliente){
        clienteRepository.save(cliente);

    }
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
}
