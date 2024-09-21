package servico;

public class ServicoUsuarioLogado {
    private static ServicoUsuarioLogado instance;
    
    private String nomeCompleto;
    private Long id; // Pode ser o ID do usuário logado, se necessário
    private String tipo; // Para armazenar se é "Paciente", "Medico" ou "Usuario"

    private ServicoUsuarioLogado() {}

    public static ServicoUsuarioLogado getInstance() {
        if (instance == null) {
            instance = new ServicoUsuarioLogado();
        }
        return instance;
    }

    public void setUsuario(String nomeCompleto, Long id, String tipo) {
        this.nomeCompleto = nomeCompleto;
        this.id = id;
        this.tipo = tipo;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void logout() {
        nomeCompleto = null;
        id = null;
        tipo = null;
        instance = null; // Para que uma nova instância seja criada em um novo login
    }
}
