package com.example.labstream02.exercicio1.model;


public class Item {
    private String nomeProduto;
    private double valor;


    public Item(String nomeProduto, double valor) {
        this.nomeProduto = nomeProduto;
        this.valor = valor;
    }


    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getValor() {
        return valor;
    }
}