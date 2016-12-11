package br.com.strategy;

public class ValorPorQuantidadeLivroTest {

	public static void main(String[] args) {
		
		Combustivel c1 = new Alcool();
		Combustivel c2 = new Diesel();
		Combustivel c3 = new Gasolina();
		
		System.out.println(c1.calculaValorPorQuantidadeLitro(1));
		System.out.println(c2.calculaValorPorQuantidadeLitro(1));
		System.out.println(c3.calculaValorPorQuantidadeLitro(1));
		
	}

}
