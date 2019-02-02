package br.com.fj93.main;
import java.text.NumberFormat;
import java.util.Locale;

public class RelatorioDivida {

	private Divida divida;

	public RelatorioDivida(Divida divida) {
		this.divida = divida;
	}

	public void gera(NumberFormat formatador) {
		System.out.println("CNPJ credor: " + divida.getDocumentoCredor());
		System.out.println("Credor: " + divida.getCredor());
		
		System.out.println("Valor da dívida: " + formatador.format(divida.getTotal()));
		System.out.println("Valor da dívida: " + formatador.format(divida.getValorPago()));
	}
	
	public static void main(String[] args) {
		Divida divida = new Divida();
		
		divida.setCredor("Uma Empresa");
		divida.setTotal(100);
		divida.setDocumentoCredor(new CNPJ("00.000.001/0001-01"));
		
		Pagamento pagamento = new Pagamento(); 
		
		pagamento.setCnpjPagador("00.000.002/0001-02");
		pagamento.setPagador("Outra Empresa");
		pagamento.setValor(20);
		
		divida.registra(pagamento);
		
		RelatorioDivida relatorio = new RelatorioDivida(divida);
		relatorio.gera(NumberFormat.getCurrencyInstance(new Locale("pt", "BR")));
		
	}
}
