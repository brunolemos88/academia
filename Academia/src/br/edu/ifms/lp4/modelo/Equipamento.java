package br.edu.ifms.lp4.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Equipamento.LISTAR_TODOS, query = "FROM Equipamento ORDER BY id")
public class Equipamento {

	public static final String LISTAR_TODOS = "Equipamento.listarTodos";

	@Id
	@GeneratedValue
	private Integer id;

	private String descricao;

	@ManyToOne
	private Modalidade modalidade;

	private String qtdEstoque;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public String getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(String qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

}
