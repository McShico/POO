package projfinalpoo;


public abstract class Utilizador {
    private static int contador = 0;
    private int id = contador++;
    private String morada;
    private String nomeUtilizador;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getNome() {
        return nomeUtilizador;
    }

    public void setNome(String nome) {
        this.nomeUtilizador = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utilizador{" + "id=" + id + ", morada=" + morada + ", nome=" + nomeUtilizador + ", email=" + email + ", password=" + password + '}';
    }
    
}
