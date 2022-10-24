package br.com.banco;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Banco {
  private final int agencia;
  private final ArrayList<Conta> contas = new ArrayList<>();

  public Banco(int agencia) {
    this.agencia = agencia;
  }

  /**
   * Cliente sem o saldo
   *
   * @param nome recebe o nome do cliente
   * @param CPF  String que recebe o CPF do cliente
   * @param tipo recebe dois caracteres que recebe o tipo da contra
   */
  public void addCliente(String nome, String CPF, @NotNull String tipo) {
    if (tipo.equals("cc")) {
      contas.add(new ContaCorrente(agencia, new Cliente(nome, CPF)));
    }
    if (tipo.equals("cp")) {
      contas.add(new ContaPoupanca(agencia, new Cliente(nome, CPF)));
    }
  }

  /**
   * Cliente com o saldo
   *
   * @param nome  recebe o nome do cliente
   * @param CPF   recebe o CPF do cliente
   * @param tipo  recbe dois caracteres que recebe o tipo da contra
   * @param saldo recebe o saldo inicial do cliente
   */
  public void addClienteSaldo(String nome, String CPF, @NotNull String tipo, double saldo) {
    if (tipo.equals("cc")) {
      contas.add(new ContaCorrente(agencia, new Cliente(nome, CPF), saldo));
    }
    if (tipo.equals("cp")) {
      contas.add(new ContaPoupanca(agencia, new Cliente(nome, CPF), saldo));
    }
  }

  public Conta consulta(String nome) {
    try {
      return contas
          .stream()
          .filter(e -> e.getTitular()
          .getNome()
          .equals(nome)).iterator()
          .next();
    } catch (NullPointerException e) {
      return null;
    }
  }

  public void imprimeContas() {
    contas.forEach(Conta::infoClientes);
  }

  void excluiCliente(int num) {
    Conta conta = busca(num);
    contas.remove(conta);

  }

  public Conta busca(int num) {
    try {
      return contas
          .stream()
          .filter(e -> e.getNumero() == num).iterator()
          .next();
    } catch (ArrayIndexOutOfBoundsException e) {
      return null;
    }
  }

  @Override
  public String toString() {
    return contas.toString();
  }
}
