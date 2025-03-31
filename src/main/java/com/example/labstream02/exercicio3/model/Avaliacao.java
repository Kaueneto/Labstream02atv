package com.example.labstream02.exercicio3.model;

public class Avaliacao {
    private String nomeFuncionario;
    private double nota;
    private String departamento;

    public Avaliacao(String nomeFuncionario, double nota, String departamento) {
        this.nomeFuncionario = nomeFuncionario;
        this.nota = nota;
        this.departamento = departamento;
    }

    // Getters
    public String getNomeFuncionario() { return nomeFuncionario; }
    public double getNota() { return nota; }
    public String getDepartamento() { return departamento; }
}