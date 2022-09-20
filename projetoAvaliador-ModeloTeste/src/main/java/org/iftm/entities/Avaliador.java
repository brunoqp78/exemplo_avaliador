package org.iftm.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Versão 2 do avaliador.
 * @author turin-turambar
 *
 */
public class Avaliador {
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private List<Lance> maiores;
	
	private void pegaOsMaioresNo(Leilao leilao) {
		//criação da lista com todos os lances do leilão
		maiores = new ArrayList<Lance>(leilao.getLances());
		//código que ordena os lances pelo valor
		Collections.sort(maiores, new Comparator<Lance>() {
			public int compare(Lance o1, Lance o2) {
				if (o1.getValor() < o2.getValor())
					return 1;
				else if (o1.getValor() > o2.getValor())
					return -1;
				else
					return 0;
			}
		});
		/*
		if (maiores.size() >= 3)
			maiores = maiores.subList(0, 3);// irá selecionar os 3 primeiros lances
		else
			maiores = maiores.subList(0, maiores.size());
		*/
		maiores = maiores.subList(0, maiores.size() >= 3 ? 3 : maiores.size());
	}	
	
	/**
	 * Método que retorna a lista contendo os três maiores lances.	
	 * @return
	 */
	public List<Lance> getTresMaiores() {
		return this.maiores;
	}



	public void setMaiores(List<Lance> maiores) {
		this.maiores = maiores;
	}



	public void avalia(Leilao leilao) throws Exception {
		if (leilao.getLances().size() == 0) {
			//retornar um erro/exception
			throw new Exception("Não é possível avaliar um leilão sem lances.");
		}
		for(Lance lance : leilao.getLances()) {
			if(lance.getValor() > maiorDeTodos) {
				maiorDeTodos = lance.getValor();
			}
			if(lance.getValor() < menorDeTodos) {
				menorDeTodos = lance.getValor();
			}
		}
		pegaOsMaioresNo(leilao);
	}
	
	public double getMaiorLance() {
		return maiorDeTodos;
	}
	
	public double getMenorLance() {
		return menorDeTodos;
	}	
}
