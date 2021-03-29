package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;
import java.util.Date;

/**Classe MedidasCorporais
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class MedidasCorporais implements Serializable{

	private int codigoMedidas;
	private double peito;
	private double cintura;
	private double quadril;
	private double panturrilha;
	private double pescoco;
	private double larguraOmbros;
	private double comprimentoBraco;
	private double pulso;
	private Date dataMedicao;
	private boolean ativo;

	public MedidasCorporais() {
		super();
		this.ativo = true;
	}

	public MedidasCorporais(int codigoMedidas, double peito, double cintura, double quadril, double panturrilha,
			double pescoco, double larguraOmbros, double comprimentoBraco, double pulso, Date dataMedicao,
			boolean ativo) {
		super();
		this.codigoMedidas = codigoMedidas;
		this.peito = peito;
		this.cintura = cintura;
		this.quadril = quadril;
		this.panturrilha = panturrilha;
		this.pescoco = pescoco;
		this.larguraOmbros = larguraOmbros;
		this.comprimentoBraco = comprimentoBraco;
		this.pulso = pulso;
		this.dataMedicao = dataMedicao;
		this.ativo = ativo;
	}

	/**
	 * @return int - Retorna o código
	 */
	public int getCodigoMedidas() {
		return codigoMedidas;
	}

	/**
	 * @param codigoMedidas Define o código
	 */
	public void setCodigoMedidas(int codigoMedidas) {
		this.codigoMedidas = codigoMedidas;
	}

	public double getPeito() {
		return peito;
	}

	public void setPeito(double peito) {
		this.peito = peito;
	}

	public double getCintura() {
		return cintura;
	}

	public void setCintura(double cintura) {
		this.cintura = cintura;
	}

	public double getQuadril() {
		return quadril;
	}

	public void setQuadril(double quadril) {
		this.quadril = quadril;
	}

	public double getPanturrilha() {
		return panturrilha;
	}

	public void setPanturrilha(double panturrilha) {
		this.panturrilha = panturrilha;
	}

	public double getPescoco() {
		return pescoco;
	}

	public void setPescoco(double pescoco) {
		this.pescoco = pescoco;
	}

	public double getLarguraOmbros() {
		return larguraOmbros;
	}

	public void setLarguraOmbros(double larguraOmbros) {
		this.larguraOmbros = larguraOmbros;
	}

	public double getComprimentoBraco() {
		return comprimentoBraco;
	}

	public void setComprimentoBraco(double comprimentoBraco) {
		this.comprimentoBraco = comprimentoBraco;
	}

	public double getPulso() {
		return pulso;
	}

	public void setPulso(double pulso) {
		this.pulso = pulso;
	}

	/**
	 * @return Date - Retorna a data da medição
	 */
	public Date getDataMedicao() {
		return dataMedicao;
	}

	/**
	 * @param dataMedicao Define a data da medição
	 */
	public void setDataMedicao(Date dataMedicao) {
		this.dataMedicao = dataMedicao;
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
		return "MedidasCorporais [peito=" + peito + ", cintura=" + cintura + ", quadril=" + quadril + ", panturrilha="
				+ panturrilha + ", pescoco=" + pescoco + ", larguraOmbros=" + larguraOmbros + ", comprimentoBraco="
				+ comprimentoBraco + ", pulso=" + pulso + "]";
	}

}
