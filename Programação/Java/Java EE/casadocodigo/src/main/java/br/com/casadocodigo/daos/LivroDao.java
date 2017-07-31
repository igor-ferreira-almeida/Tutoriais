package br.com.casadocodigo.daos;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
		String jpql = "SELECT DISTINCT(l) FROM Livro l JOIN FETCH l.autores ORDER BY l.titulo";
		TypedQuery<Livro> query = manager.createQuery(jpql, Livro.class);
		
		return query.getResultList();
	}

	public List<Livro> ultimosLancamentos() {
		String jpql = "SELECT l FROM Livro l ORDER BY l.dataDaPublicacao DESC";
		
		return manager.createQuery(jpql).setMaxResults(5).getResultList();
	}

	public List<Livro> demaisLivros() {
		String jpql = "SELECT l FROM Livro l ORDER BY l.dataDaPublicacao DESC";
		
		return manager.createQuery(jpql).getResultList();
	}

	public Livro buscaPorId(Long id) {
		String jpql = "SELECT DISTINCT(l) FROM Livro l JOIN FETCH l.autores WHERE l.id = :id";
		TypedQuery<Livro> query = manager.createQuery(jpql, Livro.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}
}
