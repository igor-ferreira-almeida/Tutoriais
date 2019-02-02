package br.com.fj93.main;

import java.util.HashMap;
import java.util.Map;

public class BancoDeDados implements ArmazenadorDeDivida {
    private Map<Documento, Divida> dividasNoBanco = new HashMap<>();

    public BancoDeDados(String endereco, String usuario, String senha) {
      System.out.println("Conectado!");
    }

    public void salva(Divida divida) {
      dividasNoBanco.put(divida.getDocumentoCredor(), divida);
    }

    public Divida carrega(Documento documentoCredor) {
      return dividasNoBanco.get(documentoCredor);
    }

    public void desconecta() {
      System.out.println("Desconectado!");
    }
  }
