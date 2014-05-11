package br.edu.ifms.lp4.bean;

import java.util.List;

import br.edu.ifms.lp4.jpa.dao.EquipamentoDao;
import br.edu.ifms.lp4.modelo.Equipamento;

public class EquipamentoBean {

	private List<Equipamento> equipamentos;
	private EquipamentoDao equipamentoDao = new EquipamentoDao();

	public List<Equipamento> getModalidades() {
		equipamentos = equipamentoDao.recuperaTodos();
		return equipamentos;
	}

	public boolean salvaModalidade(Equipamento modalidade) {
		return equipamentoDao.salva(modalidade) != null ? true : false;
	}

	public boolean deletaModalidade(Equipamento modalidade) {
		return equipamentoDao.remove(modalidade);
	}
	
	public Equipamento recuperaModalidade(Integer id){
		return equipamentoDao.recupera(id);
	}
	
}
