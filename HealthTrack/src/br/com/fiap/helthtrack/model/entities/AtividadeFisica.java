package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;
import java.util.Date;

/**Classe AtividadeFisica
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class AtividadeFisica implements Serializable {
	
	private int codigoAtividadeFisica;
	private int codigoUsuario;
	private TipoAtividadeFisica tipo;
	private String nome;
	private String descricao;
	private double gastoCalorico;
	private Date dataMedicao;
	private boolean ativo;

	public AtividadeFisica() {
		super();
		this.ativo = true;
	}

	/**
	 * @param codigoAtividadeFisica Define código da Atividade Fisica
	 * @param codigoUsuario Define código do usuário
	 * @param tipo Define o tipo da Atividade Fisica
	 * @param nome Define o nome da Atividade Fisica
	 * @param descricao Define a descrição da Atividade Fisica
	 * @param gastoCalorico Define as calorias
	 * @param dataMedicao Define a data de medição
	 * @param ativo Define se está ativo
	 */
	public AtividadeFisica(int codigoAtividadeFisica, int codigoUsuario, TipoAtividadeFisica tipo, String nome, String descricao,
			double gastoCalorico, Date dataMedicao, boolean ativo) {
		super();
		this.codigoAtividadeFisica = codigoAtividadeFisica;
		this.codigoUsuario = codigoUsuario;
		this.tipo = tipo;
		this.nome = nome;
		this.descricao = descricao;
		this.gastoCalorico = gastoCalorico;
		this.dataMedicao = dataMedicao;
		this.ativo = ativo;
	}

	/**
	 * @return int - Retorna o código da Atividade Fisica
	 */
	public int getCodigoAtividadeFisica() {
		return codigoAtividadeFisica;
	}

	/**
	 * @param codigoAtividadeFisica Define o código da Atividade Fisica
	 */
	public void setCodigoAtividadeFisica(int codigoAtividadeFisica) {
		this.codigoAtividadeFisica = codigoAtividadeFisica;
	}
	
	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	/**
	 * @return TipoAtividadeFisica - Retorna o tipo da Atividade Fisica
	 */
	public TipoAtividadeFisica getTipo() {
		return tipo;
	}

	/**
	 * @param tipo Define o tipo da Atividade Fisica
	 */
	public void setTipo(TipoAtividadeFisica tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return String - Retorna o nome da Atividade Fisica
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome Define o nome da Atividade Fisica
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return String - Retorna a descrição da Atividade Fisica
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao Define a descrição da Atividade Fisica
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return double - Retorna o gasto calorico da Atividade Fisica
	 */
	public double getGastoCalorico() {
		return gastoCalorico;
	}

	/**
	 * @param gastoCalorico Define o gasto calorico da Atividade Fisica
	 */
	public void setGastoCalorico(double gastoCalorico) {
		this.gastoCalorico = gastoCalorico;
	}

	/**
	 * @return Date - Retorna a data da medição da Atividade Fisica
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
		return "AtividadeFisica [nome=" + nome +", "+ tipo + ", gastoCalorico=" + gastoCalorico + "]";
	}
	
}
