package com.example.labstream02.exercicio4.model;

public class Transacao {
    private String nomeCliente;
    private String tipoTransacao; // "crédito" ou "débito"
    private double valor;

    public Transacao(String nomeCliente, String tipoTransacao, double valor) {
        this.nomeCliente = nomeCliente;
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
    }

    public String getNomeCliente() { return nomeCliente; }
    public String getTipoTransacao() { return tipoTransacao; }
    public double getValor() { return valor; }
}