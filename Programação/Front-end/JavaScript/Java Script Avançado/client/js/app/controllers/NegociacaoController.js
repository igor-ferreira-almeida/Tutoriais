
class NegociacaoController {

  constructor() {
    let $ = document.querySelector.bind(document);

    this._form = $(".form");
    this._inputData = $("#data");
    this._inputQuantidade = $("#quantidade");
    this._inputValor = $("#valor");

    this._ordemAtual = '';

    this._listaNegociacoes = new Bind(
      new ListaNegociacoes(),
      new NegociacaoView($("#negociacoesView")),
      'adiciona', 'esvazia', 'ordena', 'inverteOrdem'
    );

    this._mensagem = new Bind(new Mensagem(), new MensagemView($("#mensagemView")), 'texto');
    ConnectionFactory.getConnection().then(connection => {
      new NegociacaoDAO(connection).listaTodas().then(negociacoes => {
        negociacoes.forEach(negociacao => {
          this._listaNegociacoes.adiciona(negociacao);
        });
      });
    }).catch(erro => this._mensagem.texto = erro);

  }

  importar() {
    let service = new NegociacaoService();

    service.listNegociacoes()
      .then(negociacoes => {
        negociacoes.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));
        this._mensagem.texto = "Negociações importadas com sucesso";
      }).catch(erro => this._mensagem.texto = erro);
  }

  adiciona(event) {
    event.preventDefault();

    ConnectionFactory.getConnection()
      .then(connection => {
        let negociacao = this._criaNegociacao();
        let dao = new NegociacaoDAO(connection);
        dao.adiciona(negociacao).then(() => {
          this._listaNegociacoes.adiciona(negociacao);
          this._mensagem.texto = "Negociação adicionada com sucesso";
          this._limpaFormulario();
        });
      }).catch(erro => this._mensagem.texto = erro);

    // try {
    //   let negociacao = this._criaNegociacao();
    //   this._listaNegociacoes.adiciona(negociacao);
    //   this._mensagem.texto = "Negociação adicionada com sucesso";
    //   this._limpaFormulario();

    // } catch (erro) {
    //   this._mensagem.texto = erro;
    // }
  }

  apaga() {
    this._listaNegociacoes.esvazia();
    this._mensagem.texto = "Negociações apagadas com sucesso";
  }

  ordena(coluna) {
    if (this._ordemAtual == coluna) {
      this._listaNegociacoes.inverteOrdem();
    } else {
      this._listaNegociacoes.ordena((a, b) => a[coluna] - b[coluna]);
    }
    this._ordemAtual = coluna;
  }

  _criaNegociacao() {
    return new Negociacao(
      DateHelper.textoParaData(this._inputData.value),
      parseInt(this._inputQuantidade.value),
      parseFloat(this._inputValor.value)
    );
  }

  _limpaFormulario() {
    this._form.reset();
    this._inputData.focus();
  }
}
