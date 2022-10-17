package br.com.banco;

public class ContaPoupanca extends Conta{
  public ContaPoupanca(int agencia, Cliente titular, Double saldo) {
    super(agencia, titular, saldo);
  }

  public ContaPoupanca(int agencia, Cliente titular) {
    super(agencia, titular);
  }
}
