package br.com.fiap.helthtrack.model.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import br.com.fiap.helthtrack.model.enums.*;

/**Classe Pessoa
 * @author Armando Costa
 * @version 1.00
 * @since 24/08/2018
*/
public class Pessoa implements Serializable{

	protected String nome;
	protected String sobrenome;
	protected Sexo sexo;
	protected Date dataNascimento;
	
	public Pessoa() {
		super();
	}
	
	/**
	 * @param nome Define o nome
	 * @param sobrenome Define o sobrenome
	 * @param sexo Define o sexo
	 * @param dataNascimento Define a data de nascimento
	 */
	public Pessoa(String nome, String sobrenome, Sexo sexo, Date dataNascimento) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
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

	/**
	 * @return String - Retorna o sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * @param sobrenome Define o sobrenome
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	/**
	 * @return Sexo - Retorna o sexo
	 */
	public Sexo getSexo() {
		return sexo;
	}

	/**
	 * @param sexo Define o sexo
	 */
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return Date - Retorna a data de nascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento Define a data de nascimento
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	/**
	 * @return int  - Retorna a idade atual em anos.
	*/
	public int idade() {
		int idade = 0;
		if (this.dataNascimento != null) {

			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(this.dataNascimento);
			Calendar hoje = Calendar.getInstance();

			idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

			if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
				idade--;
			} else {
				if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH)
						&& hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
					idade--;
				}
			}
		}
		return idade;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", sobrenome=" + sobrenome + ", sexo=" + sexo + ", dataNascimento="
				+ dataNascimento + "]";
	}
	
}
