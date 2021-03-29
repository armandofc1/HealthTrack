package br.com.fiap.helthtrack.model.dao;

import java.util.List;

import br.com.fiap.helthtrack.model.entities.PressaoArterial;

public interface PressaoArterialDao {
	public void cadastrar(PressaoArterial pressao);
	public List<PressaoArterial> listar();
	public void atualizar(PressaoArterial pressao);
	public void remover(int codigo);
	public PressaoArterial buscarPorCodigo(int codigoBusca);
	public PressaoArterial ultimaPressao(int codigoBusca);
}
