package com.example.labstream02.exercicio3.service;

import com.example.labstream02.exercicio3.model.Avaliacao;
import java.util.List;
import java.util.stream.Collectors;

public class AnaliseDesempenhoService {

    // 1. Filtrar avaliações por departamento
    public List<Avaliacao> filtrarPorDepartamento(List<Avaliacao> avaliacoes, String departamento) {
        return avaliacoes.stream()
                .filter(a -> a.getDepartamento().equalsIgnoreCase(departamento))
                .collect(Collectors.toList());
    }

    // 2. Mapear para lista de nomes
    public List<String> getNomesFuncionarios(List<Avaliacao> avaliacoes) {
        return avaliacoes.stream()
                .map(Avaliacao::getNomeFuncionario)
                .collect(Collectors.toList());
    }

    // 3. Calcular média do departamento
    public double calcularMediaDepartamento(List<Avaliacao> avaliacoes, String departamento) {
        return filtrarPorDepartamento(avaliacoes, departamento).stream()
                .mapToDouble(Avaliacao::getNota)
                .average()
                .orElse(0.0);
    }

    // 4. Funcionários com nota acima da média
    public List<String> getFuncionariosAcimaDaMedia(List<Avaliacao> avaliacoes, String departamento) {
        double media = calcularMediaDepartamento(avaliacoes, departamento);

        return filtrarPorDepartamento(avaliacoes, departamento).stream()
                .filter(a -> a.getNota() > media)
                .map(Avaliacao::getNomeFuncionario)
                .collect(Collectors.toList());
    }
}