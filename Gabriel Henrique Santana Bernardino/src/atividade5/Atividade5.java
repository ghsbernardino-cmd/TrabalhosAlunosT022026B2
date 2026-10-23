package atividade5;

public class Atividade5 {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("Gabriel");
        pedido.adicionarLanches(1);
        pedido.adicionarLanches(2);
        double total = pedido.calcularTotal();
        System.out.println("Total calculado: R$ " + total);
        pedido.finalizarPedido();
        pedido.adicionarLanches(1);
        pedido.exibirPedido();
    }
}
