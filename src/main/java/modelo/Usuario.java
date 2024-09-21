package modelo;

import javax.persistence.*;
import util.IUsuarioLogado; // Importação correta da interface

/**
 * Classe que representa um Usuário do sistema.
 */
@Entity
@Table(name = "usuarios") // Define o nome da tabela no banco de dados
public class Usuario implements IUsuarioLogado {

    private String tipo = "Usuario"; // Define o tipo fixo como "Usuario"

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o ID será gerado automaticamente
    private Long id;

    @Column(nullable = false, length = 100) // Nome completo é obrigatório
    private String nomeCompleto; // Renomeado de 'nome' para 'nomeCompleto' para alinhar com a interface

    @Column(nullable = false, unique = true) // nomeUsuario é obrigatório e deve ser único
    private String nomeUsuario;

    @Column(nullable = false) // senhaHash é obrigatório
    private String senhaHash;

    @Column(nullable = false, unique = true, length = 11) // CPF é obrigatório e único
    private String cpf;

    @Column(nullable = false) // Papel é obrigatório
    private String papel;

    @Column(nullable = false) // Define que a autenticação de dois fatores é obrigatoriamente false por padrão
    private boolean autenticacaoDoisFatoresHabilitada;

    @Lob // Define que biometriaDigital pode ser um dado grande (byte array)
    private byte[] biometriaDigital;

    // Construtor
    public Usuario(Long id, String nomeCompleto, String nomeUsuario, String senhaHash, String cpf, String papel) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.nomeUsuario = nomeUsuario;
        this.senhaHash = senhaHash;
        this.cpf = cpf;
        this.papel = papel;
        this.autenticacaoDoisFatoresHabilitada = false; // Inicialmente, a 2FA está desabilitada
    }

    public Usuario() {
    }

    // Getters e Setters

    @Override
    public Long getId() { // Implementação do método da interface com @Override
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getNomeCompleto() { // Implementação do método da interface com @Override
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    @Override
    public String getTipo() { // Implementação do método da interface com @Override
        return tipo;
    }

    // Opcional: Setter para 'tipo' se necessário
    // public void setTipo(String tipo) {
    //     this.tipo = tipo;
    // }
}
