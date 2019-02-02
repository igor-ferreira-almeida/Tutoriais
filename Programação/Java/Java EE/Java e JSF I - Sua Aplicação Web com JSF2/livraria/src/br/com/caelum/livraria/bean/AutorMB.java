package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class AutorMB implements Serializable {

	private static final long serialVersionUID = -5293544885966086171L;

	@Getter
	@Inject
	@Setter
	private Autor autor;
	
	private DAO<Autor> autorDAO;

	@PostConstruct
	public void initialize() {
		autorDAO = new DAO<Autor>(Autor.class);
	}
	
	public void gravar() {
		if(autor.getId() == null) {
			autorDAO.adiciona(autor);
		} else {
			autorDAO.atualiza(autor);
		}
		resetForm();
	}
	
	private void resetForm() {
		autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return autorDAO.listaTodos();
	}
	
	public void carregar(Autor autor) {
		this.autor = autor;
	}
	
	public void remover(Autor autor) {
		autorDAO.remove(autor);
	}
}
