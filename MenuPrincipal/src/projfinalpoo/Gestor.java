package projfinalpoo;

public class Gestor extends Utilizador{
    
    public boolean acesso;
    
    public Gestor(String nomeUtilizador, String password) {
        super(nomeUtilizador, password);
        acesso = false;
    }
    
    public boolean getAcesso() {
        return acesso;
    }

    public void setAcesso(boolean acesso) {
        this.acesso = acesso;
    }
}
