package projfinalpoo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.exit;
import java.security.MessageDigest;
import java.util.ArrayList;
import javax.xml.bind.DatatypeConverter;

public class Projfinalpoo {
    
    //Temos 4 public static ArrayLists, uma para cada construtor que necessita de guardar cada um dos seu objetos nos ficheiros binários (.dat)
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

    //Este inteiro é usado para todas as opções de cada menu
    public static int opcaoMenu;

    // ********************** Login ****************************
    public static void menuPrincipal() throws Exception {
        //Este é o menu principal onde o utilizador pode escolher entre 3 opções:
            //->Efetuar um LogIn com uma conta já existente;
            //->Criar uma nova conta;
            //->Ou sair do programa;
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
                System.out.println("           Opção inválida!          ");
                menuPrincipal();
                break;
            case 0:
                System.out.println("");
                System.out.println("********** Até uma próxima *********");
                //Antes de o programa fechar vai guardar toda a informação que foi sendo armazenada nas public static ArrayLists através destas funções
                escritaProduto();
                escritaRecurso();
                escritaCliente();
                escritaGestor();
                //Para evitar qualquer erro, o programa efetua um exit(0) de modo a fechar o programa defenitivamente quando esta opção é selecionada
                exit(0);
                break;
        }
    }

    public static void menuLogin() throws Exception {
        //Este é o menu onde o utilizador pode efetuar um LogIn com uma conta já existente
        //Antes de poder introduzir o seu username e a sua password, o utilizador tem de indicar que tipo de conta é que pretende carregar
        //Este pedido é feito de modo a que seja verificada de emediato a ArrayList que contem os Clientes ou os Gestores
        System.out.println("+-------------- LOGIN -------------+");
        System.out.println("|                                  |");
        System.out.println("|    INTRODUZA O TIPO DE CONTA     |");
        System.out.println("|                                  |");
        System.out.println("|          1 - Cliente             |");
        System.out.println("|          2 - Gestor              |");
        System.out.print("|  Opção: ");

        opcaoMenu = myinputs.Ler.umInt();

        System.out.println("|                                  |");
        System.out.println("|      INSIRA 0 PARA CANCELAR      |");
        System.out.println("|                                  |");
        System.out.println("|        INTRODUZA USERNAME        |");
        System.out.print("|           ");

        String username = myinputs.Ler.umaString();

        //Caso o utilizador escolha cancelar o seu LogIn é levado novamente para o menu principal
        
        if (username.equals("0")) menuPrincipal();

        System.out.println("|                                  |");
        System.out.println("|         INTRODUZA PASSWORD       |");
        System.out.print("|           ");

        String password = myinputs.Ler.umaString();
        
        if (password.equals("0")) menuPrincipal();
        
        //Nesta função é calculado o hash da password 
        password = setHash(password.getBytes(), "SHA-256");

        switch (opcaoMenu) {
            case 1:
                //Caso não haja nenhum objeto dentro da arrayCliente (ou seja, nenhum cliente registado) o programa avisa o utilizador de tal
                if (arrayCliente.isEmpty()) {
                    System.err.println(" Ainda não existem contas de cliente");
                } else {
                //Caso haja pelo menos um objeto dentro da arrayCliente o programa irá vericar se o username e a password existem na mesma posicção da ArrayList
                //Se sim, o utilizador pode seguir para o menu dos clientes
                //Se não, o programa volta para o menu principal
                    for (int i = 0; i < arrayCliente.size(); i++) {
                        if (arrayCliente.get(i).getNomeUtilizador().equals(username) && arrayCliente.get(i).getPassword().equals(password)) {
                            indiceUtilizadorAtualArraylist = i;
                            menuCliente();
                        }
                    }
                    System.err.println("  Utilizador ou password errado(s)  ");
                }
                break;
            case 2:
                //No ficheiro binário gestor.dat exite um objeto predefindo que corresponde a uma conta que o programa assume como a conta do gestor principal
                //Essa conta encontra-se na primeira posição da ArrayList e é a que tem mais autoridade entre todas as outras contas de gestores (mais informação nos comentários da função menuGestorContaPrincipal())
                //Daí o programa fazer uma vereficação especial para esta conta
                if (arrayGestor.get(0).getNomeUtilizador().equals(username) && arrayGestor.get(0).getPassword().equals(password) && arrayGestor.get(0).getAcesso()) {
                    indiceUtilizadorAtualArraylist = 0;
                    menuGestorContaPrincipal();
                }
                //Caso o programa verifique que a conta não é a do gestor principal ele começa a verificar a ArrayList ineteira da mesma forma que verificou para a arrayCliente
                for (int i = 1; i < arrayGestor.size(); i++) {
                    if (arrayGestor.get(i).getNomeUtilizador().equals(username) && arrayGestor.get(i).getPassword().equals(password) && arrayGestor.get(i).getAcesso()) {
                        indiceUtilizadorAtualArraylist = i;
                        menuGestor();
                    }
                }
                //Se a verificação falhar, o programa afirma que o username e/ou a password estão incorretos
                System.err.println("  Utilizador ou password errado(s)  ");
                System.err.println("      ou ainda não tem acesso.      ");

                break;
            default:
                System.err.println("           Opção inválida!          ");
                break;
        }
        menuPrincipal();
    }

    public static void menuRegistar() throws Exception {
        //Este é o menu de registo onde o utilizador pode criar uma conta
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
        System.out.println("|      INSIRA 0 PARA CANCELAR      |");
        System.out.println("|                                  |");
        System.out.println("|        INTRODUZA USERNAME        |");
        System.out.print("|          ");
        String novoUsername = myinputs.Ler.umaString();
        
        //Caso o utilizador escolha cancelar o seu registo é levado novamente para o menu principal
        
        if (novoUsername.equals("0")) menuPrincipal();

        System.out.println("|                                  |");
        System.out.println("|        INTRODUZA PASSWORD        |");
        System.out.print("|          ");
        String novaPassword = myinputs.Ler.umaString();
        
        if (novaPassword.equals("0")) menuPrincipal();
        
        //Nesta função é calculado o hash da password
        novaPassword = setHash(novaPassword.getBytes(), "SHA-256");
        
        switch (opcaoMenu) {
            
            //Tanto no primeiro como no segundo caso, o programa irá verificar se o username existe em ambas as ArrayLists de contas (arrayCliente e arrayGestor)
            //Caso o username já exista, o programa afirma que tal está indisponível e manda o utilizador para o menu principal
            //Caso não seja introduzido um username, o programa afirma que o tal não pode ser feito e manda este para o inicio do menu de registar
            case 1:
                for (int i = 0; i < arrayCliente.size(); i++) {
                    if (arrayCliente.get(i).getNomeUtilizador().equals(novoUsername)) {
                        System.err.println("  Nome de utilizador indisponivel!");
                        System.out.println("+----------------------------------+");
                        menuPrincipal();
                    }
                }
                for (int i = 0; i < arrayGestor.size(); i++) {
                    if (arrayGestor.get(i).getNomeUtilizador().equals(novoUsername)) {
                        System.err.println("  Nome de utilizador indisponivel!");
                        System.out.println("+----------------------------------+");
                        menuPrincipal();
                    }
                }
                
                if (novoUsername.equals("")) {
                    System.err.println("  O USERNAME NÃO PODE ESTAR VAZIO");
                    menuRegistar();
                }
                
                classeCliente = new Cliente(novoUsername, novaPassword);
                arrayCliente.add(classeCliente);
                menuPrincipal();
                break;
            case 2:
                for (int i = 0; i < arrayCliente.size(); i++) {
                    if (arrayCliente.get(i).getNomeUtilizador().equals(novoUsername)) {
                        System.err.println("  Nome de utilizador indisponivel!");
                        System.out.println("+----------------------------------+");
                        menuPrincipal();
                    }
                }
                for (int i = 0; i < arrayGestor.size(); i++) {
                    if (arrayGestor.get(i).getNomeUtilizador().equals(novoUsername)) {
                        System.err.println("  Nome de utilizador indisponivel!");
                        System.out.println("+----------------------------------+");
                        menuPrincipal();
                    }
                }
                
                if (novaPassword.equals("")) {
                    System.err.println("  O USERNAME NÃO PODE ESTAR VAZIO");
                    menuRegistar();
                }
                
                classeGestor = new Gestor(novoUsername, novaPassword);
                arrayGestor.add(classeGestor);
                menuPrincipal();
                break;
            default:
                System.err.println("           Opção inválida!          ");
                System.out.println("+----------------------------------+");
                menuPrincipal();
                break;
        }
    }

    // ************************ Cliente ************************
    public static void menuCliente() throws Exception {
        //Este é o menu do cliente
        //Neste menu, o utilizador pode:
            //-> Encomendar produtos
            //-> Carregar a sua conta
            //-> Eleminar a sua conta
            //-> Terminar a sessão
        System.out.println("+------------- Cliente ------------+");
        System.out.println("|                                  |");
        //No sout abaixo podemos ver que o programa vai buscar o saldo disponível do cliente
        System.out.println("|     SALDO: " + arrayCliente.get(indiceUtilizadorAtualArraylist).conta.getSaldo());
        System.out.println("|                                  |");
        System.out.println("|     1. ENCOMENDAR PRODUTOS       |");
        System.out.println("|     2. CARREGAR CONTA            |");
        System.out.println("|     3. ELIMINAR CONTA            |");
        System.out.println("|     0. TERMINAR SESSÃO           |");
        System.out.println("|                                  |");
        System.out.println("+----------------------------------+");
        System.out.println();
        System.out.print("Opção: ");

        opcaoMenu = myinputs.Ler.umInt();

        switch (opcaoMenu) {
            case 1:
                if (arrayProduto.isEmpty()) {
                    System.out.println("|    Ainda não existem produtos!   |");
                    menuCliente();
                } else {
                    menuEncomendarProdutos();
                }
                break;
            case 2:
                menuCarregarConta();
                break;
            case 3:
                eliminarConta();
                break;
            default:
                System.err.println("           Opção inválida!          ");
                menuCliente();
                break;
            case 0:
                menuPrincipal();
                break;
        }
    }

    public static void menuEncomendarProdutos() throws Exception {
        //Neste menu, o utilizador pode emcomendar todo o tipo de produtos disponíveis na ArrayList dos produtos
        System.out.println("+--------------Cliente-------------+");
        System.out.println("+-------------PRODUTOS-------------+");
        System.out.println("|                                  |");
        System.out.println("|      SALDO: " + arrayCliente.get(indiceUtilizadorAtualArraylist).conta.getSaldo());
        System.out.println("|                                  |");

        //Neste ciclo for é impresso todos os Produtos existentes na ArrayList
        for (int i = 0; i < arrayProduto.size(); i++) {
            System.out.println("|      " + (i + 1) + ". " + arrayProduto.get(i).getNome());
        }
        System.out.println("|      0 - VOLTAR                  |");
        System.out.println("|                                  |");
        System.out.print("|  Opção: ");

        opcaoMenu = myinputs.Ler.umInt();
        //Consoante a escolha do utilizador ( !=0 ) será perguntado qual a quantidade que se pretende comprar do Produto selecionado
        if ((opcaoMenu) > 0 && (opcaoMenu) < arrayProduto.size() + 1) {
            System.out.println("|                                  |");
            System.out.println("|      Quanto(s) quer comprar?     |");
            System.out.println("|");
            System.out.print("|  Quantidade: ");

            double quantidade = myinputs.Ler.umDouble();
            //Simulação de saldo atual menos a despesa total
            if (arrayCliente.get(indiceUtilizadorAtualArraylist).conta.getSaldo() - (quantidade * arrayProduto.get(opcaoMenu - 1).getPreco()) < 0) {
                System.err.println("|        Saldo insuficiente!       |");
                menuEncomendarProdutos();
            }
            //Se o saldo nao for inferior a 0 é feita a decrementação de saldo com p valor da despesa
            arrayCliente.get(indiceUtilizadorAtualArraylist).conta.decSaldo(quantidade * arrayProduto.get(opcaoMenu - 1).getPreco());

            String nomeProduto = arrayProduto.get(opcaoMenu - 1).getNome();

            String quantidadeEmString = Double.toString(quantidade);
            //Após decrementação do saldo, é feito o envio do pedido para o Gestor
            arrayCliente.get(indiceUtilizadorAtualArraylist).encomendar(nomeProduto, quantidadeEmString);

            menuCliente();
        } else if (opcaoMenu == 0) {
            menuCliente();
        } else {
            System.err.println("           Opção inválida!          ");
            menuCliente();
        }

    }
    //Menu Cliente para efetuar carregamento da conta
    public static void menuCarregarConta() throws Exception {
        System.out.println("+--------------Cliente-------------+");
        System.out.println("+----------Carregar conta----------+");
        System.out.println("|                                  |");
        System.out.println("|QUANTIA COM QUE PRETENDE CARREGAR?|");
        System.out.println("|                                  |");
        System.out.print("|  Quantia: ");
        double quantia = myinputs.Ler.umDouble();
        //Pedido de carregamento é enviado para o Gestor Principal (para aprovação)
        arrayCliente.get(indiceUtilizadorAtualArraylist).incSaldoPedido(quantia);

        System.out.println("|      Carregamento com exito.     |");
        System.out.println("|   Só tem de esperar até que um   |");
        System.out.println("|        o seu carregamento        |");
        System.out.println("|          seja validado.          |");
        //Após quantia inserida, o menu é retrocedido
        menuCliente();
    }
    //Menu de Eliminação de conta, é necessário confirmar a intençao de eliminação
    public static void eliminarConta() throws Exception {

        System.out.println("+----------ELIMINAR conta----------+");
        System.out.println("|                                  |");
        System.out.println("|    TEM A CERTEZA QUE PRETENDE    |");
        System.out.println("|       APAGAR A SUA CONTA?        |");
        System.out.println("|                                  |");
        System.out.println("|       1. SIM                     |");
        System.out.println("|       2. NAO                     |");
        System.out.println("|                                  |");
        System.out.println("+----------------------------------+");
        System.out.println("Opção: ");

        opcaoMenu = myinputs.Ler.umInt();

        switch (opcaoMenu) {
            case 1:
                //eliminação do utilizador atual na posição respetiva da ArrayList
                arrayCliente.remove(indiceUtilizadorAtualArraylist);
                //A sessão é terminada
                menuPrincipal();
                break;
            case 2:
                menuCliente();
                break;
            default:
                System.err.println("           Opção inválida!          ");
                eliminarConta();
                break;
        }
    }

    //MENU DE GESTOR PRINCIPAL
    // ************************ Gestor *********************************
    public static void menuGestorContaPrincipal() throws Exception {
        System.out.println("+----------------GESTOR----------------+");
        System.out.println("|                                      |");
        System.out.println("|     SALDO: " + arrayGestor.get(0).contaGeral.getSaldo());
        System.out.println("|                                      |");
        System.out.println("|     1. EDITAR                        |");
        System.out.println("|     2. COMPRAR RECURSOS AO FORNECEDOR|");
        System.out.println("|     3. CONSULTAR PEDIDOS DE CLIENTES |");
        System.out.println("|     4. CONSULTAR PEDIDOS DE          |");
        System.out.println("|        CARREGAMENTO DE CONTA         |");
        System.out.println("|     5. ALTERAR ACESSO A UM OU VARIOS |");
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
                //Verificação da ArrayList dos Recursos
                if (arrayRecurso.isEmpty()) {
                    System.out.println("|--------------------------------------|");
                    System.out.println("|      Ainda não existem recursos!     |");
                    menuGestorContaPrincipal();
                } else {
                    fazerPedidoFornecedor();
                }
                break;
            case 3:
                consultarPedidoCliente();
                break;
            case 4:
                consultarPedidoCarregamento();
                break;            
            case 5:
                mudarAcesso();
                break;
            default:
                System.err.println("           Opção inválida!          ");
                menuGestorContaPrincipal();
                break;
            case 0:
                menuPrincipal();
                break;
        }
    }

    //MENU DE TODOS OS GESTORES QUE NAO SAO PRINCIPAIS
    public static void menuGestor() throws Exception {
        System.out.println("+----------------GESTOR----------------+");
        System.out.println("|                                      |");
        System.out.println("|     SALDO: " + arrayGestor.get(0).contaGeral.getSaldo());
        System.out.println("|                                      |");
        System.out.println("|     1. EDITAR                        |");
        System.out.println("|     2. COMPRAR RECURSOS AO FORNECEDOR|");
        System.out.println("|     3. CONSULTAR PEDIDOS DE CLIENTES |");
        System.out.println("|     4. CONSULTAR PEDIDOS DE          |");
        System.out.println("|        CARREGAMENTO DE CONTA         |");
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
                //Verificação da ArrayList dos Recursos
                if (arrayRecurso.isEmpty()) {
                    System.out.println("|--------------------------------------|");
                    System.out.println("|      Ainda não existem recursos!     |");
                    if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                        menuGestorContaPrincipal();
                    } else {
                        menuGestor();
                    };
                } else {
                    fazerPedidoFornecedor();
                }
                break;
            case 3:
                consultarPedidoCliente();
                break;
            case 4:
                consultarPedidoCarregamento();
                break;
            default:
                System.err.println("           Opção inválida!          ");
                //Comparação do tipo de conta para ser feito o retrocesso correto do menu
                if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                    menuGestorContaPrincipal();
                } else {
                    menuGestor();
                }
                break;
            case 0:
                menuPrincipal();
                break;
        }
    }

    //MENU DE EDIÇAO DE PRODUTOS E RECURSOS (GESTOR & GESTOR PRINCIPAL)
    public static void menuEditar() throws Exception {
        System.out.println("+---------------EDITAR----------------+");
        System.out.println("|                                     |");
        System.out.println("|        1. PRODUTOS                  |");
        System.out.println("|        2. RECURSOS                  |");
        System.out.println("|        3. VISUALIZAR STOCK          |");
        System.out.println("|                                     |");
        System.out.println("|        0. VOLTAR                    |");
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
            case 3:
                visualizarStock();
                break;
            case 0:
                //Comparação do tipo de conta para ser feito o retrocesso correto do menu
                if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                    menuGestorContaPrincipal();
                } else {
                    menuGestor();
                }
                break;
        }
    }

//MENU GESTOR & GESTOR PRINCIPAL
    //EDITAR PRODUTOS
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
        System.out.println("|        0. VOLTAR                    |");
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

    //Menu que imprime todos os produtos na ArrayList Produtos e pergunta qual aquele que se pretende editar
    public static void editarProdutoExistente() throws Exception {

        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|      EDITAR PRODUTOS EXISTENTE      |");
        System.out.println("|                                     |");

        // Dá print a todos os produtos existentes
        if (arrayProduto.isEmpty()) {
            System.out.println("|        Não existem produtos!        |");
            System.out.println("|                                     |");
            editarProdutos();
        } else {
            for (int i = 0; i < arrayProduto.size(); i++) {
                System.out.println("|     " + i + 1 + "." + arrayProduto.get(i).getNome());
            }
        }
        System.out.println("| QUAL O PRODUTO QUE PRETENDE EDITAR? |");
        int produto = myinputs.Ler.umInt();

        System.out.println("|                                     |");
        System.out.println("|       O QUE PRETENDE EDITAR?        |");
        System.out.println("|                                     |");
        System.out.println("|   1. NOME                           |");
        System.out.println("|   2. RECURSOS NECESSARIOS PARA A    |");
        System.out.println("|      SUA PRODUÇÃO                   |");
        System.out.println("|   0. VOLTAR                         |");
        System.out.println("|                                     |");
        System.out.print("|  Opção: ");
        opcaoMenu = myinputs.Ler.umInt();

        switch (opcaoMenu) {
            case 1:
                //Alteração do nome existente na ArrayList para o novo nome inserido
                System.out.println("|          NOME QUE PRETENDE?         |");
                String nomeintroduzido = myinputs.Ler.umaString();
                arrayProduto.get(produto - 1).setNome(nomeintroduzido);
                break;
            case 2:
                System.out.println("INSIRA QUANTOS RECURSOS SÃO NECESSARIOS:");
                int recursosNecessarios = myinputs.Ler.umInt();
                //Contagem de recursos a ser nomeados através do ciclo for seguinte
                String[] string = new String[recursosNecessarios];
                for (int i = 0; i < recursosNecessarios; i++) {
                    System.out.println("| INTRODUZA O NOME DO " + (i + 1) + "º RECURSO:");
                }
                //Inserção ,do array com os novos recursos respetivos a um produto, dentro do ArrayList Produtos
                arrayProduto.get(produto - 1).setStringArray(string);
                break;
            case 0:
                editarProdutos();
        }
    }
//Menu adicionar Produtos em CONTA GESTOR & GESTOR PRINCIPAL
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
        System.out.println("|    QUANTIDADE EXISTENTE EM STOCK     |");
        System.out.println("|             CASO TENHA              |");
        System.out.println("|                                     |");
        System.out.print("| Quantidade: ");

        double adicionarProdutoStock = myinputs.Ler.umDouble();

        System.out.println("|                                     |");
        System.out.println("|     INSIRA QUANTOS RECURSOS SÃO     |");
        System.out.println("|              NECESSARIOS            |");
        System.out.println("|                                     |");
        System.out.print("|  Numero de recuros: ");
        int recursosNecessarios = myinputs.Ler.umInt();
        //Verificação de numero de recursos introduzidos
        if (recursosNecessarios == 0) {
            System.err.println("        Os produtos têm de ser         ");
            System.err.println("          feitos de recursos!          ");
            menuEditar();
        }
        //Ciclo for para inserção de nomes de recursos do produto novo na ARRAYList Produtos
        String[] stringRecursosNecessarios = new String[recursosNecessarios];
        for (int i = 0; i < stringRecursosNecessarios.length; i++) {
            System.out.println("|                                     |");
            System.out.println("| INTRODUZA O NOME DO " + (i + 1) + "º RECURSO:     |");
            System.out.print("|  Nome recurso: ");
            String nomeRecurso = myinputs.Ler.umaString();
            stringRecursosNecessarios[i] = nomeRecurso;

            boolean naoExiste = true;
            //Verificação de Existencia de nome do recurso inserido na ArrayList Recurso
            for (int j = 0; j < arrayRecurso.size(); j++) {
                if (arrayRecurso.get(j).getNome().equals(nomeRecurso)) {
                    naoExiste = false;
                }
            }
            //Se o recurso nao existir faz o seguinte ciclo "do while" enquanto o boolean OpcaoValida tiver o estado "true"
            if (naoExiste) {
                boolean opcaoValida;
                do {
                    opcaoValida = true;
                    System.out.println("|                                     |");
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
        System.out.print("|  Preço: ");
        double preco = myinputs.Ler.umDouble();
        //Inserçao de todas as inputs do utilizador num construtor de produtos
        classeProduto = new Produto(NomeAdicionarProduto, adicionarProdutoStock, stringRecursosNecessarios, preco);
        //Novo objeto produto adicionado á ArrayList Produto
        arrayProduto.add(classeProduto);
    }
    
//Menu para remover Produtos--------------------------------------
    public static void RemoverProdutos() throws Exception {
        System.out.println("+-------------------------------------+");
        System.out.println("                                      ");
        System.out.println("           REMOVER PRODUTO            ");
        System.out.println("                                      ");
        // Dá print a todos os produtos existentes
        if (arrayProduto.isEmpty()) {
            System.out.println("Não existem produtos.");
            editarRecursos();
        } else {
            for (int i = 0; i < arrayProduto.size(); i++) {
                System.out.println((i + 1) + "." + arrayProduto.get(i).getNome());
            }
        }
        System.out.println("                                      ");
        System.out.println("+-------------------------------------+");
        System.out.println();
        System.out.print("Remover: ");

        opcaoMenu = myinputs.Ler.umInt();
        //Eliminação ,do produto inserido, na ArrayList Produtos
        arrayProduto.remove(opcaoMenu - 1);

        editarRecursos();
    }

    //MENU GESTOR & GESTOR PRINCIPAL EDITAR RECURSOS
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
        System.out.println("|        0. VOLTAR                    |");
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

    //MENU GESTOR & GESTOR PRINCIPAL EDIAR RECURSOS EXISTENTES
    public static void editarRecursoExistente() throws Exception {

        System.out.println("|                                     |");
        System.out.println("|      EDITAR RECURSOS EXISTENTE      |");
        System.out.println("|                                     |");

        // Dá print a todos os produtos existentes
        if (arrayRecurso.isEmpty()) {
            System.out.println("|        Não existem recursos         |");
            editarRecursos();
        } else {
        //Impressão de todos os Recursos Existentes na ArrayList Recursos
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
        System.out.println("|   2. QUANTIDADE EM STOCK             |");
        System.out.println("|   3. CUSTO                          |");
        System.out.println("|   0. VOLTAR                         |");
        System.out.println("|                                     |");

        opcaoMenu = myinputs.Ler.umInt();

        switch (opcaoMenu) {
            case 1:
                System.out.println("|          NOME QUE PRETENDE?         |");
                //Inserção do novo nome introduzido, na posição do ArrayList respetiva ao produto selecionado para editar
                arrayRecurso.get(recurso - 1).setNome(myinputs.Ler.umaString());
                break;
            case 2:
                System.out.println("|       QUANTIDADE DE ENCOMENDAS      |");
                System.out.println("|            QUE PRETENDE?            |");
                double quantidadeEncomedasinserida = myinputs.Ler.umDouble();
                //Inserção da nova quantidade inserida no na posiçao respetiva do ArrayList Recurso
                arrayRecurso.get(recurso - 1).setQuantidadeStock(quantidadeEncomedasinserida);
                break;
            case 3:
                System.out.println("|         INSIRA O NOVO CUSTO         |");
                double novocustoinserido = myinputs.Ler.umDouble();
                //Inserção do novo custo inserido na posição respetiva do ArrayList Recurso
                arrayRecurso.get(recurso - 1).setCusto(novocustoinserido);
                break;
            case 0:
                editarRecursos();
        }

    }

//MENU GESTOR & GESTOR PRINCIPAL
//MENU ADICIONAR RECURSOS
    public static void adicionarRecursos() throws Exception {
        System.out.println("|                                     |");
        System.out.println("|           ADICIONAR RECURSO         |");
        System.out.println("|                                     |");
        System.out.println("| INSIRA O NOME DO RECURSO A ADICIONAR|");
        System.out.println("|                                     |");
        System.out.print("|  Nome: ");

        String NomeAdicionarRecurso = myinputs.Ler.umaString();

        System.out.println("|    QUANTIDADE EXISTENTE EM STOCK    |");
        System.out.println("|             CASO TENHA              |");
        System.out.println("|                                     |");
        System.out.print("| Quantidade: ");

        double adicionarRecursoStock = myinputs.Ler.umDouble();

        System.out.println("| Insira o custo do recurso           |");
        System.out.println("|                                     |");
        System.out.print("|  Custo: ");

        double custo = myinputs.Ler.umDouble();

        //Inserção de inputs do utilizador no Construtor de Recursos
        classeRecurso = new Recurso(NomeAdicionarRecurso, adicionarRecursoStock, custo);

        //Inserção de objeto instaciado na ArrayList Recursos
        arrayRecurso.add(classeRecurso);
    }

//MENU GESTOR & GESTOR PRINCIPAL
//MENU REMOVER RECURSOS   
    public static void removerRecursos() throws Exception {
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|          REMOVER RECURSO            |");
        System.out.println("|                                     |");
        // Dá print a todos os recursos existentes
        if (arrayRecurso.isEmpty()) {
            System.out.println("|        Não existem recursos         |");
            editarRecursos();
        } else {
            for (int i = 0; i < arrayRecurso.size(); i++) {
                System.out.println("|  " + (i + 1) + "." + arrayRecurso.get(i).getNome());
            }
        }
        System.out.println("|                                     |");
        System.out.print("|  Remover: ");

        opcaoMenu = myinputs.Ler.umInt();

        //Eliminação do recurso escolhido pelo utilizador
        arrayRecurso.remove(opcaoMenu - 1);

        editarRecursos();
    }

//MENU GESTOR & GESTOR PRINCIPAL
//MENU VISUALIZAR STOCK    
    public static void visualizarStock() throws Exception {
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|               STOCK                 |");
        
        //Impressão do Nome do Produto e Quantidades existentes em stock através da ArrayList Produtos
        for (int i = 0; i < arrayProduto.size(); i++) {
            System.out.println("|     " + arrayProduto.get(i).getNome() + " - " + arrayProduto.get(i).getQuantidadeStock());
        }
        
        System.out.println("|                                     |");
        System.out.println("|     QUALQUER TECLA PARA VOLTAR      |");
        System.out.println("|                                     |");
        
        String opcao = myinputs.Ler.umaString();
        
        switch (opcao){
            default:
                menuEditar();
                break;
        }
    }

//MENU GESTOR & GESTOR PRINCIPAL
//MENU ENCOMEDAR RECURSOS
    public static void fazerPedidoFornecedor() throws Exception {
        int recursoEncomendar = 1;
        do {
            System.out.println("+-------------------------------------+");
            System.out.println("|                                     |");
            System.out.println("|          ENCOMENDAR RECURSO         |");
            System.out.println("|                                     |");
            System.out.println("|      QUAL O RECURSO QUE PRETENDE    |");
            System.out.println("|              ENCOMENDAR?            |");
            System.out.println("|                                     |");

            //Impressão de todos o Recursos Existentes na ArrayList Recursos
            for (int i = 0; i < arrayRecurso.size(); i++) {
                System.out.println("|        " + (i + 1) + " " + arrayRecurso.get(i).getNome());

            }
            System.out.println("|        0. VOLTAR                    |");
            System.out.println("|                                     |");
            System.out.print("  Opção: ");

            recursoEncomendar = myinputs.Ler.umInt();

            //Percepção do tipo de conta para retrocesso correto do menu
            if (recursoEncomendar == 0) {
                if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                    menuGestorContaPrincipal();
                } else {
                    menuGestor();
                }
            }
        } while (recursoEncomendar < 0 || (arrayRecurso.size() + 1) < recursoEncomendar);

        System.out.println("|                                     |");
        System.out.println("|        INSIRA A QUANTIDADE DE       |");
        System.out.println("|         " + arrayRecurso.get(recursoEncomendar - 1).getNome() + " A ENCOMENDAR"); //Nome do recurso inserido a encomendar
        System.out.println("|                                     |");
        System.out.println("|        PREÇO UNIDADE: " + arrayRecurso.get(recursoEncomendar - 1).getCusto()); //Preço do recurso inserido a encomendar
        System.out.println("|                                     |");
        System.out.print("|  Quantidade: ");

        double quantidade = myinputs.Ler.umDouble();

        //Calculo de Despesa Total através do getPreçoUnidadeArrayList
        double custoDaCompra = arrayRecurso.get(recursoEncomendar - 1).getCusto() * quantidade;
        //Simulação de decrementação de saldo
        if ((arrayGestor.get(0).contaGeral.getSaldo() - custoDaCompra) >= 0) {
            System.out.println("COMPRA EFETUADA COM SUCESSO");
            //Decrementação de saldo menos despesa total
            arrayGestor.get(0).contaGeral.decSaldo(custoDaCompra);
            arrayRecurso.get(recursoEncomendar - 1).incQuantidadeStock(quantidade);

            //Percepção do tipo de conta para retrocesso correto do menu
            if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                menuGestorContaPrincipal();
            } else {
                menuGestor();
            }
        //Se simulação de decrementação for inferior a 0
        } else {
            System.out.println("SALDO INSUFICIENTE");
            fazerPedidoFornecedor();
        }
    }

//MENU GESTOR & GESTOR PRINCIPAL
//MENU CONSULTAR PEDIDOS CLIENTE
    public static void consultarPedidoCliente() throws Exception {
        System.out.println("+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|           PEDIDO CLIENTES           |");
        System.out.println("|                                     |");

        //Impressão de todos os Pedidos de cada Cliente através de um ciclo for e ArrayList
        for (int i = 0; i < arrayCliente.size(); i++) {
            System.out.println("|      " + (i + 1) + ". " + arrayCliente.get(i).getNomeUtilizador());
            for (int j = 0; j < arrayCliente.get(i).getAllaylist().size(); j++) {

                System.out.print("|        " + arrayCliente.get(i).getProdutoEQuantidade(j, 0));
                System.out.print(" - ");
                System.out.print(arrayCliente.get(i).getProdutoEQuantidade(j, 1));
                System.out.println(";");
            }

            System.out.println();
        }
        System.out.println("|                                     |");
        System.out.println("|      0. VOLTAR                      |");
        System.out.println("|                                     |");
        System.out.print("|  Cliente opção: ");

        opcaoMenu = myinputs.Ler.umInt();

        //Percepção de conta para retrocesso correto do menu
        if (opcaoMenu == 0) {
            if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                menuGestorContaPrincipal();
            } else {
                menuGestor();
            }
        //Se a input for inferior a zero ou maior que o tamanho do ArrayList
        } else if (opcaoMenu < 0 || opcaoMenu > arrayCliente.size()) {
            System.out.println("|            Opção inválida!           |");
            System.out.println("|                                      |");
            if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                menuGestorContaPrincipal();
            } else {
                menuGestor();
            }
        }

        System.out.println("|                                     |");

        int indiceCliente = opcaoMenu - 1;

        int indiceProduto;
        boolean verificacao;
        //Impressão dos pedidos respetivos ao cliente inserido
        for (int j = 0; j < arrayCliente.get(indiceCliente).getAllaylist().size(); j++) {
            System.out.print("|      " + (j + 1) + ". " + arrayCliente.get(indiceCliente).getProdutoEQuantidade(j, 0));
            System.out.print(" - ");
            System.out.println(arrayCliente.get(indiceCliente).getProdutoEQuantidade(j, 1));

        }

        System.out.println("|                                     |");
        System.out.println("|      0. VOLTAR                      |");
        System.out.println("|                                     |");
        System.out.print("|  Produto: ");

        indiceProduto = myinputs.Ler.umInt();

        //Percepção de conta para retrocesso correto do menu
        if (indiceProduto == 0) {
            if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                menuGestorContaPrincipal();
            } else {
                menuGestor();
            }
        }
        
        //Verificação de inputs incorretas
        if (indiceProduto < 0 || indiceProduto > arrayCliente.get(indiceCliente).getAllaylist().size()) {
            System.out.println("|           Produto inválido!         |");
            System.out.println("|                                     |");
            if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                menuGestorContaPrincipal();
            } else {
                menuGestor();
            }

        }
        //Decrementação de pedido do produto
        indiceProduto--;

        String nomeProduto = arrayCliente.get(indiceCliente).getProdutoEQuantidade(indiceProduto, 0);

        double precoProduto = 0;

        //Verificação de quantidades em stock de produtos através de ciclo for e ArrayList
        for (int i = 0; i < arrayProduto.size(); i++) {
            if (arrayProduto.get(i).getNome().equals(nomeProduto)) {
                if (Double.parseDouble(arrayCliente.get(indiceCliente).getProdutoEQuantidade(indiceProduto, 1)) > arrayProduto.get(i).getQuantidadeStock()) {
                    System.err.println("|     Não tem stock suficiente para   |");
                    System.err.println("|       efetuar esta confimação.      |");
                    //Percepção do menu a retroceder
                    if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                        menuGestorContaPrincipal();
                    } else {
                        menuGestor();
                    }
                }
                //
                precoProduto = arrayProduto.get(i).getPreco();
                arrayProduto.get(i).decQuantidadeStock(Double.parseDouble(arrayCliente.get(indiceCliente).getProdutoEQuantidade(indiceProduto, 1)));
            }
        }

        //Efetuação de incremenatções de saldo derivado de uma venda/produção/aprovação de pedido
        arrayGestor.get(0).contaGeral.incSaldo(precoProduto * Double.parseDouble(arrayCliente.get(indiceCliente).getProdutoEQuantidade(indiceProduto, 1)));
        arrayCliente.get(indiceCliente).removerProdutoEQuantidade(indiceProduto);
        
        //Percepção de conta a retroceder
        if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
            menuGestorContaPrincipal();
        } else {
            menuGestor();
        }
    }

//MENU  GESTOR & GESTOR PRINCIPAL
//MENU CONSULTAR PEDIDOS DE CARREGAMENTO
    public static void consultarPedidoCarregamento() throws Exception {
        System.out.println("+--------------------------------------+");
        System.out.println("|                                      |");
        System.out.println("|          PEDIDO CARREGAMENTO         |");
        System.out.println("|                                      |");

        //Impressão de todos os pedidos de carregamento respetivos a cada cliente
        for (int i = 0; i < arrayCliente.size(); i++) {
            System.out.println("|      " + (i + 1) + ". " + arrayCliente.get(i).getNomeUtilizador() + " - " + arrayCliente.get(i).getSaldoPedido());
            System.out.println("|                                     |");
        }
        System.out.println("|      0. VOLTAR                      |");

        System.out.print("|  Opção: ");

        opcaoMenu = myinputs.Ler.umInt();

        if (opcaoMenu > 0 && opcaoMenu < arrayCliente.size() + 1) {

        //Verificação de conta a retroceder
        } else if (opcaoMenu == 0) {
            if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                menuGestorContaPrincipal();
            } else {
                menuGestor();
            }
        } else {
            System.out.println("|            Opção inválida!           |");
            System.out.println("|                                      |");
            if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                menuGestorContaPrincipal();
            } else {
                menuGestor();
            }
        }

        //Menu de Validação de Pedidos relativo ao cliente inserido anteriormente
        System.out.println("|                                      |");
        System.out.println("|      PRETENDE VALIDAR O PEDIDO?      |");
        System.out.println("|                                      |");
        System.out.println("|        1. SIM                        |");
        System.out.println("|        2. NAO                        |");
        System.out.println("|                                      |");
        System.out.print("|  Opção: ");

        int validacao = myinputs.Ler.umInt();

        switch (validacao) {
            case 1:
                //Incrementação de saldo a Cliente e Decrementação de Saldo Pedido
                arrayCliente.get(opcaoMenu - 1).conta.incSaldo(arrayCliente.get(opcaoMenu - 1).getSaldoPedido());
                arrayCliente.get(opcaoMenu - 1).decSaldoPedido(arrayCliente.get(opcaoMenu - 1).getSaldoPedido());
                //Percepçao de conta para retrocesso correto do menu
                if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                    menuGestorContaPrincipal();
                } else {
                    menuGestor();
                }
                break;
            case 2:
                consultarPedidoCarregamento();
                break;
            default:
                System.out.println("|            Opção inválida!           |");
                System.out.println("|                                      |");
                //Percepçao de conta para retrocesso correto do menu
                if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                    menuGestorContaPrincipal();
                } else {
                    menuGestor();
                }
                break;
        }
    }


    // ********************** Mudar Acesso a um (ou vários) Gestor(es) ********************** //
    public static void mudarAcesso() throws Exception {
        System.out.println("+---------------MUDAR ACESSO---------------+");
        System.out.println("|                                          |");
        System.out.println("| Deseja mudar o acesso de que utilizador: |");
        System.out.println("|                                          |");

        for (int i = 0; i < arrayGestor.size(); i++) {
            if (arrayGestor.get(i).getAcesso() == false) {
                System.out.println("|     " + (i + 1) + ". " + arrayGestor.get(i).getNomeUtilizador());
            }
        }

        System.out.println("|                                          |");
        System.out.println("|     0. VOLTAR                            |");
        System.out.println("|                                          |");
        System.out.print("| Opção: ");

        opcaoMenu = myinputs.Ler.umInt();

        if (opcaoMenu > 0 && opcaoMenu < arrayGestor.size() + 1) {
            System.out.println("|                                      |");
            System.out.println("|      PRETENDE VALIDAR ESTA CONTA?    |");
            System.out.println("|          " + arrayGestor.get(opcaoMenu - 1).getNomeUtilizador());
            System.out.println("|                                      |");
            System.out.println("|        1. SIM                        |");
            System.out.println("|        2. NAO                        |");
            System.out.println("|                                          |");
            System.out.print("| Opção: ");

            int validacao = myinputs.Ler.umInt();

            switch (validacao) {
                case 1:
                    arrayGestor.get(opcaoMenu - 1).setAcesso(true);
                    if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                        menuGestorContaPrincipal();
                    } else {
                        menuGestor();
                    }
                    break;
                case 2:
                    mudarAcesso();
                    break;
                default:
                    System.out.println("|            Opção inválida!           |");
                    System.out.println("|                                      |");
                    if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                        menuGestorContaPrincipal();
                    } else {
                        menuGestor();
                    }
                    break;
            }
        } else if (opcaoMenu == 0) {
            if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                menuGestorContaPrincipal();
            } else {
                menuGestor();
            }
        } else {
            System.out.println("|            Opção inválida!           |");
            System.out.println("|                                      |");
            if (arrayGestor.get(indiceUtilizadorAtualArraylist).getNomeUtilizador().equals("GestorPrincipal")) {
                menuGestorContaPrincipal();
            } else {
                menuGestor();
            }
        }

    }
    
//MENU  GESTOR & GESTOR PRINCIPAL
    // ********************** Mudar Acesso a um (ou vários) Gestor(es) ********************** //

    //Escrita de Produto da ArrayList Produto em Base de Dados 
    public static void escritaProduto() throws Exception {
        try {
            File f_p = new File("produto.dat");
            FileOutputStream fos_p = new FileOutputStream(f_p);
            ObjectOutputStream os_p = new ObjectOutputStream(fos_p);
            os_p.writeObject(arrayProduto);
            os_p.flush();
            os_p.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    //Escrita de Recurso da ArrayList Recurso em Base de Dados 
    public static void escritaRecurso() throws Exception {
        try {
            File f_r = new File("recurso.dat");
            FileOutputStream fos_r = new FileOutputStream(f_r);
            ObjectOutputStream os_r = new ObjectOutputStream(fos_r);
            os_r.writeObject(arrayRecurso);
            os_r.flush();
            os_r.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    //Escrita de Cliente da ArrayList Cliente em Base de Dados 
    public static void escritaCliente() throws Exception {
        try {
            File f_c = new File("cliente.dat");
            FileOutputStream fos_c = new FileOutputStream(f_c);
            ObjectOutputStream os_c = new ObjectOutputStream(fos_c);
            os_c.writeObject(arrayCliente);
            os_c.flush();
            os_c.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    //Escrita de Gestor da ArrayList Gestor em Base de Dados 
    public static void escritaGestor() throws Exception {
        try {
            File f_g = new File("gestor.dat");
            FileOutputStream fos_g = new FileOutputStream(f_g);
            ObjectOutputStream os_g = new ObjectOutputStream(fos_g);
            os_g.writeObject(arrayGestor);
            os_g.flush();
            os_g.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    // ********************** Transferir Dados ********************** //
    //Leitura das variaveis das  Bases de Dados para as ArrayLists
    public static void leitura() throws Exception {
        try {
            FileInputStream fis_p = new FileInputStream("produto.dat");
            ObjectInputStream is_p = new ObjectInputStream(fis_p);
            arrayProduto = (ArrayList) is_p.readObject();
            is_p.close();

            FileInputStream fis_r = new FileInputStream("recurso.dat");
            ObjectInputStream is_r = new ObjectInputStream(fis_r);
            arrayRecurso = (ArrayList) is_r.readObject();
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

    //Encriptação de palavras passe
    public static String setHash(byte[] bytes, String alg) {
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
        
        //Conta do Gestor Principal:
            //->Username: GestorPrincipal
            //->Password: gestor
            
        //Conta de um Cliente Teste:
            //->Username: ClienteTeste
            //->Password: cliente

        menuPrincipal();

    }

}
