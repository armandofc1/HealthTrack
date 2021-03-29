package br.com.fiap.helthtrack.model.dao;

import java.util.List;

import br.com.fiap.helthtrack.model.entities.AtividadeFisica;

public interface AtividadeFisicaDao {
	public void cadastrar(AtividadeFisica atividade);
	public List<AtividadeFisica> listar();
	public void atualizar(AtividadeFisica atividade);
	public void remover(int codigo);
	public AtividadeFisica buscarPorCodigo(int codigoBusca);
}
