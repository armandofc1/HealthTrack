package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;

/**Classe Menu
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class Menu implements Serializable{

	private int codigoMenu;
	private String nome;
	private String caminho;
	private boolean ativo;

	public Menu() {
		super();
		this.ativo = true;
	}

	/**
	 * @param codigoMenu Define código
	 * @param nome Define o nome
	 * @param caminho Define o caminho
	 * @param ativo Define se está ativo
	 */	public Menu(int codigoMenu, String nome, String caminho, boolean ativo) {
		super();
		this.codigoMenu = codigoMenu;
		this.nome = nome;
		this.caminho = caminho;
		this.ativo = ativo;
	}

	/**
	 * @return int - Retorna o código
	 */
	public int getCodigoMenu() {
		return codigoMenu;
	}

	/**
	 * @param codigoMenu Define o código
	 */
	public void setCodigoMenu(int codigoMenu) {
		this.codigoMenu = codigoMenu;
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
	 * @return String - Retorna o caminho
	 */
	public String getCaminho() {
		return caminho;
	}

	/**
	 * @param caminho Define o caminho
	 */
	public void setCaminho(String caminho) {
		this.caminho = caminho;
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
		return "Menu [nome=" + nome + "]";
	}

}
