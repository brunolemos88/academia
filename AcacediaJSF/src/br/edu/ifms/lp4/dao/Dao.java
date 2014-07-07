package br.edu.ifms.lp4.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {

	public boolean salva(T objeto);

	public boolean atualiza(T objeto);

	public boolean remove(T objeto);

	public T recupera(Serializable id);

	public List<T> recuperaTodos(boolean desc, String... camposOrdenacao);
}
