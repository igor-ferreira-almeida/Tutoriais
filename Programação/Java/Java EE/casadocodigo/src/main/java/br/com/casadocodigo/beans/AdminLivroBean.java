package br.com.casadocodigo.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.casadocodigo.daos.AutorDao;
import br.com.casadocodigo.daos.LivroDao;
import br.com.casadocodigo.models.Autor;
import br.com.casadocodigo.models.Livro;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class AdminLivroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private Livro livro = new Livro();
	
	@Inject
	private LivroDao livroDao;
	
	@Inject
	private AutorDao autorDao;
	
	@Transactional
	public String salvar() {
		livroDao.salvar(livro);
		livro = new Livro();
		
		return "/livros/lista?faces-redirect=true";
	}
	
	public List<Autor> getAutores() {
		return autorDao.listAll();
	}
}
