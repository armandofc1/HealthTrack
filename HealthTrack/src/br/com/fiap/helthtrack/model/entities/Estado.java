package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;

/**Classe Estado
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class Estado implements Serializable{

	private int codigoEstado;
	private String nome;
	
	public Estado() {
		super();
	}

	/**
	 * @param codigoEstado Define código
	 * @param nome Define o nome
	 */
	public Estado(int codigoEstado, String nome) {
		super();
		this.codigoEstado = codigoEstado;
		this.nome = nome;
	}

	/**
	 * @return int - Retorna o código
	 */
	public int getCodigoEstado() {
		return codigoEstado;
	}

	/**
	 * @param codigoEstado Define o código
	 */
	public void setCodigoEstado(int codigoEstado) {
		this.codigoEstado = codigoEstado;
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
		return "Estado [nome=" + nome + "]";
	}
	
}
