package DAL;

import modelo.Registro;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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

    /**
     * Exclui um registro do banco de dados.
     *
     * @param registro O registro a ser excluído.
     */
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
