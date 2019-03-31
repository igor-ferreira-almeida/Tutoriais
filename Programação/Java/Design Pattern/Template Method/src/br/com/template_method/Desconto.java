package br.com.template_method;

public interface Desconto {
	double desconta(Orcamento orcamento);
	void setProximo(Desconto desconto);
}
