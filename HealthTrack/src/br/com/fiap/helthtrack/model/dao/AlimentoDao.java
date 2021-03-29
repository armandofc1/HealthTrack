package br.com.fiap.helthtrack.model.dao;

import java.util.List;

import br.com.fiap.helthtrack.model.entities.Alimento;

public interface AlimentoDao {
	public void cadastrar(Alimento alimento);
	public List<Alimento> listar();
	public void atualizar(Alimento alimento);
	public void remover(int codigo);
	public Alimento buscarPorCodigo(int codigoBusca);
}
