package br.com.strategy;

public class Alcool implements Combustivel {

	@Override
	public double calculaValorPorQuantidadeLitro(double quantidadeDeLitros) {
		return quantidadeDeLitros * 1.999;
	}

}
