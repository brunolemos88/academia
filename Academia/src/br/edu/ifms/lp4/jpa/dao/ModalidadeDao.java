package br.edu.ifms.lp4.jpa.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.edu.ifms.lp4.modelo.Modalidade;
import br.edu.ifms.lp4.util.JPAUtil;

public class ModalidadeDao extends JPADao<Modalidade> {

	@Override
	public Modalidade recupera(Serializable id) {
		try {
			em = JPAUtil.getEntityManager();
			Integer chave = (Integer) id;
			Modalidade objeto = (Modalidade) em.find(Modalidade.class, chave);
			em.close();
			return objeto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Modalidade> recuperaTodos() {
		List<Modalidade> modalidades = new ArrayList<Modalidade>();
		try {
			em = JPAUtil.getEntityManager();
			Query query = em.createNamedQuery(Modalidade.LISTAR_TODOS);
			modalidades = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.isOpen()) {
				em.close();
			}
		}
		return modalidades;
	}

}
