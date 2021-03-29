package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;

/**Classe TipoAlimentacao
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class TipoAlimentacao implements Serializable{
	
	private int codigoTipoAlimentacao;
	private String nome;
	private boolean ativo;

	public TipoAlimentacao() {
		super();
		this.ativo = true;
	}

	/**
	 * @param codigoTipoAlimentacao Define c�digo
	 * @param nome Define o nome
	 * @param ativo Define se est� ativo
	 */
	public TipoAlimentacao(int codigoTipoAlimentacao, String nome, boolean ativo) {
		super();
		this.codigoTipoAlimentacao = codigoTipoAlimentacao;
		this.nome = nome;
		this.ativo = ativo;
	}

	/**
	 * @return int - Retorna o c�digo
	 */
	public int getCodigoTipoAlimentacao() {
		return codigoTipoAlimentacao;
	}

	/**
	 * @param codigoTipoAlimentacao Define o c�digo
	 */
	public void setCodigoTipoAlimentacao(int codigoTipoAlimentacao) {
		this.codigoTipoAlimentacao = codigoTipoAlimentacao;
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
		return "TipoAlimentacao [nome=" + nome + "]";
	}

}
