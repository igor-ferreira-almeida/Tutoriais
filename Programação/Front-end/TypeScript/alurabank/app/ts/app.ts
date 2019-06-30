
const negociacaoController = new NegociacaoController();
//Usando jQuery
$(".form").submit(negociacaoController.adiciona.bind(negociacaoController));
