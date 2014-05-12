package br.edu.ifms.lp4.bean;

import java.util.HashMap;
import java.util.List;

import br.edu.ifms.lp4.jpa.dao.CursoDao;
import br.edu.ifms.lp4.modelo.Curso;

public class CursoBean {
	private List<Curso> cursos;
	private CursoDao cursoDao = new CursoDao();
	
	private final String classeCSSSucesso = "alert alert-success";
	private final String classeCSSErro = "alert alert-error";
	private final String mensagem = "mensagem";
	private final String classeCSS = "classeCSS";

	public List<Curso> getCursos() {
		cursos = cursoDao.recuperaTodos();
		return cursos;
	}

	public HashMap<String, String> salvaCurso(Curso curso) {
		String mensagemErro = "Não foi possivel salvar o Curso!<br/>";
		boolean flagcursoValido = true;
		
		if (curso == null || curso.getDescricao().equals("")) {
			mensagemErro += "Descrição deve ser preenchida! <br/>";
			flagcursoValido = false;
		}
		if (curso.getModalidade() == null || curso.getModalidade().getId() == null) {
			mensagemErro += "Selecione a modalidade! <br/>";
			flagcursoValido = false;
		}
		if (curso.getHorario1() == null	|| curso.getHorario1().isEmpty()) {
			mensagemErro += "Informe o primeiro horario!<br/>";
			flagcursoValido = false;
		}
		if (curso.getHorario2() == null	|| curso.getHorario2().isEmpty()) {
			mensagemErro += "Informe o segundo horario!<br/>";
			flagcursoValido = false;
		}
		
		if (flagcursoValido && cursoDao.salva(curso) != null) {
			return preencheMensagens(classeCSSSucesso, "Curso salvo com sucesso!");
		}

		return preencheMensagens(classeCSSErro, mensagemErro);
	}

	public HashMap<String, String> removeCurso(Integer id) {
		Curso curso = recuperaCurso(id);

		if (curso == null) {
			preencheMensagens(classeCSSErro, "curso não encontrado!");
		} else {
			if (cursoDao.remove(curso)) {
				return preencheMensagens(classeCSSSucesso, "Curso removido com sucesso!");
			}
		}
		return preencheMensagens(classeCSSErro, "Error ao remover Curso!");
	}

	public Curso recuperaCurso(Integer id) {
		return cursoDao.recupera(id);
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
