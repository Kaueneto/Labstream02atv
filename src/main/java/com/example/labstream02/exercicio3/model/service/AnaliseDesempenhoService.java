package com.example.labstream02.exercicio3.service;

import com.example.labstream02.exercicio3.model.Avaliacao;
import java.util.List;
import java.util.stream.Collectors;

public class AnaliseDesempenhoService {

    public List<Avaliacao> filtrarPorDepartamento(List<Avaliacao> avaliacoes, String departamento) {
        return avaliacoes.stream()
                .filter(a -> a.getDepartamento().equalsIgnoreCase(departamento))
                .collect(Collectors.toList());
    }


    public List<String> getNomesFuncionarios(List<Avaliacao> avaliacoes) {
        return avaliacoes.stream()
                .map(Avaliacao::getNomeFuncionario)
                .collect(Collectors.toList());
    }

    public double calcularMediaDepartamento(List<Avaliacao> avaliacoes, String departamento) {
        return filtrarPorDepartamento(avaliacoes, departamento).stream()
                .mapToDouble(Avaliacao::getNota)
                .average()
                .orElse(0.0);
    }

    public List<String> getFuncionariosAcimaDaMedia(List<Avaliacao> avaliacoes, String departamento) {
        double media = calcularMediaDepartamento(avaliacoes, departamento);

        return filtrarPorDepartamento(avaliacoes, departamento).stream()
                .filter(a -> a.getNota() > media)
                .map(Avaliacao::getNomeFuncionario)
                .collect(Collectors.toList());
    }
}