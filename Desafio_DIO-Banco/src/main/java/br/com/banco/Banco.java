package br.com.banco;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Banco {
  private int agencia;
  private ArrayList<Conta> contas = new ArrayList<>();
  public Banco(int agencia) {
    this.agencia = agencia;
  }

  /**
   * Cliente sem o saldo
   * @param nome
   * @param CPF
   * @param tipo
   */
  public void addCliente(String nome, String CPF, @NotNull String tipo){
    if(tipo.equals("cc")){
      contas.add(new ContaCorrente(agencia, new Cliente(nome,CPF)));
    }
    if(tipo.equals("cp")){
      contas.add(new ContaPoupanca(agencia, new Cliente(nome,CPF)));
    }
  }

  /**
   * Cliente com o saldo
   * @param nome
   * @param CPF
   * @param tipo
   * @param saldo
   */
  public void addCliente(String nome, String CPF, @NotNull String tipo , double saldo){
    if(tipo.equals("cc")){
      contas.add(new ContaCorrente(agencia, new Cliente(nome,CPF),saldo));
    }
    if(tipo.equals("cp")){
      contas.add(new ContaPoupanca(agencia, new Cliente(nome,CPF),saldo));
    }
  }

  @Override
  public String toString() {
    return contas.toString();
  }
}
