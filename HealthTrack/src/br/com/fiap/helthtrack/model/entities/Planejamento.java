package br.com.fiap.helthtrack.model.entities;

import java.util.Date;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

/**Classe Planejamento
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class Planejamento implements Serializable{

	private int codigoPlanejamento;
	private Usuario usuario;
	private String nome;
	private String objetivo;
	private Date dataInicio;
	private Date dataFim;
	private boolean ativo;
	
	private List<Evolucao> evolucao;
	
	public Planejamento() {
		super();
		this.ativo = true;
		inicializar();
	}

	public Planejamento(int codigoPlanejamento, Usuario usuario, String nome, String objetivo, Date dataInicio,
			Date dataFim, boolean ativo) {
		super();
		this.codigoPlanejamento = codigoPlanejamento;
		this.usuario = usuario;
		this.nome = nome;
		this.objetivo = objetivo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.ativo = ativo;
		inicializar();
	}
	
	/** Inicia a lista de evolução
	*/
	public void inicializar() {
		this.evolucao = new ArrayList<Evolucao>();
	}

	/**
	 * @return int - Retorna o código
	 */
	public int getCodigoPlanejamento() {
		return codigoPlanejamento;
	}

	/**
	 * @param codigoPlanejamento Define o código
	 */
	public void setCodigoPlanejamento(int codigoPlanejamento) {
		this.codigoPlanejamento = codigoPlanejamento;
	}

	/**
	 * @return Usuario - Retorna o usuário
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario Define o usuário
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
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
	
	public List<Evolucao> getEvolucao() {
		return evolucao;
	}

	public void setEvolucao(List<Evolucao> evolucao) {
		this.evolucao = evolucao;
	}
	
	public void addEvolucao(Evolucao evolucao) {
		this.evolucao.add(evolucao);
	}
	
	public void removeEvolucao(Evolucao evolucao) {
		this.evolucao.remove(evolucao);
	}

	@Override
	public String toString() {
		return "Planejamento [nome=" + nome + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
	}

}
