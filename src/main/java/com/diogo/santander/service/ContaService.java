package com.diogo.santander.service;

import com.diogo.santander.model.Cliente;
import com.diogo.santander.model.ContaCorrente;
import com.diogo.santander.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public void cadastroConta(Cliente cliente) {
        double saldo = 0;
        List<Integer> numCont = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            numCont.add(i);
        }
        for (int i = 0; i <= numCont.size(); i++) {
            Collections.shuffle(numCont);
        }
        String num = numCont.stream().map(String::valueOf).collect(Collectors.joining());
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setTitular(cliente);
        contaCorrente.setNumero(Integer.parseInt(num));
        contaCorrente.setSaldo(saldo);
        contaRepository.save(contaCorrente);

    }

}
