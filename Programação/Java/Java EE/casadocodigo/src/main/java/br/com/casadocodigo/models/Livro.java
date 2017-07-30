package br.com.casadocodigo.models;

import java.math.BigDecimal;
import java.time.LocalDate;
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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

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
	
	@NotBlank
	private String titulo;
	
	@Length(min = 10)
	@Lob
	@NotBlank
	private String descricao;
	
	@DecimalMin("20")
	private BigDecimal preco;
	
	@Column(name = "numero_de_paginas")
	@Min(70)
	private Integer numeroDePaginas;
	
	@Column(name = "data_da_publicacao")
	private LocalDate dataDaPublicacao;
	
	@Column(name = "capa_path")
	private String capaPath;
	
	@JoinTable(
		name = "livros_autores", 
		joinColumns = {@JoinColumn(name = "livro_id")},
		inverseJoinColumns = {@JoinColumn(name = "autor_id")}
	)
	@ManyToMany
	@Size(min = 1)
	@NotNull
	private List<Autor> autores = new ArrayList<>();
	
}
