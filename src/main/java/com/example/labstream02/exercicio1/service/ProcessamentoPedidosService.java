package com.example.labstream02.exercicio1.service;

import com.example.labstream02.exercicio1.model.Pedido;
import com.example.labstream02.exercicio1.model.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ProcessamentoPedidosService {


    public List<com.example.labstream02.exercicio1.model.Pedido> filtrarPedidosPagos(List<com.example.labstream02.exercicio1.model.Pedido> pedidos) {
        return pedidos.stream()
                .filter(com.example.labstream02.exercicio1.model.Pedido::isPago)
                .collect(Collectors.toList());
    }


    public double calcularValorTotalComDesconto(com.example.labstream02.exercicio1.model.Pedido pedido) {
        double total = pedido.getItens().stream()
                .mapToDouble(Item::getValor)
                .sum();
        return total > 1000 ? total * 0.9 : total;
    }

    public List<String> getClientesComPedidosGrandes(List<com.example.labstream02.exercicio1.model.Pedido> pedidos) {
        return pedidos.stream()
                .filter(p -> calcularValorTotalComDesconto(p) > 1500)
                .map(com.example.labstream02.exercicio1.model.Pedido::getCliente)
                .collect(Collectors.toList());
    }
}