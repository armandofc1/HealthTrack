package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;
/**Classe Evolucao
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
import java.util.Date;

public class Evolucao implements Serializable{

	private int codigoEvolucao;
	private String foto;
	private Date dataRegistro;
	private MedidasCorporais medidas;
	private Peso peso;
	private PressaoArterial pressao;
	private boolean ativo;
	
	public Evolucao() {
		super();
		this.ativo = true;
	}

	/**
	 * @param codigoEvolucao Define código
	 * @param plano Define o plano
	 * @param foto Define a foto
	 * @param dataRegistro Define a dataRegistro
	 * @param medidas Define as medidas
	 * @param peso Define o peso
	 * @param pressao Define a pressao
	 * @param ativo Define se está ativo
	 */
	public Evolucao(int codigoEvolucao, Planejamento plano, String foto, Date dataRegistro, MedidasCorporais medidas,
			Peso peso, PressaoArterial pressao, boolean ativo) {
		super();
		this.codigoEvolucao = codigoEvolucao;
		this.foto = foto;
		this.dataRegistro = dataRegistro;
		this.medidas = medidas;
		this.peso = peso;
		this.pressao = pressao;
		this.ativo = ativo;
	}

	/**
	 * @return int - Retorna o código
	 */
	public int getCodigoEvolucao() {
		return codigoEvolucao;
	}

	/**
	 * @param codigoEvolucao Define o código
	 */
	public void setCodigoEvolucao(int codigoEvolucao) {
		this.codigoEvolucao = codigoEvolucao;
	}

	/**
	 * @return String - Retorna a foto
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * @param foto Define a foto
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public MedidasCorporais getMedidas() {
		return medidas;
	}

	public void setMedidas(MedidasCorporais medidas) {
		this.medidas = medidas;
	}

	public Peso getPeso() {
		return peso;
	}

	public void setPeso(Peso peso) {
		this.peso = peso;
	}

	public PressaoArterial getPressao() {
		return pressao;
	}

	public void setPressao(PressaoArterial pressao) {
		this.pressao = pressao;
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
		return "Evolucao [dataRegistro=" + dataRegistro + "]";
	}
		
}
