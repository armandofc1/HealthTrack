package br.com.fiap.helthtrack.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.helthtrack.infra.DbManager;
import br.com.fiap.helthtrack.model.entities.Usuario;
import br.com.fiap.helthtrack.model.enums.Sexo;

/**
 * Classe UsuarioDaoOracle
 * 
 * @author Armando Costa
 * @version 1.00
 * @since 12/09/2018
 */
public class UsuarioDaoOracle implements UsuarioDao {

	private Connection conexao;

	public UsuarioDaoOracle() {
		super();
	}

	public void cadastrar(Usuario usuario) {
		PreparedStatement stmt = null;
		try {
			conexao = DbManager.obterConexao();
			String sql = "INSERT INTO t_ht_usuario (cd_usuario, login, senha, nm_nome, nm_sobrenome, sexo, dt_nascimento, vl_altura, ds_foto, dt_cadastro) VALUES (SQ_usuario.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, SYSTIMESTAMP)";

			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getNome());
			stmt.setString(4, usuario.getSobrenome());
			stmt.setString(5, Integer.toString(usuario.getSexo().getValor()));
			stmt.setDate(6, new java.sql.Date(usuario.getDataNascimento().getTime()));
			stmt.setDouble(7, usuario.getAltura());
			stmt.setString(8, usuario.getFoto());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	};

	/**
	 * @return lista - Retorna a lista de usuários
	 */
	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<Usuario>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement(
					"SELECT cd_usuario, login, senha, nm_nome, nm_sobrenome, sexo, dt_nascimento, vl_altura, ds_foto, dt_cadastro FROM t_ht_usuario");
			rs = stmt.executeQuery();

			while (rs.next()) {

				int codigo = rs.getInt("cd_usuario");
				String login = rs.getString("login");
				String nome = rs.getString("nm_nome");
				String sobrenome = rs.getString("nm_sobrenome");
				Sexo sexo;
				if(rs.getString("sexo") == "1") {
					sexo = Sexo.Masculino;
				}else if(rs.getString("sexo") == "2") {
					sexo = Sexo.Feminino;
				}else {
					sexo = Sexo.Indefinido;
				}
				java.sql.Date dataNascimento = rs.getDate("dt_nascimento");
				double altura = rs.getDouble("vl_altura");
				String foto = rs.getString("ds_foto");
				java.util.Date dataCadastro = rs.getDate("dt_cadastro");

				Usuario usuario = new Usuario(codigo, login, nome, sobrenome, sexo, dataNascimento, altura, foto,
						dataCadastro, true);

				lista.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lista;
	}

	public void atualizar(Usuario usuario) {

		PreparedStatement stmt = null;
		try {
			conexao = DbManager.obterConexao();
			String sql = "UPDATE t_ht_usuario SET login = ?, senha = ?, nm_nome = ?, nm_sobrenome = ?, sexo = ?, dt_nascimento = ?, vl_altura = ?, ds_foto = ? WHERE cd_usuario = ?";

			stmt = conexao.prepareStatement(sql);

			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getNome());
			stmt.setString(4, usuario.getSobrenome());
			stmt.setString(5, Integer.toString(usuario.getSexo().getValor()));
			stmt.setDate(6, new java.sql.Date(usuario.getDataNascimento().getTime()));
			stmt.setDouble(7, usuario.getAltura());
			stmt.setString(8, usuario.getFoto());
			stmt.setInt(9, usuario.getCodigoUsuario());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	};

	public void remover(int codigo) {
		PreparedStatement stmt = null;
		try {
			conexao = DbManager.obterConexao();
			String sql = "DELETE FROM t_ht_usuario WHERE cd_usuario = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	};

	public Usuario buscarPorCodigo(int codigoBusca) {
		Usuario usuario = new Usuario();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement(
					"SELECT cd_usuario, login, senha, nm_nome, nm_sobrenome, sexo, dt_nascimento, vl_altura, ds_foto, dt_cadastro FROM t_ht_usuario WHERE cd_usuario = ?");
			stmt.setInt(1, codigoBusca);
			rs = stmt.executeQuery();
			if (rs.next()) {

				int codigo = rs.getInt("cd_usuario");
				String login = rs.getString("login");
				String nome = rs.getString("nm_nome");
				String sobrenome = rs.getString("nm_sobrenome");
				Sexo sexo;
				if(rs.getString("sexo") == "1") {
					sexo = Sexo.Masculino;
				}else if(rs.getString("sexo") == "2") {
					sexo = Sexo.Feminino;
				}else {
					sexo = Sexo.Indefinido;
				}
				java.sql.Date dataNascimento = rs.getDate("dt_nascimento");
				double altura = rs.getDouble("vl_altura");
				String foto = rs.getString("ds_foto");
				java.util.Date dataCadastro = rs.getDate("dt_cadastro");

				usuario = new Usuario(codigo, login, nome, sobrenome, sexo, dataNascimento, altura, foto, dataCadastro,
						true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return usuario;
	}

	public Usuario login(String usuarioLogin, String senha) {
		Usuario usuario = new Usuario();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement(
					"SELECT cd_usuario, login, senha, nm_nome, nm_sobrenome, sexo, dt_nascimento, vl_altura, ds_foto, dt_cadastro FROM t_ht_usuario WHERE login = ? AND senha = ?");
			stmt.setString(1, usuarioLogin);
			stmt.setString(2, senha);
			rs = stmt.executeQuery();
			if (rs.next()) {

				int codigo = rs.getInt("cd_usuario");
				String login = rs.getString("login");
				String nome = rs.getString("nm_nome");
				String sobrenome = rs.getString("nm_sobrenome");
				Sexo sexo;
				if(rs.getString("sexo") == "1") {
					sexo = Sexo.Masculino;
				}else if(rs.getString("sexo") == "2") {
					sexo = Sexo.Feminino;
				}else {
					sexo = Sexo.Indefinido;
				}
				java.sql.Date dataNascimento = rs.getDate("dt_nascimento");
				double altura = rs.getDouble("vl_altura");
				String foto = rs.getString("ds_foto");
				java.util.Date dataCadastro = rs.getDate("dt_cadastro");

				usuario = new Usuario(codigo, login, nome, sobrenome, sexo, dataNascimento, altura, foto, dataCadastro,
						true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return usuario;
	}

}
