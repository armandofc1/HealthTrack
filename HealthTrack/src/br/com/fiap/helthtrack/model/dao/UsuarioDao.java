package br.com.fiap.helthtrack.model.dao;

import java.util.List;

import br.com.fiap.helthtrack.model.entities.Usuario;

public interface UsuarioDao {
	public void cadastrar(Usuario usuario);
	public List<Usuario> listar();
	public void atualizar(Usuario usuario);
	public void remover(int codigo);
	public Usuario buscarPorCodigo(int codigoBusca);
	public Usuario login(String usuarioLogin, String senha);
}
