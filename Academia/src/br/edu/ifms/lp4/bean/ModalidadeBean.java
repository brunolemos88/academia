package br.edu.ifms.lp4.bean;

import java.util.HashMap;
import java.util.List;

import br.edu.ifms.lp4.jpa.dao.ModalidadeDao;
import br.edu.ifms.lp4.modelo.Modalidade;

public class ModalidadeBean {

	private List<Modalidade> modalidades;
	private ModalidadeDao modalidadeDao = new ModalidadeDao();
	
	private HashMap<String, String> mensagens;
	private final String classeCSSSucesso = "alert alert-success";
	private final String classeCSSErro = "alert alert-error";
	private final String mensagem = "mensagem";
	private final String classeCSS = "classeCSS";
	

	public List<Modalidade> getModalidades() {
		modalidades = modalidadeDao.recuperaTodos();
		return modalidades;
	}

	public HashMap<String, String> salvaModalidade(Modalidade modalidade) {	
		
		if(modalidade == null || modalidade.getDescricao().equals("")){
			return preencheMensagens(classeCSSErro, "Descrição deve ser preenchida!");
		}else{
			if(modalidadeDao.salva(modalidade) != null){
				return preencheMensagens(classeCSSSucesso, "Modalidade salva com sucesso!");
			}
		}
		
		return preencheMensagens(classeCSSErro, "Error ao salvar modalidade!");
	}

	public HashMap<String, String> removeModalidade(Integer id) {
		Modalidade modalidade = recuperaModalidade(id);
		
		if(modalidade == null){
			preencheMensagens(classeCSSErro, "Modalidade não encontrada!");
		}else{
			if(modalidadeDao.remove(modalidade)){
				return preencheMensagens(classeCSSSucesso, "Modalidade removida com sucesso!");
			}
		}
		return preencheMensagens(classeCSSErro, "Error ao remover modalidade!");
	}
	
	public Modalidade recuperaModalidade(Integer id){
		return modalidadeDao.recupera(id);
	}
	
	private HashMap<String, String> preencheMensagens(String classeCSS, String mensagem){
		if(classeCSS.equals(classeCSSErro)){
			this.mensagens.put(this.classeCSS, classeCSS);
			this.mensagens.put(this.mensagem, mensagem);
			return this.mensagens;
		}
		if(classeCSS.equals(classeCSSSucesso)){
			this.mensagens.put(this.classeCSS, classeCSS);
			this.mensagens.put(this.mensagem, mensagem);
			return this.mensagens;
		}
		this.mensagens.put(classeCSS, classeCSSErro);
		this.mensagens.put(mensagem, "SEGUINTE FUDEU, MUITO. Você chegou até aqui!");
		return this.mensagens;
	}
}
