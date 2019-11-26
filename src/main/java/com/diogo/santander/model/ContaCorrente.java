package com.diogo.santander.model;
import com.diogo.santander.model.Cliente;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ContaCorrente {
    @Id
    private int numero;
    @ManyToOne
    Cliente titular;
    private double saldo;

    public ContaCorrente(Cliente titular, int numero, double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;

    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "titular=" + titular +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
