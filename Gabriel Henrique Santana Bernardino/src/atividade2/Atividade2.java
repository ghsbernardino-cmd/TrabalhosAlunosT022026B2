package atividade2;

public class Atividade2 {
    public static void main(String[] args) {
        MaquinaRefrigerante maquina = new MaquinaRefrigerante();
        maquina.reporEstoque(5);
        maquina.exibirEstado();
        maquina.comprar(2, 10.00); 
        maquina.comprar(1, 4.00);  
        maquina.exibirEstado();
    }
}
