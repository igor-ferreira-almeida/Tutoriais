package br.com.fj93.main;

public class HashSet implements Iteravel {
	public Object proximo() {
		return null;
	}

	@Override
	public Iterador percorreColecao() {
		return new SequenciaDeElementoHashSet(new HashSet());
	}
}
