package poo.pkgfinal;

import java.io.*;

public class start {
    public static void main(String args[]) {
        
        Producao batatas = new Producao("Batatas");
        
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
        } catch (Exception e) {System.out.println("ola");}
    }   
}
