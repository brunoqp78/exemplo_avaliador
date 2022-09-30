package org.brsoft.entities;

public class Aluno {
	public static final int FREQUENCIA_MINIMA = 75;
	public static final double NOTA_MINIMA = 6.0;
	private String nome;
	private double nota;
	private int frequencia;

	public Aluno(String nome, double nota, int frequencia) {
		this.nome = nome;
		this.nota = nota;
		this.frequencia = frequencia;
	}
	
	public String getNome() {
		return this.nome;
	}

	public double getNota() {
		return this.nota;
	}

	public int getFrequencia() {
		return this.frequencia;
	}	

	public boolean estaAprovado() {
		return (
				this.nota >= NOTA_MINIMA 
				&& 
				this.frequencia>=FREQUENCIA_MINIMA);
	}

}
