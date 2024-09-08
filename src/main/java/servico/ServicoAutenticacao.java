package servico;

import modelo.Usuario;
import DAL.UsuarioDAO;
import util.UtilCriptografia;

/**
 *
 * @author Admin
 */
public class ServicoAutenticacao {

    private UsuarioDAO usuarioDAO;  // O DAO para acessar os usuários no banco de dados

    public ServicoAutenticacao() {
        usuarioDAO = new UsuarioDAO();  // Inicializa o DAO
    }

    public boolean autenticar(String nomeUsuario, String senha) {
        // Busca o usuário pelo nome de usuário
        Usuario usuario = usuarioDAO.buscarPorNomeUsuario(nomeUsuario);

        // Verifica se o usuário existe e se a senha fornecida corresponde à armazenada
        if (usuario != null && usuario.getSenhaHash().equals(senha)) {
            return true; // Autenticação bem-sucedida
        }

        return false; // Nome de usuário ou senha inválidos
    }
    
    // Implementar Autenticacao da Biometria
}
