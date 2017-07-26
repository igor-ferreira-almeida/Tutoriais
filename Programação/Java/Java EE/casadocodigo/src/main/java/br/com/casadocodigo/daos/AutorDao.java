package br.com.casadocodigo.daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.casadocodigo.models.Autor;

public class AutorDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager manager;
	
	public List<Autor> listAll() {
		TypedQuery<Autor> query = manager.createNamedQuery("Autor.listAll", Autor.class);
		
		return query.getResultList();
	}

	
}
