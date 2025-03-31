package com.example.labstream02.exercicio2.model;


public class Tarefa {
    private String descricao;
    private String prioridade; // "alta", "media", "baixa"
    private int tempoEstimado; // em horas


    public Tarefa(String descricao, String prioridade, int tempoEstimado) {
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.tempoEstimado = tempoEstimado;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public int getTempoEstimado() {
        return tempoEstimado;
    }

    public int getTempoEstimadoHoras() {
        return 0;
    }
}
