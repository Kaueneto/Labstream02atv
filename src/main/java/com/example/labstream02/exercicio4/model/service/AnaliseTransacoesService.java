package com.example.labstream02.exercicio4.service;

import com.example.labstream02.exercicio4.model.Transacao;
import java.util.List;
import java.util.stream.Collectors;

public class AnaliseTransacoesService {

    public List<Transacao> filtrarPorTipo(List<Transacao> transacoes, String tipo) {
        return transacoes.stream()
                .filter(t -> t.getTipoTransacao().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    public List<Double> getValoresTransacoes(List<Transacao> transacoes) {
        return transacoes.stream()
                .map(Transacao::getValor)
                .collect(Collectors.toList());
    }


    public double calcularTotalPorTipo(List<Transacao> transacoes, String tipo) {
        return filtrarPorTipo(transacoes, tipo).stream()
                .mapToDouble(Transacao::getValor)
                .sum();
    }

    public void imprimirResumoTransacoes(List<Transacao> transacoes) {
        double totalCreditos = calcularTotalPorTipo(transacoes, "crédito");
        double totalDebitos = calcularTotalPorTipo(transacoes, "débito");

        System.out.println("\nRESUMO FINANCEIRO:");
        System.out.printf("Créditos: R$%.2f%n", totalCreditos);
        System.out.printf("Débitos: R$%.2f%n", totalDebitos);

    }
}