package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**Classe Monitoracao
 * @author Armando Costa
 * @version 1.00
 * @since 15/08/2018
*/
public class Monitoracao implements Serializable{

	private Usuario usuario;
	private List<Peso> pesos;
	private List<PressaoArterial> pressoesArteriais;
	private List<Alimento> alimentacao;
	private List<AtividadeFisica> atividades;
	
	public Monitoracao() {
		super();
		this.inicializar();
	}

	/** Inicia a lista de composição
	*/
	public void inicializar() {
		this.pesos = new ArrayList<Peso>();
		this.pressoesArteriais = new ArrayList<PressaoArterial>();
		this.alimentacao = new ArrayList<Alimento>();
		this.atividades = new ArrayList<AtividadeFisica>(); 
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

	public List<Peso> getPesos() {
		return pesos;
	}

	public void setPesos(List<Peso> pesos) {
		this.pesos = pesos;
	}

	/**
	 * @param peso Adiciona um peso
	 */
	public void addPesos(Peso peso) {
		this.pesos.add(peso);
	}
	
	/**
	 * @param peso Remove um peso
	 */
	public void removePeso(Peso peso) {
		this.pesos.remove(peso);
	}
	
	public List<PressaoArterial> getPressoesArteriais() {
		return pressoesArteriais;
	}

	public void setPressoesArteriais(List<PressaoArterial> pressoesArteriais) {
		this.pressoesArteriais = pressoesArteriais;
	}

	/**
	 * @param pressao Adiciona uma pressao
	 */
	public void addPressao(PressaoArterial pressao) {
		this.pressoesArteriais.add(pressao);
	}

	/**
	 * @param pressao Remove uma pressao
	 */
	public void removePressao(PressaoArterial pressao) {
		this.pressoesArteriais.remove(pressao);
	}
	
	public List<Alimento> getAlimentacao() {
		return alimentacao;
	}

	public void setAlimentacao(List<Alimento> alimentacao) {
		this.alimentacao = alimentacao;
	}

	/**
	 * @param alimento Adiciona um alimento
	 */
	public void addAlimento(Alimento alimento) {
		this.alimentacao.add(alimento);
	}

	/**
	 * @param alimento Remove um alimento
	 */
	public void removeAlimento(Alimento alimento) {
		this.alimentacao.remove(alimento);
	}

	public List<AtividadeFisica> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<AtividadeFisica> atividades) {
		this.atividades = atividades;
	}

	/**
	 * @param atividade Adiciona uma atividade
	 */
	public void addAtividade(AtividadeFisica atividade) {
		this.atividades.add(atividade);
	}

	/**
	 * @param atividade Remove uma atividade
	 */
	public void removeAtividade(AtividadeFisica atividade) {
		this.atividades.remove(atividade);
	}

	@Override
	public String toString() {
		return "Monitoracao [usuario=" + usuario.getLogin() + "]";
	}	
	
}
