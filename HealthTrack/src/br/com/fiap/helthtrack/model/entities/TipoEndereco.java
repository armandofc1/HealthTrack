package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;

/**Classe TipoEndereco
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class TipoEndereco implements Serializable{

	private int codigoTipoEndereco;
	private String nome;
	private boolean ativo;
	
	public TipoEndereco() {
		super();
		this.ativo = true;
	}

	/**
	 * @param codigoTipoEndereco Define código
	 * @param nome Define o nome
	 * @param ativo Define se está ativo
	 */
	public TipoEndereco(int codigoTipoEndereco, String nome, boolean ativo) {
		super();
		this.codigoTipoEndereco = codigoTipoEndereco;
		this.nome = nome;
		this.ativo = ativo;
	}

	/**
	 * @return int - Retorna o código
	 */
	public int getCodigoTipoEndereco() {
		return codigoTipoEndereco;
	}

	/**
	 * @param codigoTipoEndereco Define o código
	 */
	public void setCodigoTipoEndereco(int codigoTipoEndereco) {
		this.codigoTipoEndereco = codigoTipoEndereco;
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
		return "TipoEndereco [nome=" + nome + "]";
	}
	
}
