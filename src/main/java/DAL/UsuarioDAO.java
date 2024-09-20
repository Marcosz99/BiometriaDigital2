/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import modelo.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class UsuarioDAO {

    // Método para salvar ou atualizar um usuário
    public void salvar(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void atualizar(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void remover(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para buscar um usuário pelo ID
    public Usuario buscarPorId(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Usuario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para buscar todos os usuários
    public List<Usuario> buscarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Usuario> query = session.createQuery("from Usuario", Usuario.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para buscar usuário pelo nome de usuário
    public Usuario buscarPorNomeUsuario(String nomeUsuario) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Usuario> query = session.createQuery("from Usuario where nomeUsuario = :nomeUsuario", Usuario.class);
            query.setParameter("nomeUsuario", nomeUsuario);
            return query.uniqueResult(); // Retorna único resultado ou null
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Usuario> buscarPorNome(String nome) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Usuario> query = session.createQuery("from Usuario where nome like :nome", Usuario.class);
            query.setParameter("nome", nome + "%"); // Busca por nomes que começam com o valor digitado
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean verificarUsuarioExistente(String nomeUsuario) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Usuario> query = session.createQuery("from Usuario where nomeUsuario = :nomeUsuario", Usuario.class);
            query.setParameter("nomeUsuario", nomeUsuario);
            Usuario usuario = query.uniqueResult(); // Verifica se existe um único resultado

            return usuario != null; // Retorna true se o usuário existir, false caso contrário
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Retorna false em caso de erro
        }
    }

    public boolean verificarCpfExistente(String cpf) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Usuario> query = session.createQuery("from Usuario where cpf = :cpf", Usuario.class);
            query.setParameter("cpf", cpf);
            Usuario usuario = query.uniqueResult(); // Verifica se existe um único resultado

            return usuario != null; // Retorna true se o CPF existir, false caso contrário
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Retorna false em caso de erro
        }
    }

    // Método para buscar um usuário pelo CPF
    public Usuario buscarPorCpf(String cpf) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Usuario> query = session.createQuery("from Usuario where cpf = :cpf", Usuario.class);
            query.setParameter("cpf", cpf);
            return query.uniqueResult(); // Retorna único resultado ou null
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

// Método para buscar usuários com paginação
    public List<Usuario> buscarComPaginacao(int paginaAtual, int tamanhoPagina) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Usuario> query = session.createQuery("from Usuario", Usuario.class);
            query.setFirstResult((paginaAtual - 1) * tamanhoPagina); // Define o primeiro resultado da página
            query.setMaxResults(tamanhoPagina); // Define o número máximo de resultados por página (20, por exemplo)
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

// Método para contar o total de usuários no banco de dados
    public long contarTotalUsuarios() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery("select count(u) from Usuario u", Long.class);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

// Método para excluir um usuário
    public void excluir(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
