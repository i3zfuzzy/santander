package com.diogo.santander.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cpf;
    private String nome;
    private String profissao;
    @OneToMany
    private List<ContaCorrente> contasCorrente;
    @OneToMany(mappedBy = "titular", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartaoCredito> cartoesCreditos;

    public Cliente() {
    }

    public Cliente(String nome, String profissao, String cpf) {
        this.nome = nome;
        this.profissao = profissao;
        this.cpf = cpf;
    }

    public List<CartaoCredito> getCartoesCreditos() {
        return cartoesCreditos;
    }

    public void setCartoesCreditos(List<CartaoCredito> cartoesCreditos) {
        this.cartoesCreditos = cartoesCreditos;
    }

    public List<ContaCorrente> getContaCorrentes() {
        return contasCorrente;
    }

    public void setContaCorrentes(List<ContaCorrente> contaCorrentes) {
        this.contasCorrente = contaCorrentes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", profissao='" + profissao + '\'' +
                ", CPF='" + cpf + '\'' +
                '}';
    }

}
