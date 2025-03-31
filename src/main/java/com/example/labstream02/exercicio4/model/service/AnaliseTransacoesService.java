package com.example.labstream02.exercicio4.service;

import com.example.labstream02.exercicio4.model.Transacao;
import java.util.List;
import java.util.stream.Collectors;

public class AnaliseTransacoesService {

    // Filtra transações por tipo
    public List<Transacao> filtrarPorTipo(List<Transacao> transacoes, String tipo) {
        return transacoes.stream()
                .filter(t -> t.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    // Retorna apenas valores das transações
    public List<Double> getValoresTransacoes(List<Transacao> transacoes) {
        return transacoes.stream()
                .map(Transacao::getValor)
                .collect(Collectors.toList());
    }

    // Calcula total por tipo
    public double calcularTotalPorTipo(List<Transacao> transacoes, String tipo) {
        return filtrarPorTipo(transacoes, tipo).stream()
                .mapToDouble(Transacao::getValor)
                .sum();
    }

    // Imprime resumo de transações
    public void imprimirResumoTransacoes(List<Transacao> transacoes) {
        double totalCreditos = calcularTotalPorTipo(transacoes, "crédito");
        double totalDebitos = calcularTotalPorTipo(transacoes, "débito");

        System.out.println("Total Créditos: R$" + totalCreditos);
        System.out.println("Total Débitos: R$" + totalDebitos);
        System.out.println("Saldo: R$" + (totalCreditos - totalDebitos));
    }
}