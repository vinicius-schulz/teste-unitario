package br.com.spassu.meetup.teste_unitario.service;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.spassu.meetup.teste_unitario.model.Conta;

public class ContaServiceTest {

	private ContaService contaService;

	@Before
	public void initialize() {
		contaService = new ContaService();
	}

	@Test
	public void transfereComSucesso() throws Exception {

		// Arrange
		Conta origem = new Conta();
		Conta destino = new Conta();
		origem.setSaldo(100);
		destino.setSaldo(50);

		// Act
		contaService.tranferencia(origem, destino, 75);

		// Assert
		Assert.assertEquals(new Integer(25), origem.getSaldo());
		Assert.assertEquals(new Integer(125), destino.getSaldo());
	}

	@Test(expected = Exception.class)
	public void transfereSemSaldo() throws Exception {
		// Arrange
		Conta origem = new Conta();
		Conta destino = new Conta();
		origem.setSaldo(0);
		destino.setSaldo(50);

		// Act
		contaService.tranferencia(origem, destino, 50);

	}

	@Test(expected = Exception.class)
	public void tranfereContaOrigemInativa() throws Exception {
		// Arrange
		Conta origem = new Conta();
		Conta destino = new Conta();
		origem.setSituacao(false);
		origem.setSaldo(100);
		destino.setSaldo(50);

		// Act
		contaService.tranferencia(origem, destino, 50);

	}

}
