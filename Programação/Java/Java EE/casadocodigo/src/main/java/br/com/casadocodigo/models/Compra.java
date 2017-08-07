package br.com.casadocodigo.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(exclude = {"usuario", "itens"})
@NoArgsConstructor
@Table(name = "compras")
@ToString
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_compra")
	@SequenceGenerator(name = "seq_compra", sequenceName = "seq_compra", allocationSize = 1)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Usuario usuario;
	
	private String itens;
}
