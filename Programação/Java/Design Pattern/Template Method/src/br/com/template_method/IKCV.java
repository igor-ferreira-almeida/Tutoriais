package br.com.template_method;

public class IKCV extends TemplateImpostoCondicional {

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500 && temItemMaiorQueCemReais(orcamento);
	}

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.1;
	}

	private boolean temItemMaiorQueCemReais(Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
			if(item.getValor() > 100) {
				return true;
			}
		}
		
		return false;
	}
}
