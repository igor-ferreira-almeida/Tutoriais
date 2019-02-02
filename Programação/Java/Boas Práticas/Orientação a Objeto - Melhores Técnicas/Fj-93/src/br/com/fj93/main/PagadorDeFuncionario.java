package br.com.fj93.main;

public class PagadorDeFuncionario {

	public void paga(Funcionario funcionario) {
		funcionario.depositaNaConta(funcionario.getSalario() + funcionario.getBeneficios());
	}
}
