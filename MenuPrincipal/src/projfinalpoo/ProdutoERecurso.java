package projfinalpoo;
import java.io.*;

public class ProdutoERecurso implements Serializable{
    
    private String nome;
    private double quantidadeStock;
    
    public ProdutoERecurso(String nome, double quantidadeStock) {
        this.nome = nome;
        this.quantidadeStock = quantidadeStock;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public double getQuantidadeStock() {
        return quantidadeStock;
    }

    public void setQuantidadeStock(double quantidadeStock) {
        this.quantidadeStock = quantidadeStock;
    }
    
    public void incQuantidadeStock(double quantidadeStockInc) {
        this.quantidadeStock += quantidadeStockInc;
    }
    
    public void decQuantidadeStock(double quantidadeStockDec) {
        this.quantidadeStock -= quantidadeStockDec;
    }
}
