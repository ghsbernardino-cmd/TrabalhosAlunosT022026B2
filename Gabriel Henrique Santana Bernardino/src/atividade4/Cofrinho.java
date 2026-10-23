package atividade4;

public class Cofrinho {
    private String dono;
    private double saldo;
    private double metaEconomia;

    public Cofrinho(String dono, double metaEconomia) {
        this.dono = dono;
        this.metaEconomia = metaEconomia;
        saldo = 0;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("O deposito deve ter um valor positivo.");
            return;
        }
        saldo = saldo + valor;
        verificarMeta();
    }

    public void retirar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor da retirada deve ser positivo.");
            return;
        }
        if (valor > saldo) {
            System.out.println("Retirada recusada: saldo insuficiente.");
            return;
        }
        saldo = saldo - valor;
    }

    public void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.println("Meta de economia atingida!");
        } else {
            double falta = metaEconomia - saldo;
            System.out.println("Faltam R$ " + falta + " para atingir a meta.");
        }
    }

    public void exibirSaldo() {
        System.out.println("Dono: " + dono);
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Meta: R$ " + metaEconomia);
    }
}
