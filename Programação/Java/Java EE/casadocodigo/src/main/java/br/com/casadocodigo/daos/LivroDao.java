package br.com.casadocodigo.daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.casadocodigo.models.Livro;

public class LivroDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Livro livro) {
		manager.persist(livro);
	}
	
	public List<Livro> listAll() {
		TypedQuery<Livro> query = manager.createNamedQuery("Livro.listAll", Livro.class);
		
		return query.getResultList();
	}
}
