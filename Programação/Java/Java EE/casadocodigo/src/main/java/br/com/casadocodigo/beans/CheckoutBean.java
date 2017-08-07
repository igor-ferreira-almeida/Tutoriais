package br.com.casadocodigo.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.casadocodigo.models.Carrinho;
import br.com.casadocodigo.models.Usuario;
import lombok.Getter;
import lombok.Setter;

@Model
public class CheckoutBean {
	
	@Getter
	@Setter
	private Usuario usuario = new Usuario();
	
	@Inject
	private Carrinho carrinho;
	
	@Transactional
	public void finalizar() {
		carrinho.finalizar(usuario);
	}
	
}
