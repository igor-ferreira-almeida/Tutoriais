package br.com.casadocodigo.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.daos.LivroDao;
import br.com.casadocodigo.models.Livro;
import lombok.Getter;
import lombok.Setter;

@Model
public class DetalheProdutoBean {
	
	@Inject
	private LivroDao livroDao;
	
	@Getter
	@Setter
	private Livro livro = new Livro();
	
	@Getter
	@Setter
	private Long id;
	
	public void carregaDetalhe() {
		livro = livroDao.buscaPorId(id);
	}
	
}
