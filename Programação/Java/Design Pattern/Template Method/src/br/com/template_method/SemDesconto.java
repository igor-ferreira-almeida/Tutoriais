package br.com.template_method;
public class SemDesconto implements Desconto {

	public double desconta(Orcamento orcamento) {
		return 0;
	}

	public void setProximo(Desconto desconto) {
		// nao tem!
	}
}