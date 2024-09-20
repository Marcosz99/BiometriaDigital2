package modelo;

import javax.persistence.*;

@Entity
@Table(name = "medicos")  // Nome da tabela no banco de dados
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Gera valores automaticamente para o ID
    private Long id;

    @Column(nullable = false, length = 100)  // Nome é obrigatório
    private String nome;

    @Column(nullable = false, unique = true)  // nomeUsuario é obrigatório e deve ser único
    private String nomeUsuario;

    @Column(nullable = false)  // senhaHash é obrigatório
    private String senhaHash;

    @Column(nullable = false, unique = true)  // CPF é obrigatório e único
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)  // Data de nascimento é obrigatória
    private String dataNascimento;

    public Medico() {
    }

    public Medico(Long id, String nome, String nomeUsuario, String senhaHash, String cpf, String dataNascimento ) {
        this.id = id;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senhaHash = senhaHash;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
