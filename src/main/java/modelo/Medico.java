package modelo;

import java.util.List;
import javax.persistence.*;
import util.IUsuarioLogado; // Certifique-se de que o pacote está correto

@Entity
@Table(name = "medicos")  // Nome da tabela no banco de dados
public class Medico implements IUsuarioLogado {

    private String tipo = "Medico";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Gera valores automaticamente para o ID
    private Long id;

    @Column(nullable = false, length = 100)  // Nome é obrigatório
    private String nomeCompleto; // Alterado de 'nome' para 'nomeCompleto' para corresponder à interface

    @Column(nullable = false, unique = true)  // nomeUsuario é obrigatório e deve ser único
    private String nomeUsuario;

    @Column(nullable = false)  // senhaHash é obrigatório
    private String senhaHash;

    @Column(nullable = false, unique = true)  // CPF é obrigatório e único
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)  // Data de nascimento é obrigatória
    private String dataNascimento;

    @OneToMany(mappedBy = "medico", fetch = FetchType.LAZY)
    private List<Registro> registros;

    public Medico() {
    }

    public Medico(Long id, String nomeCompleto, String nomeUsuario, String senhaHash, String cpf, String dataNascimento) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.nomeUsuario = nomeUsuario;
        this.senhaHash = senhaHash;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    // Getters e Setters
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Alterado de getNome() para getNomeCompleto()
    @Override
    public String getNomeCompleto() {
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    // Você também pode adicionar um setter para 'tipo' se necessário, mas geralmente para um campo fixo, não é necessário.
}
