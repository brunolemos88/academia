package br.edu.ifms.lp4.jpa.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.ifms.lp4.dao.Dao;
import br.edu.ifms.lp4.util.JPAUtil;
import br.edu.ifms.lp4.util.ReflectionUtil;

public class JpaDao<T> implements Dao<T> {

	protected EntityManager em;

	@Override
	public boolean salva(T objeto) {
		try {
			em = JPAUtil.getEntityManager();
			Object pk = em.getEntityManagerFactory().getPersistenceUnitUtil()
					.getIdentifier(objeto);
			if (pk == null) {
				EntityTransaction transacao = em.getTransaction();
				transacao.begin();
				em.persist(objeto);
				transacao.commit();
				em.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return false;
	}

	@Override
	public boolean atualiza(T objeto) {
		try {
			em = JPAUtil.getEntityManager();
			Object pk = em.getEntityManagerFactory().getPersistenceUnitUtil()
					.getIdentifier(objeto);
			if (pk != null) {
				EntityTransaction transacao = em.getTransaction();
				transacao.begin();
				em.merge(objeto);
				transacao.commit();
				em.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return false;
	}

	@Override
	public boolean remove(T objeto) {
		try {
			em = JPAUtil.getEntityManager();
			EntityTransaction transacao = em.getTransaction();
			transacao.begin();
			objeto = em.merge(objeto);
			em.remove(objeto);
			transacao.commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T recupera(Serializable id) {
		try {
			em = JPAUtil.getEntityManager();
			Class<?> classe = ReflectionUtil.getGenericClass(this, 0);
			T objeto = (T) em.find(classe, id);
			em.close();
			return objeto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> recuperaTodos(boolean desc, String... camposOrdenacao) {
		try {
			em = JPAUtil.getEntityManager();
			Class<?> classe = ReflectionUtil.getGenericClass(this, 0);
			String jpql = "FROM " + classe.getName();
			if (camposOrdenacao != null && camposOrdenacao.length > 0) {
				jpql += " ORDER BY ";
				int tamanho = camposOrdenacao.length;
				for (int i = 0; i < tamanho; i++) {
					jpql += camposOrdenacao[i];
					if (i < tamanho - 1) {
						jpql += ", ";
					}
				}
				jpql += desc ? " DESC" : "";
			}
			Query consulta = em.createQuery(jpql);
			List<T> resultado = consulta.getResultList();
			em.close();
			return resultado;
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return null;
	}

}
