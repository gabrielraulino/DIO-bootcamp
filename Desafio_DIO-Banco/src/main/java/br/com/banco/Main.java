package br.com.banco;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.println("-------- Digite a agencia para a criação do banco --------");
    Banco banco = new Banco(Integer.parseInt(sc.nextLine()));
    operacoes();
    label:
    while (true) {
      String line;
      String[] ui;
      String escolha = sc.nextLine();
      try {
        switch (escolha) {
          case "1":
            banco.imprimeContas();
            break;
          case "2":
            System.out.println("Digite o nome do titular, CPF (com 11 dígitos), tipo(cp, cc), saldo(opicional)");
            line = sc.nextLine();
            ui = line.split(" ");
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
            break;
          case "3":
            System.out.println("Digite o nome do cliente");
            String nome = sc.nextLine();
            banco.consulta(nome).infoClientes();
            break;
          case "4":
            //Invoca o metodo que printa as operações disponíveis
            operacoes();
            break;
          case "5":
            System.out.println("Digite o numero da conta do cliente a ser excluido");
            banco.excluiCliente(Integer.parseInt(sc.nextLine()));
            break;
          case "6": {
            System.out.println("Insira o numero da conta e o valor a ser depositado");
            line = sc.nextLine();
            ui = line.split(" ");
            int numConta;
            double valor;
            numConta = Integer.parseInt(ui[0]);
            valor = Double.parseDouble(ui[1]);
            Conta conta = banco.busca(numConta);
            conta.deposita(valor);
            break;
          }
          case "7": {
            System.out.println("Insira o numero da conta e o valor a ser sacado");
            line = sc.nextLine();
            ui = line.split(" ");
            int numConta;
            double valor;
            numConta = Integer.parseInt(ui[0]);
            valor = Double.parseDouble(ui[1]);
            banco.busca(numConta).saca(valor);
            break;
          }
          case "8": {
            System.out.println("Insira o numero da conta origem e da conta destino e o valor a ser transferido");
            line = sc.nextLine();
            ui = line.split(" ");
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
      } catch (InputMismatchException | NumberFormatException e) {
        System.out.println("Parametro invalido");
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("valor ou conta não inserida");
        break;
      } catch (NoSuchElementException e) {
        System.out.println("conta não encontrada!!");
      }
    }
  }

  //  menu que imprime as possíveis operações que o user irá fazer
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