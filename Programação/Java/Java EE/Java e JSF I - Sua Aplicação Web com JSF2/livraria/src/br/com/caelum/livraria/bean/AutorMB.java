package br.com.caelum.livraria.bean;

import java.io.Serializable;

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

	public void gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		new DAO<Autor>(Autor.class).adiciona(this.autor);
	}
}
