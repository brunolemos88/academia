package br.edu.ifms.lp4.bean;

import java.util.HashMap;
import java.util.List;

import br.edu.ifms.lp4.jpa.dao.EquipamentoDao;
import br.edu.ifms.lp4.modelo.Equipamento;

public class EquipamentoBean {

	private List<Equipamento> equipamentos;
	private EquipamentoDao equipamentoDao = new EquipamentoDao();

	private final String classeCSSSucesso = "alert alert-success";
	private final String classeCSSErro = "alert alert-error";
	private final String mensagem = "mensagem";
	private final String classeCSS = "classeCSS";

	public List<Equipamento> getEquipamentos() {
		equipamentos = equipamentoDao.recuperaTodos();
		return equipamentos;
	}

	public HashMap<String, String> salvaEquipamento(Equipamento equipamento) {
		String mensagemErro = "Não foi possivel salvar o equipamento!<br/>";
		boolean flagEquipamentoValido = true;
		
		if (equipamento == null || equipamento.getDescricao().equals("")) {
			mensagemErro += "Descrição deve ser preenchida! <br/>";
			flagEquipamentoValido = false;
		}
		if (equipamento.getIdModalidade() == null || equipamento.getIdModalidade().isEmpty()) {
			mensagemErro += "Selecione a modalidade! <br/>";
			flagEquipamentoValido = false;
		}
		if (equipamento.getQtdEstoque() == null
				|| equipamento.getQtdEstoque().isEmpty()) {
			mensagemErro += "Informe a quantidade em estoque!<br/>";
			flagEquipamentoValido = false;
		}
		
		if (flagEquipamentoValido && equipamentoDao.salva(equipamento) != null) {
			return preencheMensagens(classeCSSSucesso, "Equipamento salva com sucesso!");
		}

		return preencheMensagens(classeCSSErro, mensagemErro);
	}

	public HashMap<String, String> removeEquipamento(Integer id) {
		Equipamento equipamento = recuperaEquipamento(id);

		if (equipamento == null) {
			preencheMensagens(classeCSSErro, "Equipamento não encontrado!");
		} else {
			if (equipamentoDao.remove(equipamento)) {
				return preencheMensagens(classeCSSSucesso,
						"Equipamento removido com sucesso!");
			}
		}
		return preencheMensagens(classeCSSErro, "Error ao remover equipamento!");
	}

	public Equipamento recuperaEquipamento(Integer id) {
		return equipamentoDao.recupera(id);
	}

	private HashMap<String, String> preencheMensagens(String classeCSS,
			String mensagem) {
		if (classeCSS.equals(classeCSSErro)) {
			HashMap<String, String> mensagens = new HashMap<>();
			mensagens.put(this.classeCSS, classeCSSErro);
			mensagens.put(this.mensagem, mensagem);
			return mensagens;
		}
		if (classeCSS.equals(classeCSSSucesso)) {
			HashMap<String, String> mensagens = new HashMap<>();
			mensagens.put(this.classeCSS, classeCSSSucesso);
			mensagens.put(this.mensagem, mensagem);
			return mensagens;
		}
		HashMap<String, String> mensagens = new HashMap<>();
		mensagens.put(classeCSS, classeCSSErro);
		mensagens.put(mensagem, "SEGUINTE FUDEU, MUITO. Você chegou até aqui!");
		return mensagens;

	}

}
