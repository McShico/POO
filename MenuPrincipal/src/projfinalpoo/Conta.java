package projfinalpoo;


public class Conta {
    
    private String nomeUtilizadorConta;
    private double saldo;

    public Conta(String nomeDoUtilizador) {
        this.nomeUtilizadorConta = nomeDoUtilizador;
        this.saldo = 0;
    }
    
    public Conta(String nomeDoUtilizador, double saldo) {
        this.nomeUtilizadorConta = nomeDoUtilizador;
        this.saldo = saldo;
    }

    public String getNomeDoUtilizador() {
        return nomeUtilizadorConta;
    }

    public void setNomeDoUtilizador(String nomeDoUtilizador) {
        this.nomeUtilizadorConta = nomeDoUtilizador;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void incSaldo(double saldo) {
        this.saldo += saldo;
    }
    
    public void decSaldo(double saldo) {
        this.saldo -= saldo;
    }
}
