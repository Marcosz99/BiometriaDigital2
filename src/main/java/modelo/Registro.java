package modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registros")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    // Construtores

    public Registro() {}

    public Registro(String descricao, Paciente paciente, Medico medico) {
        this.descricao = descricao;
        this.paciente = paciente;
        this.medico = medico;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    // toString()

    @Override
    public String toString() {
        return "Registro{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", paciente=" + paciente.getNome() +
                ", medico=" + medico.getNome() +
                '}';
    }
}