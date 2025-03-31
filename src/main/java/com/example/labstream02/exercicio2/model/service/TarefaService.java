package com.example.labstream02.exercicio2.service;

import com.example.labstream02.exercicio2.model.Tarefa;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TarefaService {

    // 1. Filtrar tarefas com prioridade alta
    public List<Tarefa> filtrarTarefasAltas(List<Tarefa> tarefas) {
        return tarefas.stream()
                .filter(t -> t.getPrioridade().equalsIgnoreCase("alta")) // Lambda
                .collect(Collectors.toList());
    }

    // 2. Mapear para exibir apenas descrições
    public List<String> getDescricoes(List<Tarefa> tarefas) {
        return tarefas.stream()
                .map(Tarefa::getDescricao) // Method reference
                .collect(Collectors.toList());
    }

    // 3. Calcular tempo total das tarefas altas
    public int calcularTempoTotalAltas(List<Tarefa> tarefas) {
        return filtrarTarefasAltas(tarefas).stream()
                .mapToInt(Tarefa::getTempoEstimado) // Lambda
                .sum();
    }

    // 4. Ordenar por prioridade
    public List<Tarefa> ordenarPorPrioridade(List<Tarefa> tarefas) {
        return tarefas.stream()
                .sorted(Comparator.comparing(Tarefa::getPrioridade)) // Lambda
                .collect(Collectors.toList());
    }
}