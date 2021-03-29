package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;

/**Classe Pais
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class Pais implements Serializable{

	private int codigoPais;
	private String nome;

	public Pais() {
		super();
	}

	/**
	 * @param codigoPais Define código
	 * @param nome Define o nome
	 */
	public Pais(int codigoPais, String nome) {
		super();
		this.codigoPais = codigoPais;
		this.nome = nome;
	}

	/**
	 * @return int - Retorna o código
	 */
	public int getCodigoPais() {
		return codigoPais;
	}

	/**
	 * @param codigoPais Define o código
	 */
	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}

	/**
	 * @return String - Retorna o nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome Define o nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pais [nome=" + nome + "]";
	}

}
