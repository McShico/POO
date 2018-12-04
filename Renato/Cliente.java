package poo.pkgfinal;

public class Cliente extends Utilizador {
    
    Conta conta;
    
    public Cliente(String nome, String morada, String email, String password) {
        super.setNome(nome);
        super.setMorada(morada);
        super.setEmail(email);
        super.setPassword(password);
        conta = new Conta(super.getId(), super.getNome());
    }
    
    public void comprar(int decValor) {
        conta.decSaldo(decValor);
    }
    
    public void carregar(int incValor) {
        conta.incSaldo(incValor);
    }
    
    public String visualizar() {
        return "ID de utilizador: " + super.getId() + ", Nome de utilizador: " + super.getNome() + ", Morada: " + super.getMorada() + ", Email: " + super.getEmail() + ", ID de conta: " + conta.getId() + ", Saldo: " + conta.getSaldo();
    }
}
