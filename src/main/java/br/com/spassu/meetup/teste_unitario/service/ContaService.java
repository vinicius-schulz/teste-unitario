package br.com.spassu.meetup.teste_unitario.service;

import br.com.spassu.meetup.teste_unitario.model.Conta;

public class ContaService {

	public void tranferencia(Conta origem, Conta destino, Integer valor) throws Exception {

		if (!origem.getSituacao()) {
			throw new Exception("Conta origem inativa");
		}
		if (origem.getSaldo() < valor) {
			throw new Exception("Saldo insuficiente");
		}
		origem.setSaldo(origem.getSaldo() - valor);
		destino.setSaldo(destino.getSaldo() + valor);
	}

}
