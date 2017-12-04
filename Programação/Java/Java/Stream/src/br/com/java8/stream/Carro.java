package br.com.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"marca", "modelo"})
@NoArgsConstructor
public class Carro {
	
	private Long id;
	
	private String modelo;

	private String marca;

}
