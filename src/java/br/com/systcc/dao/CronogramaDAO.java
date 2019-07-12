package br.com.systcc.dao;

import br.com.systcc.domain.Cronograma;
import br.com.systcc.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CronogramaDAO {

    //SALVAR
    public void salvar(Cronograma cronograma) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.save(cronograma);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex; //Propagar o erro
        } finally {
            sessao.close();
        }
    }
    
    //LISTAR
    public List<Cronograma> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Cronograma> cronogramas = null;
        try {
            Query consulta = sessao.getNamedQuery("Cronograma.listar");
            cronogramas = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return cronogramas;
    }

    //BUSCAR P/ CODIGO
    public Cronograma buscarPorCronograma(String id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Cronograma cronograma = null;
        try {
            Query consulta = sessao.getNamedQuery("Cronograma.buscarPorId");
            consulta.setString("semestre", id);
            cronograma = (Cronograma) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return cronograma;
    }

    //EXCLUSÃO
    public void excluir(Cronograma cronograma) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(cronograma);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex; //Propagar o erro
        } finally {
            sessao.close();
        }
    }

    //EDIÇÃO
    public void editar(Cronograma cronograma) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        // Partindo da ideia que a tela obrigará o usuário a preencher todos os dados
        try {
            transacao = sessao.beginTransaction();
            sessao.update(cronograma);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex; //Propagar o erro
        } finally {
            sessao.close();
        }
    }
}
