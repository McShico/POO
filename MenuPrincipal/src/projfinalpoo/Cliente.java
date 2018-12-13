package projfinalpoo;

import java.util.ArrayList;

public class Cliente extends Utilizador {
    
    public Conta conta;
    public ArrayList<ArrayList<String>> arraylist = new ArrayList<ArrayList<String>>();
    
    public Cliente(String nomeUtilizador, String password) {
        super(nomeUtilizador, password);
        conta = new Conta(nomeUtilizador);
    }
    
    public ArrayList<ArrayList<String>> getAllaylist() {
        return arraylist;
    }

    public void setAllaylist(ArrayList<ArrayList<String>> allaylist) {
        this.arraylist = allaylist;
    }
    
    public void encomendar(String produto, String quantidade) {
        ArrayList<ArrayList<String>> arraylist = new ArrayList<ArrayList<String>>();
        ArrayList interior = new ArrayList<String>();
        interior.add(produto);
        interior.add(quantidade);
        arraylist.add(interior);
    }
}
