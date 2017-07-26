package br.com.casadocodigo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(exclude = "nome")
@NamedQuery(name = "Autor.listAll", query = "SELECT a FROM Autor a ORDER BY a.nome")
@NoArgsConstructor
@Table(name = "autores")
@ToString
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_autor")
	@SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor", allocationSize = 1)
	private Long id;
	
	private String nome;
	
	public Autor(Long id) {
		this.id = id;
	}
	
}
