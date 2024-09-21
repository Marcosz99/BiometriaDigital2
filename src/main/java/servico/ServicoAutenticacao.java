package servico;

import DAL.MedicoDAO;
import DAL.PacienteDAO;
import DAL.UsuarioDAO;
import modelo.Usuario;
import modelo.Medico;
import modelo.Paciente;

public class ServicoAutenticacao {

    private UsuarioDAO usuarioDAO;
    private PacienteDAO pacienteDAO;
    private MedicoDAO medicoDAO;
    private String nomeCompletoLogado;

    public ServicoAutenticacao() {
        usuarioDAO = new UsuarioDAO();
        pacienteDAO = new PacienteDAO();
        medicoDAO = new MedicoDAO();
    }

    public boolean autenticarUsuario(String nomeUsuario, String senha) {
        Usuario usuario = usuarioDAO.buscarPorNomeUsuario(nomeUsuario);
        if (usuario != null && usuario.getSenhaHash().equals(senha)) {
            ServicoUsuarioLogado.getInstance().setUsuario(usuario.getNomeCompleto(), usuario.getId(), "Usuario");
            return true;
        }
        return false;
    }

    public boolean autenticarPaciente(String nomeUsuario, String senha) {
        Paciente paciente = pacienteDAO.buscarPorNomeUsuario(nomeUsuario);
        if (paciente != null && paciente.getSenhaHash().equals(senha)) {
            ServicoUsuarioLogado.getInstance().setUsuario(paciente.getNomeCompleto(), paciente.getId(), "Paciente");
            return true;
        }
        return false;
    }

    public boolean autenticarMedico(String nomeUsuario, String senha) {
        Medico medico = medicoDAO.buscarPorNomeUsuario(nomeUsuario);
        if (medico != null && medico.getSenhaHash().equals(senha)) {
            ServicoUsuarioLogado.getInstance().setUsuario(medico.getNomeCompleto(), medico.getId(), "Medico");
            return true;
        }
        return false;
    }

    public String getNomeCompletoLogado() {
        return nomeCompletoLogado;
    }
}
