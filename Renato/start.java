package poo.pkgfinal;

import java.io.*;
import java.util.ArrayList;

public class start {
    public static void main(String args[]) {
        
        
        //Este Ficheiro foi apenas para testar coisas
        
        Cliente cliente = new Cliente("Renato", "Ourém", "renato@gmail.com" , "123456");
        cliente = new Cliente("Renato", "Ourém", "renato@gmail.com" , "123456");
        cliente = new Cliente("Renato", "Ourém", "renato@gmail.com" , "123456");
        cliente.carregar(5);
        System.out.println(cliente.conta.getSaldo());
        System.out.println(cliente.getNome());
        System.out.println(cliente.visualizar());
        
        
        
        
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
