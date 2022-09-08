package org.iftm.entity;

import org.iftm.entities.Avaliador;
import org.iftm.entities.Leilao;
import org.iftm.entities.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	public void meuPrimeiroTeste() {
		
	}
}
