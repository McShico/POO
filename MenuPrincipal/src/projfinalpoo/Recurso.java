package projfinalpoo;
import java.io.*;

public class Recurso extends ProdutoERecurso implements Serializable{
    
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
