package projfinalpoo;

import java.util.ArrayList;

public class Cliente extends Utilizador {
    
    public Conta conta;
    public ArrayList<ArrayList<String>> arraylist = new ArrayList<ArrayList<String>>();
    ArrayList<String> NomeEQuantidade = new ArrayList<String>();
    public double saldoPedido;
    
    public Cliente(String nomeUtilizador, String password) {
        super(nomeUtilizador, password);
        conta = new Conta(nomeUtilizador, 50);
        this.saldoPedido = 0;
    }

    public ArrayList<ArrayList<String>> getArraylist() {
        return arraylist;
    }

    public void setArraylist(ArrayList<ArrayList<String>> arraylist) {
        this.arraylist = arraylist;
    }
    
    public void encomendar(String produto, String quantidade) {
        NomeEQuantidade.add(produto);
        NomeEQuantidade.add(quantidade);
        this.arraylist.add(NomeEQuantidade);
    }
    
    public String getProdutoOuQuantidade (int posicaoNaArrayList, int ProdutoOuQuantidade) {
        NomeEQuantidade = arraylist.get(posicaoNaArrayList);
        return NomeEQuantidade.get(ProdutoOuQuantidade);
    }

    public double getSaldoPedido() {
        return saldoPedido;
    }

    public void setSaldoPedido(double saldoPedido) {
        this.saldoPedido = saldoPedido;
    }
    
    public void incSaldoPedido(double saldoPedido) {
        this.saldoPedido += saldoPedido;
    }
}
