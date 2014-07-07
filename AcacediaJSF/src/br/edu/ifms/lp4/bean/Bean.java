package br.edu.ifms.lp4.bean;

import java.util.List;

public interface Bean<T> {

	public String aoEditar(T objeto);

	public String aoCadastrar();

	public String aoExcluir(T objeto);

	public void salva();

	public void edita();

	public void exclui();

	public List<T> getLista();
}
