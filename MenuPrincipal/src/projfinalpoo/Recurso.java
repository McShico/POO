package projfinalpoo;

public class Recurso extends ProdutoERecurso{
    
    public double custo;
    
    public Recurso(String nome, double quantidadeStock, double custo) {
        super(nome, quantidadeStock);
        this.custo = custo;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}
