package atividade3;

public class Atividade3 {
    public static void main(String[] args) {
        Time primeiro = new Time("Azul");
        Time segundo = new Time("Verde");
        primeiro.registrarVitoria();
        primeiro.registrarVitoria();
        primeiro.registrarEmpate();
        segundo.registrarVitoria();
        segundo.registrarEmpate();
        segundo.registrarDerrota();
        primeiro.exibirEstatisticas();
        segundo.exibirEstatisticas();
        exibirClassificacao(primeiro, segundo);
    }

    public static void exibirClassificacao(Time primeiro, Time segundo) {
        if (primeiro.getPontos() == segundo.getPontos()) {
            System.out.println("Houve empate na classificacao.");
        } else if (primeiro.getPontos() > segundo.getPontos()) {
            System.out.println(primeiro.getNome() + " possui mais pontos: " + primeiro.getPontos());
        } else {
            System.out.println(segundo.getNome() + " possui mais pontos: " + segundo.getPontos());
        }
    }
}
