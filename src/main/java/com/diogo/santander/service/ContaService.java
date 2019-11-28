package com.diogo.santander.service;

import com.diogo.santander.model.Cliente;
import com.diogo.santander.model.ContaCorrente;
import com.diogo.santander.repository.ContaRepository;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.sun.org.apache.xerces.internal.impl.xs.util.XSInputSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
    public String deposito(double valor, int numeroConta) {
        String msg = "";
        int qtdconta = contaRepository.validaNumConta(numeroConta);
        if(qtdconta == 0) {
            msg = "Conta inexistente";
        }else {
            double saldo = contaRepository.buscaSaldo(numeroConta);
            double saldoAtualizado = saldo + valor;
            contaRepository.atualizarSaldo(saldoAtualizado, numeroConta);
            msg = "deposito efetuado";
        }
        return msg;
    }
    public void pagar(double valor, int numeroConta){
        double saldo = contaRepository.buscaSaldo(numeroConta);
        double saldoAtualizado = saldo - valor;
        contaRepository.atualizarSaldo(saldoAtualizado, numeroConta);
    }
    public void sacar(double valor, int numeroConta){
        double saldo = contaRepository.buscaSaldo(numeroConta);
        double saldoAtualizado = saldo - valor;
        contaRepository.atualizarSaldo(saldoAtualizado, numeroConta);
    }



}
