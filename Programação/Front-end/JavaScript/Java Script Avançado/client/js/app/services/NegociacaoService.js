class NegociacaoService {

    listNegociacoesSemana(callback) {
        let xhr = new XMLHttpRequest();
        xhr.open("GET", "negociacoes/semana");

        xhr.onreadystatechange = () => {
            // 0: requisição ainda não iniciada.
            // 1: conexão com o servidor estabelecida.
            // 2: requisição recebida.
            // 3: processando requisição.
            // 4: requisição concluída e a resposta esta pronta.
            if (xhr.readyState == EstadoRequisicao.REQUISICAO_CONCLUIDA_E_RESPOSTA_PRONTA) {
                if (xhr.status == 200) {
                    console.log("obtendo as negociações do servidor...");
                    let negociacaoJson = JSON.parse(xhr.responseText);
                    callback(null, negociacaoJson.map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)));
                } else {
                    console.log(xhr.responseText);
                    callback("Não foi possível obter as negociações do servidor");
                }
            }
        };

        xhr.send();
    }
}