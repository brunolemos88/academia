package br.edu.ifms.lp4.bean;

import java.util.List;

import br.edu.ifms.lp4.jpa.dao.ModalidadeDao;
import br.edu.ifms.lp4.modelo.Modalidade;

public class ModalidadeBean {
	
	private List<Modalidade> modalidades;
	private ModalidadeDao modalidadeDao = new ModalidadeDao();
	
	public List<Modalidade> getModalidades(){
		modalidades = modalidadeDao.recuperaTodos();
		return modalidades;
	}
}
