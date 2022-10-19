package br.com.banco;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Scanner str = new Scanner(System.in);
    System.out.println("-------- Digite a agencia para a criação do banco --------");
    Banco banco = new Banco(Integer.parseInt(sc.nextLine()));

    operacoes();
    while (true) {
      String escolha = sc.nextLine();
      if (escolha.equals("1")) {
        banco.imprimeContas();
      } else if (escolha.equals("2")) {
        try {
          System.out.println("Digite o nome do titular, CPF (com 11 dígitos), tipo(cp, cc), saldo(opicional)");
          String line = str.nextLine();
          String ui[] = line.split(" ");
          if (ui.length == 3 || ui.length == 4) {
            if (ui.length == 3) {
              banco.addCliente(ui[0], ui[1], ui[2]);
              System.out.println("Conta inserida com sucesso!!!");
            } else {
              banco.addCliente(ui[0], ui[1], ui[2], Double.parseDouble(ui[3]));
              System.out.println("Conta inserida com sucesso!!!");
            }
          } else
            System.out.println("parametros insuficientes");
        } catch (InputMismatchException e) {
          System.out.println("parametros insuficientes");
        }
      } else if (escolha.equals("3")) {
        System.out.println(banco.consulta(sc.nextLine()).getTitular().getNome());
      } else if (escolha.equals("4"))
        operacoes();
      else if (escolha.equals("5")) {
        System.out.println("Digite o numero da conta do cliente a ser excluido");
        banco.excluiCliente(sc.nextInt());
      } else if (escolha.equals("6")) {
        System.out.println("Insira o numero da conta e o valor a ser depositado");
        String line = str.nextLine();
        String ui[] = line.split(" ");
        int numConta = Integer.parseInt(ui[0]);
        double saldo = Double.parseDouble(ui[1]);
        banco.busca(numConta).deposita(saldo);
      } else if (escolha.equals("7")) {
        System.out.println("Insira o numero da conta e o valor a ser sacado");
        String line = str.nextLine();
        String ui[] = line.split(" ");
        int numConta = Integer.parseInt(ui[0]);
        double valor = Double.parseDouble(ui[1]);
        banco.busca(numConta).saca(valor);
      } else if (escolha.equals("8")) {
        System.out.println("Insira o numero da conta origem e da conta destino e o valor a ser transferido");
        String line = str.nextLine();
        String ui[] = line.split(" ");
        int contaOrigem = Integer.parseInt(ui[0]);
        int contaDestino = Integer.parseInt(ui[1]);
        double valor = Double.parseDouble(ui[2]);
        Conta origem = banco.busca(contaOrigem);
        Conta destino = banco.busca(contaDestino);
        origem.transfere(destino, valor);
      } else if (escolha.equals("0")) {
        break;
      } else {
        System.out.println("Comando invalido");
      }
    }
  }

  public static void operacoes() {
    System.out.println("--------- Operacoes --------- ");
    System.out.println("1 - Consultar clientes        ");
    System.out.println("2 - Inserir clientes          ");
    System.out.println("3 - Procurar Cliente por nome ");
    System.out.println("4 - mostrar menu              ");
    System.out.println("5 - excluir cliente           ");
    System.out.println("6 - deposito                  ");
    System.out.println("7 - saque                     ");
    System.out.println("8 - transferencia             ");
    System.out.println("0 - sair                      ");
  }
}