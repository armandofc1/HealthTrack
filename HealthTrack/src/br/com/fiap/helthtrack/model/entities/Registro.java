package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;
import java.util.Date;

/**Classe Registro
 * @author Armando Costa
 * @version 1.00
 * @since 24/08/2018
*/
public class Registro implements Serializable{

	protected Date dataMedicao;
	protected boolean ativo;
	
	public Registro() {
		super();
		this.ativo = true;
	}

	public Registro(Date dataMedicao, boolean ativo) {
		super();
		this.dataMedicao = dataMedicao;
		this.ativo = ativo;
	}

	/**
	 * @return Date - Retorna a data de medi��o
	 */
	public Date getDataMedicao() {
		return dataMedicao;
	}

	/**
	 * @param dataMedicao Define a data de medi��o
	 */
	public void setDataMedicao(Date dataMedicao) {
		this.dataMedicao = dataMedicao;
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
		return "Registro [dataMedicao=" + dataMedicao + ", ativo=" + ativo + "]";
	}
	
}
