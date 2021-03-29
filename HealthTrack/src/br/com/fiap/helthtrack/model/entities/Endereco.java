package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;

/**Classe Endereco
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class Endereco implements Serializable{
	
	private int codigoEndereco;
	private TipoEndereco tipo;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String caixaPostal;
	private String cidade;
	private Estado estado;
	private Pais pais;
	private boolean ativo;
	
	public Endereco() {
		super();
		this.ativo = true;
	}

	/**
	 * @param codigoEndereco Define código
	 * @param tipo Define o tipo
	 * @param logradouro Define o logradouro
	 * @param numero Define o numero
	 * @param bairro Define o bairro
	 * @param cep Define o cep
	 * @param caixaPostal Define a caixaPostal
	 * @param cidade Define a cidade
	 * @param estado Define o estado
	 * @param pais Define o pais
	 * @param ativo Define se está ativo
	 */
	public Endereco(int codigoEndereco, TipoEndereco tipo, String logradouro, String numero, String bairro, String cep,
			String caixaPostal, String cidade, Estado estado, Pais pais, boolean ativo) {
		super();
		this.codigoEndereco = codigoEndereco;
		this.tipo = tipo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.caixaPostal = caixaPostal;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.ativo = ativo;
	}

	/**
	 * @return int - Retorna o código
	 */
	public int getCodigoEndereco() {
		return codigoEndereco;
	}

	/**
	 * @param codigoEndereco Define o código
	 */
	public void setCodigoEndereco(int codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}

	/**
	 * @return TipoEndereco - Retorna o tipo
	 */
	public TipoEndereco getTipo() {
		return tipo;
	}

	/**
	 * @param tipo Define o tipo
	 */
	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return String - Retorna o logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro Define o logradouro
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return String - Retorna o numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero Define o numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return String - Retorna o bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro Define o bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return String - Retorna o cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep Define o cep
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return String - Retorna a caixaPostal
	 */
	public String getCaixaPostal() {
		return caixaPostal;
	}

	/**
	 * @param caixaPostal Define a caixaPostal
	 */
	public void setCaixaPostal(String caixaPostal) {
		this.caixaPostal = caixaPostal;
	}

	/**
	 * @return String - Retorna a cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade Define a cidade
	*/
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return Estado - Retorna o estado
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * @param estado Define o estado
	*/
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/**
	 * @return Pais - Retorna o país
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * @param pais Define o país
	*/
	public void setPais(Pais pais) {
		this.pais = pais;
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
		return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep
				+ ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais + "]";
	}
	
}
