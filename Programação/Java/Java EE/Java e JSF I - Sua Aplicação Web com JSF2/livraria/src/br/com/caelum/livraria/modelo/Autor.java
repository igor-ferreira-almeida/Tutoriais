package br.com.caelum.livraria.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@Table(name = "AUTOR")
@ToString
public class Autor implements Serializable {

	private static final long serialVersionUID = 8252418215841633555L;

	@Column(name = "ID")
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "NOME")
	private String nome;
}
