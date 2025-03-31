package com.example.labstream02.exercicio4.model;

public class Transacao {
    private String nomeCliente;
    private String tipo; // se e credito ou deb
    private double valor;


    public Transacao(String nomeCliente, String tipo, double valor) {
        this.nomeCliente = nomeCliente;
        this.tipo = tipo;
        this.valor = valor;
    }


    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}