package br.com.casadocodigo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.casadocodigo.daos.LivroDao;
import br.com.casadocodigo.models.Livro;

@Named
@ViewScoped
public class AdminListaLivrosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LivroDao livroDao;

	private List<Livro> livros = new ArrayList<>();

	public List<Livro> getLivros() {
		livros = livroDao.listAll();

		return livros;
	}

}
