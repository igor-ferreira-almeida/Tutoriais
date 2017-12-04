package br.com.java8.stream;

public class FormatadorDeCaracteres {
	
	public String removeCaracteresInvalidosPorPadrao(String texto, TipoValidadorCaracter tipoValidador) {
		
		String padrao = tipoValidador.getPattern();
		
		if(texto.matches(padrao)) {
			return texto;
		} else {
			StringBuilder caracteresFormatados = new StringBuilder();
			
			for (int i = 0; i < texto.length(); i++) {
				String character = new Character(texto.charAt(i)).toString();
				
				if(character.matches(padrao)) {
					caracteresFormatados.append(character);
				}
			}
			
			return caracteresFormatados.toString();
		}
	}	
}
