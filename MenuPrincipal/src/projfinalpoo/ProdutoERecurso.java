package projfinalpoo;


public class ProdutoERecurso {
    
    private String nome;
    private String tipo;
    private double quantidadeEncomendada;
    private double quantidadeEncomendadaTotal;
    private int quantidadeStock;
    private double preco;

    public ProdutoERecurso(String nome, int quantidadeStock){
        this.nome = nome;
        this.quantidadeStock = quantidadeStock;;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
    
    public int getQuantidadeStock() {
        return quantidadeStock;
    }

    public void setQuantidadeStock(int quantidadeStock) {
        this.quantidadeStock = quantidadeStock;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
