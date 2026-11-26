package br.com.fintech;

public class Conta {

    // atributos: o ESTADO de cada objeto conta
    String numero;
    String titular;
    double saldo;

    // métodos: o COMPORTAMENTO
    void depositar(double valor) {
        saldo = saldo + valor;
    }

    void sacar(double valor) {
        saldo = saldo - valor;
    }

    void exibir() {
        System.out.println("Conta " + numero + " de " + titular + ": R$ " + saldo);
    }
}
