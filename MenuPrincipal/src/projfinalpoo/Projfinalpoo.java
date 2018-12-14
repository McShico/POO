package projfinalpoo;

import myinputs.Ler.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import javax.xml.bind.DatatypeConverter;
import myinputs.Ler;

public class Projfinalpoo {

    public static ArrayList<Produto> arrayProduto = new ArrayList<Produto>();
    public static ArrayList<Recurso> arrayRecurso = new ArrayList<Recurso>();
    public static ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();
    public static ArrayList<Gestor> arrayGestor = new ArrayList<Gestor>();

    public static Produto classeProduto;
    public static Recurso classeRecurso;
    public static Cliente classeCliente;
    public static Gestor classeGestor;
    
    public static String utilizadorLoginAtual;
    public static int indiceUtilizadorAtualArraylist;

    public static int opcaoMenu;

    // ********************** Login ****************************
    public static void menuPrincipal() throws Exception {
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

    public static void menuLogin() throws Exception {
        System.out.println("+-------------- LOGIN -------------+");
        System.out.println("|                                  |");
        System.out.println("|    INTRODUZA O TIPO DE CONTA     |");
        System.out.println("|                                  |");
        System.out.println("|          1 - Cliente             |");
        System.out.println("|          2 - Gestor              |");
        System.out.print("|    Opção: ");
        
        opcaoMenu = myinputs.Ler.umInt();
        
        System.out.println("|                                  |");
        System.out.println("|        INTRODUZA USERNAME        |");
        System.out.print("|            ");
        
        String username = myinputs.Ler.umaString();

        System.out.println("|                                  |");
        System.out.println("|         INTRODUZA PASSWORD       |");
        System.out.print("|            ");
        
        String password = myinputs.Ler.umaString();
        
        System.out.println("+----------------------------------+");
        
        switch (opcaoMenu) {
            case 1:
                for (int i = 0; i < arrayCliente.size(); i++) {
                    if (arrayCliente.get(i).getNomeUtilizador().equals(username) && arrayCliente.get(i).getPassword().equals(password)) {
                        indiceUtilizadorAtualArraylist = i;
                        menuCliente();
                    } else {
                        System.err.println("Utilizador ou password errado(s).");
                    }
                }
                if (arrayCliente.size() == 0) {
                    System.err.println("Ainda não existem contas de cliente.");
                }
                break;
            case 2:
                for (int i = 0; i < arrayGestor.size(); i++) {
                    if (arrayGestor.get(i).getNomeUtilizador().equals(username) && arrayGestor.get(i).getPassword().equals(password) && arrayGestor.get(i).getAcesso()) {
                        indiceUtilizadorAtualArraylist = i;
                        menuGestor();
                    } else {
                        System.err.println("Utilizador ou password errado(s) ou ainda não tem acesso.");
                    }
                }
                if (arrayCliente.size() == 0) {
                    System.err.println("Ainda não existem contas de gestor.");
                }
                break;
            default:
                System.err.println("Opção inválida.");
                menuPrincipal();
                
        }
        
        menuPrincipal();
    }



    public static void menuRegistar() throws Exception {
        System.out.println("+------------ REGISTO -------------+");
        System.out.println("|                                  |");
        System.out.println("|     INTRODUZA O TIPO DE CONTA    |");
        System.out.println("|                                  |");
        System.out.println("|          1 - Cliente             |");
        System.out.println("|          2 - Gestor              |");
        System.out.println("|                                  |");
        System.out.print("|  Opção: ");

        opcaoMenu = myinputs.Ler.umInt();
        
        System.out.println("|                                  |");
        System.out.println("|        INTRODUZA USERNAME        |");
        System.out.print("|         ");
        String novoUsername = myinputs.Ler.umaString();

        System.out.println("|                                  |");
        System.out.println("|        INTRODUZA PASSWORD        |");
        System.out.print("|         ");
        String novaPassword = myinputs.Ler.umaString();

        switch (opcaoMenu) {
            case 1:
                for (int i = 0; i < arrayCliente.size(); i++) {
                    if (arrayCliente.get(i).getNomeUtilizador().equals(novoUsername)) {
                        System.err.println("Nome de utilizador indisponivel.");
                        menuPrincipal();
                    }
                }
                for (int i = 0; i < arrayGestor.size(); i++) {
                    if (arrayGestor.get(i).getNomeUtilizador().equals(novoUsername)) {
                        System.err.println("Nome de urilizador indisponivel.");
                        menuPrincipal();
                    }
                }
                classeCliente = new Cliente(novoUsername, novaPassword);
                arrayCliente.add(classeCliente);
                break;
            case 2:
                for (int i = 0; i < arrayCliente.size(); i++) {
                    if (arrayCliente.get(i).getNomeUtilizador().equals(novoUsername)) {
                        System.err.println("Nome de utilizador indisponivel.");
                        menuPrincipal();
                    }
                }
                for (int i = 0; i < arrayGestor.size(); i++) {
                    if (arrayGestor.get(i).getNomeUtilizador().equals(novoUsername)) {
                        System.err.println("Nome de urilizador indisponivel.");
                        menuPrincipal();
                    }
                }
                classeGestor = new Gestor(novoUsername, novaPassword);
                arrayGestor.add(classeGestor);
                break;
        }

            System.out.println("+----------------------------------+");
        menuPrincipal();

    }

    // ************************ Cliente ************************
    public static void menuCliente() throws Exception {
        System.out.println("+------------- Cliente ------------+");
        System.out.println("|                                  |");
        System.out.println("|     SALDO:" + arrayCliente.get(indiceUtilizadorAtualArraylist).conta.getSaldo() );
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
                if (arrayProduto.size() == 0) {
                    System.out.println("Ainda não existem produtos.");
                    menuCliente();
                } else {
                    menuEncomendarProdutos();
                }
                break;
            case 2:
                menuConsultarMovimentos();
                break;
            case 3:
                menuCarregarConta();
                break;
            case 0:
                //menuPrincipal(); NAO ELIMINAR. VERSAO FINAL!!!
                menuGestor(); // ELIMINAR NO FIM DO PROJ
                break;
        }
    }

    public static void menuEncomendarProdutos() throws Exception {
        System.out.println("+--------------Cliente-------------+");
        System.out.println("+-------------PRODUTOS-------------+");
        System.out.println("|                                  |");
        System.out.println("|      SALDO: " + arrayCliente.get(indiceUtilizadorAtualArraylist).conta.getSaldo() );
        System.out.println("|                                  |");
        
        for (int i = 0; i < arrayProduto.size(); i++) {
            System.out.println("|  " + (i+1) + ". " + arrayProduto.get(i).getNome());
        }
        System.out.println("|      0 - RETROCEDER              |");
        System.out.println("|                                  |");
        System.out.print("|  Opção: ");
        
        opcaoMenu = myinputs.Ler.umInt();
        
        switch (opcaoMenu) {
            default :
                System.out.println("|                                  |");
                System.out.println("|      Quanto(s) quer comprar?     |");
                System.out.println("|");
                System.out.println("|  Quantidade: ");
                
                int quantidade = myinputs.Ler.umInt();
                
                System.out.println(indiceUtilizadorAtualArraylist);
                
                String nomeProduto = arrayProduto.get(opcaoMenu-1).getNome();
                
                String quantidadeEmString = Integer.toString(quantidade);
                
                arrayCliente.get(indiceUtilizadorAtualArraylist).encomendar(nomeProduto,quantidadeEmString);
                
            case 0:
                menuCliente();
                break;
        }
    }

    public static void menuConsultarMovimentos() throws Exception {
        System.out.println("+--------------MOVIMENTOS-------------+");
        System.out.println("|                                     |");
        System.out.println("|        SALDO: "  + arrayCliente.get(indiceUtilizadorAtualArraylist).conta.getSaldo() );
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
    
    public static void menuCarregarConta() {
        System.out.println("+--------------Cliente-------------+");
        System.out.println("+----------Carregar conta----------+");
        System.out.println("|                                  |");
        System.out.println("|QUANTIA COM QUE PRETENDE CARREGAR?|");
        System.out.println("|                                  |");
        System.out.print("|  Quantia: ");
        double quantia = myinputs.Ler.umDouble();
        
        arrayCliente.get(indiceUtilizadorAtualArraylist).incSaldoPedido(quantia);
        
        System.out.println("|                                  |");
        System.out.println("|   Só tem de esperar até que um   |");
        System.out.println("|     aceite o seu carregamento.   |");
    }

    // ************************ Gestor *********************************
    public static void menuGestor() throws Exception {
        System.out.println("+----------------GESTOR----------------+");
        System.out.println("|                                      |");
        System.out.println("|     SALDO: /*GETSALDO*/              |");
        System.out.println("|                                      |");
        System.out.println("|     1. EDITAR                        |");
        System.out.println("|     2. CONSULTAR MOVIMENTOS          |");
        System.out.println("|     3. COMPRAR RECURSOS AO FORNECEDOR|");
        System.out.println("|     4. CONSULTAR PEDIDOS DE CLIENTES |");
        System.out.println("|     5. CONSULTAR PEDIDOS DE          |");
        System.out.println("|        CARREGAMENTO DE CONTA         |");
        System.out.println("|     6. GUARDAR NA BASE DE DADOS      |");
        System.out.println("|     7. ALTERAR ACESSO A UM OU VARIOS |");
        System.out.println("|        GESTOR(ES)                    |");
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
                if (arrayRecurso.size() == 0) menuGestor();
                fazerPedidoFornecedor();
                break;
            case 4:
                consultarPedidoCliente();
                break;
            case 5:
                consultarPedidoCarregamento();
                break;
            case 6:
                System.out.println("| Deseja guardar todas as alterações feitas? |");
                System.out.println("|                   1) Sim                   |");
                System.out.println("|                   2) Não                   |");
                System.out.println("|                                            |");
                System.out.print("| Opção: ");
                opcaoMenu = myinputs.Ler.umInt();
                switch(opcaoMenu)
                {
                    case 1:
                        escrita();
                        menuGestor();
                        break;
                    case 2:
                        System.out.println("As alterações não foram guardadas");
                        menuGestor();
                        break;
                    default:
                        System.err.println("OPÇÃO ERRADA");
                        menuGestor();
                        break;
                }
                break;
            case 7: 
                mudarAcesso();
                break;
                
            case 0:
                menuPrincipal();
                break;
        }
    }

    public static void menuEditar() throws Exception {
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
    public static void editarProdutos() throws Exception {
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

        switch (opcaoMenu) {
            case 1:
                editarProdutoExistente();
                break;
            case 2:
                AdicionarProdutos();
                editarProdutos();
                break;
            case 3:
                RemoverProdutos();
                break;
            case 0:
                menuEditar();
                break;
        }
    }

    public static void editarProdutoExistente() throws Exception {

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
                System.out.println(i + 1 + "." + arrayProduto.get(i).getNome());
            }
        }
        System.out.println("| QUAL O PRODUTO QUE PRETENDE EDITAR? |");
        int produto = myinputs.Ler.umInt();

        System.out.println("|                                     |");
        System.out.println("|       O QUE PRETENDE EDITAR?        |");
        System.out.println("|                                     |");
        System.out.println("|   1. NOME                           |");
        System.out.println("|   2. QUANTIDADE DE ENCOMENDAS       |");
        System.out.println("|   3. QUANTIDADE DE ENCOMENDAS TOTAL |");
        System.out.println("|   4. RECURSOS NECESSARIOS PARA A    |");
        System.out.println("|      SUA PRODUÇÃO                   |");
        System.out.println("|   0. VOLTAR                         |");
        System.out.println("|                                     |");
        System.out.print("|  Opção: ");
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
                    System.out.println("INTRODUZA O NOME DO " + (i + 1) + "º RECURSO:");
                }
                arrayProduto.get(produto - 1).setStringArray(string);
                break;
            case 0:
                editarProdutos();
        }
    }

    public static void AdicionarProdutos() throws Exception {
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|           ADICIONAR PRODUTO         |");
        System.out.println("|                                     |");
        System.out.println("| INSIRA O NOME DO PRODUTO A ADICIONAR|");
        System.out.println("|                                     |");
        System.out.print("|  Nome: ");

        String NomeAdicionarProduto = myinputs.Ler.umaString();
        
        System.out.println("|                                     |");
        System.out.println("|    QUANTIADE EXISTENTE EM STOCK     |");
        System.out.println("|             CASO TENHA              |");
        System.out.println("|                                     |");
        System.out.print("| Quantidade: ");

        double adicionarProdutoStock = myinputs.Ler.umDouble();
        
        System.out.println("|                                     |");
        System.out.println("|     INSIRA QUANTOS RECURSOS SÃO     |");
        System.out.println("|              NECESSARIOS            |");
        System.out.println("|                                     |");
        System.out.print("|  Nuemero de recuros: ");
        int recursosNecessarios = myinputs.Ler.umInt();
        String[] stringRecursosNecessarios = new String[recursosNecessarios];
        for (int i = 0; i < stringRecursosNecessarios.length; i++) {
            System.out.println("|                                     |");
            System.out.println("| INTRODUZA O NOME DO " + (i + 1) + "º RECURSO:     |");
            System.out.print("|  Nome recurso: ");
            String nomeRecurso = myinputs.Ler.umaString();
            stringRecursosNecessarios[i] = nomeRecurso;

          
            boolean naoExiste = true;
            for (int j = 0; j < arrayRecurso.size(); j++) {
                if (arrayRecurso.get(j).getNome().equals(nomeRecurso)) {
                    naoExiste = false;
                }
            }
            if (naoExiste) {
                boolean opcaoValida;
                do {
                    opcaoValida = true;
                    System.out.println("|                                     |");
                    System.out.println("|      INSIRA O PREÇO DO PRODUTO      |");
                    System.out.println("|   O recurso introduzido ainda não   |");
                    System.out.println("| exite. Pretende adiciona-lo agora?  |");
                    System.out.println("|  1. Sim                             |");
                    System.out.println("|  2. Não                             |");
                    System.out.println("|                                     |");
                    System.out.print("|  Opção: ");
                    opcaoMenu = myinputs.Ler.umInt();
                    if (opcaoMenu == 1) {
                        adicionarRecursos();
                        opcaoValida = false;
                    }
                    if (opcaoMenu == 2) {
                        opcaoValida = false;
                    }
                } while (opcaoValida);
            }

        }
        System.out.println("|                                     |");
        System.out.println("|      INSIRA O PREÇO DO PRODUTO      |");
        System.out.println("|                                     |");
        System.out.println("|  Proço: |");
        double preco = myinputs.Ler.umDouble();

        classeProduto = new Produto(NomeAdicionarProduto, adicionarProdutoStock, stringRecursosNecessarios, preco);

        arrayProduto.add(classeProduto);
    }

    public static void RemoverProdutos() throws Exception {
        System.out.println("+-------------------------------------+");
        System.out.println("                                      ");
        System.out.println("           REMOVER PRODUTO            ");
        System.out.println("                                      ");
        // Dá print a todos os produtos existentes
        if (arrayProduto.size() == 0) {
            System.out.println("Não existem produtos.");
            editarRecursos();
        } else {
            for (int i = 0; i < arrayProduto.size(); i++) {
                System.out.println((i+1) + "." + arrayProduto.get(i).getNome());
            }
        }
        System.out.println("                                      ");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Remover: ");

        opcaoMenu = myinputs.Ler.umInt();

        arrayProduto.remove(opcaoMenu-1);
        
        editarRecursos();
    }

    // *********************************************** Recursos ***************************************
    public static void editarRecursos() throws Exception {
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|            EDITAR RECURSOS          |");
        System.out.println("|                                     |");
        System.out.println("|        O QUE PRETENDE EDITAR?       |");
        System.out.println("|                                     |");
        System.out.println("|        1. EDITAR RECURSO EXISTENTE  |");
        System.out.println("|        2. ADICIONAR RECURSO         |");
        System.out.println("|        3. REMOVER RECURSO           |");
        System.out.println("|        0. RETROCEDER                |");
        System.out.println("|                                     |");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Opção: ");

        opcaoMenu = myinputs.Ler.umInt();

        switch (opcaoMenu) {
            case 1:
                System.out.println("+-------------------------------------+");
                editarRecursoExistente();
                System.out.println("+-------------------------------------+");
                editarRecursos();
                break;
            case 2:
                System.out.println("+-------------------------------------+");
                adicionarRecursos();
                System.out.println("+-------------------------------------+");
                editarRecursos();
                break;
            case 3:
                removerRecursos();
                break;
            case 0:
                menuEditar();
                break;
        }
    }

    public static void editarRecursoExistente() throws Exception {

        System.out.println("|                                     |");
        System.out.println("|      EDITAR RECURSOS EXISTENTE      |");
        System.out.println("|                                     |");

        // Dá print a todos os produtos existentes
        if (arrayRecurso.size() == 0) {
            System.out.println("|        Não existem recursos         |");
            editarRecursos();
        } else {
            for (int i = 0; i < arrayRecurso.size(); i++) {
                System.out.println(i + 1 + "." + arrayRecurso.get(i).getNome());
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
                System.out.println("|         INSIRA O NOVO CUSTO         |");
                arrayRecurso.get(recurso - 1).setCusto(myinputs.Ler.umDouble());
                break;
            case 0:
                editarRecursos();
        }

    }

    public static void adicionarRecursos() throws Exception {
        System.out.println("|                                     |");
        System.out.println("|           ADICIONAR RECURSO         |");
        System.out.println("|                                     |");
        System.out.println("| INSIRA O NOME DO RECURSO A ADICIONAR|");
        System.out.println("|                                     |");
        System.out.print("|  Nome: ");

        String NomeAdicionarRecurso = myinputs.Ler.umaString();

        System.out.println("|    QUANTIADE EXISTENTE EM STOCK     |");
        System.out.println("|             CASO TENHA              |");
        System.out.println("|                                     |");
        System.out.print("| Quantidade: ");
        
        double adicionarRecursoStock = myinputs.Ler.umDouble();

        System.out.println("| Insira o custo do recurso           |");
        System.out.println("|                                     |");
        System.out.print("|  Custo: ");
        
        double custo = myinputs.Ler.umDouble();

        classeRecurso = new Recurso(NomeAdicionarRecurso, adicionarRecursoStock, custo);

        arrayRecurso.add(classeRecurso);
    }
    
    public static void removerRecursos() throws Exception {
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|          REMOVER RECURSO            |");
        System.out.println("|                                     |");
        // Dá print a todos os recursos existentes
        if (arrayRecurso.size() == 0) {
            System.out.println("|        Não existem recursos         |");
            editarRecursos();
        } else {
            for (int i = 0; i < arrayRecurso.size(); i++) {
                System.out.println("|  " + (i+1) + "." + arrayRecurso.get(i).getNome());
            }
        }
        System.out.println("|                                     |");
        System.out.print("|  Remover: ");

        opcaoMenu = myinputs.Ler.umInt();

        arrayRecurso.remove(opcaoMenu-1);
        
        editarRecursos();
    }
    

    public static void menuConsultarMovimentosGestor() throws Exception {
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

    public static void fazerPedidoFornecedor() throws Exception {
        int recursoEncomendar = 1;
        do {
            System.out.println("+-------------------------------------+");
            System.out.println("                                      ");
            System.out.println("           ENCOMENDAR RECURSO         ");
            System.out.println("                                      ");
            System.out.println("QUAL O RECURSO QUE PRETENDE ENCOMENDAR?");
            System.out.println("                                      ");

            for (int i = 0; i < arrayRecurso.size(); i++) {
                System.out.println("           " + (i+1) + " " + arrayRecurso.get(i).getNome());

            }
            System.out.println("           0. RETROCEDER              ");
            System.out.println("                                      ");
            System.out.print("  Opção: ");

            recursoEncomendar = myinputs.Ler.umInt();
            
            if(recursoEncomendar == 0) menuGestor();
        } while (recursoEncomendar < 0 || (arrayRecurso.size() + 1) < recursoEncomendar);

        System.out.println("|                                     |");
        System.out.println("|        INSIRA A QUANTIDADE DE       |");
        System.out.println("|         " + arrayRecurso.get(recursoEncomendar - 1).getNome() + " A ENCOMENDAR        |");
        System.out.println("|                                     |");
        System.out.println("|        PREÇO UNIDADE: " + arrayRecurso.get(recursoEncomendar - 1).getCusto());
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Quantidade: ");
        
        double quantidade = myinputs.Ler.umDouble();
        
        Conta conta = new Conta("JOAQUIM", 2000);
        
        if ((conta.getSaldo() - arrayRecurso.get(opcaoMenu - 1).getCusto() * quantidade) > 0) {
            System.out.println("COMPRA EFETUADA COM SUCESSO");

            //arrayGestor.get(0).conta.decSaldo(arrayRecurso.get(opcaoMenu - 1).getCusto() * quantidade);
            //arrayRecurso.get(opcaoMenu - 1).incQuantidadeStock(quantidade);

            menuGestor();
        } else{
            System.out.println("SALDO INSUFICIENTE");
            fazerPedidoFornecedor();
        }
    }

    public static void consultarPedidoCliente() throws Exception {
        System.out.println("+-------------------------------------+");
        System.out.println("                                      ");
        System.out.println("           PEDIDOS CLIENTE            ");
        System.out.println("                                      ");
        System.out.println("           BOLOS: ");
        /* + getMetodoEncomendaBolo */
        System.out.println("                                      ");
        System.out.println("           IOGURTES: ");
        /* + getMetodoEncomendaIgurte */
        System.out.println("                                      ");
        System.out.println("           SUMOS: ");
        /* + getMetodoEncomedaSumo */
        System.out.println("                                      ");
        System.out.println("           1. PRODUZIR ENCOMENDAS     ");
        System.out.println("                                      ");
        System.out.println("           0. RETROCEDER              ");
        System.out.println("                                      ");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Opção: ");

        opcaoMenu = myinputs.Ler.umInt();

        switch (opcaoMenu) {
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
    
    public static void consultarPedidoCarregamento() {
        
    }

    // ********************** Mudar Acesso a um (ou vários) Gestor(es) ********************** //
    public static void mudarAcesso() throws Exception {
//        System.out.println("+---------------MUDAR ACESSO---------------+");
//        System.out.println("|                                          |");
//        System.out.println("| Deseja mudar o acesso de que utilizador: |");
//        System.out.println("|                                          |");
//        //
//        try {
//            //conta cada linha na base de dados
//            FileInputStream fis_count = new FileInputStream("data_base.txt");
//            DataInputStream in_count = new DataInputStream(fis_count);
//            BufferedReader br_count = new BufferedReader(new InputStreamReader(in_count));
//            String strLine_count;
//            int i = 0;
//            while ((strLine_count = br_count.readLine()) != null) {
//                i = i + 1;
//            }
//            in_count.close();
//
//            //dá print de cada linha na base de dados
//            FileInputStream fis = new FileInputStream("data_base.txt");
//            DataInputStream in = new DataInputStream(fis);
//            BufferedReader br = new BufferedReader(new InputStreamReader(in));
//            String[] list = new String[i];
//            ArrayList gList = new ArrayList();
//            String strLine;
//            int ii = 0;
//            int iii = 1;
//            while ((strLine = br.readLine()) != null) {
//                list[ii] = strLine;
//                if (list[ii].equals("Acesso: Negado") || list[ii].equals("Acesso: Permitido")) {
//                    System.out.println("| " + iii + ": " + list[(ii - 2)]);
//                    gList.add(list[(ii - 2)]);
//                    iii++;
//                }
//                ii++;
//            }
//            in.close();
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
//        System.out.println("|                                          |");
//        System.out.print("| Opção: ");
//        int op = myinputs.Ler.umInt();
//        //   
//       ArrayList<Gestor> ge = new ArrayList<Gestor>();
//       
//       try {
//           // Lê as autorizações de cada utilizador
//           FileInputStream fis_g = new FileInputStream("gestor.dat");
//            ObjectInputStream is_g = new ObjectInputStream(fis_g);
//            ge = (ArrayList) is_g.readObject();
//            is_g.close();       
//        }
//       catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
//       for (int i = 0; i<= ge.size(); i++)  {   // Conta cada linha e permite ou nega acesso às contas que fizeram pedido para Gestor
//           arrayGestor.add(ge.get(i));
//               if (i!=0)   {
//                   arrayGestor.get(i).set(i, false);
//               }
//           else {
//               arrayGestor.get(i).set(i, true);
//            }
//       }
    }
    // ********************** Mudar Acesso a um (ou vários) Gestor(es) ********************** //
    
    public static void escrita() throws Exception {
        try {
            File f_p = new File("produto.dat");
            FileOutputStream fos_p = new FileOutputStream(f_p);
            ObjectOutputStream os_p = new ObjectOutputStream(fos_p);
            os_p.writeObject(arrayProduto);
            os_p.flush();
            os_p.close();

            File f_r = new File("recurso.dat");
            FileOutputStream fos_r = new FileOutputStream(f_r);
            ObjectOutputStream os_r = new ObjectOutputStream(fos_r);
            os_r.writeObject(arrayRecurso);
            os_r.flush();
            os_r.close();

            File f_c = new File("cliente.dat");
            FileOutputStream fos_c = new FileOutputStream(f_c);
            ObjectOutputStream os_c = new ObjectOutputStream(fos_c);
            os_c.writeObject(arrayCliente);
            os_c.flush();
            os_c.close();

            File f_g = new File("gestor.dat");
            FileOutputStream fos_g = new FileOutputStream(f_g);
            ObjectOutputStream os_g = new ObjectOutputStream(fos_g);
            os_g.writeObject(arrayGestor);
            os_g.flush();
            os_g.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        
        System.out.println("Alterações guardadas com sucesso");

    }
    // ********************** Transferir Dados ********************** //
    public static void leitura() throws Exception
    {
        try {                       
            FileInputStream fis_p = new FileInputStream("produto.dat");
            ObjectInputStream is_p = new ObjectInputStream(fis_p);
            arrayProduto = (ArrayList) is_p.readObject();
            is_p.close();

            FileInputStream fis_r = new FileInputStream("recurso.dat");
            ObjectInputStream is_r = new ObjectInputStream(fis_r);
            arrayRecurso = (ArrayList) is_p.readObject();
            is_r.close();

            FileInputStream fis_c = new FileInputStream("cliente.dat");
            ObjectInputStream is_c = new ObjectInputStream(fis_c);
            arrayCliente = (ArrayList) is_c.readObject();
            is_c.close();

            FileInputStream fis_g = new FileInputStream("gestor.dat");
            ObjectInputStream is_g = new ObjectInputStream(fis_g);
            arrayGestor = (ArrayList) is_g.readObject();
            is_g.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
// ********************** Transferir Dados ********************** //  
    public static String getHash(byte[] bytes, String alg) {
        String hash = "";
        try {
            MessageDigest message = MessageDigest.getInstance(alg);
            message.update(bytes);
            byte[] dBytes = message.digest();
            hash = DatatypeConverter.printHexBinary(dBytes).toLowerCase();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return hash;
    }

    public static void main(String[] args) throws IOException, Exception {
        leitura();
        classeGestor = new Gestor("GestorPrincipal", "gestorprincipal", true);
        arrayGestor.add(classeGestor);
        menuPrincipal();

    }

}
