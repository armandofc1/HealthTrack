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
	 * @param codigoTipoAlimentacao Define código
	 * @param nome Define o nome
	 * @param ativo Define se está ativo
	 */
	public TipoAlimentacao(int codigoTipoAlimentacao, String nome, boolean ativo) {
		super();
		this.codigoTipoAlimentacao = codigoTipoAlimentacao;
		this.nome = nome;
		this.ativo = ativo;
	}

	/**
	 * @return int - Retorna o código
	 */
	public int getCodigoTipoAlimentacao() {
		return codigoTipoAlimentacao;
	}

	/**
	 * @param codigoTipoAlimentacao Define o código
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
		return "TipoAlimentacao [nome=" + nome + "]";
	}

}
