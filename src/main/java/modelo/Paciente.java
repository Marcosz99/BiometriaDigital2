package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.Serializable;

/**
 * Classe que representa um paciente no sistema.
 */
@Entity
@Table(name = "pacientes")  // Nome da tabela no banco de dados
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Gera valores automaticamente para o ID
    private Long id;

    @Column(nullable = false, length = 100)  // Define a coluna e suas restrições
    private String nome;

    @Column(nullable = false, length = 100, unique = true)  // Define email como único
    private String email;

    @Column(nullable = false, length = 11, unique = true)  // Define CPF como único
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)  // Nome da coluna no banco de dados
    private String dataNascimento;

    // Construtor padrão
    public Paciente() {
    }

    // Construtor completo
    public Paciente(Long id, String nome, String email, String cpf, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Paciente{"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", email='" + email + '\''
                + ", cpf='" + cpf + '\''
                + ", dataNascimento='" + dataNascimento + '\''
                + '}';
    }
}
