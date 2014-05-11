package br.edu.ifms.lp4.bean;

import java.util.List;

import br.edu.ifms.lp4.jpa.dao.ModalidadeDao;
import br.edu.ifms.lp4.modelo.Modalidade;

public class ModalidadeBean {

	private List<Modalidade> modalidades;
	private ModalidadeDao modalidadeDao = new ModalidadeDao();

	public List<Modalidade> getModalidades() {
		modalidades = modalidadeDao.recuperaTodos();
		return modalidades;
	}

	public boolean salvaModalidade(Modalidade modalidade) {
		return modalidadeDao.salva(modalidade) != null ? true : false;
	}

	public boolean deletaModalidade(Integer id) {
		Modalidade modalidade = recuperaModalidade(id);
		return modalidadeDao.remove(modalidade);
	}
	
	public Modalidade recuperaModalidade(Integer id){
		return modalidadeDao.recupera(id);
	}
}
