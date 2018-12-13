package projfinalpoo;

public class Produto extends ProdutoERecurso{
    private double quantidadeEncomendada;
    private double quantidadeEncomendadaTotal;
    private String[] stringArray;
    private double preco;

    public Produto(String nome, double quantidadeStock, String[] stringArray, double preco) {
        super(nome, quantidadeStock);
        this.stringArray = stringArray;
        this.preco = preco;
    }
    
    
    public double getQuantidadeEncomendada() {
        return quantidadeEncomendada;
    }

    public void setQuantidadeEncomendada(double quantidadeEncomendada) {
        this.quantidadeEncomendada = quantidadeEncomendada;
    }
    
    public void incQuantidadeEncomendada(double quantidadeEncomendada) {
        this.quantidadeEncomendada += quantidadeEncomendada;
        this.quantidadeEncomendadaTotal += quantidadeEncomendada;
    }
    
    public void decQuantidadeEncomendada(double quantidadeEncomendada) {
        this.quantidadeEncomendada -= quantidadeEncomendada;
    }

    public double getQuantidadeEncomendadaTotal() {
        return quantidadeEncomendadaTotal;
    }

    public void setQuantidadeEncomendadaTotal(double quantidadeEncomendadaTotal) {
        this.quantidadeEncomendadaTotal = quantidadeEncomendadaTotal;
    }

    public String[] getStringArray() {
        return stringArray;
    }

    public void setStringArray(String[] stringArray) {
        this.stringArray = stringArray;
    }
    
    public String getValorPosicaoStringArray(int i) {
        return stringArray[i];
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
    
}
