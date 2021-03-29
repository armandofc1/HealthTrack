package br.com.fiap.helthtrack.model.entities;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

/**Classe Contato
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class Contato implements Serializable{
	
	private int codigoContato;
	private Usuario usuario;
	private Email email;
	private List<Telefone> telefones;
	private boolean ativo;
	
	public Contato() {
		super();
		this.ativo = true;
		inicializar();
	}

	/**
	 * @param codigoContato Define código do Contato
	 * @param usuario Define o usário
	 * @param email Define o email
	 * @param telefone Adiciona um telefone
	 * @param ativo Define se está ativo
	 */
	public Contato(int codigoContato, Usuario usuario, Email email, boolean ativo, Telefone telefone) {
		super();
		inicializar();
		this.codigoContato = codigoContato;
		this.usuario = usuario;
		this.email = email;
		this.ativo = ativo;
		addTelefone(telefone);
	}

	/** Inicia a lista de telefones
	*/
	public void inicializar() {
		this.telefones = new ArrayList<Telefone>();
	}

	/**
	 * @return int - Retorna o código do Contato
	 */
	public int getCodigoContato() {
		return codigoContato;
	}

	/**
	 * @param codigoContato Define o código do Contato
	 */
	public void setCodigoContato(int codigoContato) {
		this.codigoContato = codigoContato;
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

	/**
	 * @param email Define o email
	 */
	public void setEmail(Email email) {
		this.email = email;
	}
	
	/**
	 * @return Email - Retorna o email
	 */
	public Email getEmail(){
		return this.email;
	}

	/**
	 * @param telefones Define a lista de telefones
	 */
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	/**
	 * @return telefones - Retorna a lista de telefones
	 */
	public List<Telefone> getTelefones(){
		return this.telefones;
	}
	
	/**
	 * @param telefone Adiciona um telefone
	 */
	public void addTelefone(Telefone telefone) {
		telefones.add(telefone);
	}
	
	/**
	 * @param telefone Remove um telefone
	 */
	public void removeTelefone(Telefone telefone) {
		telefones.remove(telefone);
	}

	@Override
	public String toString() {
		return "Contato [usuario=" + usuario.getLogin() + "]";
	}	

}
