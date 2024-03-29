class NegociacaoController {
    private _inputData: JQuery;
    private _inputQuantidade: JQuery;
    private _inputValor: JQuery;
    private _negociacoes: Negociacoes;
    private _negociacaoView: NegociacaoView;
    private _mensagemView: MensagemView;

    constructor() {
        this._inputData = $("#data");
        this._inputQuantidade = $("#quantidade");
        this._inputValor = $("#valor");
        this._negociacoes = new Negociacoes();

        this._negociacaoView = new NegociacaoView("#negociacaoView");
        this._negociacaoView.update(this._negociacoes);

        this._mensagemView = new MensagemView("#mensagemView");
    }

    adiciona(event: Event) {
        event.preventDefault();
        const negociacao = new Negociacao(
            new Date(this._inputData.val().replace(/-/g, ",")), 
            parseInt(this._inputQuantidade.val()), 
            parseFloat(this._inputValor.val())
        );

        this._negociacoes.adiciona(negociacao);
        this._negociacaoView.update(this._negociacoes);
        this._mensagemView.update("Negociação adicionada com sucesso");
    }
}