
class HttpService {
    get(url) {
        return new Promise((resolve, reject) => {
            let xhr = new XMLHttpRequest();
            xhr.open("GET", url);

            xhr.onreadystatechange = () => {
                if (xhr.readyState == EstadoRequisicao.REQUISICAO_CONCLUIDA_E_RESPOSTA_PRONTA) {
                    if (xhr.status == 200) {
                        resolve(JSON.parse(xhr.responseText));
                    } else {
                        reject(xhr.responseText);
                    }
                }
            };

            xhr.send();
        });
    }
}