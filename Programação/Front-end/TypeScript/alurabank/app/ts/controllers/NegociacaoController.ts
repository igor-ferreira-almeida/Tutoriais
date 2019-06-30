class NegociacaoController {
    private _inputData: HTMLInputElement;
    private _inputQuantidade: HTMLInputElement;
    private _inputValor: HTMLInputElement;
    private _negociacoes: Negociacoes;
    private _negociacaoView: NegociacaoView;
    private _mensagemView: MensagemView;

    constructor() {
        this._inputData = <HTMLInputElement>document.querySelector("#data");
        this._inputQuantidade = <HTMLInputElement>document.querySelector("#quantidade");
        this._inputValor = <HTMLInputElement>document.querySelector("#valor");
        this._negociacoes = new Negociacoes();

        this._negociacaoView = new NegociacaoView("#negociacaoView");
        this._negociacaoView.update(this._negociacoes);

        this._mensagemView = new MensagemView("#mensagemView");
    }

    adiciona(event: Event) {
        event.preventDefault();
        const negociacao = new Negociacao(
            new Date(this._inputData.value.replace(/-/g, ",")), 
            parseInt(this._inputQuantidade.value), 
            parseFloat(this._inputValor.value)
        );

        this._negociacoes.adiciona(negociacao);
        this._negociacaoView.update(this._negociacoes);
        this._mensagemView.update("Negociação adicionada com sucesso");
    }
}