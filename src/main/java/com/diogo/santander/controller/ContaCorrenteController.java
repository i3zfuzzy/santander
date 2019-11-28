package com.diogo.santander.controller;

import com.diogo.santander.model.ContaCorrente;
import com.diogo.santander.service.CartaoService;
import com.diogo.santander.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/conta-corrente")
public class ContaCorrenteController {

    @Autowired
    private ContaService contaService;
    @Autowired
    private CartaoService cartaoService;

    @PostMapping(value = "/deposito/{valor}/{numeroConta}")
    public String depositar(@PathVariable double valor, @PathVariable int numeroConta){
        return contaService.deposito(valor, numeroConta);
    }

    @PostMapping(value = "/pagar/{valor}/{numeroConta}")
    public void pagar(@PathVariable double valor, @PathVariable int numeroConta){
        contaService.pagar(valor, numeroConta);
    }

    @PostMapping(value = "/pagcartao/{valor}/{numeroCartao}")
    public String pagarCartao(@PathVariable double valor, @PathVariable String numeroCartao){
        String msg = "";
        if(valor <= 0) {
            msg = "Valor invaliddo";
        }else{
            cartaoService.pagarCartao(valor, numeroCartao);
        }
        return msg;
    }

    @PostMapping(value = "/sacar/{valor}/{numeroConta}")
    public String sacar(@PathVariable double valor, @PathVariable int numeroConta){
        String msg = "";
        if(valor <= 0){
            msg = "valor invalido";
        }else{
            contaService.sacar(valor, numeroConta);
        }
        return msg;
    }

    @PostMapping(value = "/aumentalimite/{valor}/{numeroCartao}")
    public void aumentaLimite(@PathVariable double valor, @PathVariable String numeroCartao){
        cartaoService.aumentaLimite(valor, numeroCartao);
    }

    @PostMapping(value = "/pagfat/{valor}/{numeroCartao}")
    public void pagfatura(@PathVariable double valor, @PathVariable String numeroCartao){
        cartaoService.pagfatura(valor, numeroCartao);
    }
}
