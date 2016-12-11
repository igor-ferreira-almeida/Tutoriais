package br.com.strategy;

public class Gasolina implements Combustivel {

	@Override
	public double calculaValorPorQuantidadeLitro(double quantidadeDeLitros) {
		return quantidadeDeLitros * 3.099;
	}

}
