package org.iftm.entity;

import org.iftm.entities.Avaliador;
import org.iftm.entities.Lance;
import org.iftm.entities.Leilao;
import org.iftm.entities.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;

public class AvaliadorTest {
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	private Usuario usuario4;
	private Leilao leilao;
	private Avaliador avaliador;

	@BeforeEach
	public void instanciarObjetos() {
		usuario1 = new Usuario("Shirley");
		usuario2 = new Usuario("Edna");
		usuario3 = new Usuario("Laiane");
		usuario4 = new Usuario("Cristina");
		leilao = new Leilao("Computador Apple");
		avaliador = new Avaliador();
	}

	// Testes da Versão 1: encontrar o maior lance
	@Test
	public void testarBuscaMaiorLanceSemOrdem() throws Exception {
		// Entradas : criar os lances e o resultado esperado
		Lance lance1 = new Lance(usuario1, 300);
		Lance lance2 = new Lance(usuario2, 400.0000001);
		Lance lance3 = new Lance(usuario3, 250);
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance3);

		double resultadoEsperado = 400;

		// execução
		avaliador.avalia(leilao);
		double resultadoObtido = avaliador.getMaiorLance();

		// comparação
		// Assertions.assertEquals(resultadoEsperado, resultadoObtido);
		assertEquals(resultadoEsperado, resultadoObtido, 0.0001);

	}

	@Test
	public void testarBuscaMaiorLanceComOrdemCrescente() throws Exception {
//Entradas : criar os lances e o resultado esperado
		Lance lance1 = new Lance(usuario1, 300);
		Lance lance2 = new Lance(usuario2, 400.0000001);
		Lance lance3 = new Lance(usuario3, 250);
		leilao.propoe(lance3);
		leilao.propoe(lance1);
		leilao.propoe(lance2);

		double resultadoEsperado = 400;

//execução 
		avaliador.avalia(leilao);
		double resultadoObtido = avaliador.getMaiorLance();

//comparação
		// assertEquals(resultadoEsperado, resultadoObtido);
		assertEquals(resultadoEsperado, resultadoObtido, 0.0001);
	}

	@Test
	public void testarBuscaMenorLanceSemOrdem() throws Exception {
		// Entradas : criar os lances e o resultado esperado
		Lance lance1 = new Lance(usuario1, 300);
		Lance lance2 = new Lance(usuario2, 400.0000001);
		Lance lance3 = new Lance(usuario3, 250);
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance3);

		double resultadoEsperado = 250;

		// execução
		avaliador.avalia(leilao);
		double resultadoObtido = avaliador.getMenorLance();

		// comparação
		// Assertions.assertEquals(resultadoEsperado, resultadoObtido);
		assertEquals(resultadoEsperado, resultadoObtido, 0.0001);

	}

	@Test
	public void testarBuscaMenorLanceComOrdemCrescente() throws Exception {
//Entradas : criar os lances e o resultado esperado
		Lance lance1 = new Lance(usuario1, 300);
		Lance lance2 = new Lance(usuario2, 400.0000001);
		Lance lance3 = new Lance(usuario3, 250);
		leilao.propoe(lance3);
		leilao.propoe(lance1);
		leilao.propoe(lance2);

		double resultadoEsperado = 250;

//execução 
		avaliador.avalia(leilao);
		double resultadoObtido = avaliador.getMenorLance();

//comparação
		// assertEquals(resultadoEsperado, resultadoObtido);
		assertEquals(resultadoEsperado, resultadoObtido, 0.0001);
	}

	/**
	 * Testar se o método avalia consegue identificar o maior lance quando há apenas
	 * um lance
	 * @throws Exception 
	 */
	@Test
	public void testarBuscaMenorLanceComUmLance() throws Exception {
		// Entradas : criar os lances e o resultado esperado
		Lance lance1 = new Lance(usuario1, 300);
		leilao.propoe(lance1);

		double resultadoEsperado = 300;

		// execução
		avaliador.avalia(leilao);
		double resultadoObtido = avaliador.getMenorLance();

		// comparação
		assertEquals(resultadoEsperado, resultadoObtido, 0.0001);

	}

	/**
	 * Teste que verifica se o Avaliador retorna erro quando não há lance.
	 * @throws Exception 
	 */
	@Test
	public void testarBuscaMaiorLanceSemLance(){
		Assertions.assertThrows(
				Exception.class, 
				()->{
					avaliador.avalia(leilao);
					});
	}
	
	// Testes da Versão 2: encontrar os 3 maiores lances(um conjunto de lances)
	@Test
	public void testarBuscaTresMaioresLancesComApenasUmLance() throws Exception {
		// Entradas : criar os lances e o resultado esperado
		Lance lance1 = new Lance(usuario1, 300);
		Lance lance2 = new Lance(usuario2, 400.0000001);
		Lance lance3 = new Lance(usuario3, 250);
		Lance lance4 = new Lance(usuario4, 750);
		Lance lance5 = new Lance(usuario1, 650);
		Lance lance6 = new Lance(usuario3, 550);
		leilao.propoe(lance3);
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		leilao.propoe(lance6);
		leilao.propoe(lance5);
		leilao.propoe(lance4);
		//resultados esperados
		int numeroLancesEsperados = 3;
		double valorPrimeiroLanceEsperado = 750;
		double valorSegundoLanceEsperado = 650;
		double valorTerceiroLanceEsperado = 550;
		//executar
		avaliador.avalia(leilao);
		List<Lance> maiores = avaliador.getTresMaiores();
		int numeroLancesObtidos = maiores.size();
		double valorPrimeiroLanceObtido = maiores.get(0).getValor();
		double valorSegundoLanceObtido = maiores.get(1).getValor();
		double valorTerceiroLanceObtido = maiores.get(2).getValor();	
		
		//comparar resultados
		assertEquals(numeroLancesEsperados, numeroLancesObtidos);
		assertEquals(valorPrimeiroLanceEsperado, valorPrimeiroLanceObtido, 0.0000001, "O maior lance não corresponde ao resultado obtido!!");
		assertEquals(valorSegundoLanceEsperado, valorSegundoLanceObtido, 0.0000001, "O segundo maior lance não corresponde ao resultado obtido!!");
		assertEquals(valorTerceiroLanceEsperado, valorTerceiroLanceObtido, 0.0000001, "O terceiro maior lance não corresponde ao resultado obtido!!");
		assertEquals(lance4, maiores.get(0));
		assertEquals(lance5, maiores.get(1));
		assertEquals(lance6, maiores.get(2));
	}

	// Testes da Versão 2: encontrar os 3 maiores lances(um conjunto de lances)
	@Test
	public void testarBuscaTresMaioresLancesComOrdemCrescente() throws Exception {
		// Entradas : criar os lances e o resultado esperado
		Lance lance1 = new Lance(usuario1, 300);
		leilao.propoe(lance1);
		//resultados esperados
		int numeroLancesEsperados = 1;
		double valorPrimeiroLanceEsperado = 300;
		//executar
		avaliador.avalia(leilao);
		List<Lance> maiores = avaliador.getTresMaiores();
		int numeroLancesObtidos = maiores.size();
		double valorPrimeiroLanceObtido = maiores.get(0).getValor();
		
		//comparar resultados
		assertEquals(numeroLancesEsperados, numeroLancesObtidos);
		assertEquals(valorPrimeiroLanceEsperado, valorPrimeiroLanceObtido, 0.0000001);
		assertEquals(lance1, maiores.get(0));
	}
	
	@Test
	public void testarAvaliadorAvaliaCemMilLancesEmUmMilesegundo() {
		for(int i=0; i<100000; i++) {
			leilao.propoe(new Lance(usuario1, i));
		}
		Assertions.assertTimeout(
				Duration.ofMillis(1), 
				()->{
					avaliador.avalia(leilao);
				}
		);
	}
	
	
}
