package br.com.fj93.main;

public class SequenciaDeElementosArrayList implements Iterador {
	
	private ArrayList colecao;
	
	public SequenciaDeElementosArrayList(ArrayList colecao) {
		this.colecao = colecao;
	}
	
	public Object proximo() {
		return null;
	}
}
