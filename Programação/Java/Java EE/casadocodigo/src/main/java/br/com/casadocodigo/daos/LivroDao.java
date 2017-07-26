package br.com.casadocodigo.daos;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.casadocodigo.models.Livro;

@Stateless
public class LivroDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Livro livro) {
		manager.persist(livro);
	}
	
	@TransactionAttribute
	public List<Livro> listAll() {
		TypedQuery<Livro> query = manager.createQuery("SELECT DISTINCT(l) FROM Livro l JOIN FETCH l.autores ORDER BY l.titulo", Livro.class);
		
		return query.getResultList();
	}
}
