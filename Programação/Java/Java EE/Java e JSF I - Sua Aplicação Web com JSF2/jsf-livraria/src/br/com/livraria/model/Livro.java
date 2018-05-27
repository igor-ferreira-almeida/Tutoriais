package br.com.livraria.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Livro implements Serializable {
	
	private static final long serialVersionUID = -8789045690762454139L;

	@Getter
	@Setter
	private String titulo;
	
	@Getter
	@Setter
	private String isbn;
	
	@Getter
	@Setter
	private double preco;
	
	@Getter
	@Setter
	private String dataLancamento;
	
}
