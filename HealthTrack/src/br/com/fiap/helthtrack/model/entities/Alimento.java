package br.com.fiap.helthtrack.model.entities;

import java.util.Date;

/**Classe Alimento
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class Alimento {
	
	private int codigoAlimento;
	private int codigoUsuario;
	private TipoAlimentacao tipo;
	private String nome;
	private String descricao;
	private double calorias;
	private Date dataConsumo;
	private boolean ativo;

	public Alimento() {
		super();
		this.ativo = true;
	}

	/**
	 * @param codigoAlimento Define código do alimento
	 * @param codigoUsuario Define código do usuário
	 * @param tipo Define o tipo do alimento
	 * @param nome Define o nome do alimento
	 * @param descricao Define a descrição do alimento
	 * @param calorias Define as calorias
	 * @param dataConsumo Define a data de consumo
	 * @param ativo Define se está ativo
	 */
	public Alimento(int codigoAlimento, int codigoUsuario, TipoAlimentacao tipo, String nome, String descricao, double calorias, Date dataConsumo,
			boolean ativo) {
		super();
		this.codigoAlimento = codigoAlimento;
		this.codigoUsuario = codigoUsuario;
		this.tipo = tipo;
		this.nome = nome;
		this.descricao = descricao;
		this.calorias = calorias;
		this.dataConsumo = dataConsumo;
		this.ativo = ativo;
	}

	/**
	 * @return int - Retorna o código do Alimento
	 */
	public int getCodigoAlimentacao() {
		return codigoAlimento;
	}

	/**
	 * @param codigoAlimento Define o código do Alimento
	 */
	public void setCodigoAlimentacao(int codigoAlimento) {
		this.codigoAlimento = codigoAlimento;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	
	/**
	 * @return String - Retorna o nome do Alimento
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome Define o nome do Alimento
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return String - Retorna a descrição do Alimento
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao Define a descrição do Alimento
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return double - Retorna as calorias do Alimento
	 */
	public double getCalorias() {
		return calorias;
	}

	/**
	 * @param calorias Define as calorias do Alimento
	 */
	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	/**
	 * @return Date - Retorna a data de consumo
	 */
	public Date getDataConsumo() {
		return dataConsumo;
	}

	/**
	 * @param dataConsumo Define data de consumo
	 */
	public void setDataConsumo(Date dataConsumo) {
		this.dataConsumo = dataConsumo;
	}

	/**
	 * @return boolean - Retorna se o Alimento está ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}

	/**
	 * @param ativo Define se o Alimento está ativo
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * @return TipoAlimentacao - Retorna o tipo do Alimento
	 */
	public TipoAlimentacao getTipo() {
		return tipo;
	}

	/**
	 * @param tipo Define o tipo do Alimento
	 */
	public void setTipo(TipoAlimentacao tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Alimento [nome=" + nome + ", "+ tipo +" calorias=" + calorias + "]";
	}

}
