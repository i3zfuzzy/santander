package com.diogo.santander.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class CartaoCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String numero;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente titular;
    private double limite;
    private double fatura;

    public CartaoCredito(Cliente titular, String numero, double limite, double fatura) {
        this.titular = titular;
        this.numero = numero;
        this.limite = limite;
        this.fatura = fatura;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getFatura() {
        return fatura;
    }

    public void setFatura(double fatura) {
        this.fatura = fatura;
    }

    @Override
    public String toString() {
        return "CartaoCredito{" +
                "titular=" + titular +
                ", numero='" + numero + '\'' +
                ", limite=" + limite +
                ", fatura=" + fatura +
                '}';
    }
}
