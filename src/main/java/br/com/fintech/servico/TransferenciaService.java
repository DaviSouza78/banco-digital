package br.com.fintech.servico;

import br.com.fintech.Conta;
import br.com.fintech.repositorio.ContaRepository;

public class TransferenciaService {

    private final ContaRepository repositorio;   // depende de ABSTRAÇÕES (interfaces)
    private final PoliticaDeTarifa politica;

    // Injeção de dependência pelo construtor: quem cria o serviço escolhe as peças
    public TransferenciaService(ContaRepository repositorio, PoliticaDeTarifa politica) {
        this.repositorio = repositorio;
        this.politica = politica;
    }

    public void transferir(String origem, String destino, double valor) {
        if (!(valor > 0 && valor <= Double.MAX_VALUE)) {
            throw new IllegalArgumentException("O valor deve ser positivo e finito: " + valor);
        }
        if (origem.equals(destino)) {
            throw new IllegalArgumentException("Origem e destino devem ser diferentes");
        }
        Conta de = buscar(origem);
        Conta para = buscar(destino);
        double tarifa = politica.calcular(valor);
        if (!(tarifa >= 0 && valor + tarifa <= Double.MAX_VALUE)) {
            throw new IllegalArgumentException("Tarifa inválida: " + tarifa);
        }
        if (!(para.getSaldo() + valor <= Double.MAX_VALUE)) {
            throw new IllegalArgumentException("Crédito excede o saldo máximo");
        }
        de.sacar(valor + tarifa);
        para.depositar(valor);
    }

    private Conta buscar(String numero) {
        return repositorio.buscarPorNumero(numero)
                .orElseThrow(() -> new IllegalArgumentException("Conta inexistente: " + numero));
    }
}
