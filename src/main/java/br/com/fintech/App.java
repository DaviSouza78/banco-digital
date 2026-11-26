package br.com.fintech;

public class App {
    public static void main(String[] args) {
        Conta contaDaAna = new Conta();      // new cria um OBJETO no heap
        contaDaAna.numero = "001";
        contaDaAna.titular = "Ana Souza";
        contaDaAna.depositar(1000);

        Conta contaDoBruno = new Conta();    // outro objeto, outro estado
        contaDoBruno.numero = "002";
        contaDoBruno.titular = "Bruno Lima";
        contaDoBruno.depositar(250);

        Conta outraReferencia = contaDaAna;  // NÃO cria objeto: aponta para o mesmo
        outraReferencia.sacar(100);

        contaDaAna.exibir();
        contaDoBruno.exibir();

        // Nada impede isto... e é esse o problema que a próxima etapa resolve:
        contaDoBruno.saldo = -1_000_000;
        contaDoBruno.exibir();
    }
}
