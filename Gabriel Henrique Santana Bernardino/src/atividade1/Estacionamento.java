package atividade1;

public class Estacionamento {

	private int minutosEstacionado;
	private String placa;
	private String modelo;
	private double valorPago;
	
public void calcularValor() {
	if(minutosEstacionado <= 30) {
		valorPago = 5.00;
	}
	else {
	valorPago = 5.00 + (minutosEstacionado - 30)* 0.10;
	}
	if(valorPago > 30.00) {
		valorPago = 30.00;
	}
}	

public void adicionarTempo(int minutos) {
	
	if(minutos <= 0 ) {
		return;
	}
minutosEstacionado = minutosEstacionado + minutos;

}

public void exibirResumo() {
	System.out.println("placa : " +placa);
	System.out.println("modelo : "+modelo);
	System.out.println("tempo estacionado : "+ minutosEstacionado);
	System.out.println("valor a pagar : "+ valorPago);
}

public static void main(String [] Args) {
	
	Estacionamento carro = new Estacionamento();
	carro.placa = "abc 1234";
	carro.modelo = "uno";
	carro.adicionarTempo(70);
	carro.calcularValor();
	carro.exibirResumo();
	carro.placa = "abc 1234";
	carro.modelo = "uno";
}

}


