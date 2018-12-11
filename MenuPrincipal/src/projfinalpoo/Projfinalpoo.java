package projfinalpoo;

import myinputs.Ler.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import myinputs.Ler;

public class Projfinalpoo {
    
    public static ArrayList<Produto> arrayProduto = new ArrayList<Produto>();
    public static ArrayList<Recurso> arrayRecurso = new ArrayList<Recurso>();
    public static ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();
    public static ArrayList<Gestor> arrayGestor = new ArrayList<Gestor>();
    
    public static Produto classProduto;
    public static Recurso classRecurso;

    public static int opcaoMenu;
    
    // ********************** Login ****************************

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
        System.out.println("|          3 - Fornecedor          |");
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

    // ************************ Cliente ************************
    
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
    
    // ************************ Gestor *********************************
    
    public static void menuGestor() {
        System.out.println("+--------------" /* Xico.getUser()*/);
        System.out.println("|                                      |");
        System.out.println("|     SALDO: /*GETSALDO*/              |");
        System.out.println("|                                      |");
        System.out.println("|     1. EDITAR                        |");
        System.out.println("|     2. CONSULTAR MOVIMENTOS          |");
        System.out.println("|     3. COMPRAR RECURSOS AO FORNECEDOR|");
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
    
// *********************************************** Produtos ***************************************


    public static void editarProdutos() {
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|            EDITAR PRODUTOS          |");
        System.out.println("|                                     |");
        System.out.println("|        O QUE PRETENDE EDITAR?       |");
        System.out.println("|                                     |");
        System.out.println("|        1. EDITAR PRODUTO EXISTENTE  |");
        System.out.println("|        2. ADICIONAR PRODUTO         |");
        System.out.println("|        3. REMOVER PRODUTO           |");
        System.out.println("|        0. RETROCEDER                |");
        System.out.println("|                                     |");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Opção: ");
        
        opcaoMenu = myinputs.Ler.umInt();
        
        switch(opcaoMenu) {
            case 1:
                editarProdutoExistente();
                break;
            case 2:
                AdicionarProdutos();
                editarProdutos();
                break;

            case 3:
                break;
            case 0:
                menuEditar();
                break;
        }
    }
    
    public static void editarProdutoExistente(){
        
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|      EDITAR PRODUTOS EXISTENTE      |");
        System.out.println("|                                     |");
        
        // Dá print a todos os produtos existentes
        if (arrayProduto.size() == 0) {
                System.out.println("Não existem produtos.");
                editarProdutos();
        } else {
            for (int i = 0; i < arrayProduto.size(); i++) {
                System.out.println(i+1 + "." + arrayProduto.get(i).getNome());
            }
	}
        System.out.println("| QUAL O PRODUTO QUE PRETENDE EDITAR? |");
        int produto = myinputs.Ler.umInt();
        
        System.out.println("|                                     |");
        System.out.println("|       O QUE PRETENDE EDITAR?        |");
        System.out.println("|                                     |");
        System.out.println("|   1. NOME                           |");
        System.out.println("|   2. QUANIDADE DE ENCOMENDAS        |");
        System.out.println("|   3. QUANIDADE DE ENCOMENDAS TOTAL  |");
        System.out.println("|   4. RECURSOS NECESSARIOS PARA A    |");
        System.out.println("|             SUA PRODUÇÃO            |");
        System.out.println("|   0. VOLTAR                         |");
        System.out.println("|                                     |");
        System.out.println("|    QUANIDADE TOTAL DE ENCOMENDAS    |");
        System.out.println("|            QUE PRETENDE?            |");
        opcaoMenu = myinputs.Ler.umInt();
        
        switch (opcaoMenu) {
            case 1:
                System.out.println("|          NOME QUE PRETENDE?         |");
                arrayProduto.get(produto - 1).setNome(myinputs.Ler.umaString());
                break;
            case 2:
                System.out.println("|       QUANIDADE DE ENCOMENDAS       |");
                System.out.println("|            QUE PRETENDE?            |");
                arrayProduto.get(produto - 1).setQuantidadeEncomendada(myinputs.Ler.umInt());
                break;
            case 3:
                System.out.println("|    QUANIDADE TOTAL DE ENCOMENDAS    |");
                System.out.println("|            QUE PRETENDE?            |");
                arrayProduto.get(produto - 1).setQuantidadeEncomendadaTotal(myinputs.Ler.umInt()); 
                break;
            case 4:
                System.out.println("INSIRA QUANTOS RECURSOS SÃO NECESSARIOS:");
                int recursosNecessarios = myinputs.Ler.umInt();
                String[] string = new String[recursosNecessarios];
                for (int i = 0; i < recursosNecessarios; i++) {
                    System.out.println("INTRODUZA O NOME DO " + (i+1) + "º RECURSO:");
                }
                arrayProduto.get(produto - 1).setStringArray(string); 
                break;
            case 0:
                editarProdutos();
        }
    }
   
    
    public static void AdicionarProdutos() {
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|           ADICIONAR PRODUTO         |");
        System.out.println("|                                     |");
        System.out.println("| INSIRA O NOME DO PRODUTO A ADICIONAR|");
        System.out.println("|                                     |");
        System.out.println();
        System.out.print("Nome: ");

        String NomeAdicionarProduto = myinputs.Ler.umaString();
        
        System.out.println("|    QUANTIADE EXISTENTE EM STOCK CASO TENHA    |");
        
        double adicionarProdutoStock = myinputs.Ler.umDouble();

        System.out.println("INSIRA QUANTOS RECURSOS SÃO NECESSARIOS:");
        int recursosNecessarios = myinputs.Ler.umInt();
        String[] stringRecursosNecessarios = new String[recursosNecessarios];
        for (int i = 0; i < stringRecursosNecessarios.length; i++) {
            System.out.println("INTRODUZA O NOME DO " + (i + 1) + "º RECURSO:");
            String nomeRecurso = myinputs.Ler.umaString();
            stringRecursosNecessarios[i] = nomeRecurso;
            
            
            // ********************************************************************************************BUG************************************
            
            for (int j = 0; j < arrayRecurso.size(); j++) {
                if (arrayRecurso.get(j).getNome().equals(nomeRecurso)) {
                    System.out.println("O recurso introduzido ainda não exite. Pretende adiciona-lo agora?");
                    System.out.println(" 1. Sim");
                    System.out.println(" 2. Não");
                    int opcao = myinputs.Ler.umInt();
                    if (opcao == 1) {
                        adicionarRecurso();
                    }
                } else {
                    
                }
            }
        }
        
        System.out.println("|   INSIRA O PREÇO DO PRODUTO       |");
        double preco = myinputs.Ler.umDouble();
        
        classProduto = new Produto(NomeAdicionarProduto, adicionarProdutoStock, stringRecursosNecessarios, preco);
        
        arrayProduto.add(classProduto);
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
    
    // *********************************************** Recursos ***************************************
    
    public static void editarRecursos() {
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|            EDITAR RECURSOS          |");
        System.out.println("|                                     |");
        System.out.println("|        O QUE PRETENDE EDITAR?       |");
        System.out.println("|                                     |");
        System.out.println("|        1. EDITAR PRODUTO EXISTENTE  |");
        System.out.println("|        2. ADICIONAR PRODUTO         |");
        System.out.println("|        3. REMOVER PRODUTO           |");
        System.out.println("|        0. RETROCEDER                |");
        System.out.println("|                                     |");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Opção: ");
        
        opcaoMenu = myinputs.Ler.umInt();
        
        switch(opcaoMenu) {
            case 1:
                editarRecursoExistente();
                break;
            case 2:
                adicionarRecurso();
                editarProdutos();
                break;
            case 3:
                //removerRecurso();
                break;
            case 0:
                menuEditar();
                break;
        }
    }
    
    public static void editarRecursoExistente() {
        
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|      EDITAR RECURSOS EXISTENTE      |");
        System.out.println("|                                     |");
        
        // Dá print a todos os produtos existentes
        if (arrayRecurso.size() == 0) {
                System.out.println("Não existem recursos.");
                editarRecursos();
        } else {
            for (int i = 0; i < arrayRecurso.size(); i++) {
                System.out.println(i+1 + "." + arrayRecurso.get(i).getNome());
            }
	}
        
        System.out.println("| QUAL O RECURSO QUE PRETENDE EDITAR? |");
        int recurso = myinputs.Ler.umInt();
        
        System.out.println("|                                     |");
        System.out.println("|       O QUE PRETENDE EDITAR?        |");
        System.out.println("|                                     |");
        System.out.println("|   1. NOME                           |");
        System.out.println("|   2. QUANIDADE EM STOCK             |");
        System.out.println("|   3. CUSTO                          |");
        System.out.println("|   0. VOLTAR                         |");
        System.out.println("|                                     |");
        System.out.println("|    QUANIDADE TOTAL DE ENCOMENDAS    |");
        System.out.println("|            QUE PRETENDE?            |");
        opcaoMenu = myinputs.Ler.umInt();
        
        switch (opcaoMenu) {
            case 1:
                System.out.println("|          NOME QUE PRETENDE?         |");
                arrayRecurso.get(recurso - 1).setNome(myinputs.Ler.umaString());
                break;
            case 2:
                System.out.println("|       QUANIDADE DE ENCOMENDAS       |");
                System.out.println("|            QUE PRETENDE?            |");
                arrayRecurso.get(recurso - 1).setQuantidadeStock(myinputs.Ler.umDouble());
                break;
            case 3:
                System.out.println("|   INSIRA O NOVO CUSTO |");
                arrayRecurso.get(recurso-1).setCusto(myinputs.Ler.umDouble());
                break;
            case 0:
                editarProdutos();
        }
        
    }
    
    public static void adicionarRecurso() {
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|           ADICIONAR RECURSO         |");
        System.out.println("|                                     |");
        System.out.println("| INSIRA O NOME DO RECURSO A ADICIONAR|");
        System.out.println("|                                     |");
        System.out.println();
        System.out.print("Nome: ");

        String NomeAdicionarRecurso = myinputs.Ler.umaString();
        
        System.out.println("|    QUANTIADE EXISTENTE EM STOCK CASO TENHA    |");
        
        double adicionarRecursoStock = myinputs.Ler.umDouble(); // Está a restringir para um Int porque a quantidade do
                                                          // produto tem de ser inteiro apesar de na class ter double. 
                                                          // Double será para os recursos

        System.out.println("| Insira o custo do recurso |");
        double custo = myinputs.Ler.umDouble();
        
        classRecurso = new Recurso(NomeAdicionarRecurso, adicionarRecursoStock, custo);
                                                          
        arrayRecurso.add(classRecurso);
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
                /*Metodo EncomendarRecurso(Farinha) */
                fazerPedidoFornecedor();
                break;
            case 2:
                /*Metodo EncomendarRecurso(Ovos) */
                fazerPedidoFornecedor();
                break;
            case 3:
                /*Metodo EncomendarRecurso(Chocolate) */
                fazerPedidoFornecedor();
                break;
            case 4:
                /*Metodo EncomendarRecurso(Leite) */
                fazerPedidoFornecedor();
                break;
            case 5:
                /*Metodo EncomendarRecurso(Açucar) */
                fazerPedidoFornecedor();
                break;
            case 6:
                /*Metodo EncomendarRecurso(Morango) */
                fazerPedidoFornecedor();
                break;
            case 7:
                /*Metodo EncomendarRecurso(Água) */
                fazerPedidoFornecedor();
                break;
            case 8:
                /*Metodo EncomendarRecurso(Laranja) */
                fazerPedidoFornecedor();
                break;
            case 9:
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
