class NegociacaoControllerSemJquery {
    constructor() {
        this._inputData = document.querySelector("#data");
        this._inputQuantidade = document.querySelector("#quantidade");
        this._inputValor = document.querySelector("#valor");
        this._negociacoes = new Negociacoes();
        this._negociacaoView = new NegociacaoView("#negociacaoView");
        this._negociacaoView.update(this._negociacoes);
        this._mensagemView = new MensagemView("#mensagemView");
    }
    adiciona(event) {
        event.preventDefault();
        const negociacao = new Negociacao(new Date(this._inputData.value.replace(/-/g, ",")), parseInt(this._inputQuantidade.value), parseFloat(this._inputValor.value));
        this._negociacoes.adiciona(negociacao);
        this._negociacaoView.update(this._negociacoes);
        this._mensagemView.update("Negociação adicionada com sucesso");
    }
}
