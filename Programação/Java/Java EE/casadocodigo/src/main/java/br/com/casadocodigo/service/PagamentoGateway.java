package br.com.casadocodigo.service;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import br.com.casadocodigo.models.Pagamento;

public class PagamentoGateway implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public String pagar(BigDecimal total) {
		Client client = ClientBuilder.newClient();
		Pagamento pagamento = new Pagamento(total);
		String target = "http://book-payment.herokuapp.com/payment";
		Entity<Pagamento> json = Entity.json(pagamento);
		WebTarget webTarget = client.target(target);
		
		Builder request = webTarget.request();
		
		return request.post(json, String.class);
	}
}
