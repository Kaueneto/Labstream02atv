package com.example.labstream02.exercicio2.model;

public class Tarefa {
    private String descricao;
    private String prioridade; // "alta", "media", "baixa"
    private int tempoEstimadoHoras;

    // Construtor
    public Tarefa(String descricao, String prioridade, int tempoEstimadoHoras) {
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.tempoEstimadoHoras = tempoEstimadoHoras;
    }

    // Getters
    public String getDescricao() {
        return descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public int getTempoEstimadoHoras() {
        return tempoEstimadoHoras;
    }
}