package projfinalpoo;

import myinputs.Ler.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import myinputs.Ler;

public class Projfinalpoo {
    
    public ArrayList ProdutoERecurso = new ArrayList<ProdutoERecurso>();
    public ArrayList Cliente = new ArrayList<Cliente>();
    public ArrayList Gestor = new ArrayList<Gestor>();

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
        System.out.println("|        INTRODUZA USERNAME        |");
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
        System.out.println("|                                  |");
        System.out.println("+----------------------------------+");
        System.out.println();
        System.out.print("Opção: ");
        
        int novoTipoDeConta = myinputs.Ler.umInt();
        
        System.out.println("|                                  |");
        System.out.println("|                                  |");
        
        menuLogin();
        
        
        // Informação vai para a função de registo do Xico
    }

    public static void menuCliente() {
        System.out.println("+------------- Cliente ------------+" /* Xico.getUser()*/ );
        System.out.println("|                                  |");
        System.out.println("|     SALDO:" /* + Fabio.getSaldo() */);
        System.out.println("|                                  |");
        System.out.println("|     1. ENCOMENDAR PRODUTOS       |");
        System.out.println("|     2. CONSULTAR MOVIMENTOS      |");
        System.out.println("|     3. CARREGAR CONTA            |");
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
            case 3:
                
                // Carregar a Conta
                
                break;
            case 0:
                //menuPrincipal(); NAO ELIMINAR. VERSAO FINAL!!!
                menuGestor(); // ELIMINAR NO FIM DO PROJ
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
        System.out.println();
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
                
                /*
                    if( (saldo = saldo - EncomendaBolo * PreçoBolo) >= 0){
                        
                        Metodo EncomendarBolo(EncomendaBolo)
                        System.out.println("     ENCOMENDA EFETUADA COM SUCESSO    ");
                        System.out.println("+-------------------------------------+");
                    }
                    else{
                        System.out.println("   O SEU SALDO NÃO LHE PERMITE FAZER   ");
                        System.out.println("             ESTA ENCOMENDA            ");
                        System.out.println("+-------------------------------------+");
                    }
                */
                
                menuEncomendarProdutos(); //Retrocede menu depois de input
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
                
                /*
                    if( (saldo = saldo - EncomendaIogurtes * PreçoIogurtes) >= 0){
                        
                        Metodo EncomendarIogurtes(EncomendaIogurtes)
                        System.out.println("     ENCOMENDA EFETUADA COM SUCESSO    ");
                        System.out.println("+-------------------------------------+");
                    }
                    else{
                        System.out.println("   O SEU SALDO NÃO LHE PERMITE FAZER   ");
                        System.out.println("             ESTA ENCOMENDA            ");
                        System.out.println("+-------------------------------------+");
                    }
                */
                
                menuEncomendarProdutos(); //Retrocede menu depois de input
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
                
                 /*
                    if( (saldo = saldo - EncomendaSumos * PreçoSumos) >= 0){
                        
                        Metodo EncomendarSumos(EncomendaSumos)
                        System.out.println("     ENCOMENDA EFETUADA COM SUCESSO    ");
                        System.out.println("+-------------------------------------+");
                    }
                    else{
                        System.out.println("   O SEU SALDO NÃO LHE PERMITE FAZER   ");
                        System.out.println("             ESTA ENCOMENDA            ");
                        System.out.println("+-------------------------------------+");
                    }
                */
                menuEncomendarProdutos(); //Retrocede menu depois de input
                break;
            case 0:
                // Corrigir para que vá para o tipo de conta em que o utilizador fez log in
                menuCliente();
                break;
        }
    }

    public static void menuConsultarMovimentos() {
        System.out.println("-----------" /* Xico.getUser()*/);
        System.out.println("+--------------MOVIMENTOS-------------+");
        System.out.println("|                                     |");
        System.out.println("|        SALDO: /*GETSALDO*/          |");
        System.out.println("|                                     |");
        System.out.println("|        TOTAL DE DESPESAS:           |" /* + GETTOTALDESPESAS */);
        System.out.println("|         >BOLO:                      |" /* + GETTOTALDESPESASSBOLO */);
        System.out.println("|         >IOGURTE:                   |" /* + GETTOTALDESPESASIOGURTE */);
        System.out.println("|         >SUMO:                      |" /* + GETTOTALDESPESASSUMOS */);
        System.out.println("|                                     |");
        System.out.println("|        TOTAL DE UNIDADES COMPRADAS: |" /* GETTOTALUNIDADESCOMPRADAS */);
        System.out.println("|         >BOLO:                      |" /* + GETTOTALUNIDADESBOLO */);
        System.out.println("|         >IOGURTE:                   |" /* + GETTOTALDESPESASIOGURTES */);
        System.out.println("|         >SUMO:                      |" /* + GETTOTALDESPESASSUMOS */);
        System.out.println("|                                     |");
        System.out.println("|        0. RETROCEDER                |");
        System.out.println("|                                     |");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Opção: ");
        
        String retroceder = myinputs.Ler.umaString();
        
        switch (retroceder) {
            default:
                menuCliente();
                break;
        }
    }
    
    public static void menuGestor() {
        System.out.println("+--------------" /* Xico.getUser()*/);
        System.out.println("|                                      |");
        System.out.println("|     SALDO: /*GETSALDO*/              |");
        System.out.println("|                                      |");
        System.out.println("|     1. EDITAR                        |");
        System.out.println("|     2. CONSULTAR MOVIMENTOS          |");
        System.out.println("|     3. FAZER PEDIDOS A FORNECEDOR    |");
        System.out.println("|     4. CONSULTAR PEDIDOS DE CLIENTES |");
        System.out.println("|     0. TERMINAR SESSÃO               |");
        System.out.println("|                                      |");
        System.out.println("+--------------------------------------+");
        System.out.println();
        System.out.print("Opção: ");
        
        opcaoMenu = myinputs.Ler.umInt();
        
        switch (opcaoMenu) {
            case 1:
                menuEditar();
                break;
            case 2:
                menuConsultarMovimentosGestor();
                break;
            case 3:
                fazerPedidoFornecedor();
                break;
            case 4:
                consultarPedidoCliente();
                break;
            case 0:
                menuPrincipal();
                break;
        }
    }

    public static void menuEditar() {
        System.out.println("---------------" /* Xico.getUser()*/);
        System.out.println("+--------------EDITAR-----------------+");
        System.out.println("|                                     |");
        System.out.println("|        SALDO: /*GETSALDO*/          |");
        System.out.println("|                                     |");
        System.out.println("|        1. PRODUTOS                  |");
        System.out.println("|        2. RECURSOS                  |");
        System.out.println("|        0. RETROCEDER                |");
        System.out.println("|                                     |");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Opção: ");
        
        opcaoMenu = myinputs.Ler.umInt();
        
        switch (opcaoMenu) {
            case 1:
                editarProdutos();
                break;
            case 2:
                editarRecursos();
                break;
            case 0:
                menuGestor();
                break;
        }
    }

    public static void editarProdutos() {
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|            EDITAR PRODUTOS          |");
        System.out.println("|                                     |");
        System.out.println("| QUAL O PRODUTO QUE PRETENDE EDITAR? |");
        System.out.println("|                                     |");
        System.out.println("|        1. BOLOS                     |");
        System.out.println("|        2. IOGURTES                  |");
        System.out.println("|        3. SUMOS                     |");
        System.out.println("|                                     |");
        System.out.println("|        4. ADICIONAR PRODUTO         |");
        System.out.println("|        5. REMOVER PRODUTO           |");
        System.out.println("|        0. RETROCEDER                |");
        System.out.println("|                                     |");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Opção: ");
        
        opcaoMenu = myinputs.Ler.umInt();
        
        switch(opcaoMenu) {
            case 1:
                editarProdutosBolos();
                break;
            case 2:
                editarProdutosIogurtes();
                break;

            case 3:
                editarProdutosSumos();
                break;
                
            case 4:
                AdicionarProdutos();
                break;
            case 5:
                RemoverProdutos();
                break;
            case 0:
                menuEditar();
                break;
        }
    }
    
    public static void editarProdutosBolos(){
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|             EDITAR BOLOS            |");
        System.out.println("|                                     |");
        System.out.println("|  QUAL O RECURSO QUE PRETENDE EDITAR?|");
        System.out.println("|                                     |");
        System.out.println("|              1. FARINHA             |");
        System.out.println("|              2. OVOS                |");
        System.out.println("|              3. CHOCOLATE           |");
        System.out.println("|              0. RETROCEDER          |");
        System.out.println("|                                     |");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Opção: ");

        opcaoMenu = myinputs.Ler.umInt();
        
        switch(opcaoMenu){
            case 1:
            System.out.println("+-------------------------------------+");
            System.out.println("|                                     |");
            System.out.println("|        EDITAR FARINHA DOS BOLOS     |");
            System.out.println("|                                     |");
            System.out.println("|     QUANTIDADE USADA POR UNIDADE    |");
            System.out.println("|            /* GET FARINHA BOLOc*/   |" );
            System.out.println("|                                     |");
            System.out.println("|        INSIRA NOVA QUANTIDADE       |");
            System.out.println("|          USADA POR UNIDADE          |");
            System.out.println("|                                     |");
            System.out.println("+-------------------------------------+");
            System.out.println();
            System.out.print("Quantidade: ");

            double QuantidadeNovaFarinha = myinputs.Ler.umDouble();
            editarProdutosBolos(); //Retrocede este menu após input
                break;
            case 2:
            System.out.println("+-------------------------------------+");
            System.out.println("|                                     |");
            System.out.println("|         EDITAR OVOS DOS BOLOS       |");
            System.out.println("|                                     |");
            System.out.println("|     QUANTIDADE USADA POR UNIDADE    |");
            System.out.println("|             /*GETOVOSBOLOS*/        |");
            System.out.println("|                                     |");
            System.out.println("|        INSIRA NOVA QUANTIDADE       |");
            System.out.println("|          USADA POR UNIDADE          |");
            System.out.println("|                                     |");
            System.out.println("+-------------------------------------+");
            System.out.println();
            System.out.print("Quantidade: ");

            double QuantidadeNovaOvos = myinputs.Ler.umDouble();
            editarProdutosBolos(); //Retrocede este menu após input
                break;
            case 3:
            System.out.println("+-------------------------------------+");
            System.out.println("|                                     |");
            System.out.println("|       EDITAR CHOCOLATE DOS BOLOS    |");
            System.out.println("|                                     |");
            System.out.println("|     QUANTIDADE USADA POR UNIDADE    |");
            System.out.println("|           /*GETCHOCOLATEBOLOS */    |");
            System.out.println("|                                     |");
            System.out.println("|        INSIRA NOVA QUANTIDADE       |");
            System.out.println("|          USADA POR UNIDADE          |");
            System.out.println("|                                     |");
            System.out.println("+-------------------------------------+");
            System.out.println();
            System.out.print("Quantidade: ");

            double QuantidadeNovaChocolate = myinputs.Ler.umDouble();
            editarProdutosBolos(); //Retrocede este menu após input
                break;
            case 0:
                editarProdutos();
                break;
        }
        
        
    }
    
    public static void editarProdutosIogurtes(){
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|             EDITAR IOGURTES         |");
        System.out.println("|                                     |");
        System.out.println("|  QUAL O RECURSO QUE PRETENDE EDITAR?|");
        System.out.println("|                                     |");
        System.out.println("|              1. LEITE               |");
        System.out.println("|              2. AÇUCAR              |");
        System.out.println("|              3. MORANGO             |");
        System.out.println("|              0. RETROCEDER          |");
        System.out.println("|                                     |");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Opção: ");

        opcaoMenu = myinputs.Ler.umInt();
        
        switch(opcaoMenu){
            case 1:
            System.out.println("+-------------------------------------+");
            System.out.println("|                                     |");
            System.out.println("|       EDITAR LEITE DOS IOGURTES     |");
            System.out.println("|                                     |");
            System.out.println("|     QUANTIDADE USADA POR UNIDADE    |");
            System.out.println("|            /*GETLEITEIOGURTES*/     |");
            System.out.println("|                                     |");
            System.out.println("|        INSIRA NOVA QUANTIDADE       |");
            System.out.println("|          USADA POR UNIDADE          |");
            System.out.println("|                                     |");
            System.out.println("+-------------------------------------+");
            System.out.println();
            System.out.print("Quantidade: ");

            double QuantidadeNovaLeite = myinputs.Ler.umDouble();
            editarProdutosIogurtes(); //Retrocede este menu após input
                break;
            case 2:
            System.out.println("+-------------------------------------+");
            System.out.println("|                                     |");
            System.out.println("|       EDITAR AÇUCAR DOS IOGURTES    |");
            System.out.println("|                                     |");
            System.out.println("|     QUANTIDADE USADA POR UNIDADE    |");
            System.out.println("|            /*GETAÇUCARIOGURTES*/    |");
            System.out.println("|                                     |");
            System.out.println("|        INSIRA NOVA QUANTIDADE       |");
            System.out.println("|          USADA POR UNIDADE          |");
            System.out.println("|                                     |");
            System.out.println("+-------------------------------------+");
            System.out.println();
            System.out.print("Quantidade: ");

            double QuantidadeNovaAcucar = myinputs.Ler.umDouble();
            editarProdutosIogurtes(); //Retrocede este menu após input
                break;
            case 3:
            System.out.println("+-------------------------------------+");
            System.out.println("|                                     |");
            System.out.println("|       EDITAR MORANGO DOS IOGURTES   |");
            System.out.println("|                                     |");
            System.out.println("|     QUANTIDADE USADA POR UNIDADE    |");
            System.out.println("|            /*GETMORANGOIOGURTES*    |");
            System.out.println("|                                     |");
            System.out.println("|        INSIRA NOVA QUANTIDADE       |");
            System.out.println("|          USADA POR UNIDADE          |");
            System.out.println("|                                     |");
            System.out.println("+-------------------------------------+");
            System.out.println();
            System.out.print("Quantidade: ");

            double QuantidadeNovaMorangos = myinputs.Ler.umDouble();
            editarProdutosIogurtes(); //Retrocede este menu após input
                break;
            case 0:
                editarProdutos();
                break;
        }
        
        
    }
    
    public static void editarProdutosSumos(){
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|              EDITAR SUMOS           |");
        System.out.println("|                                     |");
        System.out.println("|  QUAL O RECURSO QUE PRETENDE EDITAR?|");
        System.out.println("|                                     |");
        System.out.println("|              1. ÁGUA                |");
        System.out.println("|              2. LARANJA             |");
        System.out.println("|              3. MARACUJÀ            |");
        System.out.println("|              0. RETROCEDER          |");
        System.out.println("|                                     |");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Opção: ");

        opcaoMenu = myinputs.Ler.umInt();
        
        switch(opcaoMenu){
            case 1:
            System.out.println("+-------------------------------------+");
            System.out.println("|                                     |");
            System.out.println("|        EDITAR AGUA DOS SUMOS        |");
            System.out.println("|                                     |");
            System.out.println("|     QUANTIDADE USADA POR UNIDADE    |");
            System.out.println("|            /*GETAGUASUMOS*          |");
            System.out.println("|                                     |");
            System.out.println("|        INSIRA NOVA QUANTIDADE       |");
            System.out.println("|          USADA POR UNIDADE          |");
            System.out.println("|                                     |");
            System.out.println("+-------------------------------------+");
            System.out.println();
            System.out.print("Quantidade: ");

            double QuantidadeNovaAgua = myinputs.Ler.umDouble();
            editarProdutosSumos(); //Retrocede este menu após input
                break;
            case 2:
            System.out.println("+-------------------------------------+");
            System.out.println("|                                     |");
            System.out.println("|      EDITAR LARANJA DOS SUMOS       |");
            System.out.println("|                                     |");
            System.out.println("|     QUANTIDADE USADA POR UNIDADE    |");
            System.out.println("|            /*GETLARANJAUMOS*        |");
            System.out.println("|                                     |");
            System.out.println("|        INSIRA NOVA QUANTIDADE       |");
            System.out.println("|          USADA POR UNIDADE          |");
            System.out.println("|                                     |");
            System.out.println("+-------------------------------------+");
            System.out.println();
            System.out.print("Quantidade: ");

            double QuantidadeNovaLaranja = myinputs.Ler.umDouble();
            editarProdutosSumos(); //Retrocede este menu após input
                break;
            case 3:
            System.out.println("+-------------------------------------+");
            System.out.println("|                                     |");
            System.out.println("|      EDITAR MARACUJA DOS SUMOS      |");
            System.out.println("|                                     |");
            System.out.println("|     QUANTIDADE USADA POR UNIDADE    |");
            System.out.println("|          /*GETMARACUJASUMOS*/       |");
            System.out.println("|                                     |");
            System.out.println("|        INSIRA NOVA QUANTIDADE       |");
            System.out.println("|          USADA POR UNIDADE          |");
            System.out.println("|                                     |");
            System.out.println("+-------------------------------------+");
            System.out.println();
            System.out.print("Quantidade: ");

            double QuantidadeNovaMaracujá = myinputs.Ler.umDouble();
            editarProdutosSumos(); //Retrocede este menu após input
                break;
            case 0:
                editarProdutos();
                break;
        }
        
        
    }
    
    public static void AdicionarProdutos() {
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|           ADICIONAR PRODUTO         |");
        System.out.println("|                                     |");
        System.out.println("| INSIRA O NOME DO PRODUTO A ADICIONAR|");
        System.out.println("|                                     |");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Nome: ");

        String NomeAdicionarProduto = myinputs.Ler.umaString();

        System.out.println("+-------------------------------------+");
        System.out.println("                                      ");
        System.out.println("   QUANTOS RECURSOS SÃO NECESSÀRIOS   ");
        System.out.println("       PARA PRODUZIR O PRODUTO?       ");
        System.out.println("                                      ");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Numero de Recursos: ");

        int numero = Ler.umInt();

        for (int i = 0; i < numero; i++) {

            System.out.println("+-------------------------------------+");
            System.out.println("                                      ");
            System.out.println(" INSIRA O NOME DO RECURSO A ADICIONAR ");
            System.out.println("                                      ");
            System.out.println("+-------------------------------------+");
            System.out.println();
            System.out.print("Nome: ");

            String nomeAdicionarRecurso = myinputs.Ler.umaString();

            System.out.println("+-------------------------------------+");
            System.out.println("                                      ");
            System.out.println("    INSIRA A QUANTIDADE DO RECURSO    ");
            System.out.println("            " /* + nomeAdicionarRecurso */);
            System.out.println("       PARA PRODUZIR O PRODUTO?       ");
            System.out.println("                                      ");
            System.out.println("+-------------------------------------+");
            System.out.println();
            System.out.print("Quantidade: ");

            double quantidadeAdicionarRecurso = myinputs.Ler.umDouble();

            /* Metodo AdicionarProduto(nomeAdicionarRecurso, quantidadeAdicionarRecurso) */
        }

        editarProdutos();
    }
    
    public static void RemoverProdutos() {
        System.out.println("+-------------------------------------+");
        System.out.println("                                      ");
        System.out.println("           REMOVER PRODUTO            ");
        System.out.println("                                      ");
        System.out.println("  INSIRA O NOME DO PRODUTO A REMOVER  ");
        System.out.println("                                      ");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Remover: ");

        String NomeRemoverProdutos = myinputs.Ler.umaString();

        //Metodo removerProdutos(NomeRemoverProdutos);
        editarProdutos();
    }
    
    public static void editarRecursos(){
        System.out.println("+-------------------------------------+");
        System.out.println("                                      ");
        System.out.println("            REMOVER RECURSOS          ");
        System.out.println("                                      ");
        System.out.println(" QUAL O RECURSO QUE PRETENDE REMOVER? ");
        System.out.println("                                      ");
        System.out.println("           BOLOS:                     ");
        System.out.println("           > 1. FARINHA               ");
        System.out.println("           > 2. OVOS                  ");
        System.out.println("           > 3. CHOCOLATE             ");
        System.out.println("                                      ");
        System.out.println("           IOGURTES:                  ");
        System.out.println("           > 4. LEITE                 ");
        System.out.println("           > 5. AÇUCAR                ");
        System.out.println("           > 6. MORANGO               ");
        System.out.println("                                      ");
        System.out.println("           SUMOS:                     ");
        System.out.println("           > 7. ÁGUA                  ");
        System.out.println("           > 8. LARANJA               ");
        System.out.println("           > 9. MARACUJÁ              ");
        System.out.println("                                      ");
        System.out.println("           0. RETROCEDER              ");
        System.out.println("                                      ");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Opção: ");
        
        opcaoMenu = myinputs.Ler.umInt();
        
        switch(opcaoMenu){
            case 1:
                /*Metodo RemoverRecurso(Farinha) */
                editarRecursos();
                break;
            case 2:
                /*Metodo RemoverRecurso(Ovos) */
                editarRecursos();
                break;
            case 3:
                /*Metodo RemoverRecurso(Chocolate) */
                editarRecursos();
                break;
            case 4:
                /*Metodo RemoverRecurso(Leite) */
                editarRecursos();
                break;
            case 5:
                /*Metodo RemoverRecurso(Açucar) */
                editarRecursos();
                break;
            case 6:
                /*Metodo RemoverRecurso(Morango) */
                editarRecursos();
                break;
            case 7:
                /*Metodo RemoverRecurso(Água) */
                editarRecursos();
                break;
            case 8:
                /*Metodo RemoverRecurso(Laranja) */
                editarRecursos();
                break;
            case 9:
                /*Metodo RemoverRecurso(Maracujá) */
                editarRecursos();
                break;
            case 0:
                menuEditar();
                break;
        }
    }
    
    public static void menuConsultarMovimentosGestor() {
        System.out.println("-----------" /* Xico.getUser()*/);
        System.out.println("+--------------MOVIMENTOS-------------+");
        System.out.println("|                                     |");
        System.out.println("|        SALDO: /*GETSALDO*/          |");
        System.out.println("|                                     |");
        System.out.println("|        TOTAL DE DESPESAS:           |" /* + GETTOTALDESPESAS */);
        System.out.println("|         >BOLO:                      |" /* + GETTOTALDESPESASSBOLO */);
        System.out.println("|         >IOGURTE:                   |" /* + GETTOTALDESPESASIOGURTE */);
        System.out.println("|         >SUMO:                      |" /* + GETTOTALDESPESASSUMOS */);
        System.out.println("|                                     |");
        System.out.println("|        TOTAL DE UNIDADES COMPRADAS: |" /* GETTOTALUNIDADESCOMPRADAS */);
        System.out.println("|         >BOLO:                      |" /* + GETTOTALUNIDADESBOLO */);
        System.out.println("|         >IOGURTE:                   |" /* + GETTOTALDESPESASIOGURTES */);
        System.out.println("|         >SUMO:                      |" /* + GETTOTALDESPESASSUMOS */);
        System.out.println("|                                     |");
        System.out.println("|        0. RETROCEDER                |");
        System.out.println("|                                     |");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Opção: ");
        
        String retroceder = myinputs.Ler.umaString();
        
        switch (retroceder) {
            default:
                menuGestor();
                break;
        }
    }
    
    public static void fazerPedidoFornecedor(){
        System.out.println("+-------------------------------------+");
        System.out.println("                                      ");
        System.out.println("           ENCOMENDAR RECURSO         ");
        System.out.println("                                      ");
        System.out.println("QUAL O RECURSO QUE PRETENDE ENCOMENDAR?");
        System.out.println("                                      ");
        System.out.println("           BOLOS:                     ");
        System.out.println("           > 1. FARINHA               ");
        System.out.println("           > 2. OVOS                  ");
        System.out.println("           > 3. CHOCOLATE             ");
        System.out.println("                                      ");
        System.out.println("           IOGURTES:                  ");
        System.out.println("           > 4. LEITE                 ");
        System.out.println("           > 5. AÇUCAR                ");
        System.out.println("           > 6. MORANGO               ");
        System.out.println("                                      ");
        System.out.println("           SUMOS:                     ");
        System.out.println("           > 7. ÁGUA                  ");
        System.out.println("           > 8. LARANJA               ");
        System.out.println("           > 9. MARACUJÁ              ");
        System.out.println("                                      ");
        System.out.println("           0. RETROCEDER              ");
        System.out.println("                                      ");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Opção: ");
        
        opcaoMenu = myinputs.Ler.umInt();
        
        switch(opcaoMenu){
            case 1:
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("|        INSIRA A QUANTIDADE DE       |");
                System.out.println("|         FARINHA A ENCOMENDAR        |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println();
                System.out.print("Quantidade: ");
                /*Metodo EncomendarRecurso(Farinha) */
                fazerPedidoFornecedor();
                break;
            case 2:
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("|        INSIRA A QUANTIDADE DE       |");
                System.out.println("|          OVOS A ENCOMENDAR          |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println();
                System.out.print("Quantidade: ");
                /*Metodo EncomendarRecurso(Ovos) */
                fazerPedidoFornecedor();
                break;
            case 3:
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("|        INSIRA A QUANTIDADE DE       |");
                System.out.println("|        CHOCOLATE A ENCOMENDAR       |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println();
                System.out.print("Quantidade: ");
                /*Metodo EncomendarRecurso(Chocolate) */
                fazerPedidoFornecedor();
                break;
            case 4:
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("|        INSIRA A QUANTIDADE DE       |");
                System.out.println("|          LEITE A ENCOMENDAR         |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println();
                System.out.print("Quantidade: ");
                /*Metodo EncomendarRecurso(Leite) */
                fazerPedidoFornecedor();
                break;
            case 5:
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("|        INSIRA A QUANTIDADE DE       |");
                System.out.println("|          AÇUCAR A ENCOMENDAR        |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println();
                System.out.print("Quantidade: ");
                /*Metodo EncomendarRecurso(Açucar) */
                fazerPedidoFornecedor();
                break;
            case 6:
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("|        INSIRA A QUANTIDADE DE       |");
                System.out.println("|         MORANGO A ENCOMENDAR        |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println();
                System.out.print("Quantidade: ");
                /*Metodo EncomendarRecurso(Morango) */
                fazerPedidoFornecedor();
                break;
            case 7:
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("|        INSIRA A QUANTIDADE DE       |");
                System.out.println("|           AGUA A ENCOMENDAR         |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println();
                System.out.print("Quantidade: ");
                /*Metodo EncomendarRecurso(Água) */
                fazerPedidoFornecedor();
                break;
            case 8:
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("|        INSIRA A QUANTIDADE DE       |");
                System.out.println("|         LARANJA A ENCOMENDAR        |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println();
                System.out.print("Quantidade: ");
                /*Metodo EncomendarRecurso(Laranja) */
                fazerPedidoFornecedor();
                break;
            case 9:
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("|        INSIRA A QUANTIDADE DE       |");
                System.out.println("|         MARACUJÁ A ENCOMENDAR       |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println();
                System.out.print("Quantidade: ");
                /*Metodo EncomendarRecurso(Maracujá) */
                fazerPedidoFornecedor();
                break;
            case 0:
                menuGestor();
                break;
        }
        
        
    }
    
    public static void consultarPedidoCliente(){
        System.out.println("+-------------------------------------+");
        System.out.println("                                      ");
        System.out.println("           PEDIDOS CLIENTE            ");
        System.out.println("                                      ");
        System.out.println("           BOLOS: "); /* + getMetodoEncomendaBolo */
        System.out.println("                                      ");
        System.out.println("           IOGURTES: "); /* + getMetodoEncomendaIgurte */
        System.out.println("                                      ");
        System.out.println("           SUMOS: "); /* + getMetodoEncomedaSumo */
        System.out.println("                                      ");
        System.out.println("           1. PRODUZIR ENCOMENDAS     ");
        System.out.println("                                      ");
        System.out.println("           0. RETROCEDER              ");
        System.out.println("                                      ");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Opção: ");
        
        opcaoMenu = myinputs.Ler.umInt();
        
        switch(opcaoMenu){
            case 1:
                /* Metodo FabricarBolo( getMetodoEncomendaBolo ) */
                /* Metodo FabricarIogurte( getMetodoEncomendaIgurte ) */
                /* Metodo FabricarSumo( getMetodoEncomedaSumo ) */
                
                /* Metodo EnviarBolo( getMetodoEncomendaBolo ) */
                /* Metodo EnviarIogurte( getMetodoEncomendaIgurte ) */
                /* Metodo EnviarSumo( getMetodoEncomedaSumo ) */
                
                break;
            case 0:
                menuGestor();
                break;
        }
    }
    

    public static void main(String[] args) throws IOException {
        
        menuPrincipal();
        
    }
    
}
