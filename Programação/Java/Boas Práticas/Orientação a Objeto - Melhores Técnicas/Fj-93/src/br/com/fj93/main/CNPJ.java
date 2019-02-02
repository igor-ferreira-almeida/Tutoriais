package br.com.fj93.main;

public class CNPJ implements Documento {

    private String valor;
    
    public CNPJ(String valor) {
		this.valor = valor;
	}

	public boolean isValido() {
        return primeiroDigitoVerificador() == primeiroDigitoCorreto() && segundoDigitoVerificador() == segundoDigitoCorreto();
    }
    
    private int primeiroDigitoCorreto() {
        // Calcula o primeiro dígito verificador correto para
        // o CNPJ armazenado no atributo valor
        return 0;
    }
    private int primeiroDigitoVerificador() {
        // Extrai o primeiro dígito verificador do CNPJ armazenado
        // no atributo valor
        return 0;
    }
    
    private int segundoDigitoCorreto() {
        // Calcula o segundo dígito verificador correto para
        // o CNPJ armazenado no atributo valor
        return 0;
    }
    private int segundoDigitoVerificador() {
        // Extrai o segundo dígito verificador do CNPJ armazenado
        // no atributo valor
        return 0;
    }
    
    public String getValor() {
        return this.valor;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CNPJ other = (CNPJ) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return valor;
	} 
}
