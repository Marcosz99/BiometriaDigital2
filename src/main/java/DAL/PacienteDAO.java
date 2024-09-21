package DAL;

import modelo.Paciente;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query; // Importação correta para o Hibernate 5.x e 6.x

public class PacienteDAO {

    // Método para salvar ou atualizar um paciente
    public void salvar(Paciente paciente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(paciente); // Usado para salvar ou atualizar o paciente
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para buscar um paciente pelo ID
    public Paciente buscarPorId(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Paciente.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para buscar todos os pacientes
    public List<Paciente> buscarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Paciente> query = session.createQuery("from Paciente", Paciente.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Paciente buscarPorNome(String nomeCompleto) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Paciente> query = session.createQuery("from Paciente where nomeCompleto = :nomeCompleto", Paciente.class);
            query.setParameter("nomeCompleto", nomeCompleto);
            return query.uniqueResult(); // Retorna o objeto Paciente ou null se não encontrado
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Retorna null em caso de erro
        }
    }

    // Método para buscar paciente pelo nome de usuario
    public Paciente buscarPorNomeUsuario(String nomeUsuario) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Paciente> query = session.createQuery("from Paciente where nomeUsuario = :nomeUsuario", Paciente.class);
            query.setParameter("nomeUsuario", nomeUsuario);
            return query.uniqueResult(); // Retorna único resultado ou null
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // Método para verificar se um paciente com o CPF existe
    public boolean verificarPacienteExistente(String cpf) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Paciente> query = session.createQuery("from Paciente where cpf = :cpf", Paciente.class);
            query.setParameter("cpf", cpf);
            Paciente paciente = query.uniqueResult(); // Verifica se existe um único resultado

            return paciente != null; // Retorna true se o paciente existir, false caso contrário
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Retorna false em caso de erro
        }
    }

    // Método para verificar se um usuário com o CPF existe (corrigido)
    public boolean verificarCpfExistente(String cpf) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Paciente> query = session.createQuery("from Paciente where cpf = :cpf", Paciente.class); // Corrigido de "Usuario" para "Paciente"
            query.setParameter("cpf", cpf);
            Paciente paciente = query.uniqueResult(); // Verifica se existe um único resultado

            return paciente != null; // Retorna true se o CPF existir, false caso contrário
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Retorna false em caso de erro
        }
    }

    public Paciente obterPacietePorCPF(String cpf) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Paciente> query = session.createQuery("from Paciente where cpf = :cpf", Paciente.class);
            query.setParameter("cpf", cpf);
            return query.uniqueResult(); // Retorna o paciente se encontrado, ou null se não
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Retorna null em caso de erro
        }
    }

    // Método para excluir um paciente
    public void excluir(Paciente paciente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(paciente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
