package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;
import java.util.Date;

/**Classe PressaoArterial
 * @author Armando Costa
 * @version 1.01
 * @since 15/08/2018
*/
public class PressaoArterial extends Registro implements Serializable{
	
	private int codigoPressaoArterial;
	private int codigoUsuario;
	private double sistolica;
	private double diastolica;

	public PressaoArterial() {
		super();
	}

	public PressaoArterial(int codigoPressaoArterial, int codigoUsuario, double sistolica, double diastolica,
			Date dataMedicao, boolean ativo) {
		super(dataMedicao, ativo);
		this.codigoPressaoArterial = codigoPressaoArterial;
		this.codigoUsuario = codigoUsuario;
		this.sistolica = sistolica;
		this.diastolica = diastolica;
	}

	/**
	 * @return int - Retorna o código
	 */
	public int getCodigoPressaoArterial() {
		return codigoPressaoArterial;
	}

	/**
	 * @param codigoPressaoArterial Define o código
	 */
	public void setCodigoPressaoArterial(int codigoPressaoArterial) {
		this.codigoPressaoArterial = codigoPressaoArterial;
	}
	
	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public double getSistolica() {
		return sistolica;
	}

	public void setSistolica(double sistolica) {
		this.sistolica = sistolica;
	}

	public double getDiastolica() {
		return diastolica;
	}

	public void setDiastolica(double diastolica) {
		this.diastolica = diastolica;
	}

	@Override
	public String toString() {
		return "PressaoArterial [Sistolica=" + sistolica + ", Diastolica=" + diastolica
				+ "]";
	}

}
