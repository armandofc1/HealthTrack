package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;
import java.util.Date;

/**Classe RelembrarSenha
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class RelembrarSenha implements Serializable{

	private Usuario usuario;
	private String enderecoEmailEnviado;
	private Date dataEnvio;
	
	public RelembrarSenha() {
		super();
	}

	/**
	 * @param usuario Define o usuário
	 * @param enderecoEmailEnviado Define o email
	 * @param dataEnvio Define a data de envio
	 */
	public RelembrarSenha(Usuario usuario, String enderecoEmailEnviado, Date dataEnvio) {
		super();
		this.usuario = usuario;
		this.enderecoEmailEnviado = enderecoEmailEnviado;
		this.dataEnvio = dataEnvio;
	}

	/**
	 * @return Usuario - Retorna o usuário
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario Define o usuário
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEnderecoEmailEnviado() {
		return enderecoEmailEnviado;
	}

	public void setEnderecoEmailEnviado(String enderecoEmailEnviado) {
		this.enderecoEmailEnviado = enderecoEmailEnviado;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	@Override
	public String toString() {
		return "RelembrarSenha [usuario=" + usuario.getLogin() + ", enderecoEmailEnviado=" + enderecoEmailEnviado + "]";
	}
	
}
