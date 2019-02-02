package br.com.fj93.main;

public class For {
	public void percorreColecao(Iteravel colecao) {
		Iterador sequencia = colecao.percorreColecao();
		
		sequencia.proximo();
	}
}
