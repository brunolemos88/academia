package br.edu.ifms.lp4.service;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifms.lp4.bean.EquipamentoBean;
import br.edu.ifms.lp4.bean.ModalidadeBean;
import br.edu.ifms.lp4.modelo.Equipamento;
import br.edu.ifms.lp4.modelo.Modalidade;

@WebServlet(name = "equipamento", urlPatterns = { "/equipamento" })
public class EquipamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String mensagem = "mensagem";
	private String classeCSS = "classeCSS";
	private HashMap<String, String> mensagens;

	private Integer id;

	private EquipamentoBean bean = new EquipamentoBean();
	private Equipamento equipamento;

	public EquipamentoServlet() { 
		super();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			String acao = request.getParameter("acao");
			
			switch (acao) {
			case "salva":
				String descricao = request.getParameter("descricao");
				String idModalidade = request.getParameter("idModalidade");
				String qtdEstoque = request.getParameter("qtdEstoque");
				if (request.getParameter("id").equals("")) {
					response.sendRedirect(salva(descricao, null, qtdEstoque, idModalidade));
				} else {
					id = Integer.parseInt(request.getParameter("id"));
					response.sendRedirect(salva(descricao, id, qtdEstoque, idModalidade));
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
		mensagens = bean.removeEquipamento(id);
		return resposta(mensagens.get(mensagem), mensagens.get(classeCSS));
	}

	private String salva(String descricao, Integer id, String qtdEstoque, String idModalidade) {
		equipamento = new Equipamento();
		equipamento.setDescricao(descricao);
		equipamento.setId(id);
		equipamento.setQtdEstoque(qtdEstoque);
		
		try {
			ModalidadeBean modalidadeBean = new ModalidadeBean();
			Modalidade modalidade = modalidadeBean.recuperaModalidade(Integer.parseInt(idModalidade));
			equipamento.setModalidade(modalidade);
		} catch (Exception e) {}
		

		mensagens = bean.salvaEquipamento(equipamento);
		return resposta(mensagens.get(mensagem), mensagens.get(classeCSS));
	}

	private String resposta(String mensagem, String classeResposta) {
		return "index.jsp?pagina=equipamentos&resposta=" + mensagem
				+ "&classResposta=" + classeResposta;
	}

}
