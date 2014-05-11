package br.edu.ifms.lp4.jpa.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.edu.ifms.lp4.modelo.Curso;
import br.edu.ifms.lp4.util.JPAUtil;

public class CursoDao extends JPADao<Curso> {

	@Override
	public Curso recupera(Serializable id) {
		try {
			em = JPAUtil.getEntityManager();
			Integer chave = (Integer) id;
			Curso objeto = (Curso) em.find(Curso.class, chave);
			em.close();
			return objeto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> recuperaTodos() {
		List<Curso> cursos = new ArrayList<Curso>();
		try {
			em = JPAUtil.getEntityManager();
			Query query = em.createNamedQuery(Curso.LISTAR_TODOS);
			cursos = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.isOpen()) {
				em.close();
			}
		}
		return cursos;
	}

}
