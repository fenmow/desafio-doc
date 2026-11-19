package com.cybertron.autobot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GerenciadorAutobots {

    private final Integer VALOR_MAXIMO_ELITE = 500;
    private final Integer VALOR_MAXIMO_PADRAO = 200;
    private final Integer VALOR_REPARO = 100;
    private final Integer ZERO = 0;
    private final String MENSAGEM_ERRO = "Energon negativo";

    private List<Autobot> lista = new ArrayList<>();
    public void adicionar(Autobot novoAutobot) {
        lista.add(novoAutobot);
    }
    public double calcularEnergonTotal() {
        double total = 0;
        // O erro era porque o array era percorrido até uma posicao após o
        // tamanho real do array
        for (int i = 0; i < lista.size(); i++) {
            total += lista.get(i).getEnergon();
        }
        return total;
    }
    public Autobot buscar(String nome) {
        for (Autobot a : lista) {
            if (Objects.equals(a.getNome(), nome)) {
                return a;
            } }
        return null;
    }
    public void reparar(Autobot a) {
            if (a.getEnergon() < ZERO) {
                throw new IllegalArgumentException(MENSAGEM_ERRO);
            }
            a.setEnergon(a.getEnergon() + VALOR_REPARO);
    }
    public Tipo classificar(Autobot a) {
        if (a.getEnergon() > VALOR_MAXIMO_ELITE) {
            return Tipo.ELITE;
        } else if (a.getEnergon() > VALOR_MAXIMO_PADRAO) {
            return Tipo.PADRAO;
        } else {
            return Tipo.RESERVA;
        }
    }

    public List<Autobot> listarIndisponiveis() {
        return lista.stream()
                .filter(a -> a.getEnergon() <= 0)
                .toList();
    }

}
