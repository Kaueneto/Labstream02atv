package com.example.labstream02.exercicio1.model;


import com.example.labstream02.exercicio1.model.Item;

import java.util.List;

public class Pedido {
    private String cliente;
    private List<Item> itens;
    private boolean pago;


    public Pedido(String cliente, List<Item> itens, boolean pago) {
        this.cliente = cliente;
        this.itens = itens;
        this.pago = pago;
    }

    public String getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public boolean isPago() {
        return pago;
    }
}