package util;

public interface IUsuarioLogado {
    String getNomeCompleto();
    Long getId();
    String getTipo(); // "Usuario", "Medico" ou "Paciente"
}
