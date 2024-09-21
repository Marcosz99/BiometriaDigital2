package DAL;

import modelo.Registro;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import javax.persistence.TypedQuery;

public class RegistroDAO {

    /**
     * Salva ou atualiza um registro no banco de dados.
     *
     * @param registro O registro a ser salvo ou atualizado.
     */
    public void salvar(Registro registro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(registro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Busca um registro pelo seu ID.
     *
     * @param id O ID do registro.
     * @return O registro encontrado ou null se não encontrado.
     */
    public Registro buscarPorId(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Registro.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Busca todos os registros no banco de dados.
     *
     * @return Uma lista de todos os registros.
     */
    public List<Registro> buscarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Registro> query = session.createQuery("from Registro", Registro.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Busca registros por ID do paciente.
     *
     * @param idPaciente O ID do paciente.
     * @return Uma lista de registros associados ao paciente.
     */
    public List<Registro> buscarPorPaciente(Long idPaciente) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Registro r where r.paciente.id = :idPaciente";
            Query<Registro> query = session.createQuery(hql, Registro.class);
            query.setParameter("idPaciente", idPaciente);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Busca registros por ID do médico.
     *
     * @param idMedico O ID do médico.
     * @return Uma lista de registros associados ao médico.
     */
    public List<Registro> buscarPorMedico(Long idMedico) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Registro r where r.medico.id = :idMedico";
            Query<Registro> query = session.createQuery(hql, Registro.class);
            query.setParameter("idMedico", idMedico);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Registro> buscarPorNomePaciente(String nomeCompletoPaciente) {
        Transaction transaction = null;
        List<Registro> registros = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Cria uma query para buscar registros com base no nome completo do paciente
            TypedQuery<Registro> query = session.createQuery(
                    "FROM Registro r WHERE r.paciente.nomeCompleto LIKE :nomeCompletoPaciente", Registro.class);
            query.setParameter("nomeCompletoPaciente", "%" + nomeCompletoPaciente + "%"); // Usando like para busca parcial

            // Obtém a lista de registros correspondentes
            registros = query.getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return registros;
    }

    public List<Registro> carregarPagina(int paginaAtual, int linhasPorPagina) {
        Transaction transaction = null;
        List<Registro> registros = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Calcula o offset com base na página atual e no número de linhas por página
            int offset = (paginaAtual - 1) * linhasPorPagina;

            // Cria a query para buscar os registros com paginação
            TypedQuery<Registro> query = session.createQuery(
                    "FROM Registro", Registro.class);
            query.setFirstResult(offset); // Define o ponto inicial
            query.setMaxResults(linhasPorPagina); // Define o número máximo de resultados

            // Obtém a lista de registros para a página solicitada
            registros = query.getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return registros;
    }

    public long contarTotalRegistros() {
        Transaction transaction = null;
        long totalRegistros = 0;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Cria uma query para contar o total de registros
            totalRegistros = (long) session.createQuery("SELECT COUNT(r) FROM Registro r")
                    .uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return totalRegistros;
    }

    public void excluir(Registro registro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(registro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
