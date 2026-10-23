package atividade5;

public class Pedido {
    private String nomeCliente;
    private int quantidadeLanches;
    private double precoLanche = 18.00;
    private double taxaEntrega = 7.00;
    private String status = "Aberto";

    public Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void adicionarLanches(int quantidade) {
        if (status.equals("Finalizado")) {
            System.out.println("Operacao nao permitida: o pedido ja foi finalizado.");
            return;
        }
        if (quantidade <= 0) {
            System.out.println("A quantidade de lanches deve ser positiva e valida.");
            return;
        }
        quantidadeLanches = quantidadeLanches + quantidade;
        System.out.println("Lanches adicionados: " + quantidade);
    }

    public double calcularTotal() {
        double valorLanches = quantidadeLanches * precoLanche;
        if (quantidadeLanches >= 3) {
            double desconto = valorLanches * 0.10;
            valorLanches = valorLanches - desconto;
        }
        double total = valorLanches + taxaEntrega;
        return total;
    }

    public void finalizarPedido() {
        status = "Finalizado";
        System.out.println("Pedido finalizado.");
    }

    public void exibirPedido() {
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Lanches: " + quantidadeLanches);
        System.out.println("Preco unitario: R$ " + precoLanche);
        System.out.println("Entrega: R$ " + taxaEntrega);
        System.out.println("Status: " + status);
        double total = calcularTotal();
        System.out.println("Total: R$ " + total);
    }
}
