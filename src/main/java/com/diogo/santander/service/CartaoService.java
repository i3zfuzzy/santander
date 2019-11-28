package com.diogo.santander.service;

import com.diogo.santander.model.CartaoCredito;
import com.diogo.santander.model.Cliente;
import com.diogo.santander.repository.CartaoRepository;
import com.diogo.santander.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private ContaRepository contaRepository;

    public void cadastroCartao(Cliente cliente) {
        List<Integer> numCard = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            numCard.add(i);
        }
        for (int i = 0; i <= numCard.size(); i++) {
            Collections.shuffle(numCard);
        }
        String num = numCard.stream().map(String::valueOf).collect(Collectors.joining());
        String numero = (num.substring(0, 4) + "." + num.substring(4, 8) + "." + num.substring(8, 12) + "." + num.substring(12, 16));
        double limite = 400;
        double fatura = 0;
        CartaoCredito novoCartao = new CartaoCredito(cliente, numero, limite, fatura);
        cartaoRepository.save(novoCartao);
        List<CartaoCredito> listaCartoes = new ArrayList<>();
        listaCartoes.add(novoCartao);
        cliente.setCartoesCreditos(listaCartoes);
    }

    public void pagarCartao (double valor, String numeroCartao) {
        double limiteAtual = cartaoRepository.consultaLimite(numeroCartao);
        double limiteAtualizado = limiteAtual - valor;
        cartaoRepository.atualizaLimiteFatura(numeroCartao, limiteAtualizado, valor);

    }
    public void aumentaLimite(double valor, String numeroCartao){
        double limiteAtual = cartaoRepository.consultaLimite(numeroCartao);
        double limiteAtualizado = limiteAtual + valor;
        cartaoRepository.atualizaLimite(numeroCartao, limiteAtualizado);
    }

    public void pagfatura(double valor, String numeroCartao){
        double faturaAtual = cartaoRepository.consultaFatura(numeroCartao);
        double faturaAtualizada = faturaAtual - valor;
        cartaoRepository.atualizaFatura(numeroCartao, faturaAtualizada);
    }
}
