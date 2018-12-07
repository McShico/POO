package projfinalpoo;


public class Conta {
    private int id;
    private String nomeUtilizadorConta;
    private int saldo;

    public Conta(int id, String nomeDoUtilizador) {
        this.id = id;
        this.nomeUtilizadorConta = nomeDoUtilizador;
        this.saldo = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDoUtilizador() {
        return nomeUtilizadorConta;
    }

    public void setNomeDoUtilizador(String nomeDoUtilizador) {
        this.nomeUtilizadorConta = nomeDoUtilizador;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public void incSaldo(int saldo) {
        this.saldo += saldo;
    }
    
    public void decSaldo(int saldo) {
        this.saldo += saldo;
    }
}
