package br.com.casadocodigo.daos;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.models.Compra;

public class CompraDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Compra compra) {
		manager.persist(compra);
	}
	
}
