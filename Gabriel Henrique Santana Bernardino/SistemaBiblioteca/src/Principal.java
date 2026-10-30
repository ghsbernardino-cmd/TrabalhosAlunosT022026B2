import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import objetos.Livro;
import objetos.Pessoa;

public class Principal {

    static Scanner scan = new Scanner(System.in);

    static List<Livro> listaLivros = new ArrayList<Livro>();
    static List<Pessoa> listaUsuarios = new ArrayList<Pessoa>();

    public static void main(String[] args) {
        popularTabela();
        System.out.println("Sistema de Biblioteca iniciado!");
        mostrarMenu();
    }

    private static void popularTabela() {

        listaUsuarios.add(new Pessoa("Gabriel"));
        listaUsuarios.add(new Pessoa("Pedro"));
        listaUsuarios.add(new Pessoa("João"));

        listaLivros.add(new Livro("Dom Casmurro", "Machado de Assis"));
        listaLivros.add(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry"));
        listaLivros.add(new Livro("Harry Potter", "J.K. Rowling"));
        listaLivros.add(new Livro("1984", "George Orwell"));
        listaLivros.add(new Livro("O Hobbit", "J.R.R. Tolkien"));
    }

    public static void mostrarMenu() {

        int escolhaUsuario;

        do {
            System.out.println("\n SISTEMA DE BIBLIOTECA ");
            System.out.println("1 - Listar livros");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Excluir livro");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("6 - Cadastrar usuário");
            System.out.println("7 - Listar usuários");
            System.out.println("0 - Sair");

            escolhaUsuario = lerNumero("Escolha uma opção: ");

            validarEscolha(escolhaUsuario);

        } while (escolhaUsuario != 0);
    }

    private static int lerNumero(String mensagem) {

        System.out.println(mensagem);

        try {
            return Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Informe um número válido!");
            return -1;
        }
    }

    public static void validarEscolha(int escolhaUsuario) {

        switch (escolhaUsuario) {

            case 0:
                System.out.println("Sistema encerrado!");
                break;

            case 1:
                listarLivros();
                break;

            case 2:
                cadastrarLivro();
                break;

            case 3:
                excluirLivro();
                break;

            case 4:
                emprestarLivro();
                break;

            case 5:
                devolverLivro();
                break;

            case 6:
                cadastrarUsuario();
                break;

            case 7:
                listarUsuarios();
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void listarLivros() {

        System.out.println("\n-------- LISTA DE LIVROS --------");

        if (listaLivros.size() == 0) {
            System.out.println("Nenhum livro cadastrado!");
            return;
        }

        for (int i = 0; i < listaLivros.size(); i++) {

            Livro livro = listaLivros.get(i);

            System.out.printf(
                "%d) %s - %s / %s\n",
                i + 1,
                livro.getTitulo(),
                livro.getAutor(),
                livro.validarDisponibilidade()
            );
        }
    }

    private static void cadastrarLivro() {

        Livro livro = new Livro();

        System.out.println("Informe o título do livro:");
        livro.setTitulo(scan.nextLine());

        System.out.println("Informe o autor do livro:");
        livro.setAutor(scan.nextLine());

        listaLivros.add(livro);

        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void excluirLivro() {

        if (listaLivros.isEmpty()) {
            System.out.println("Não existem livros para excluir!");
            return;
        }

        listarLivros();

        int escolha = lerNumero("Informe o livro que deseja excluir: ") - 1;

        if (escolha < 0 || escolha >= listaLivros.size()) {
            System.out.println("Livro inválido!");
            return;
        }

        if (listaLivros.get(escolha).getDataEmprestimo() != null) {
            System.out.println("O livro está emprestado e não pode ser excluído!");
            return;
        }

        listaLivros.remove(escolha);

        System.out.println("Livro excluído com sucesso!");
    }

    private static void emprestarLivro() {

        if (listaUsuarios.isEmpty() || listaLivros.isEmpty()) {
            System.out.println("É necessário ter usuários e livros cadastrados!");
            return;
        }

        listarUsuarios();

        int usuario = lerNumero("Informe o usuário que deseja pegar um livro: ") - 1;

        if (usuario < 0 || usuario >= listaUsuarios.size()) {
            System.out.println("Usuário inválido!");
            return;
        }

        Pessoa pessoa = listaUsuarios.get(usuario);

        if (pessoa.getLivrosEmprestados().size() >= 2) {
            System.out.println("Usuário atingiu o limite de 2 livros emprestados!");
            return;
        }

        listarLivros();

        int livro = lerNumero("Informe o livro que deseja emprestar: ") - 1;

        if (livro < 0 || livro >= listaLivros.size()) {
            System.out.println("Livro inválido!");
            return;
        }

        Livro livroEscolhido = listaLivros.get(livro);

        if (livroEscolhido.getDataEmprestimo() != null) {
            System.out.println("Este livro já está emprestado!");
            return;
        }

        pessoa.getLivrosEmprestados().add(livroEscolhido);

        livroEscolhido.setDataEmprestimo(new Date());

        System.out.println("Livro emprestado com sucesso!");
    }

    private static void devolverLivro() {

        if (listaUsuarios.isEmpty()) {
            System.out.println("Não existem usuários cadastrados!");
            return;
        }

        listarUsuarios();

        int usuario = lerNumero("Informe o usuário que vai devolver o livro: ") - 1;

        if (usuario < 0 || usuario >= listaUsuarios.size()) {
            System.out.println("Usuário inválido!");
            return;
        }

        Pessoa pessoa = listaUsuarios.get(usuario);

        if (pessoa.getLivrosEmprestados().isEmpty()) {
            System.out.println("Este usuário não possui livros emprestados!");
            return;
        }

        System.out.println("\nLivros emprestados:");

        for (int i = 0; i < pessoa.getLivrosEmprestados().size(); i++) {
            System.out.printf(
                "%d) %s\n",
                i + 1,
                pessoa.getLivrosEmprestados().get(i).getTitulo()
            );
        }

        int livro = lerNumero("Informe o livro que deseja devolver: ") - 1;

        if (livro < 0 || livro >= pessoa.getLivrosEmprestados().size()) {
            System.out.println("Livro inválido!");
            return;
        }

        Livro livroDevolvido = pessoa.getLivrosEmprestados().get(livro);

        livroDevolvido.setDataEmprestimo(null);

        pessoa.getLivrosEmprestados().remove(livro);

        System.out.println("Livro devolvido com sucesso!");
    }

    private static void cadastrarUsuario() {

        Pessoa usuario = new Pessoa();

        System.out.println("Informe o nome do usuário:");
        usuario.setNome(scan.nextLine());

        listaUsuarios.add(usuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void listarUsuarios() {

        System.out.println("\n LISTA DE USUÁRIOS ");

        if (listaUsuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado!");
            return;
        }

        for (int i = 0; i < listaUsuarios.size(); i++) {

            Pessoa usuario = listaUsuarios.get(i);

            System.out.printf("%d) %s\n", i + 1, usuario.getNome());

            for (int j = 0; j < usuario.getLivrosEmprestados().size(); j++) {

                Livro livro = usuario.getLivrosEmprestados().get(j);

                System.out.printf(
                    "   %d) %s - %s\n",
                    j + 1,
                    livro.getTitulo(),
                    livro.getAutor()
                );
            }
        }
    }
}
