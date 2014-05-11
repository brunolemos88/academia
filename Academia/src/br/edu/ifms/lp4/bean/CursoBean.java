package br.edu.ifms.lp4.bean;

import java.util.List;

import br.edu.ifms.lp4.jpa.dao.CursoDao;
import br.edu.ifms.lp4.modelo.Curso;

public class CursoBean {
	private List<Curso> cursos;
	private CursoDao cursoDao = new CursoDao();

	public List<Curso> getCursos() {
		cursos = cursoDao.recuperaTodos();
		return cursos;
	}

	public boolean salvaCurso(Curso curso) {
		return cursoDao.salva(curso) != null ? true : false;
	}

	public boolean deletaCurso(Curso curso) {
		return cursoDao.remove(curso);
	}

	public Curso recuperaCurso(Integer id) {
		return cursoDao.recupera(id);
	}
}
