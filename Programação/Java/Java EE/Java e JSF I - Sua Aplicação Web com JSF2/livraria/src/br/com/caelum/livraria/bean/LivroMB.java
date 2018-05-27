package br.com.caelum.livraria.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.DAO;
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

	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			throw new RuntimeException("Livro deve ter pelo menos um Autor.");
		}

		new DAO<Livro>(Livro.class).adiciona(this.livro);
	}

}
