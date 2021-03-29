package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe Acesso
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
 */
public class Acesso implements Serializable {

	private Usuario usuario;
	private Date dataAcesso;

	public Acesso() {
		super();
	}

	/**
	 * @param usuario Define o usuário do acesso
	 * @param dataAcesso Define a data do acesso
	 */
	public Acesso(Usuario usuario, Date dataAcesso) {
		super();
		this.usuario = usuario;
		this.dataAcesso = dataAcesso;
	}

	/**
	 * @return Usuario - Retorna o usuário do acesso
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario Define o usuário do acesso
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return Date - Retorna a data do acesso
	 */
	public Date getDataAcesso() {
		return dataAcesso;
	}

	/**
	 * @param dataAcesso Define a data do acesso
	 */
	public void setDataAcesso(Date dataAcesso) {
		this.dataAcesso = dataAcesso;
	}

	@Override
	public String toString() {
		return "Acesso [usuario=" + usuario.getLogin() + ", dataAcesso=" + dataAcesso + "]";
	}

}
