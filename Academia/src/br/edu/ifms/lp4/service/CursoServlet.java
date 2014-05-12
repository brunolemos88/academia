package br.edu.ifms.lp4.service;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifms.lp4.bean.CursoBean;
import br.edu.ifms.lp4.modelo.Curso;

@WebServlet(name = "curso", urlPatterns = { "/curso" })
public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String mensagem = "mensagem";
	private String classeCSS = "classeCSS";
	private HashMap<String, String> mensagens;

	private Integer id;

	private CursoBean bean = new CursoBean();
	private Curso curso;

	public CursoServlet() {
		super();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			String acao = request.getParameter("acao");

			switch (acao) {

			case "salva":
				String descricao = request.getParameter("descricao");
				String horario1 = request.getParameter("horario1");
				String horario2 = request.getParameter("horario2");
				String idModalidade = request.getParameter("idModalidade");
				if (request.getParameter("id").equals("")) {
					response.sendRedirect(salva(null, descricao, horario1,
							horario2, idModalidade));
				} else {
					id = Integer.parseInt(request.getParameter("id"));
					response.sendRedirect(salva(id, descricao, horario1,
							horario2, idModalidade));
				}
				break;

			case "remove":
				id = Integer.parseInt(request.getParameter("id"));
				response.sendRedirect(remove(id));
				break;

			default:
				break;
			}
		} catch (Exception e) {
			response.sendRedirect("index.jsp");
		}

	}

	private String remove(Integer id) {
		mensagens = bean.removeCurso(id);
		return resposta(mensagens.get(mensagem), mensagens.get(classeCSS));
	}

	private String salva(Integer id, String descricao, String horario1,
			String horario2, String idModalidade) {
		curso = new Curso();
		curso.setId(id);
		curso.setDescricao(descricao);
		curso.setHorario1(horario1);
		curso.setHorario2(horario2);
		curso.setIdModalidade(idModalidade);

		mensagens = bean.salvaCurso(curso);
		return resposta(mensagens.get(mensagem), mensagens.get(classeCSS));
	}

	private String resposta(String mensagem, String classeResposta) {
		return "index.jsp?pagina=cursos&resposta=" + mensagem
				+ "&classResposta=" + classeResposta;
	}

}
