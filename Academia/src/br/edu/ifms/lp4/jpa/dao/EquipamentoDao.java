package br.edu.ifms.lp4.jpa.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.edu.ifms.lp4.modelo.Equipamento;
import br.edu.ifms.lp4.util.JPAUtil;

public class EquipamentoDao extends JPADao<Equipamento>{

	@Override
	public Equipamento recupera(Serializable id) {
		try {
			em = JPAUtil.getEntityManager();
			Integer chave = (Integer) id;
			Equipamento objeto = (Equipamento) em.find(Equipamento.class, chave);
			em.close();
			return objeto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Equipamento> recuperaTodos() {
		List<Equipamento> equipamentos = new ArrayList<Equipamento>();
		try {
			em = JPAUtil.getEntityManager();
			Query query = em.createNamedQuery(Equipamento.LISTAR_TODOS);
			equipamentos = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.isOpen()) {
				em.close();
			}
		}
		return equipamentos;
	}

}
