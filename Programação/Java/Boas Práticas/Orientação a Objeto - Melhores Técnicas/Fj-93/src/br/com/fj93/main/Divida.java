package br.com.fj93.main;
public class Divida {
	
	private double total;
	private String credor;
	private Documento documentoCredor;
	private Pagamentos pagamentos = new Pagamentos();

	public double getTotal() {
		return this.total;
	}

	public String getCredor() {
		return this.credor;
	}

	public Documento getDocumentoCredor() {
		return documentoCredor;
	}
	
	public void setDocumentoCredor(Documento cnpjCredor) {
		this.documentoCredor = cnpjCredor;
	}

	public void setCredor(String credor) {
		this.credor = credor;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setPagamentos(Pagamentos pagamentos) {
		this.pagamentos = pagamentos;
	}

	public void registra(Pagamento pagamento) {
		pagamentos.registra(pagamento);
	}

	public double getValorPago() {
		return pagamentos.getValorPago();
	}
}