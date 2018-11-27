package poo.pkgfinal;

public class RecursosComprados {
    private String nomeRecurso;
    private int quantidade;
    private int qualidade;
    private int valor;
    
    public RecursosComprados(String nomeRecurso, int qualidade) {
        this.nomeRecurso = nomeRecurso;
        this.qualidade = qualidade;
    }
    
    public RecursosComprados(String nomeRecurso, int quantidade, int qualidade) {
        this.nomeRecurso = nomeRecurso;
        this.quantidade = quantidade;
        this.qualidade = qualidade;
    }

    public String getNomeRecurso() {
        return nomeRecurso;
    }

    public void setNomeRecurso(String nomeRecurso) {
        this.nomeRecurso = nomeRecurso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQualidade() {
        return qualidade;
    }

    public void setQualidade(int qualidade) {
        this.qualidade = qualidade;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
