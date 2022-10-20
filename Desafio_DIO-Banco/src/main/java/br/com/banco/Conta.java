package br.com.banco;

public abstract class Conta {
  private static int SEQUENCIAL = 0;
  private int numero;
  private int agencia;
  private Cliente titular;
  private double saldo = 0d;

  public int getNumero() {
    return numero;
  }

  public Cliente getTitular() {
    return titular;
  }

  public Double getSaldo() {
    return saldo;
  }

  public Conta(int agencia, Cliente titular, Double saldo) {
    this.numero = SEQUENCIAL++;
    this.agencia = agencia;
    this.titular = titular;
    this.saldo = saldo;
  }

  public Conta(int agencia, Cliente titular) {
    this.numero = SEQUENCIAL++;
    this.agencia = agencia;
    this.titular = titular;
    this.saldo = 0d;
  }

  public void deposita(double valor) {
    saldo += valor;
    System.out.println("Depósito realizado com sucesso!!");
  }

  public double saca(double valor) {
    if (saldo == 0) {
      System.out.println("Sem saldo na conta");
      return saldo;
    }
    if (valor > saldo) {
      System.out.println("Conta vazia após saque de " + saldo + "R$");
      double saida = saldo;
      saldo = 0;
      return saida;
    }
    System.out.println("Saque de " + valor + "R$ realizado com sucesso!!!");
    saldo -= valor;
    return valor;
  }

  public void transfere(Conta destino, double valor) {
    destino.deposita(this.saca(valor));
    System.out.println("transferencia realizada com sucesso");
  }

  protected void extrato() {
    System.out.printf("Nome: %s%n", titular.getNome());
    System.out.printf("CPF: %s%n", titular.getCpf());
    System.out.printf("Agencia %d%n", agencia);
    System.out.printf("Numero %d%n", numero);
    System.out.printf("Saldo %.2f%n", saldo);

  }
}
