package br.com.casadocodigo.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode(exclude = "quantidade")
@NoArgsConstructor
public class CarrinhoItem {
	
	@Getter
	@Setter
	private Livro livro;
	
	@Getter
	@Setter
	private Integer quantidade;
		
	public CarrinhoItem(Livro livro) {
		this.livro = livro;
		this.quantidade = 1;
	}
}
