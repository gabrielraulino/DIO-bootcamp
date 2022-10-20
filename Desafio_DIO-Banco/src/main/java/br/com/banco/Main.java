package br.com.banco;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    Scanner str = new Scanner(System.in);
    System.out.println("-------- Digite a agencia para a criação do banco --------");
    Banco banco = new Banco(Integer.parseInt(sc.nextLine()));

    operacoes();
    label:
    while (true) {
      String escolha = sc.nextLine();
      switch (escolha) {
        case "1":
          banco.imprimeContas();
          break;
        case "2":
          try {
            System.out.println("Digite o nome do titular, CPF (com 11 dígitos), tipo(cp, cc), saldo(opicional)");
            String line = str.nextLine();
            String[] ui = line.split(" ");
            if (ui.length == 3 || ui.length == 4) {
              if (ui.length == 3) {
                if (ui[2].equals("cc") || ui[2].equals("cp")) {
                  banco.addCliente(ui[0], ui[1], ui[2]);
                  System.out.println("Conta inserida com sucesso!!!");
                } else
                  System.out.println("Tipo de conta invalida");
              } else {
                if (ui[2].equals("cc") || ui[2].equals("cp")) {
                  banco.addClienteSaldo(ui[0], ui[1], ui[2], Double.parseDouble(ui[3]));
                  System.out.println("Conta inserida com sucesso!!!");
                } else
                  System.out.println("Tipo de conta invalida");
              }
            } else
              System.out.println("parametros insuficientes");
          } catch (InputMismatchException e) {
            System.out.println("parametros insuficientes");
          }
          break;
        case "3":
          try {
            System.out.println("Digite o nome do cliente");
            String nome = sc.nextLine();
            banco.consulta(nome).extrato();
          }catch (NullPointerException e){
            System.out.println("Cliente não encotrado");
          }
          break;
        case "4":
          operacoes();
          break;
        case "5":
          System.out.println("Digite o numero da conta do cliente a ser excluido");
          banco.excluiCliente(sc.nextInt());
          break;
        case "6": {
          System.out.println("Insira o numero da conta e o valor a ser depositado");
          String line = str.nextLine();
          String[] ui = line.split(" ");
          int numConta = Integer.parseInt(ui[0]);
          double saldo = Double.parseDouble(ui[1]);
          banco.busca(numConta).deposita(saldo);
          break;
        }
        case "7": {
          System.out.println("Insira o numero da conta e o valor a ser sacado");
          String line = str.nextLine();
          String[] ui = line.split(" ");
          int numConta = Integer.parseInt(ui[0]);
          double valor = Double.parseDouble(ui[1]);
          banco.busca(numConta).saca(valor);
          break;
        }
        case "8": {
          System.out.println("Insira o numero da conta origem e da conta destino e o valor a ser transferido");
          String line = str.nextLine();
          String[] ui = line.split(" ");
          int contaOrigem = Integer.parseInt(ui[0]);
          int contaDestino = Integer.parseInt(ui[1]);
          double valor = Double.parseDouble(ui[2]);
          Conta origem = banco.busca(contaOrigem);
          Conta destino = banco.busca(contaDestino);
          origem.transfere(destino, valor);
          break;
        }
        case "0":
          break label;
        default:
          System.out.println("Comando invalido");
          break;
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