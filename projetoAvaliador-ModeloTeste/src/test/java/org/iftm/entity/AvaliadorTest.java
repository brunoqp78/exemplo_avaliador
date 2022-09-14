package org.iftm.entity;

import org.iftm.entities.Avaliador;
import org.iftm.entities.Lance;
import org.iftm.entities.Leilao;
import org.iftm.entities.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

	@Test
	public void testarBuscaMaiorLanceSemOrdem() {
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
	public void testarBuscaMaiorLanceComOrdem() {
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
	public void testarBuscaMenorLanceSemOrdem() {
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
	public void testarBuscaMenorLanceComOrdem() {
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

}
