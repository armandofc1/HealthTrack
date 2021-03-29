package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;

/**Classe TipoAtividadeFisica
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class TipoAtividadeFisica implements Serializable{
	
	private int codigoTipoAividadeFisica;
	private String nome;
	private boolean ativo;
	
	public TipoAtividadeFisica() {
		super();
		this.ativo = true;
	}

	/**
	 * @param codigoTipoAividadeFisica Define c�digo
	 * @param nome Define o nome
	 * @param ativo Define se est� ativo
	 */
	public TipoAtividadeFisica(int codigoTipoAividadeFisica, String nome, boolean ativo) {
		super();
		this.codigoTipoAividadeFisica = codigoTipoAividadeFisica;
		this.nome = nome;
		this.ativo = ativo;
	}

	/**
	 * @return int - Retorna o c�digo
	 */
	public int getCodigoTipoAtividadeFisica() {
		return codigoTipoAividadeFisica;
	}

	/**
	 * @param codigoTipoAividadeFisica Define o c�digo
	 */
	public void setCodigoTipoAtividadeFisica(int codigoTipoAividadeFisica) {
		this.codigoTipoAividadeFisica = codigoTipoAividadeFisica;
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
	 * @return boolean - Retorna se est� ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}

	/**
	 * @param ativo Define se est� ativo
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "TipoAtividadeFisica [nome=" + nome + "]";
	}

}
