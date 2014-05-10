package br.edu.ifms.lp4.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso {

	@Id
	@GeneratedValue
	private Integer id;

	private String descricao;
	
	@OneToMany(targetEntity = Modalidade.class)
	private String idModalidade;

	private String horario1;

	private String horario2;

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIdModalidade() {
		return idModalidade;
	}

	public void setIdModalidade(String idModalidade) {
		this.idModalidade = idModalidade;
	}

	public String getHorario1() {
		return horario1;
	}

	public void setHorario1(String horario1) {
		this.horario1 = horario1;
	}

	public String getHorario2() {
		return horario2;
	}

	public void setHorario2(String horario2) {
		this.horario2 = horario2;
	}

}
