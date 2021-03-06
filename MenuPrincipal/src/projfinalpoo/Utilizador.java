package projfinalpoo;

import java.util.ArrayList;
import java.io.*;


public abstract class Utilizador implements Serializable{
    private String nomeUtilizador;
    private String password;
    
    public Utilizador(String nomeUtilizador, String password) {
        this.nomeUtilizador = nomeUtilizador;
        this.password = password;
    }

    public String getNomeUtilizador() {
        return nomeUtilizador;
    }

    public void setNomeUtilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
