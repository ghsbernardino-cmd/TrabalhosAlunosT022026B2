package atividade2;

public class MaquinaRefrigerante {
    private int quantidadeEstoque;
    private double preco = 4.50;
    private double dinheiroArrecadado;

    public MaquinaRefrigerante() {
        quantidadeEstoque = 0;
        dinheiroArrecadado = 0.0;
    }

    public void comprar(int quantidade, double valorPago) {
        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser positiva.");
            return;
        }
        if (quantidade > quantidadeEstoque) {
            System.out.println("Estoque insuficiente.");
            return;
        }
        double total = quantidade * preco;
        if (valorPago < total) {
            System.out.println("Pagamento insuficiente.");
            return;
        }
        quantidadeEstoque = quantidadeEstoque - quantidade;
        dinheiroArrecadado = dinheiroArrecadado + total;
        double troco = valorPago - total;
        System.out.println("Compra realizada: " + quantidade + " refrigerante(s).");
        System.out.println("Total: R$ " + total);
        System.out.println("Troco: R$ " + troco);
    }

    public void reporEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("A quantidade de reposicao deve ser positiva.");
            return;
        }
        quantidadeEstoque = quantidadeEstoque + quantidade;
    }

    public void exibirEstado() {
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.println("Preco: R$ " + preco);
        System.out.println("Dinheiro arrecadado: R$ " + dinheiroArrecadado);
    }
}
