package br.com.fj93.teste;

import br.com.fj93.main.Arquivo;
import br.com.fj93.main.BalancoEmpresa;
import br.com.fj93.main.CNPJ;
import br.com.fj93.main.Divida;
import br.com.fj93.main.Pagamento;

public class MinhaAplicacao {
    public static void main(String[] args) {
      // BancoDeDados bd = new BancoDeDados("servidor", "usuario", "senha");
      Arquivo bd = new Arquivo();
      BalancoEmpresa balanco = new BalancoEmpresa(bd);
      registraDividas(balanco);
      realizaPagamentos(balanco);
      // bd.desconecta();
    }
    private static void registraDividas(BalancoEmpresa balanco) {
      Divida d1 = new Divida();
      Divida d2 = new Divida();
      // preenche dados das dividas
      balanco.registraDivida(d1);
      balanco.registraDivida(d2);
    }
    private static void realizaPagamentos(BalancoEmpresa balanco) {
      Pagamento p1 = new Pagamento();
      Pagamento p2 = new Pagamento();
      CNPJ credor = new CNPJ("00.000.000/0001-01");
      // preenche dados dos pagamentos
      balanco.pagaDivida(credor, p1);
      balanco.pagaDivida(credor, p2);
    }
  }
