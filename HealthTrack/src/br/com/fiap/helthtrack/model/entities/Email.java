package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;

/**Classe Email
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class Email implements Serializable{

	private int codigoEmail;
	private TipoEmail tipo;
	private String enderecoEmail;
	private boolean ativo;
	
	public Email() {
		super();
		this.ativo = true;
	}

	/**
	 * @param codigoEmail Define código
	 * @param tipo Define o tipo
	 * @param enderecoEmail Define o email
	 * @param ativo Define se está ativo
	 */
	public Email(int codigoEmail, TipoEmail tipo, String enderecoEmail, boolean ativo) {
		super();
		this.codigoEmail = codigoEmail;
		this.tipo = tipo;
		this.enderecoEmail = enderecoEmail;
		this.ativo = ativo;
	}

	/**
	 * @return int - Retorna o código
	 */
	public int getCodigoEmail() {
		return codigoEmail;
	}

	/**
	 * @param codigoEmail Define o código
	 */
	public void setCodigoEmail(int codigoEmail) {
		this.codigoEmail = codigoEmail;
	}

	/**
	 * @return TipoEmail - Retorna o tipo
	 */
	public TipoEmail getTipo() {
		return tipo;
	}

	/**
	 * @param tipo Define o tipo
	 */
	public void setTipo(TipoEmail tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return String - Retorna o email
	 */
	public String getEnderecoEmail() {
		return enderecoEmail;
	}
	
	/**
	 * @param enderecoEmail Define o email
	 */
	public void setEnderecoEmail(String enderecoEmail) {
		this.enderecoEmail = enderecoEmail;
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
		return "Email [enderecoEmail=" + enderecoEmail + "]";
	}
	
}
