/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package apresentacao;

import DAL.UsuarioDAO;
import apresentacao.usuario.TelaDadosUsuario;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;

/**
 *
 * @author Alan
 */
public class TelaUsuario extends javax.swing.JFrame {

    /**
     * Creates new form TelaAvancado
     */
    private DefaultTableModel tableModel;
    private int paginaAtual = 1;
    private static final int ITENS_POR_PAGINA = 20;

    public TelaUsuario() {
        initComponents();

    }

    public void abrirTelaDadosUsuario(Usuario usuario) {
        TelaDadosUsuario telaDados = new TelaDadosUsuario(usuario);
        jDPane.add(telaDados);
        telaDados.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frmPesquisar = new javax.swing.JFrame();
        btnPesquisarPorCPF = new javax.swing.JButton();
        txfCpf = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        frmExibirGeral = new javax.swing.JFrame();
        jTabExibirDadosLinha = new javax.swing.JScrollPane();
        TblDados = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();
        btnAvancar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnPesquisarPorNome = new javax.swing.JButton();
        txfNomePesquisado = new javax.swing.JTextField();
        jDPane = new javax.swing.JDesktopPane();
        jMenu = new javax.swing.JMenuBar();
        jMenuEscolhaBanco = new javax.swing.JMenu();
        JMUsuario = new javax.swing.JMenuItem();
        JMPaciente = new javax.swing.JMenuItem();
        JMMedico = new javax.swing.JMenuItem();
        jMenuPesquisarPorCPF = new javax.swing.JMenu();
        JMUsuarioPesquisar = new javax.swing.JMenuItem();
        JMPacientePesquisar = new javax.swing.JMenuItem();
        JMMedicoPesquisar = new javax.swing.JMenuItem();

        frmPesquisar.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frmPesquisar.setTitle("Pesquisar");

        btnPesquisarPorCPF.setText("Pesquisar");
        btnPesquisarPorCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarPorCPFActionPerformed(evt);
            }
        });

        lblCpf.setText("Digite o CPF:");

        javax.swing.GroupLayout frmPesquisarLayout = new javax.swing.GroupLayout(frmPesquisar.getContentPane());
        frmPesquisar.getContentPane().setLayout(frmPesquisarLayout);
        frmPesquisarLayout.setHorizontalGroup(
            frmPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmPesquisarLayout.createSequentialGroup()
                .addGroup(frmPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frmPesquisarLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(txfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frmPesquisarLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(lblCpf))
                    .addGroup(frmPesquisarLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnPesquisarPorCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        frmPesquisarLayout.setVerticalGroup(
            frmPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmPesquisarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(txfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisarPorCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        frmExibirGeral.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabExibirDadosLinha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabExibirDadosLinhaMouseClicked(evt);
            }
        });

        TblDados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TblDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome Completo", "Usuario", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblDadosMouseClicked(evt);
            }
        });
        jTabExibirDadosLinha.setViewportView(TblDados);
        if (TblDados.getColumnModel().getColumnCount() > 0) {
            TblDados.getColumnModel().getColumn(0).setResizable(false);
            TblDados.getColumnModel().getColumn(1).setResizable(false);
            TblDados.getColumnModel().getColumn(2).setResizable(false);
        }

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnAvancar.setText("Avançar");
        btnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clique duas vezes para abrir mais informações");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnPesquisarPorNome.setText("Pesquisar por Nome");
        btnPesquisarPorNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarPorNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frmExibirGeralLayout = new javax.swing.GroupLayout(frmExibirGeral.getContentPane());
        frmExibirGeral.getContentPane().setLayout(frmExibirGeralLayout);
        frmExibirGeralLayout.setHorizontalGroup(
            frmExibirGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabExibirDadosLinha, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
            .addGroup(frmExibirGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmExibirGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frmExibirGeralLayout.createSequentialGroup()
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frmExibirGeralLayout.createSequentialGroup()
                        .addComponent(txfNomePesquisado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesquisarPorNome)))
                .addContainerGap())
        );
        frmExibirGeralLayout.setVerticalGroup(
            frmExibirGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmExibirGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmExibirGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPesquisarPorNome, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(txfNomePesquisado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabExibirDadosLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frmExibirGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(frmExibirGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btnAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Avançada");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(720, 480));

        javax.swing.GroupLayout jDPaneLayout = new javax.swing.GroupLayout(jDPane);
        jDPane.setLayout(jDPaneLayout);
        jDPaneLayout.setHorizontalGroup(
            jDPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jDPaneLayout.setVerticalGroup(
            jDPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        jMenuEscolhaBanco.setText("Banco");

        JMUsuario.setText("Usuarios");
        JMUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMUsuarioActionPerformed(evt);
            }
        });
        jMenuEscolhaBanco.add(JMUsuario);

        JMPaciente.setText("Pacientes");
        jMenuEscolhaBanco.add(JMPaciente);

        JMMedico.setText("Medicos");
        jMenuEscolhaBanco.add(JMMedico);

        jMenu.add(jMenuEscolhaBanco);

        jMenuPesquisarPorCPF.setText("Pesquisar");
        jMenuPesquisarPorCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPesquisarPorCPFActionPerformed(evt);
            }
        });

        JMUsuarioPesquisar.setText("Usuarios");
        JMUsuarioPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMUsuarioPesquisarActionPerformed(evt);
            }
        });
        jMenuPesquisarPorCPF.add(JMUsuarioPesquisar);

        JMPacientePesquisar.setText("Pacientes");
        jMenuPesquisarPorCPF.add(JMPacientePesquisar);

        JMMedicoPesquisar.setText("Medicos");
        jMenuPesquisarPorCPF.add(JMMedicoPesquisar);

        jMenu.add(jMenuPesquisarPorCPF);

        setJMenuBar(jMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMUsuarioPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMUsuarioPesquisarActionPerformed
        frmPesquisar.setVisible(true);
        frmPesquisar.setLocationRelativeTo(null);
        frmPesquisar.setSize(320, 180);
    }//GEN-LAST:event_JMUsuarioPesquisarActionPerformed

    private void jMenuPesquisarPorCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPesquisarPorCPFActionPerformed

    }//GEN-LAST:event_jMenuPesquisarPorCPFActionPerformed

    private void btnPesquisarPorCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarPorCPFActionPerformed
        String cpf = txfCpf.getText();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscarPorCpf(cpf);

        if (usuario != null) {
            TelaDadosUsuario telaDados = new TelaDadosUsuario(usuario);
            telaDados.setVisible(true);
        } else {
            // Mensagem de usuário não encontrado
            JOptionPane.showMessageDialog(this, "Usuário não encontrado");
        }

    }//GEN-LAST:event_btnPesquisarPorCPFActionPerformed

    private void TblDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDadosMouseClicked
        if (evt.getClickCount() == 2) {
            int row = TblDados.getSelectedRow();
            if (row != -1) {
                String cpf = (String) TblDados.getValueAt(row, 1);
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.buscarPorCpf(cpf);
                if (usuario != null) {
                    TelaDadosUsuario telaDados = new TelaDadosUsuario(usuario);
                    telaDados.setVisible(true);
                } else {
                    // ERRO!!
                }
            }
        }

    }//GEN-LAST:event_TblDadosMouseClicked

    private void JMUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMUsuarioActionPerformed
//fafaw
        frmExibirGeral.setVisible(true);
        frmExibirGeral.setSize(750, 580);
        frmExibirGeral.setLocationRelativeTo(null);
        carregarPagina(1, 20);
    }//GEN-LAST:event_JMUsuarioActionPerformed

    private void jTabExibirDadosLinhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabExibirDadosLinhaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabExibirDadosLinhaMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed

        if (paginaAtual > 1) {
            paginaAtual--;
            carregarPagina(paginaAtual, 20); // Página anterior
        }

    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        long totalUsuarios = usuarioDAO.contarTotalUsuarios(); // Conta o total de usuários
        int totalPaginas = (int) Math.ceil((double) totalUsuarios / ITENS_POR_PAGINA); // Calcula o número total de páginas

        if (paginaAtual < totalPaginas) { // Só avança se ainda houver páginas
            paginaAtual++;
            carregarPagina(paginaAtual, ITENS_POR_PAGINA); // Carrega a próxima página
        }
    }//GEN-LAST:event_btnAvancarActionPerformed

    private void btnPesquisarPorNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarPorNomeActionPerformed
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String nomePesquisado = txfNomePesquisado.getText(); // Obtém o texto do campo de pesquisa

        if (!nomePesquisado.trim().isEmpty()) {
            List<Usuario> usuariosFiltrados = usuarioDAO.buscarPorNome(nomePesquisado);
            atualizarTabela(usuariosFiltrados); // Atualiza a tabela com os usuários filtrados
        } else {
            // Se o campo estiver vazio, carrega a tabela normalmente
            carregarPagina(paginaAtual, ITENS_POR_PAGINA);
        }

    }//GEN-LAST:event_btnPesquisarPorNomeActionPerformed
    public void atualizarTabela(List<Usuario> usuarios) {
        DefaultTableModel modelo = (DefaultTableModel) TblDados.getModel();
        modelo.setRowCount(0); // Limpa a tabela

        for (Usuario usuario : usuarios) {
            modelo.addRow(new Object[]{
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getNomeUsuario()
            });
        }
    }

    private void carregarPagina(int paginaAtual, int linhasPorPagina) {
        DefaultTableModel modelo = (DefaultTableModel) TblDados.getModel();
        modelo.setRowCount(0); // Limpa a tabela antes de carregar novos dados

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.buscarComPaginacao(paginaAtual, linhasPorPagina);

        // Percorre a lista de usuários e adiciona as linhas à tabela
        for (Usuario usuario : usuarios) {
            Object[] dados = {
                usuario.getNome(),
                usuario.getNomeUsuario(),
                usuario.getCpf()
            };
            modelo.addRow(dados);
        }
    }

    public static void main(String args[]) {
        try {
            // Definir o Look and Feel para Cupertino Light
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMMedico;
    private javax.swing.JMenuItem JMMedicoPesquisar;
    private javax.swing.JMenuItem JMPaciente;
    private javax.swing.JMenuItem JMPacientePesquisar;
    private javax.swing.JMenuItem JMUsuario;
    private javax.swing.JMenuItem JMUsuarioPesquisar;
    private javax.swing.JTable TblDados;
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnPesquisarPorCPF;
    private javax.swing.JButton btnPesquisarPorNome;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JFrame frmExibirGeral;
    private javax.swing.JFrame frmPesquisar;
    private javax.swing.JDesktopPane jDPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenuEscolhaBanco;
    private javax.swing.JMenu jMenuPesquisarPorCPF;
    private javax.swing.JScrollPane jTabExibirDadosLinha;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JTextField txfCpf;
    private javax.swing.JTextField txfNomePesquisado;
    // End of variables declaration//GEN-END:variables
}
