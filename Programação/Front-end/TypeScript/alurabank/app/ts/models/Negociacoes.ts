class Negociacoes {
    private _negociacoes: Array<Negociacao> = [];
    // private _negociacoes: Negociacao[] = [];

    adiciona(negociacao: Negociacao): void {
        this._negociacoes.push(negociacao);
    }

    toArray(): Array<Negociacao> {
        return [].concat(this._negociacoes);
    }
}