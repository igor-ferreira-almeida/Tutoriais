
class NegociacaoView extends View {

  constructor(elemento) {
    super(elemento);
  }

  template(model) {
    return `
      <table class="table table-hover table-bordered">
          <thead>
              <tr>
                  <th class="order-column" onclick="negociacaoController.ordena('data')">DATA</th>
                  <th class="order-column" onclick="negociacaoController.ordena('quantidade')">QUANTIDADE</th>
                  <th class="order-column" onclick="negociacaoController.ordena('valor')">VALOR</th>
                  <th class="order-column" onclick="negociacaoController.ordena('volume')">VOLUME</th>
              </tr>
          </thead>

          <tbody>

            ${model.negociacoes.map(n => {
              return `<tr>
                  <td>${DateHelper.dataParaTexto(n.data)}</td>
                  <td>${n.quantidade}</td>
                  <td>${n.valor}</td>
                  <td>${n.volume}</td>
                </tr>
              `
            }).join("")}

          </tbody>

          <tfoot>
            <tr>
              <td colspan="3"></td>
              <td>${model.volumeTotal}</td>
            </tr>
          </tfoot>
      </table>
    `;
  }
}
