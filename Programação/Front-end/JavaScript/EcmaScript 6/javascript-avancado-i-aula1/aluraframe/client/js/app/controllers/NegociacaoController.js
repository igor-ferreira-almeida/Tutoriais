
class NegociacaoController {

  constructor() {
    let $ = document.querySelector.bind(document);

    this._form = $(".form");
    this._inputData = $("#data");
    this._inputQuantidade = $("#quantidade");
    this._inputValor = $("#valor");
    this._listaNegociacoes = new ListaNegociacoes();
    this._negociacaoView = new NegociacaoView($("#negociacoesView"));

    this._negociacaoView.update(this._listaNegociacoes);
  }

  adiciona(event) {
    event.preventDefault();

    let negociacao = this._criaNegociacao();

    this._listaNegociacoes.adiciona(negociacao);
    this._limpaFormulario();
    this._negociacaoView.update(this._listaNegociacoes);

    // this._listaNegociacoes.negociacoes.length = 0;
    console.log(this._listaNegociacoes.negociacoes);
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
