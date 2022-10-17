package br.com.banco;

public class ContaCorrente extends Conta {


  public ContaCorrente(int agencia, Cliente titular, Double saldo) {
    super(agencia, titular, saldo);
  }

  public ContaCorrente(int agencia, Cliente titular) {
    super(agencia, titular);
  }
}
