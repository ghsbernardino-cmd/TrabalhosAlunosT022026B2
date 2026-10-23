package atividade3;

public class Time {
    private String nome;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int pontos;

    public Time(String nome) {
        this.nome = nome;
    }

    public void registrarVitoria() {
        vitorias = vitorias + 1;
        pontos = pontos + 3;
    }

    public void registrarEmpate() {
        empates = empates + 1;
        pontos = pontos + 1;
    }

    public void registrarDerrota() {
        derrotas = derrotas + 1;
    }

    public int getPontos() {
        return pontos;
    }

    public String getNome() {
        return nome;
    }

    public void exibirEstatisticas() {
        System.out.println("Time: " + nome);
        System.out.println("Vitorias: " + vitorias);
        System.out.println("Empates: " + empates);
        System.out.println("Derrotas: " + derrotas);
        System.out.println("Pontos: " + pontos);
    }
}
