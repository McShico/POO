package projfinalpoo;


public class Produtos {
    
    private String nomerecurso;
    
    private int qualidade;
    
    private double quantidadecomprada;
    
    private double totalquantidade;
    
    
    //-----------CONSTRUTOR DE TODOS OS PRODUTOS--------------
    public Produtos(String nomerecurso, int qualidade, double quantidadecomprada){
        
        this.nomerecurso = nomerecurso;
        
        this.qualidade = qualidade;
        
        this.totalquantidade = quantidadecomprada;
    }
    
    //-------------ENVIA NOME DE RECURSOS JA ADQUIRIDOS PARA PRODUÇÂO--------------
    public String getRecurso(){
        return this.nomerecurso;
    }
    
    //-------------RECEBE NOME DE RECURSOS DO FORNECEDOR------------------
    public void setRecurso(String recurso){
        this.nomerecurso = recurso;
    }
    
    //-------------ENVIA QUANTIDADE JA ADQUIRIDOS PARA PRODUÇÂO--------------
    public double getQuantidade(){
        return this.totalquantidade;
    }
    
    //-------------RECEBE QUANTIDADE COMPRADA AO FORNECEDOR E ADICIONA AO TOTAL EM STOCK------------------
    public void setQuantidadeTotal(double quantidadecomprada){
        this.totalquantidade = this.totalquantidade + quantidadecomprada;
    }
    
    //-------------ENVIA QUANTIDADE TOTAL EM STOCK------------------
    public double getQuantidadeTotal(double quantidadecomprada){
        return this.totalquantidade;
    }
}
