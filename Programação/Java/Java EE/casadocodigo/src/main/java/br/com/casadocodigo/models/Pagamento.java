package br.com.casadocodigo.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Pagamento {
	@Getter
	@Setter
	private BigDecimal value;
}
