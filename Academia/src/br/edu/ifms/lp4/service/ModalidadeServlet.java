package br.edu.ifms.lp4.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifms.lp4.jpa.dao.ModalidadeDao;
import br.edu.ifms.lp4.modelo.Modalidade;

@WebServlet(name = "modalidade", urlPatterns = { "/modalidade" })
public class ModalidadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String resposta = "";
	private String classResposta = "";

	public ModalidadeServlet() {
		super();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		ModalidadeDao modalidadeDao = new ModalidadeDao();

		modalidadeDao.remove(modalidadeDao.recupera(id));

		resposta = "Removido com sucesso!";
		classResposta = "alert alert-success";

		response.sendRedirect("index.jsp?pagina=modalidades&resposta="
				+ resposta + "&classResposta=" + classResposta);

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String descricao = request.getParameter("descricao");

		if (!descricao.isEmpty()) {
			try {
				Modalidade modalidade = new Modalidade();

				modalidade.setDescricao(descricao);
				ModalidadeDao modalidadeDao = new ModalidadeDao();
				modalidadeDao.salva(modalidade);

				resposta = "Salvo com sucesso!";
				classResposta = "alert alert-success";
			} catch (Exception e) {
				e.printStackTrace();
				classResposta = "alert alert-error";
				resposta = "Ocorreu um erro ao tentar realizar o cadastro.";
			}
		} else {
			classResposta = "alert alert-error";
			resposta = "Dados incompletos!";
		}
		response.sendRedirect("index.jsp?pagina=modalidades&resposta="
				+ resposta + "&classResposta=" + classResposta);
	}

}
