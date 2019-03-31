package br.com.template_method;
interface Resposta {
	void responde(Requisicao req, Conta conta);

	void setProxima(Resposta resposta);
}