
package projfinalpoo;

import myinputs.Ler.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Projfinalpoo {

    public static int opcaoMenu;

    public static void menuPrincipal() {
        System.out.println("+-------------- MENU --------------+");
        System.out.println("|                                  |");
        System.out.println("|      1 - Efetuar LOGIN           |");
        System.out.println("|      2 - Registar UTILIZADOR     |");
        System.out.println("|      0 - Sair                    |");
        System.out.println("|                                  |");
        System.out.println("+----------------------------------+");
        System.out.println();
        System.out.print("Opção: ");
        
        opcaoMenu = myinputs.Ler.umInt();
        
        switch (opcaoMenu) {
            case 1:
                menuLogin();
                break;
            case 2:
                menuRegistar();
                break;
            default:
                menuPrincipal();
                break;
            case 0:
                System.out.println("");
                System.out.println("**** Até uma próxima ****");
                break;
        }
    }

    public static void menuLogin() {
        System.out.println("+-------------- LOGIN -------------+");
        System.out.println("|                                  |");
        System.out.println("|        Intruduza USERNAME        |");
        System.out.print("|            ");
        String username = myinputs.Ler.umaString();
       
        username.toUpperCase();

        System.out.println("|                                  |");
        System.out.println("|         INTRODUZA PASSWORD       |");
        System.out.print("|            ");
        String password = myinputs.Ler.umaString();
        System.out.println("+----------------------------------+");
        
        
        // Função que vem do Xico com a confirmação da conta
        
        // Exemplificar
        String tipoDeConta = "Cliente";
        
        if (tipoDeConta.equals("Cliente")) {
            menuCliente();
        } else if(tipoDeConta.equals("Gestor")) {
            menuGestor();
        } else if(tipoDeConta.equals("Fornecedor")) {
            //menuFornecedor();
        }
    }

    public static void menuRegistar() {
        System.out.println("+------------ REGISTO -------------+");
        System.out.println("|                                  |");
        System.out.println("|        INTRODUZA USERNAME        |");
        System.out.print("|         ");
        String novoUsername = myinputs.Ler.umaString();

        System.out.println("|                                  |");
        System.out.println("|        INTRODUZA PASSWORD        |");
        System.out.print("|         ");
        String novaPassword = myinputs.Ler.umaString();

        System.out.println("|                                  |");
        System.out.println("|     INTRODUZA O TIPO DE CONTA    |");
        System.out.println("|                                  |");
        System.out.println("|          1 - Cliente             |");
        System.out.println("|          2 - Gestor              |");
        System.out.println("|          3 - Fornecedor          |");
        System.out.println("|                                  |");
        System.out.println("+----------------------------------+");
        System.out.println();
        System.out.print("Opção: ");
        
        int novoTipoDeConta = myinputs.Ler.umInt();
        
        
        // Informação vai para a função de registo do Xico
    }

    public static void menuCliente() {
        System.out.println("+------------- Cliente ------------+" /* Xico.getUser()*/ );
        System.out.println("|                                  |");
        System.out.println("|     SALDO:" /* + Fabio.getSaldo() */);
        System.out.println("|                                  |");
        System.out.println("|     1. ENCOMENDAR PRODUTOS       |");
        System.out.println("|     2. CONSULTAR MOVIMENTOS      |");
        System.out.println("|     0. TERMINAR SESSÃO           |");
        System.out.println("|                                  |");
        System.out.println("+----------------------------------+");
        System.out.println();
        System.out.print("Opção: ");

        opcaoMenu = myinputs.Ler.umInt();
        
        switch (opcaoMenu) {
            case 1:
                menuEncomendarProdutos();
                break;
            case 2:
                menuConsultarMovimentos();
                break;
            case 0:
                menuPrincipal();
                break;
        }
    }
    
    public static void menuEncomendarProdutos() {
        System.out.println("+--------------Cliente-------------+" /* Xico.getUser()*/);
        System.out.println("+-------------PRODUTOS-------------+");
        System.out.println("|                                  |");
        System.out.println("|      SALDO: " /* + GETSALDO */);
        System.out.println("|                                  |");
        System.out.println("|      1 - BOLOS                   |");
        System.out.println("|      2 - IOGURTES                |");
        System.out.println("|      3 - SUMOS                   |");
        System.out.println("|      0 - RETROCEDER              |");
        System.out.println("|                                  |");
        System.out.println("+----------------------------------+");
        System.out.print("Opção: ");
        
        opcaoMenu = myinputs.Ler.umInt();
        
        switch (opcaoMenu) {
            case 1:
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("|       CADA BOLO CUSTA X EUROS       |");
                System.out.println("|                                     |");
                System.out.println("|      QUANTAS UNIDADES PRETENDE      |");
                System.out.println("|             ENCOMENDAR?             |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println();
                System.out.print("Quantidade: ");
                
                int EncomendaBolo = myinputs.Ler.umInt();
                break;

            case 2:
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("|       CADA IOGURTE CUSTA X EUROS    |");
                System.out.println("|                                     |");
                System.out.println("|      QUANTAS UNIDADES PRETENDE      |");
                System.out.println("|             ENCOMENDAR?             |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println();
                System.out.print("Quantidade: ");
                
                int EncomendaIogurte = myinputs.Ler.umInt();
                break;

            case 3:
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("|       CADA SUMO CUSTA X EUROS       |");
                System.out.println("|                                     |");
                System.out.println("|      QUANTAS UNIDADES PRETENDE      |");
                System.out.println("|             ENCOMENDAR?             |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println();
                System.out.print("Quantidade: ");
                
                int EncomendaSumo = myinputs.Ler.umInt();
                break;
            case 0:
                // Corrigir para que vá para o tipo de conta em que o utilizador fez log in
                menuCliente();
                break;
        }
    }

    public static void menuConsultarMovimentos() {
        System.out.println("-----------" /* Xico.getUser()*/ + "-----------");
        System.out.println("--------------MOVIMENTOS--------------");
        System.out.println("                                      ");
        System.out.println("        SALDO: " /* + GETSALDO */);
        System.out.println("                                      ");
        System.out.println("        TOTAL DE DESPESAS: " /* + GETTOTALDESPESAS */);
        System.out.println("         >BOLO: " /* + GETTOTALDESPESASSBOLO */);
        System.out.println("         >IOGURTE: " /* + GETTOTALDESPESASIOGURTE */);
        System.out.println("         >SUMO: " /* + GETTOTALDESPESASSUMOS */);
        System.out.println("                                      ");
        System.out.println("        TOTAL DE UNIDADES COMPRADAS: " /* GETTOTALUNIDADESCOMPRADAS */);
        System.out.println("         >BOLO: " /* + GETTOTALUNIDADESBOLO */);
        System.out.println("         >IOGURTE: " /* + GETTOTALDESPESASIOGURTES */);
        System.out.println("         >SUMO: " /* + GETTOTALDESPESASSUMOS */);
        System.out.println("                                      ");
        System.out.println("        0. RETROCEDER                 ");
        
        String retroceder = myinputs.Ler.umaString();
        
        switch (retroceder) {
            default:
                menuEncomendarProdutos();
                break;
        }
    }
    
    public static void menuGestor() {
        System.out.println("---------------" /* Xico.getUser()*/);
        System.out.println("                                      ");
        System.out.println("        SALDO: " /* + GETSALDO */);
        System.out.println("                                      ");
        System.out.println("        1. EDITAR                     ");
        System.out.println("        2. CONSULTAR MOVIMENTOS       ");
        System.out.println("        3. FAZER PEDIDOS A FORNECEDOR  ");
        System.out.println("        4. CONSULTAR PEDIDOS DE CLIENTES");
        System.out.println("        0. TERMINAR SESSÃO            ");
        
        opcaoMenu = myinputs.Ler.umInt();
        
        switch (opcaoMenu) {
            case 1:
                menuEditar();
                break;
            case 2:
                menuConsultarMovimentos();
                break;
            case 3:
                //fazerPedidosAFornecedores();
                break;
            case 4:
                //consultarPedidosDeClientes();
                break;
            case 0:
                menuPrincipal();
                break;
        }
    }

    public static void menuEditar() {
        System.out.println("---------------" /* Xico.getUser()*/);
        System.out.println("---------------EDITAR---------------");
        System.out.println("                                      ");
        System.out.println("        SALDO: " /* + GETSALDO */);
        System.out.println("                                      ");
        System.out.println("        1. PRODUTOS                   ");
        System.out.println("        2. RECURSOS                   ");
        System.out.println("        0. RETROCEDER                 ");
        
        opcaoMenu = myinputs.Ler.umInt();
        
        switch (opcaoMenu) {
            case 1:
                editarProdutos();
                break;
        }
    }

    public static void editarProdutos() {
        System.out.println("--------------------------------------");
        System.out.println("                                      ");
        System.out.println("            EDITAR PRODUTOS           ");
        System.out.println("                                      ");
        System.out.println(" QUAL O PRODUTO QUE PRETENDE EDITAR?  ");
        System.out.println("                                      ");
        System.out.println("        1. BOLOS                      ");
        System.out.println("        2. IOGURTES                   ");
        System.out.println("        3. SUMOS                      ");
        System.out.println("                                      ");
        System.out.println("        4. ADICIONAR PRODUTO          ");
        System.out.println("        5. REMOVER PRODUTO            ");
        System.out.println("        0. RETROCEDER                 ");
        
        opcaoMenu = myinputs.Ler.umInt();
        
        switch(opcaoMenu) {
            case 1:
                //Bolos
                break;
            case 2:
                //Iogurtes
                break;

            case 3:
                //Sumos
                break;
                
            case 4:
                //adicionarProduto();
                break;
            case 5:
                //removerRecurso();
                break;
            case 0:
                menuEditar();
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        
        menuPrincipal();

//
//        switch (OpcaoMenuUserGestorEditarProdutosBolos) {
//        case 1:
//            System.out.println("--------------------------------------");
//            System.out.println("                                      ");
//            System.out.println("         EDITAR BOLOS FARINHA         ");
//            System.out.println("                                      ");
//            System.out.println("     QUANTIDADE USADA POR UNIDADE     ");
//            System.out.println("            " /* + GETFARINHABOLO + */);
//            System.out.println("                                      ");
//            System.out.println("INSIRA NOVA QUANTIDADE USADA POR UNIDADE");
//
//            double QuantidadeNovaFarinha = myinputs.Ler.umDouble();
//
//        break;
//        case 2:
//            System.out.println("--------------------------------------");
//            System.out.println("                                      ");
//            System.out.println("         EDITAR BOLOS OVOS            ");
//            System.out.println("                                      ");
//            System.out.println("     QUANTIDADE USADA POR UNIDADE     ");
//            System.out.println("            " /* + GETFARINHABOLO + */);
//            System.out.println("                                      ");
//            System.out.println("INSIRA NOVA QUANTIDADE USADA POR UNIDADE");
//
//            double QuantidadeNovaOvos = myinputs.Ler.umDouble();
//
//        break;
//        case 3:
//            System.out.println("--------------------------------------");
//            System.out.println("                                      ");
//            System.out.println("         EDITAR BOLOS CHOCOLATE       ");
//            System.out.println("                                      ");
//            System.out.println("     QUANTIDADE USADA POR UNIDADE     ");
//            System.out.println("            " /* + GETFARINHABOLO + */);
//            System.out.println("                                      ");
//            System.out.println("INSIRA NOVA QUANTIDADE USADA POR UNIDADE");
//
//            double QuantidadeNovaChocolate = myinputs.Ler.umDouble();
//
//        break;
//        case 4:
//            System.out.println("--------------------------------------");
//            System.out.println("                                      ");
//            System.out.println("           ADICIONAR RECURSO          ");
//            System.out.println("                                      ");
//            System.out.println(" INSIRA O NOME DO RECURSO A ADICCIONAR");
//
//            String NomeAdicionarRecurso = myinputs.Ler.umaString();
//
//            System.out.println("                                      ");
//            System.out.println(" INSIRA O NOME DO RECURSO A ADICCIONAR");
//
//            double QuantidadeAdicionarRecurso = myinputs.Ler.umDouble();
//
//        break;
//        case 5:
//            System.out.println("--------------------------------------");
//            System.out.println("                                      ");
//            System.out.println("           REMOVER RECURSO            ");
//            System.out.println("                                      ");
//            System.out.println("  INSIRA O NOME DO RECURSO A REMOVER  ");
//
//            String NomeRemoverRecurso = myinputs.Ler.umaString();
//
//        break;
//        case 0:
//            OpcaoMenuUserGestorEditarProdutos = -1;
//        break;    
//        }
//        break;
//        case 2:
//
//        break;
//        case 3:
//
//        break;
//        case 4:
//
//        break;
//        case 5:
//
//        break;
//        case 0:
//        OpcaoMenuUserGestorEditarProdutos = -1;
//        break;
//        }
//        }
//        }    
//        break;
//
//        case 2:
//        System.out.println("--------------------------------------");
//        System.out.println("                                      ");
//        System.out.println("      CADA IOGURTE CUSTA X EUROS      ");
//        System.out.println("                                      ");
//        System.out.println("QUANTAS UNIDADES PRETENDE ENCOMENDAR? ");
//
//        int EncomendaIogurtes = myinputs.Ler.umInt();
//        break;
//
//        case 3:
//        System.out.println("--------------------------------------");
//        System.out.println("                                      ");
//        System.out.println("        CADA SUMO CUSTA X EUROS       ");
//        System.out.println("                                      ");
//        System.out.println("QUANTAS UNIDADES PRETENDE ENCOMENDAR? ");
//
//        int EncomendaSumos = myinputs.Ler.umInt();
//        break;
//
//        //RETROCEDER--------------------------------------------
//        case 0:
//        OpcaoMenuUserGestorEditar = -1;
//        OpcaoMenuUserGestorEditar1 = -1;
//        break;
//        }
//        }
//        break;
//
//        //MENU CONSULTAR SALDO-----------------------------
//        case 2:
//
//        break;
//        //TERMINAR SESSÃO--------------------------------------------
//        case 0:
//        OpcaoMenuUserGestor = -1;
//        break;
//
//        }   
//
//        }
//
//
//        break;
//        //-------------------------------------
//        //-------------------------------------
//
//        //-------------------REGISTO------------------------
//        case 2:
//
//
//        break;
//        }
//        }
//        }
    }
}
