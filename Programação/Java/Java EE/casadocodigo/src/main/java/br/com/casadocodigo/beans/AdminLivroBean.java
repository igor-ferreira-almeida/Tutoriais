package br.com.casadocodigo.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import br.com.casadocodigo.daos.AutorDao;
import br.com.casadocodigo.daos.LivroDao;
import br.com.casadocodigo.infra.FileSaver;
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
	
	@Inject
	private LivroDao livroDao;
	
	@Inject
	private AutorDao autorDao;
	
	@Inject
	private FacesContext context;
	
	@Getter
	@Setter
	private Part capaLivro;
	
	@Transactional
	public String salvar() throws IOException {	
		livroDao.salvar(livro);
		
		FileSaver fileSaver = new FileSaver();
		String relativePath = fileSaver.write(capaLivro, "livros");
		livro.setCapaPath(relativePath);
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));
		
		return "/livros/lista?faces-redirect=true";
	}
	
	public List<Autor> getAutores() {
		return autorDao.listAll();
	}
	
	private void resetFields() {
		livro = new Livro();
	}
}
