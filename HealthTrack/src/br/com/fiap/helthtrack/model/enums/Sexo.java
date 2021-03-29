package br.com.fiap.helthtrack.model.enums;

public enum Sexo {
	Masculino(1), Feminino(2), Indefinido(3);

	private final int valor;

	Sexo(int valorSexo) {
		valor = valorSexo;
	}

	public int getValor() {
		return valor;
	}
	
}
