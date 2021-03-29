package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;
import java.util.Date;

/**Classe Peso
 * @author Armando Costa
 * @version 1.01
 * @since 15/08/2018
*/
public class Peso extends Registro implements Serializable {

	private int codigoPeso;
	private double afericao;
	private int codigoUsuario;

	public Peso() {
		super();
	}

	/**
	 * @param codigoPeso Define código
	 * @param codigoUsuario Define código do usuário
	 * @param afericao Define a aferição
	 * @param dataMedicao Define a data de medição
	 * @param ativo Define se está ativo
	 */
	public Peso(int codigoPeso, int codigoUsuario, double afericao, Date dataMedicao, boolean ativo) {
		super(dataMedicao, ativo);
		this.codigoPeso = codigoPeso;
		this.afericao = afericao;
		this.codigoUsuario = codigoUsuario;
	}

	/**
	 * @return int - Retorna o código
	 */
	public int getCodigoPeso() {
		return codigoPeso;
	}

	/**
	 * @param codigoPeso Define o código
	 */
	public void setCodigoPeso(int codigoPeso) {
		this.codigoPeso = codigoPeso;
	}
	
	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public double getAfericao() {
		return afericao;
	}

	public void setAfericao(double afericao) {
		this.afericao = afericao;
	}

	@Override
	public String toString() {
		return "Peso [afericao=" + afericao + "]";
	}


}
