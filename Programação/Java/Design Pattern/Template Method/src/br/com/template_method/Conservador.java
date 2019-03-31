package br.com.template_method;
class Conservador implements Investimento {
	public double calcula(Conta conta) {
		return conta.getSaldo() * 0.008;
	}
}