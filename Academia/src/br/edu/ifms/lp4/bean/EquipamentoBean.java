package br.edu.ifms.lp4.bean;

import java.util.List;

import br.edu.ifms.lp4.jpa.dao.EquipamentoDao;
import br.edu.ifms.lp4.modelo.Equipamento;

public class EquipamentoBean {

	private List<Equipamento> equipamentos;
	private EquipamentoDao equipamentoDao = new EquipamentoDao();

	public List<Equipamento> getEquipamentos() {
		equipamentos = equipamentoDao.recuperaTodos();
		return equipamentos;
	}

	public boolean salvaEquipamento(Equipamento equipamento) {
		return equipamentoDao.salva(equipamento) != null ? true : false;
	}

	public boolean deletaEquipamento(Equipamento equipamento) {
		return equipamentoDao.remove(equipamento);
	}
	
	public Equipamento recuperaEquipamento(Integer id){
		return equipamentoDao.recupera(id);
	}
	
}
