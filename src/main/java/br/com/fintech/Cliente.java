package br.com.fintech;

import java.util.Objects;

public class Cliente {

    private final String nome;
    private final String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                        // mesmo objeto
        if (!(o instanceof Cliente outro)) return false;   // tipo diferente (ou null)
        return cpf.equals(outro.cpf);                      // mesma identidade de negócio
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);          // TEM que usar os mesmos campos do equals
    }

    @Override
    public String toString() {
        return "Cliente{nome='" + nome + "', cpf='" + cpf + "'}";
    }
}
