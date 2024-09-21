package main;

import apresentacao.usuario.TelaUsuario;
import apresentacao.medico.TelaLoginMedico;
import apresentacao.paciente.TelaLoginPaciente;
import apresentacao.usuario.TelaLoginUsuario;
import modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class Biometria2 {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BiometriaPersistence");
        EntityManager em = emf.createEntityManager();

        TelaLoginUsuario telaLoginUsuario = new TelaLoginUsuario();
        telaLoginUsuario.setVisible(true);
        telaLoginUsuario.setLocationRelativeTo(null);

//        TelaLoginMedico telaLoginMedico = new TelaLoginMedico();
//        telaLoginMedico.setVisible(true);
//        telaLoginMedico.setLocationRelativeTo(null);
//
//        TelaLoginPaciente telaLoginPaciente = new TelaLoginPaciente();
//        telaLoginPaciente.setVisible(true);
//        telaLoginPaciente.setLocationRelativeTo(null);

    }
}
