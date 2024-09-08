package DAL;

import modelo.Paciente;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PacienteDAO {

    // Método para salvar ou atualizar um paciente
    public void salvar(Paciente paciente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(paciente); // Usado para salvar ou atualizar o paciente
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

    // Método para buscar paciente pelo nome
    public List<Paciente> buscarPorNome(String nome) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Paciente> query = session.createQuery("from Paciente where nome like :nome", Paciente.class);
            query.setParameter("nome", "%" + nome + "%"); // Usa % para buscar qualquer parte do nome
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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
