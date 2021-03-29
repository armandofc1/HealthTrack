package br.com.fiap.helthtrack.model.dao;

import java.util.List;

import br.com.fiap.helthtrack.model.entities.Peso;

public interface PesoDao {
	public void cadastrar(Peso peso);
	public List<Peso> listar();
	public void atualizar(Peso peso);
	public void remover(int codigo);
	public Peso buscarPorCodigo(int codigoBusca);
	public Peso ultimoPeso(int codigoBusca);
}
