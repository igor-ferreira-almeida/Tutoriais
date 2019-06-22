var ConnectionFactory = (function () {

    const STORES = ["negociacao"];
    const VERSION = 6;
    const DBNAME = "aluraframe";

    var connection = null;
    var close = null;

    return class ConnectionFactory {

        constructor() {
            throw new Error("Não é possível criar instâncias de ConnectionFactory");
        }

        static getConnection() {
            return new Promise((resolve, reject) => {
                let openRequest = window.indexedDB.open(DBNAME, VERSION);

                openRequest.onupgradeneeded = e => {
                    ConnectionFactory._createStores(e.target.result);
                };

                openRequest.onsuccess = e => {
                    if (!connection) {
                        let connection = e.target.result;
                        close = connection.close.bind(connection);
                        connection.close = function() {
                            throw new Error("Você não pode fechar diretamente a conexão");
                        }
                    }
                    resolve(e.target.result);
                };

                openRequest.onerror = e => {
                    console.log(e.target.error);
                    reject(e.target.error.name);
                };

            });
        }

        static close() {
            if(connection) {
                close();
                connection = null;

            }
        }

        static _createStores(connection) {
            STORES.forEach(store => {
                if (connection.objectStoreNames.contains(store)) {
                    connection.deleteObjectStore(store);
                }

                connection.createObjectStore(store, { autoIncrement: true });
            });
        }
    }
})();