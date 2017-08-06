package br.com.casadocodigo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Carrinho implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Set<CarrinhoItem> itens = new HashSet<>();
	
	public void add(CarrinhoItem item) {
		itens.add(item);
	}
	
	public List<CarrinhoItem> getItens() {
		return new ArrayList<CarrinhoItem>(itens);
	}
	
	public BigDecimal getTotalItem(CarrinhoItem item) {
		BigDecimal total = BigDecimal.ZERO;
		
		return item.getLivro().getPreco().multiply(new BigDecimal(item.getQuantidade()));
	}
	
	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		
		for (CarrinhoItem item : itens) {
			total = total.add(item.getLivro().getPreco().multiply(new BigDecimal(item.getQuantidade())));
		}
		
		return total;
	}

}
