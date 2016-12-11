package br.com.strategy;

public class Diesel implements Combustivel {

	@Override
	public double calculaValorPorQuantidadeLitro(double quantidadeDeLitros) {
		return quantidadeDeLitros * 2.749;
	}

}
