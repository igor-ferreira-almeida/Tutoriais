package br.com.livraria.manager;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.livraria.model.Livro;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class LivroMB implements Serializable {
	
	private static final long serialVersionUID = -481372658741720108L;
	
	@Getter
	@Inject
	@Setter
	private Livro livro;
	
	public void gravar() {
		System.out.println(livro);
	}
}
