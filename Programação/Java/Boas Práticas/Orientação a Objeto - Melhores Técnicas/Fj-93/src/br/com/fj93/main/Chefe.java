package br.com.fj93.main;

public class Chefe implements Funcionario {

	private double salario;
	private double bonificacao;
	private double salarioLiquido;
	
	@Override
	public void depositaNaConta(double valor) {
		salarioLiquido = valor;
	}

	@Override
	public double getSalario() {
		return salario;
	}

	@Override
	public double getBeneficios() {
		return bonificacao;
	}

}
