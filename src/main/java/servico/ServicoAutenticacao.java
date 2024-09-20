package servico;

import DAL.MedicoDAO;
import DAL.PacienteDAO;
import modelo.Usuario;
import DAL.UsuarioDAO;
import modelo.Medico;
import modelo.Paciente;
import util.UtilCriptografia;

/**
 *
 * @author Admin
 */
public class ServicoAutenticacao {

    private UsuarioDAO usuarioDAO; // O DAO para acessar os usuários no banco de dados
    private PacienteDAO pacienteDAO;
    private MedicoDAO medicoDAO;

    private String NomeCompletoLogado; // Para armazenar o nome completo do usuário logado

    public ServicoAutenticacao() {
        usuarioDAO = new UsuarioDAO();  // Inicializa o DAO para Usuario
        pacienteDAO = new PacienteDAO();  // Inicializa o DAO para Paciente
        medicoDAO = new MedicoDAO();  // Inicializa o DAO para Medico
    }

    public boolean autenticarUsuario(String nomeUsuario, String senha) {
        // Busca o usuário pelo nome de usuário
        Usuario usuario = usuarioDAO.buscarPorNomeUsuario(nomeUsuario);

        // Verifica se o usuário existe e se a senha fornecida corresponde à armazenada
        if (usuario != null && usuario.getSenhaHash().equals(senha)) {
            NomeCompletoLogado = usuario.getNome(); // Armazena o nome completo do usuário logado
            return true; // Autenticação bem-sucedida
        }

        return false; // Nome de usuário ou senha inválidos
    }

    public boolean autenticarPaciente(String nomeUsuario, String senha) {
        // Busca o paciente pelo nome de usuário
        Paciente paciente = pacienteDAO.buscarPorNomeUsuario(nomeUsuario);

        // Verifica se o paciente existe e se a senha fornecida corresponde à armazenada
        if (paciente != null && paciente.getSenhaHash().equals(senha)) {
            NomeCompletoLogado = paciente.getNome(); // Armazena o nome completo do paciente logado
            return true; // Autenticação bem-sucedida
        }

        return false; // Nome de usuário ou senha inválidos
    }

    public boolean autenticarMedico(String nomeUsuario, String senha) {
        // Busca o médico pelo nome de usuário
        Medico medico = medicoDAO.buscarPorNomeUsuario(nomeUsuario);

        // Verifica se o médico existe e se a senha fornecida corresponde à armazenada
        if (medico != null && medico.getSenhaHash().equals(senha)) {
            NomeCompletoLogado = medico.getNome(); // Armazena o nome completo do médico logado
            return true; // Autenticação bem-sucedida
        }

        return false; // Nome de usuário ou senha inválidos
    }

    public String getNomeCompletoLogado() {
        return NomeCompletoLogado; // Retorna o nome completo do usuário logado
    }

    // Implementar Autenticacao da Biometria
}
