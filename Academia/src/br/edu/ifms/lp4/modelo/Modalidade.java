package br.edu.ifms.lp4.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Modalidade.LISTAR_TODOS, query = "FROM Modalidade ORDER BY id")
public class Modalidade {

	public static final String LISTAR_TODOS = "Modalidade.listarTodos";

	@Id
	@GeneratedValue
	private Integer id;

	private String descricao;

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
