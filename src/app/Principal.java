
package app;
import java.util.ArrayList;
import java.util.Scanner;


public class Principal {

    static ArrayList<Jogo> jogos = new ArrayList<>();
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n========== SISTEMA DE GERENCIAMENTO ==========");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    atualizar();
                    break;
                case 5:
                    excluir();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        entrada.close();
    }

    public static Jogo buscarJogoPorId(int id) {
        for (Jogo jogo : jogos) {
            if (jogo.getId() == id) {
                return jogo;
            }
        }
        return null;
    }

    public static void cadastrar() {
        System.out.print("ID do jogo: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        if (buscarJogoPorId(id) != null) {
            System.out.println("Já existe um jogo com esse ID!");
            return;
        }

        System.out.print("Nome do jogo: ");
        String nome = entrada.nextLine();

        System.out.print("Gênero: ");
        String genero = entrada.nextLine();

        Jogo jogo = new Jogo(id, nome, genero);
        jogos.add(jogo);

        System.out.println("Jogo cadastrado com sucesso!");
    }

    public static void listar() {
        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        for (Jogo jogo : jogos) {
            System.out.println("ID: " + jogo.getId()
                    + " | Nome: " + jogo.getNome()
                    + " | Gênero: " + jogo.getGenero());
        }
    }

    public static void buscar() {
        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        System.out.print("ID para buscar: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        Jogo jogo = buscarJogoPorId(id);

        if (jogo == null) {
            System.out.println("ID não encontrado.");
        } else {
            System.out.println("ID: " + jogo.getId());
            System.out.println("Nome: " + jogo.getNome());
            System.out.println("Gênero: " + jogo.getGenero());
        }
    }

    public static void atualizar() {
        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        System.out.print("ID para atualizar: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        Jogo jogo = buscarJogoPorId(id);

        if (jogo == null) {
            System.out.println("ID não encontrado.");
            return;
        }

        System.out.print("Novo nome: ");
        jogo.setNome(entrada.nextLine());

        System.out.print("Novo gênero: ");
        jogo.setGenero(entrada.nextLine());

        System.out.println("Jogo atualizado com sucesso!");
    }

    public static void excluir() {
        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        System.out.print("ID para excluir: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        Jogo jogo = buscarJogoPorId(id);

        if (jogo == null) {
            System.out.println("ID não encontrado.");
        } else {
            jogos.remove(jogo);
            System.out.println("Jogo excluído com sucesso!");
        }
    }
}