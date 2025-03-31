package com.example.labstream02.exercicio2.service;

import com.example.labstream02.exercicio2.model.Tarefa;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TarefaService {

    public List<Tarefa> filtrarTarefasAltas(List<Tarefa> tarefas) {
        return tarefas.stream()
                .filter(t -> t.getPrioridade().equalsIgnoreCase("alta"))
                .collect(Collectors.toList());
    }

    // ret apenas descrições
    public List<String> getDescricoesTarefas(List<Tarefa> tarefas) {
        return tarefas.stream()
                .map(Tarefa::getDescricao)
                .collect(Collectors.toList());
    }


    public int calcularTempoTotalAltas(List<Tarefa> tarefas) {
        return filtrarTarefasAltas(tarefas).stream()
                .mapToInt(Tarefa::getTempoEstimadoHoras)
                .sum();
    }

    public List<Tarefa> ordenarPorPrioridade(List<Tarefa> tarefas) {
        return tarefas.stream()
                .sorted(Comparator.comparing(Tarefa::getPrioridade))
                .collect(Collectors.toList());
    }
}