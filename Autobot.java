package com.cybertron.autobot;

public class Autobot {

    private final String MENSAGEM_ERRO_NIVEL = "Nível inválido";
    private final Integer VALOR_MINIMO_NIVEL = 1;
    private final Integer VALOR_MAXIMO_NIVEL = 10;

    private String nome;
    private double energon;
    private int nivel;
    public Autobot(String nome, double energon, int nivel) {
        this.setNome(nome);
        this.setEnergon(energon);
        this.setNivel(nivel);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getEnergon() {
        return energon;
    }

    public void setEnergon(double energon) {
        this.energon = energon;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel < VALOR_MINIMO_NIVEL || nivel > VALOR_MAXIMO_NIVEL) {
            throw new IllegalArgumentException(MENSAGEM_ERRO_NIVEL);
        }
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

}
