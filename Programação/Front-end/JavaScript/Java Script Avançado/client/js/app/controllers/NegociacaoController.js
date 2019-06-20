
class NegociacaoController {

  constructor() {
    let $ = document.querySelector.bind(document);

    this._form = $(".form");
    this._inputData = $("#data");
    this._inputQuantidade = $("#quantidade");
    this._inputValor = $("#valor");

    this._listaNegociacoes = new ListaNegociacoes(model => this._negociacaoView.update(model));

    this._negociacaoView = new NegociacaoView($("#negociacoesView"));
    this._mensagem = new Mensagem();
    this._mensagemView = new MensagemView($("#mensagemView"));
    this._mensagemView.update(this._mensagem);
  }

  adiciona(event) {
    event.preventDefault();
    let negociacao = this._criaNegociacao();
    this._listaNegociacoes.adiciona(negociacao);
    this._mensagem.texto = "Negociação adicionada com sucesso";
    this._mensagemView.update(this._mensagem);
    this._limpaFormulario();

    // this._listaNegociacoes.negociacoes.length = 0;
    console.log(this._listaNegociacoes.negociacoes);
  }

  apaga() {
    this._listaNegociacoes.esvazia();
    this._mensagem.texto = "Negociações apgadas com sucesso";
    this._mensagemView.update(this._mensagem);
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
