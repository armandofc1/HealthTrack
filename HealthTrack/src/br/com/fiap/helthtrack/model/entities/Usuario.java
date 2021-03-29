package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;
import java.util.Date;
import br.com.fiap.helthtrack.model.enums.*;

/**Classe Usuario
 * @author Armando Costa
 * @version 1.01
 * @since 15/08/2018 
*/
public class Usuario extends Pessoa implements Serializable{

	private int codigoUsuario;
	private String login;
	private String senha;
	private double altura;
	private String foto;
	private Date dataCadastro;
	private boolean ativo;

	public Usuario() {
		super();
		inicializar();
	}

	/**
	 * @param codigoUsuario Define código
	 * @param login Define o login
	 * @param nome Define o nome
	 * @param sobrenome Define o sobrenome
	 * @param sexo Define o sexo
	 * @param dataNascimento Define a data de nascimento
	 * @param altura Define a altura
	 * @param foto Define a foto
	 * @param dataCadastro Define a data de cadastro
	 * @param ativo Define se está ativo
	 */
	public Usuario(int codigoUsuario, String login, String nome, String sobrenome, Sexo sexo, Date dataNascimento, double altura, String foto, Date dataCadastro, boolean ativo) {
		super(nome, sobrenome, sexo, dataNascimento);

		this.codigoUsuario = codigoUsuario;
		this.login = login;
		this.altura = altura;
		this.foto = foto;
		this.dataCadastro = dataCadastro;
		this.ativo = ativo;
	}
	
	/**
	 * @param login Define o login
	 * @param nome Define o nome
	 * @param sobrenome Define o sobrenome
	 * @param sexo Define o sexo
	 * @param dataNascimento Define a data de nascimento
	 * @param altura Define a altura
	 * @param foto Define a foto
	 * @param dataCadastro Define a data de cadastro
	 * @param ativo Define se está ativo
	 */
	public Usuario(String login, String nome, String sobrenome, Sexo sexo, Date dataNascimento, double altura, String foto, Date dataCadastro, boolean ativo) {
		super(nome, sobrenome, sexo, dataNascimento);

		this.login = login;
		this.altura = altura;
		this.foto = foto;
		this.dataCadastro = dataCadastro;
		this.ativo = ativo;
	}
	
	/** Inicia o atributo ativo com o valor true.
	*/
	public void inicializar() {
		this.ativo = true;
	}

	/**
	 * @return int - Retorna o código
	 */
	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	/**
	 * @param codigoUsuario Define o código
	 */
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	/**
	 * @return String - Retorna o login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login Define o login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return String - Retorna a senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha Define a senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return double - Retorna a altura
	 */
	public double getAltura() {
		return altura;
	}

	/**
	 * @param altura Define a altura
	 */
	public void setAltura(double altura) {
		this.altura = altura;
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

	/**
	 * @return String - Retorna a do cadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param dataCadastro Define a do cadastro
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
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

}
