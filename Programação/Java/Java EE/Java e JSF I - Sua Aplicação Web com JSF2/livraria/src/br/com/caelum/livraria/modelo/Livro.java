package br.com.caelum.livraria.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@Table(name = "LIVRO")
@ToString
public class Livro {

	@Column(name = "ID")
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "TITULO")
	private String titulo;
	
	@Column(name = "ISBN")
	private String isbn;
	
	@Column(name = "PRECO")
	private double preco;
	
	@Column(name = "DATA_LANCAMENTO")
	private String dataLancamento;

	
	@JoinTable(name="LIVRO_AUTOR",
            joinColumns={@JoinColumn(name="AUTOR_ID")},
            inverseJoinColumns={@JoinColumn(name="LIVRO_ID")})
	@ManyToMany
	private List<Autor> autores = new ArrayList<Autor>();
	
	public void adicionaAutor(Autor autor) {
		this.autores.add(autor);
	}
}