package br.edu.ifms.lp4.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifms.lp4.bean.ModalidadeBean;
import br.edu.ifms.lp4.jpa.dao.ModalidadeDao;
import br.edu.ifms.lp4.modelo.Modalidade;

@WebServlet(name = "modalidade", urlPatterns = { "/modalidade" })
public class ModalidadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModalidadeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// String descricao = request.getParameter("descricao");
		// String resposta = "";
		//
		// if (descricao != null && !descricao.isEmpty()) {
		// Modalidade modalidade = new Modalidade();
		// modalidade.setDescricao(descricao);
		//
		// ModalidadeBean modalidadeBean = new ModalidadeBean();
		// resposta = modalidadeBean.salvaModalidade(modalidade) ?
		// "Salvo com sucesso!" : "Erro ao gravar";
		// }else{
		// resposta = "Nenhuma descrição informada";
		// }
		//
		// response.sendRedirect("index.jsp?resposta=" + resposta);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse response)
			throws ServletException, IOException {
		super.service(arg0, response);

		ModalidadeBean modalidadeBean = new ModalidadeBean();
		Modalidade modalidade = modalidadeBean.recuperaModalidade(1);
	
		response.sendRedirect("index.jsp?resposta=" + modalidadeBean.deletaModalidade(modalidade));
	}

}
