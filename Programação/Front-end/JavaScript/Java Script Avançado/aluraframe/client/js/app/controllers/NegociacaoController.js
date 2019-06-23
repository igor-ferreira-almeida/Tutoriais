"use strict";

System.register(["../models/ListaNegociacoes", "../models/Mensagem", "../models/Negociacao", "../views/NegociacaoView", "../views/MensagemView", "../services/NegociacaoService", "../helpers/DateHelper", "../helpers/Bind"], function (_export, _context) {
  "use strict";

  var ListaNegociacoes, Mensagem, Negociacao, NegociacaoView, MensagemView, NegociacaoService, DateHelper, Bind, _createClass, NegociacaoController, negociacaoController;

  function _classCallCheck(instance, Constructor) {
    if (!(instance instanceof Constructor)) {
      throw new TypeError("Cannot call a class as a function");
    }
  }

  return {
    setters: [function (_modelsListaNegociacoes) {
      ListaNegociacoes = _modelsListaNegociacoes.ListaNegociacoes;
    }, function (_modelsMensagem) {
      Mensagem = _modelsMensagem.Mensagem;
    }, function (_modelsNegociacao) {
      Negociacao = _modelsNegociacao.Negociacao;
    }, function (_viewsNegociacaoView) {
      NegociacaoView = _viewsNegociacaoView.NegociacaoView;
    }, function (_viewsMensagemView) {
      MensagemView = _viewsMensagemView.MensagemView;
    }, function (_servicesNegociacaoService) {
      NegociacaoService = _servicesNegociacaoService.NegociacaoService;
    }, function (_helpersDateHelper) {
      DateHelper = _helpersDateHelper.DateHelper;
    }, function (_helpersBind) {
      Bind = _helpersBind.Bind;
    }],
    execute: function () {
      _createClass = function () {
        function defineProperties(target, props) {
          for (var i = 0; i < props.length; i++) {
            var descriptor = props[i];
            descriptor.enumerable = descriptor.enumerable || false;
            descriptor.configurable = true;
            if ("value" in descriptor) descriptor.writable = true;
            Object.defineProperty(target, descriptor.key, descriptor);
          }
        }

        return function (Constructor, protoProps, staticProps) {
          if (protoProps) defineProperties(Constructor.prototype, protoProps);
          if (staticProps) defineProperties(Constructor, staticProps);
          return Constructor;
        };
      }();

      NegociacaoController = function () {
        function NegociacaoController() {
          _classCallCheck(this, NegociacaoController);

          var $ = document.querySelector.bind(document);

          this._form = $(".form");
          this._inputData = $("#data");
          this._inputQuantidade = $("#quantidade");
          this._inputValor = $("#valor");
          this._service = new NegociacaoService();

          this._ordemAtual = '';

          this._listaNegociacoes = new Bind(new ListaNegociacoes(), new NegociacaoView($("#negociacoesView")), 'adiciona', 'esvazia', 'ordena', 'inverteOrdem');

          this._mensagem = new Bind(new Mensagem(), new MensagemView($("#mensagemView")), 'texto');
          this._init();
        }

        _createClass(NegociacaoController, [{
          key: "_init",
          value: function _init() {
            var _this = this;

            this._service.listar().then(function (negociacoes) {
              negociacoes.forEach(function (negociacao) {
                _this._listaNegociacoes.adiciona(negociacao);
              });
            }).catch(function (erro) {
              return _this._mensagem.texto = erro;
            });

            setInterval(function () {
              return _this.importar();
            }, 3000);
          }
        }, {
          key: "importar",
          value: function importar() {
            var _this2 = this;

            this._service.importar(this._listaNegociacoes.negociacoes).then(function (negociacoes) {
              negociacoes.forEach(function (negociacao) {
                return _this2._listaNegociacoes.adiciona(negociacao);
              });
              _this2._mensagem.texto = "Negociações importadas com sucesso";
            }).catch(function (erro) {
              return _this2._mensagem.texto = erro;
            });
          }
        }, {
          key: "adiciona",
          value: function adiciona(event) {
            var _this3 = this;

            event.preventDefault();
            var negociacao = this._criaNegociacao();

            this._service.cadastrar(negociacao).then(function (mensagem) {
              _this3._listaNegociacoes.adiciona(negociacao);
              _this3._mensagem.texto = mensagem;
              _this3._limpaFormulario();
            }).catch(function (erro) {
              return _this3._mensagem.texto = erro;
            });
          }
        }, {
          key: "apaga",
          value: function apaga() {
            var _this4 = this;

            this._service.apaga().then(function (mensagem) {
              _this4._mensagem.texto = mensagem;
              _this4._listaNegociacoes.esvazia();
            }).catch(function (erro) {
              return _this4._mensagem.texto = erro;
            });
          }
        }, {
          key: "ordena",
          value: function ordena(coluna) {
            if (this._ordemAtual == coluna) {
              this._listaNegociacoes.inverteOrdem();
            } else {
              this._listaNegociacoes.ordena(function (a, b) {
                return a[coluna] - b[coluna];
              });
            }
            this._ordemAtual = coluna;
          }
        }, {
          key: "_criaNegociacao",
          value: function _criaNegociacao() {
            return new Negociacao(DateHelper.textoParaData(this._inputData.value), parseInt(this._inputQuantidade.value), parseFloat(this._inputValor.value));
          }
        }, {
          key: "_limpaFormulario",
          value: function _limpaFormulario() {
            this._form.reset();
            this._inputData.focus();
          }
        }]);

        return NegociacaoController;
      }();

      negociacaoController = new NegociacaoController();
      function currentInstance() {
        return negociacaoController;
      }

      _export("currentInstance", currentInstance);
    }
  };
});
//# sourceMappingURL=NegociacaoController.js.map