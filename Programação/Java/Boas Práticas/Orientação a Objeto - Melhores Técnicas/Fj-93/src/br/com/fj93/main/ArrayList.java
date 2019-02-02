package br.com.fj93.main;

public class ArrayList implements Iteravel {
	public Object proximo() {
		return null;
	}

	@Override
	public Iterador percorreColecao() {
		return new SequenciaDeElementosArrayList(new ArrayList());
	}
}
