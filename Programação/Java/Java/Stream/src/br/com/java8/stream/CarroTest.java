package br.com.java8.stream;

public class CarroTest {

	public static void main(String[] args) {
		Carro carro = new Carro();
		Carro carro2 = new Carro();
		
		carro.setId(1L);
		carro2.setId(1L);
		
		carro2.setModelo("Koenigsegg");
		carro.setModelo("Murciélago");
		
		System.out.println(carro);
		System.out.println(carro.equals(carro2));
		
		char c = 0x1a;
		
		System.out.println(c);
	}

}
