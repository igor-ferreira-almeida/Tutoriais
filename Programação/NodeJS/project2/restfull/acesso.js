var acesso = {};

acesso.getAcesso = function(req, res) {
    res.status(200).send("Blitzkrieg - GET");
} 

acesso.postAcesso = function(req, res) {
    var parametro = req.body.chave;
    res.status(200).send("Blitzkrieg - POST" + parametro);
} 

module.exports = acesso;