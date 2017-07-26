package br.com.casadocodigo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
@RequestScoped
public class AdminLivroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private Livro livro = new Livro();
	
	@Getter
	@Setter
	private List<Long> autoresId = new ArrayList<>();
	
	@Inject
	private LivroDao livroDao;
	
	@Inject
	private AutorDao autorDao;
	
	@Inject
	private FacesContext context;
	
	@Transactional
	public String salvar() {
		
		autoresId.forEach(autorId -> livro.getAutores().add(new Autor(autorId)));
		
		livroDao.salvar(livro);
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));
		
		return "/livros/lista?faces-redirect=true";
	}
	
	public List<Autor> getAutores() {
		return autorDao.listAll();
	}
	
	private void resetFields() {
		livro = new Livro();
		autoresId = new ArrayList<>();
	}
}
