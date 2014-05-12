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

		if (equipamento == null || equipamento.getDescricao().equals("")) {
			return preencheMensagens(classeCSSErro,
					"Descrição deve ser preenchida!");
		} else {
			if (equipamentoDao.salva(equipamento) != null) {
				return preencheMensagens(classeCSSSucesso,
						"Equipamento salva com sucesso!");
			}
		}

		return preencheMensagens(classeCSSErro, "Error ao salvar equipamento!");
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
