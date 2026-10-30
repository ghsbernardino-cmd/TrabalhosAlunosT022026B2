package objetos;

import java.util.Date;

public class Livro {

    private String titulo;
    private String autor;
    private Date dataEmprestimo;

    public Livro() {
    }

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String validarDisponibilidade() {
        if (dataEmprestimo == null) {
            return "Disponível";
        } else {
            return "Indisponível";
        }
    }
}
