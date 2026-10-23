package atividade4;

public class Atividade4 {
    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho("Gabriel", 100.00);
        cofrinho.depositar(40.00);
        cofrinho.depositar(60.00);
        cofrinho.retirar(150.00);
        cofrinho.exibirSaldo();
        cofrinho.verificarMeta();
    }
}
