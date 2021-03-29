package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;

/**Classe TipoTelefone
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class TipoTelefone implements Serializable{

	private int codigoTipoTelefone;
	private String nome;
	private boolean ativo;

	public TipoTelefone() {
		super();
		this.ativo = true;
	}

	/**
	 * @param codigoTipoTelefone Define c�digo
	 * @param nome Define o nome
	 * @param ativo Define se est� ativo
	 */
	public TipoTelefone(int codigoTipoTelefone, String nome, boolean ativo) {
		super();
		this.codigoTipoTelefone = codigoTipoTelefone;
		this.nome = nome;
		this.ativo = ativo;
	}

	/**
	 * @return int - Retorna o c�digo
	 */
	public int getCodigoTipoTelefone() {
		return codigoTipoTelefone;
	}

	/**
	 * @param codigoTipoTelefone Define o c�digo
	 */
	public void setCodigoTipoTelefone(int codigoTipoTelefone) {
		this.codigoTipoTelefone = codigoTipoTelefone;
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
		return "TipoTelefone [nome=" + nome + "]";
	}

}
