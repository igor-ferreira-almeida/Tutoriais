var express = require("express");
var app = express();
var server = require("http").createServer(app);

var bodyParser = require("body-parser");
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

var acesso = require("./restfull/acesso");
app.route("/acesso").get(acesso.getAcesso).post(acesso.postAcesso);

server.listen(process.env.PORT || 3000, function() {
    console.log("Rodando o server!");
});