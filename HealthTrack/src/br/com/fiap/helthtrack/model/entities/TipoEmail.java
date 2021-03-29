package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;

/**Classe TipoEmail
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class TipoEmail implements Serializable{

	private int codigoTipoEmail;
	private String nome;
	private boolean ativo;
	
	public TipoEmail() {
		super();
		this.ativo = true;
	}

	/**
	 * @param codigoTipoEmail Define código
	 * @param nome Define o nome
	 * @param ativo Define se está ativo
	 */
	public TipoEmail(int codigoTipoEmail, String nome, boolean ativo) {
		super();
		this.codigoTipoEmail = codigoTipoEmail;
		this.nome = nome;
		this.ativo = ativo;
	}

	/**
	 * @return int - Retorna o código
	 */
	public int getCodigoTipoEmail() {
		return codigoTipoEmail;
	}

	/**
	 * @param codigoTipoEmail Define o código
	 */
	public void setCodigoTipoEmail(int codigoTipoEmail) {
		this.codigoTipoEmail = codigoTipoEmail;
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

	/**
	 * @return boolean - Retorna se está ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}

	/**
	 * @param ativo Define se está ativo
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "TipoEmail [nome=" + nome + "]";
	}
		
}
