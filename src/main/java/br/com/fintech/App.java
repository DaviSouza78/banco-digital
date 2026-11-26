package br.com.fintech;

import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Cliente ana1 = new Cliente("Ana Souza", "12345678901");
        Cliente ana2 = new Cliente("Ana Souza", "12345678901");

        System.out.println("ana1 == ana2 ? " + (ana1 == ana2));          // mesma referência?
        System.out.println("ana1.equals(ana2) ? " + ana1.equals(ana2));  // mesmo conteúdo?

        Set<Cliente> clientes = new HashSet<>();
        clientes.add(ana1);
        clientes.add(ana2);
        System.out.println("Clientes cadastrados: " + clientes.size());
        System.out.println(ana1);
    }
}
