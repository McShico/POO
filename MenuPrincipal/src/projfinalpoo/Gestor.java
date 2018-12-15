package projfinalpoo;

public class Gestor extends Utilizador{
    
    public boolean acesso;
    Conta contaGeral;
    
    public Gestor(String nomeUtilizador, String password) {
        super(nomeUtilizador, password);
        acesso = false;
    }
    
    public Gestor(String nomeUtilizador, String password, boolean acesso, double saldo) {
        super(nomeUtilizador, password);
        this.acesso = acesso;
        contaGeral = new Conta(nomeUtilizador, saldo);
    }
    
    public boolean getAcesso() {
        return acesso;
    }

    public void setAcesso(boolean acesso) {
        this.acesso = acesso;
    }

    void set(int i, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
