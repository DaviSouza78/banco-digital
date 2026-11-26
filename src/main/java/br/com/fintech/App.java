package br.com.fintech;

public class App {
    public static void main(String[] args) {
        ContaCorrente corrente = new ContaCorrente("001", "Ana Souza", 500);
        corrente.depositar(1000);
        corrente.sacar(1300);                // usa o limite do cheque especial
        System.out.println(corrente);

        ContaPoupanca poupanca = new ContaPoupanca("002", "Bruno Lima", 0.005);
        poupanca.depositar(2000);
        poupanca.renderJuros();
        System.out.println(poupanca);

        corrente.aplicarTarifaMensal();
        System.out.println("Depois da tarifa: " + corrente);
    }
}
