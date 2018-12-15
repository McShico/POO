package projfinalpoo;

import java.util.ArrayList;

public class Cliente extends Utilizador {
    
    public Conta conta;
    public String[] NomeEQuantidade = new String[2];
    public ArrayList<String[]> arraylist = new ArrayList<String[]>();
    public double saldoPedido;
    
    public Cliente(String nomeUtilizador, String password) {
        super(nomeUtilizador, password);
        conta = new Conta(nomeUtilizador);
        this.saldoPedido = 0;
    }
    
    public ArrayList<String[]> getAllaylist() {
        return arraylist;
    }

    public void setAllaylist(ArrayList<String[]> allaylist) {
        this.arraylist = allaylist;
    }
    
    public void encomendar(String produto, String quantidade) {
        NomeEQuantidade[0] = produto;
        NomeEQuantidade[1] = quantidade;
        arraylist.add(NomeEQuantidade);
    }
    
    public String getPordutoEQuantidade (int posicaoNaArrayList, int ProdutoOuQuantidade) {
        String[] ProdutoOuQuantidadeString = arraylist.get(posicaoNaArrayList);
        return ProdutoOuQuantidadeString[ProdutoOuQuantidade];
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
