package br.com.casadocodigo.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.daos.LivroDao;
import br.com.casadocodigo.models.Carrinho;
import br.com.casadocodigo.models.CarrinhoItem;
import br.com.casadocodigo.models.Livro;
import lombok.Getter;

@Model
public class CarrinhoBean {
	
	@Inject
	private LivroDao livroDao;
	
	@Getter
	@Inject
	private Carrinho carrinho;
	
	public String add(Long id) {
		
		Livro livro = livroDao.buscaPorId(id);
		CarrinhoItem item = new CarrinhoItem(livro);
		carrinho.add(item);
		
		return "carrinho?faces-redirect=true";
	}
	
	public List<CarrinhoItem> getItens() {
		return carrinho.getItens();
	}
	
	public void remover(CarrinhoItem item) {
		carrinho.remove(item);
	}
	
}
