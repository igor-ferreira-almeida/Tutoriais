package br.com.fj93.main;

public class Estagiario implements Funcionario {

	private double bolsa;
	private double auxilios;
	private double salarioLiquido;
	
	@Override
	public void depositaNaConta(double valor) {
		salarioLiquido = valor;
	}

	@Override
	public double getSalario() {
		return bolsa;
	}

	@Override
	public double getBeneficios() {
		return auxilios;
	}

}
