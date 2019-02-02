package br.com.fj93.teste;

import java.util.ArrayList;

import br.com.fj93.main.Pagamento;
import br.com.fj93.main.Pagamentos;

public class TestaPagamento {

	public static void main(String[] args) {
		Pagamentos pagamentos = new Pagamentos();
		
		Pagamento pagamento1 = new Pagamento();
		Pagamento pagamento2 = new Pagamento();
		
		pagamento1.setValor(105);
		pagamento2.setValor(25);
		
		pagamentos.registra(pagamento1);
		pagamentos.registra(pagamento2);
		
		System.out.println("Valor total pago: " + pagamentos.getValorPago());
		
		Iterable<Pagamento> lista = new Pagamentos();
		
		for (Pagamento pagamento : lista) {
			System.out.println(pagamento.getValor());
		}
	}

}
