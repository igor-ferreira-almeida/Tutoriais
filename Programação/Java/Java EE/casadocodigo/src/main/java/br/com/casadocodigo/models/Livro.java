package br.com.casadocodigo.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(exclude = {"titulo", "descricao", "preco", "numeroDePaginas"})
@NoArgsConstructor
@Table(name = "livros")
@ToString
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_livro")
	@SequenceGenerator(name = "seq_livro", sequenceName = "seq_livro", allocationSize = 1)
	private Long id;
	
	private String titulo;
	
	@Lob
	private String descricao;
	
	private BigDecimal preco;
	
	@Column(name = "numero_de_paginas")
	private Integer numeroDePaginas;
	
	@JoinTable(
		name = "livros_autores", 
		joinColumns = {@JoinColumn(name = "livro_id")},
		inverseJoinColumns = {@JoinColumn(name = "autor_id")}
	)
	@ManyToMany
	private List<Autor> autores = new ArrayList<>();
	
}
