package br.edu.ifms.lp4.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.ifms.lp4.jpa.dao.ModalidadeDao;
import br.edu.ifms.lp4.modelo.Modalidade;
import br.edu.ifms.lp4.util.JSFUtil;

@ManagedBean
@SessionScoped
public class ModalidadeBean implements Bean<Modalidade> {

	private ModalidadeDao modalidadeDao = new ModalidadeDao();

	private Modalidade modalidade = new Modalidade();

	private List<Modalidade> modalidades;

	//private CursoBean cursoBean;

	private boolean preenchido = false;

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	@Override
	public void salva() {
		preenchido = false;
		if (!modalidadeDao.salva(modalidade)) {
			JSFUtil.addErrorMessage("mensagem",
					"Ocorreu um erro ao tentar salvar a modalidade no banco de dados.");
		} else {
			JSFUtil.addSuccessMessage("mensagem", "Modalidade salva com sucesso!");
		}
	}

	@Override
	public void exclui() {
		//getCursoBean().excluiModalidadecoesDaModalidade(modalidade);
		if (!modalidadeDao.remove(modalidade)) {
			JSFUtil.addErrorMessage("mensagem",
					"Ocorreu um erro ao tentar excluir a modalidade no banco de dados.");
		} else {
			JSFUtil.addSuccessMessage("mensagem",
					"Modalidade excluída com sucesso!");
			preenchido = false;
		}

	}

	@Override
	public String aoEditar(Modalidade modalidade) {
		this.modalidade = modalidade;
		return "editarModalidade.jsf";
	}

	@Override
	public void edita() {
		preenchido = false;
		if (!modalidadeDao.atualiza(modalidade)) {
			JSFUtil.addErrorMessage("mensagem",
					"Ocorreu um erro ao tentar editar a modalidade no banco de dados.");
		} else {
			JSFUtil.addSuccessMessage("mensagem", "Modalidade editada com sucesso!");
		}

	}

	@Override
	public String aoCadastrar() {
		modalidade = new Modalidade();
		return "cadastrarModalidade.jsf";
	}

	@Override
	public List<Modalidade> getLista() {
		if (modalidades == null || !preenchido) {
			modalidades = modalidadeDao.recuperaTodos(false, "descricao");
			preenchido = true;
		}
		return modalidades;
	}

	@Override
	public String aoExcluir(Modalidade modalidade) {
		this.modalidade = modalidade;
		return "Deseja realmente excluir esta modalidade?";
	}
}
