class MensagemView extends View<String> {
    template(model: string): string {
        return `<p class="alert alert-info">${model}</p>`;
    }
}