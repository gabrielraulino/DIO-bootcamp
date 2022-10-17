package br.com.banco;

public abstract class Conta {
  private static int SEQUENCIAL = 0;
  private int numero;
  private int agencia;
  private Cliente titular;
  private double saldo = 0d;
  private int id;

  public int getNumero() {
    return numero;
  }

  public Cliente getTitular() {
    return titular;
  }

  public Double getSaldo() {
    return saldo;
  }

  public int getId() {
    return id;
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

  public void deposita(double valor){
    saldo += valor;
  }

  public double saca(double valor){
    if(saldo == 0){
      System.out.println("Sem saldo na conta");
      return saldo;
    }
    if(valor > saldo){
      System.out.println("Conta vazia após saque de "+saldo+"R$");
       double saida = saldo;
       saldo = 0;
       return saida;
    }
    System.out.println("Saque de "+valor+"R$ realizado com sucesso!!!");
    saldo -= valor;
    return valor;
  }

   public void transfere(Conta destino, double valor){
      destino.deposita(this.saca(valor));
   }
}
