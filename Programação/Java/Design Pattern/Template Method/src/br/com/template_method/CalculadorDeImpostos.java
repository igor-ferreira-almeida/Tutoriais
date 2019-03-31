package br.com.template_method;
public class CalculadorDeImpostos {

	public void realizaCalculo(Orcamento orcamento, Imposto imposto) {

		double valor = imposto.calcula(orcamento);

		System.out.println(valor);

	}

}