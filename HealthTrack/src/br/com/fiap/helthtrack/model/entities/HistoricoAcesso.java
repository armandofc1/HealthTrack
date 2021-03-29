package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**Classe HistoricoAcesso
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class HistoricoAcesso implements Serializable {

	private Usuario usuario;
	private List<Acesso> acessos;
	
	public HistoricoAcesso() {
		super();
		inicializar();
	}

	/**
	 * @param usuario Define o usuário
	 * @param acessos Define a lista de acessos
	 */
	public HistoricoAcesso(Usuario usuario, List<Acesso> acessos) {
		super();
		this.usuario = usuario;
		this.acessos = acessos;
		inicializar();
	}

	/** Inicia a lista de acessos
	*/
	public void inicializar() {
		this.acessos = new ArrayList<Acesso>();
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

	/**
	 * @return acessos - Retorna a lista de acessos
	 */
	public List<Acesso> getAcessos() {
		return acessos;
	}

	/**
	 * @param acessos Define a lista de acessos
	 */
	public void setAcessos(List<Acesso> acessos) {
		this.acessos = acessos;
	}

	/**
	 * @param acesso Adiciona um acesso
	 */
	public void addAcesso(Acesso acesso) {
		this.acessos.add(acesso);
	}

	/**
	 * @param acesso Remove um acesso
	 */
	public void removeAcesso(Acesso acesso) {
		this.acessos.remove(acesso);
	}

	@Override
	public String toString() {
		return "HistoricoAcesso [usuario=" + usuario.getLogin() + "]";
	}
	
}
