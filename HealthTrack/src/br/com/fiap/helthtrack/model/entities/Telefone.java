package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;

/**Classe Telefone
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class Telefone implements Serializable{

	private int codigoTelefone;
	private TipoTelefone tipo;
	private String ddi;
	private String ddd;
	private String prefixo;
	private String sufixo;
	private boolean ativo;
	
	public Telefone() {
		super();
		this.ativo = true;
	}

	public Telefone(int codigoTelefone, TipoTelefone tipo, String ddi, String ddd, String prefixo, String sufixo,
			boolean ativo) {
		super();
		this.codigoTelefone = codigoTelefone;
		this.tipo = tipo;
		this.ddi = ddi;
		this.ddd = ddd;
		this.prefixo = prefixo;
		this.sufixo = sufixo;
		this.ativo = ativo;
	}

	/**
	 * @return int - Retorna o código
	 */
	public int getCodigoTelefone() {
		return codigoTelefone;
	}

	/**
	 * @param codigoTelefone Define o código
	 */
	public void setCodigoTelefone(int codigoTelefone) {
		this.codigoTelefone = codigoTelefone;
	}

	/**
	 * @return TipoTelefone - Retorna o tipo
	 */
	public TipoTelefone getTipo() {
		return tipo;
	}

	/**
	 * @param tipo Define o tipo
	 */
	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	public String getSufixo() {
		return sufixo;
	}

	public void setSufixo(String sufixo) {
		this.sufixo = sufixo;
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
		return "Telefone [" + ddi + " " + ddd + " =" + prefixo + "-" + sufixo + "]";
	}
	
}
