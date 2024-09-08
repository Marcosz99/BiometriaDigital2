package main;

import apresentacao.TelaLoginUsuario;
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
        telaLoginUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaLoginUsuario.setLocationRelativeTo(null);

    }
}
