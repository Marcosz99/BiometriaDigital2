package DAL;

import java.util.List;
import modelo.Medico;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query; // Importação correta para o Hibernate 5.x e 6.x

public class MedicoDAO {

    // Método para salvar ou atualizar um medico
    public void salvar(Medico medico) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(medico); // Usado para salvar ou atualizar o medico
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para buscar um medico pelo ID
    public Medico buscarPorId(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Medico.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para buscar todos os medico
    public List<Medico> buscarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Medico> query = session.createQuery("from Medico", Medico.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Medico buscarPorNome(String nome) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Medico> query = session.createQuery("from Medico where nome = :nome", Medico.class);
            query.setParameter("nome", nome);
            return query.uniqueResult(); // Retorna o objeto Medico ou null se não encontrado
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Retorna null em caso de erro
        }
    }

    // Método para buscar medico pelo nome de usuario
    public Medico buscarPorNomeUsuario(String nomeUsuario) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Medico> query = session.createQuery("from Medico where nomeUsuario = :nomeUsuario", Medico.class);
            query.setParameter("nomeUsuario", nomeUsuario);
            return query.uniqueResult(); // Retorna único resultado ou null
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para verificar se um medico com o CPF existe
    public boolean verificarMedicoExistente(String cpf) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Medico> query = session.createQuery("from Medico where cpf = :cpf", Medico.class);
            query.setParameter("cpf", cpf);
            Medico medico = query.uniqueResult(); // Verifica se existe um único resultado

            return medico != null; // Retorna true se o medico existir, false caso contrário
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Retorna false em caso de erro
        }
    }

    // Método para verificar se um usuário com o CPF existe (corrigido)
    public boolean verificarCpfExistente(String cpf) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Medico> query = session.createQuery("from Medico where cpf = :cpf", Medico.class); // Corrigido de "Usuario" para "Paciente"
            query.setParameter("cpf", cpf);
            Medico medico = query.uniqueResult(); // Verifica se existe um único resultado

            return medico != null; // Retorna true se o CPF existir, false caso contrário
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Retorna false em caso de erro
        }
    }

    public Medico obterMedicoPorCPF(String cpf) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Medico> query = session.createQuery("from Medico where cpf = :cpf", Medico.class);
            query.setParameter("cpf", cpf);
            return query.uniqueResult(); // Retorna o médico se encontrado, ou null se não
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Retorna null em caso de erro
        }
    }

    // Método para excluir um medico
    public void excluir(Medico medico) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(medico);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
