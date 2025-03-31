package com.example.labstream02;

import com.example.labstream02.exercicio1.model.Item;
import com.example.labstream02.exercicio1.model.Pedido;
import com.example.labstream02.exercicio1.service.ProcessamentoPedidosService;
import com.example.labstream02.exercicio2.model.Tarefa;
import com.example.labstream02.exercicio2.service.TarefaService;
import com.example.labstream02.exercicio3.model.Avaliacao;
import com.example.labstream02.exercicio3.service.AnaliseDesempenhoService;
import com.example.labstream02.exercicio4.model.Transacao;
import com.example.labstream02.exercicio4.service.AnaliseTransacoesService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***********ATIVIDADE STREAM************\n");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Processamento de Pedidos");
            System.out.println("2 - Gerenciamento de Tarefas");
            System.out.println("3 - Análise de Desempenho");
            System.out.println("4 - Análise de Transações");
            System.out.println("0 - Sair");
            System.out.print("Escolha um exercicio a ser resolvido: ");

            int escolha = scanner.nextInt();
            System.out.println();

            switch (escolha) {
                case 1 -> exercicio1();
                case 2 -> exercicio2();
                case 3 -> exercicio3();
                case 4 -> exercicio4();
                case 0 -> {
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    // exerc 1
    private static void exercicio1() {
        System.out.println("EXERCICIO 01: PROCESSAMENTO DE PEDIDOS DE COMPRAS 🛒");

        List<Item> itens = List.of(
                new Item("NOTEBOOK LENOVO IDEAPAD4", 2500.00),
                new Item("MOUSE SEM FIO OPTICO 3200 DPI USB WIRELESS", 120.00),
                new Item("TECLADO MULTILASER SLIM USB PRETO", 350.00)
        );

        Pedido pedido = new Pedido("Maria Oliveira", itens, true);
        ProcessamentoPedidosService service = new ProcessamentoPedidosService();

        System.out.println("\n Itens do pedido:");
        pedido.getItens().forEach(item ->
                System.out.printf("- %s: R$%.2f%n", item.getNomeProduto(), item.getValor())
        );


        double total = service.calcularValorTotalComDesconto(pedido);
        System.out.printf("\n Total com desconto(-10): R$%.2f%n", total);

    }

    // exerc 2
    private static void exercicio2() {
        System.out.println("EXERCICIO 02: GERENCIAMENTO DE TAREFAS DE PROJETO");

        List<Tarefa> tarefas = List.of(
                new Tarefa("Criar banco de dados", "alta", 5),
                new Tarefa("Escrever documentação", "baixa", 2),
                new Tarefa("Testar sistema", "alta", 3)
        );

        TarefaService service = new TarefaService();

        System.out.println("\n🔝 Tarefas de alta prioridade:");
        service.filtrarTarefasAltas(tarefas).forEach(tarefa ->
                System.out.printf("- %s (%d horas)%n", tarefa.getDescricao(), tarefa.getTempoEstimadoHoras())
        );

        int totalHoras = service.calcularTempoTotalAltas(tarefas);
        System.out.println("\n⏳ Total de horas (alta prioridade): " + totalHoras);
    }

    // exerc 3
    private static void exercicio3() {
        System.out.println("EXERCICIO 03: ANALISE DE DESEMPENHO DE FUNCIONARIOS");

        List<Avaliacao> avaliacoes = List.of(
                new Avaliacao("João", 8.5, "T.I."),
                new Avaliacao("Maria", 6.0, "VENDAS"),
                new Avaliacao("Carlos", 9.0, "FINANCEIRO")
        );

        AnaliseDesempenhoService service = new AnaliseDesempenhoService();
        String departamento = "T.I.";

        System.out.printf("\n🏅 Média do departamento %s: %.1f%n",
                departamento, service.calcularMediaDepartamento(avaliacoes, departamento));

        System.out.println("\n⭐ Destaques:");
        service.getFuncionariosAcimaDaMedia(avaliacoes, departamento).forEach(System.out::println);
    }

    // exerc 4
    private static void exercicio4() {
        System.out.println("EXERCICIO 04: ANALISE DE TRANSACOES BANCARIAS💰 ");

        List<Transacao> transacoes = List.of(
                new Transacao("Cliente A", "crédito", 1000.00),
                new Transacao("Cliente B", "débito", 250.00),
                new Transacao("Cliente A", "crédito", 500.00)
        );

        AnaliseTransacoesService service = new AnaliseTransacoesService();

        System.out.println("\n💸 Resumo financeiro:");
        System.out.printf("Créditos: R$%.2f%n",
                service.calcularTotalPorTipo(transacoes, "crédito"));
        System.out.printf("Débitos: R$%.2f%n",
                service.calcularTotalPorTipo(transacoes, "débito"));
    }
}