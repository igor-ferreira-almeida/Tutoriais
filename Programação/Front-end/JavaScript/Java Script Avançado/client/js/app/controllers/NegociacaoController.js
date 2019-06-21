
class NegociacaoController {

  constructor() {
    let $ = document.querySelector.bind(document);

    this._form = $(".form");
    this._inputData = $("#data");
    this._inputQuantidade = $("#quantidade");
    this._inputValor = $("#valor");

    this._listaNegociacoes = new Bind(
      new ListaNegociacoes(),
      new NegociacaoView($("#negociacoesView")),
      'adiciona', 'esvazia'
    );

    this._mensagem = new Bind(new Mensagem(), new MensagemView($("#mensagemView")), 'texto');
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
    let negociacao = this._criaNegociacao();
    this._listaNegociacoes.adiciona(negociacao);
    this._mensagem.texto = "Negociação adicionada com sucesso";
    this._limpaFormulario();

    console.log(this._listaNegociacoes.negociacoes);
  }

  apaga() {
    this._listaNegociacoes.esvazia();
    this._mensagem.texto = "Negociações apagadas com sucesso";
  }

  _criaNegociacao() {
    return new Negociacao(
      DateHelper.textoParaData(this._inputData.value),
      this._inputQuantidade.value,
      this._inputValor.value
    );
  }

  _limpaFormulario() {
    this._form.reset();
    this._inputData.focus();
  }
}
