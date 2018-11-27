package poo.pkgfinal;

import java.io.*;
import java.util.ArrayList;

public class start {
    public static void main(String args[]) {
        
        System.out.println("Insira o nome do Produto:");
        String nome = myinputs.Myinputs.umaString();
        int qualidade;
        do {
           System.out.println("Insira a qualidade do produto");
           qualidade = myinputs.Myinputs.umInt();
        } while (qualidade < 1 || qualidade > 3);
        
        ArrayList<RecursosComprados> lista = new ArrayList<RecursosComprados>();
        
        lista.add( new RecursosComprados(nome, qualidade));
        
       
        
        
        
        
        
        
        
        // ********* BASE DE DADOS ***********
        
        /*Producao batatas = new Producao("Batatas");
        
        String nomeDoFicheiro = "ola.bin";
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(nomeDoFicheiro));
            os.writeObject(batatas);
            os.close();
        } catch (Exception e) {System.out.println("ole");}
    
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
            Producao arroz = (Producao) is.readObject();
            System.out.println("Nome " + arroz.nome);
            is.close();
        } catch (Exception e) {System.out.println("ola");}*/
    }   
}
