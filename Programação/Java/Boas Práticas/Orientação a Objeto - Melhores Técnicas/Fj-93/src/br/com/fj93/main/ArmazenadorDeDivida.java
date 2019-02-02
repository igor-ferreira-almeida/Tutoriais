package br.com.fj93.main;

public interface ArmazenadorDeDivida {
	void salva(Divida divida);
	Divida carrega(Documento documentoCredor);
}
