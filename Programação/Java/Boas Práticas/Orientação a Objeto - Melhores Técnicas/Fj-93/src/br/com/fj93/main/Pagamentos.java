package br.com.fj93.main;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Pagamentos implements Iterable<Pagamento> {
	
	private double valorPago;
	private Collection<Pagamento> pagamentosRealizados = new ArrayList<>();

	public List<Pagamento> pagamentosAntesDe(Calendar data) {
		List<Pagamento> pagamentosFiltrados = new ArrayList<>();
		for (Pagamento pagamento : this.pagamentosRealizados) {
			if (pagamento.getData().before(data)) {
				pagamentosFiltrados.add(pagamento);
			}
		}
		return pagamentosFiltrados;
	}

	public List<Pagamento> pagamentosComValorMaiorQue(double valorMinimo) {
		List<Pagamento> pagamentosFiltrados = new ArrayList<>();
		for (Pagamento pagamento : this.pagamentosRealizados) {
			if (pagamento.getValor() > valorMinimo) {
				pagamentosFiltrados.add(pagamento);
			}
		}
		return pagamentosFiltrados;
	}

	public List<Pagamento> pagamentosDo(String cnpjPagador) {
		List<Pagamento> pagamentosFiltrados = new ArrayList<>();
		for (Pagamento pagamento : this.pagamentosRealizados) {
			if (pagamento.getCnpjPagador().equals(cnpjPagador)) {
				pagamentosFiltrados.add(pagamento);
			}
		}
		return pagamentosFiltrados;
	}

	private void paga(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Valor invalido para pagamento");
		}
		if (valor > 100) {
			valor = valor - 8;
		}
		this.valorPago += valor;
	}

	public void registra(Pagamento pagamento) {
		this.pagamentosRealizados.add(pagamento);
		paga(pagamento.getValor());
	}
	
	public boolean isRealizado(Pagamento pagamento) {
		return pagamentosRealizados.contains(pagamento);
	}

	public double getValorPago() {
		return this.valorPago;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(valorPago);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamentos other = (Pagamentos) obj;
		if (Double.doubleToLongBits(valorPago) != Double.doubleToLongBits(other.valorPago))
			return false;
		return true;
	}

	@Override
	public Iterator<Pagamento> iterator() {
		return pagamentosRealizados.iterator();
	}

}
