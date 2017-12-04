package br.com.java8.stream;

public enum TipoValidadorCaracter {
	
	LETRAS("[a-zA-Z .]*"),
	LETRAS_E_NUMEROS("[a-zA-Z0-9 .,]*"),
	LETRAS_COM_ACENTOS("[a-zA-ZáéíóúêâîôûãõÁÉÍÓÚÂ .]*"), 
	LETRAS_COM_ACENTOS_E_NUMEROS("[a-zA-Z0-9áéíóúêâîôûãõÁÉÍÓÚÂ .]*");
	
	private String pattern;
	
	private TipoValidadorCaracter(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
}
