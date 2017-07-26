package br.com.casadocodigo.beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.casadocodigo.daos.LivroDao;
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
	
	@Transactional
	public void salvar() {
		livroDao.salvar(livro);
		System.out.println("Livro cadastrado: " + livro);
	}
}
