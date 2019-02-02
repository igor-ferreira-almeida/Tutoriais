package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class LivroMB implements Serializable {
	
	private static final long serialVersionUID = 2854886218063611857L;
	
	@Getter
	@Inject
	@Setter
	private Livro livro;
	
	@Getter
	@Setter
	private Long idAutor;
	
	private DAO<Livro> livroDAO;
	
	private DAO<Autor> autorDAO;
	
	@PostConstruct
	public void initialize() {
		livroDAO = new DAO<Livro>(Livro.class);
		autorDAO = new DAO<Autor>(Autor.class);
	}
	
	public List<Autor> getAutores() {
		return autorDAO.listaTodos();
	}

	public List<Livro> getLivros() {
		return livroDAO.listaTodos();
	}
	
	public void gravarAutor() {
		Autor autor = autorDAO.buscaPorId(idAutor);
		livro.adicionaAutor(autor);
	}
	
	public void gravar() {
		if (livro.getAutores().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Livro deve ter pelo menos um Autor."));
		}
		
		if(livro.getId() == null) {
			livroDAO.adiciona(livro);
		} else {
			livroDAO.atualiza(livro);
		}
		
		resetForm();
	}
	
	public void remover(Livro livro) {
		livroDAO.remove(livro);
	}
	
	public void removerAutor(Autor autor) {
		this.livro.removerAutor(autor);
	}
	
	public void carregar(Livro livro) {
		this.livro = livro;
	}
	
	public void validateISBN(FacesContext facesContext, UIComponent component, Object value) throws ValidatorException {
		String valor = value.toString();
		
		if(!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage("ISBN deve começar com dígito 1."));
		}
	}
	
	public String formAutor() {
		return "autor?faces-redirect=true";
	}
	
	private void resetForm() {
		livro = new Livro();
	}

}
