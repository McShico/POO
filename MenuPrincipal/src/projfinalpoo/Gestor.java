package projfinalpoo;

public class Gestor extends Utilizador{
    
    public boolean acesso;
    
    public Gestor(String nomeUtilizador, String password) {
        super(nomeUtilizador, password);
        acesso = false;
    }
    
    public Gestor(String nomeUtilizador, String password, boolean acesso) {
        super(nomeUtilizador, password);
        this.acesso = acesso;
        Conta a = new Conta(nomeUtilizador);
    }
    
    public boolean getAcesso() {
        return acesso;
    }

    public void setAcesso(boolean acesso) {
        this.acesso = acesso;
    }
}
