package br.com.fj93.main;

public class CPF implements Documento {
    private String valor;

    public CPF(String valor) {
      this.valor = valor;
    }

    public String getValor() {
      return this.valor;
    }

    public boolean equals(Object o) {
      if (!(o instanceof CPF)) {
        return false;
      }
      CPF outro = (CPF) o;
      return this.valor.equals(outro.valor);
    }

    public int hashCode() {
      return this.valor.hashCode();
    }

    private boolean primeiroDigitoVerificadoEstaCorreto() {
    	return false;
    }

    private boolean segundoDigitoVerificadorEstaCorreto() {
    	return false;
    }

	@Override
	public boolean isValido() {
	      return primeiroDigitoVerificadoEstaCorreto()
	              && segundoDigitoVerificadorEstaCorreto();
	    }
  }
