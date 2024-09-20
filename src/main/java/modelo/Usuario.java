package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "usuarios") // Define o nome da tabela no banco de dados
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o ID será gerado automaticamente
    private Long id;

    @Column(nullable = false) // Nome é obrigatório
    private String nome;

    @Column(nullable = false, unique = true) // nomeUsuario é obrigatório e deve ser único
    private String nomeUsuario;

    @Column(nullable = false) // senhaHash é obrigatório
    private String senhaHash;

    @Column(nullable = false) // Papel é obrigatório
    private String cpf;

    @Column(nullable = false) // Papel é obrigatório
    private String papel;

    @Column(nullable = false) // Define que a autenticação de dois fatores é obrigatoriamente false por padrão
    private boolean autenticacaoDoisFatoresHabilitada;

    @Lob // Define que biometriaDigital pode ser um dado grande (byte array)
    private byte[] biometriaDigital;

    // Construtor
    public Usuario(Long id, String nome, String nomeUsuario, String senhaHash, String cpf, String papel) {
        this.id = id;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senhaHash = senhaHash;
        this.cpf = cpf;
        this.papel = papel;
        this.autenticacaoDoisFatoresHabilitada = false; // Inicialmente, a 2FA está desabilitada
    }

    public Usuario() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public boolean isAutenticacaoDoisFatoresHabilitada() {
        return autenticacaoDoisFatoresHabilitada;
    }

    public void setAutenticacaoDoisFatoresHabilitada(boolean autenticacaoDoisFatoresHabilitada) {
        this.autenticacaoDoisFatoresHabilitada = autenticacaoDoisFatoresHabilitada;
    }

    public byte[] getBiometriaDigital() {
        return biometriaDigital;
    }

    public void setBiometriaDigital(byte[] biometriaDigital) {
        this.biometriaDigital = biometriaDigital;
    }
}
