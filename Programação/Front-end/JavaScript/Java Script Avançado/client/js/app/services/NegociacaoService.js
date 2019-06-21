class NegociacaoService {

    constructor() {
        this._http = new HttpService();
    }

    listNegociacoesSemana() {
        let promise = new Promise((resolve, reject) => {
            this._http.get("negociacoes/semana").then(negociacoes => {
                resolve(negociacoes.map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)))
            }).catch(erro => {
                console.log(erro);
                reject("Não foi possível obter as negociações da semana");
            });
        });

        return promise;
    }

    listNegociacoesSemanaAnterior() {
        let promise = new Promise((resolve, reject) => {
            this._http.get("negociacoes/anterior").then(negociacoes => {
                resolve(negociacoes.map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)))
            }).catch(erro => {
                console.log(erro);
                reject("Não foi possível obter as negociações da semana anterior");
            });
        });

        return promise;
    }

    listNegociacoesSemanaRetrasada() {
        let promise = new Promise((resolve, reject) => {
            this._http.get("negociacoes/retrasada").then(negociacoes => {
                resolve(negociacoes.map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)))
            }).catch(erro => {
                console.log(erro);
                reject("Não foi possível obter as negociações da semana retrasada");
            });
        });      

        return promise;
    }
}