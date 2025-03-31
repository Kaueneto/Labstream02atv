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

import java.util.ArrayList;
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

    // comecando os exercicios aqui
    private static void exercicio1() {
        System.out.println("EXERCICIO 01: PROCESSAMENTO DE PEDIDOS DE COMPRAS 🛒");


        List<Item> itensPedido1 = List.of(
                new Item("NOTEBOOK LENOVO IDEAPAD4", 2500.00),
                new Item("MOUSE SEM FIO OPTICO 3200 DPI USB WIRELESS", 120.00),
                new Item("TECLADO MULTILASER SLIM USB PRETO", 350.00)
        );
        Pedido pedido1 = new Pedido("Maria Oliveira", itensPedido1, true);


        List<Item> itensPedido2 = List.of(
                new Item("Caneta Esferográfica Azul", 100.00)
        );
        Pedido pedido2 = new Pedido("Jucelino Kubitschek", itensPedido2, false);

        ProcessamentoPedidosService service = new ProcessamentoPedidosService();

        List<String> clientesAcima1500 = new ArrayList<>();


        System.out.println("\nPEDIDO 20251- " + pedido1.getCliente());
        pedido1.getItens().forEach(item ->
                System.out.printf("- %s: R$%.2f%n", item.getNomeProduto(), item.getValor())
        );
        double total1 = service.calcularValorTotalComDesconto(pedido1);
        System.out.printf("Total com desconto: R$%.2f%n", total1);

        if (total1 > 1500) {
            clientesAcima1500.add(pedido1.getCliente());
        }


        System.out.println("\nPEDIDO 20252- " + pedido2.getCliente());
        pedido2.getItens().forEach(item ->
                System.out.printf("- %s: R$%.2f%n", item.getNomeProduto(), item.getValor())
        );
        double total2 = service.calcularValorTotalComDesconto(pedido2);
        System.out.printf("Total com desconto: R$%.2f%n", total2);


        System.out.println("\nCLIENTES COM PEDIDOS ACIMA DE R$1500,00:");
        if (clientesAcima1500.isEmpty()) {
            System.out.println("Nenhum cliente encontrado");
        } else {
            clientesAcima1500.forEach(cliente ->
                    System.out.println("CLIENTE " + cliente + ", PEDIDO ACIMA DE R$1500,00"));
            System.out.println("**********************************************************************");
        }
    }
// -------------------------------**********************************************************



    private static void exercicio2() {
        System.out.println("EXERCICIO 02: GERENCIAMENTO DE TAREFAS 📝");

        List<Tarefa> tarefas = List.of(
                new Tarefa("IMPLEMENTAR TELA DE LOGIN ", "alta", 8),
                new Tarefa("ATUALIZAR DOCUMENTAÇÃO", "baixa", 3),
                new Tarefa("TESTAR MODULO X", "alta", 5),
                new Tarefa("REVISAR UI", "media", 4)
        );

        TarefaService service = new TarefaService();

        System.out.println("\nTAREFAS DE ALTA PRIORIDADE:");
        service.filtrarTarefasAltas(tarefas).forEach(t ->
                System.out.println("- " + t.getDescricao() + t.getTempoEstimado() +  " horas")
        );

        System.out.println("\n LISTA DE TAREFAS - SOMENTE DESCRIÇÕES:");
        service.getDescricoes(tarefas).forEach(System.out::println);

        System.out.printf("\nTEMPO TOTAL (ALTA): %d horas%n",
                service.calcularTempoTotalAltas(tarefas));

        System.out.println("\nTAREFAS ORDENADAS:");
        service.ordenarPorPrioridade(tarefas).forEach(t ->
                System.out.printf("- %s (%s)%n", t.getDescricao(), t.getPrioridade())
        );
        System.out.println("**********************************************************************");
    }

    //**************************************************************************************


    // exerc 3
    private static void exercicio3() {
        System.out.println("EXERCICIO 03: ANALISE DE DESEMPENHO");

        // Dados de exemplo
        List<Avaliacao> avaliacoes = List.of(
                new Avaliacao("JOAO COSTA E SILVA", 9.5, "TI"),
                new Avaliacao("MARIA CALLAS", 7.0, "Vendas"),
                new Avaliacao("CARLOS DRUMMOND", 8.0, "TI"),
                new Avaliacao("ANA COSTA ", 6.5, "Vendas"),
                new Avaliacao("JOSE EDUARDO", 8.0, "TI")
        );

        String departamentoAlvo = "TI";
        AnaliseDesempenhoService service = new AnaliseDesempenhoService();

        System.out.println("\n🔍 FUNCIONARIOS DO DEPTO " + departamentoAlvo + ":");
        service.filtrarPorDepartamento(avaliacoes, departamentoAlvo).forEach(a ->
                System.out.println("- " + a.getNomeFuncionario() + ": " + a.getNota())
        );

        System.out.println("\nNOMES DOS FUNCIONARIOS:");
        service.getNomesFuncionarios(avaliacoes).forEach(System.out::println);


        double media = service.calcularMediaDepartamento(avaliacoes, departamentoAlvo);
        System.out.printf("\nMEIDA DO DEPTO 📊 %s: %.1f%n", departamentoAlvo, media);

        System.out.println("\n DESTAQUES (ACIMA DA MÉDIA):");
        service.getFuncionariosAcimaDaMedia(avaliacoes, departamentoAlvo).forEach(nome ->
                System.out.println("- " + nome)
        );

        System.out.println("****************************************************************************");
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
                service.calculatotalPortipo(transacoes, "crédito"));
        System.out.printf("Débitos: R$%.2f%n",
                service.calculatotalPortipo(transacoes, "débito"));
    }
}