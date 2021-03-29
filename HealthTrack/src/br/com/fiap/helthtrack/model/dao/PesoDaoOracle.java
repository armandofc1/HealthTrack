package br.com.fiap.helthtrack.model.dao;

import br.com.fiap.helthtrack.infra.DbManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.fiap.helthtrack.model.entities.Peso;

/**
 * Classe PesoDaoOracle
 * 
 * @author Armando Costa
 * @version 1.00
 * @since 12/09/2018
 */
public class PesoDaoOracle implements PesoDao {

	private Connection conexao;

	public PesoDaoOracle() {
		super();
	}

	public void cadastrar(Peso peso) {
		PreparedStatement stmt = null;
		try {
			conexao = DbManager.obterConexao();
			String sql = "INSERT INTO t_ht_peso (cd_peso, vl_peso, dt_medicao, cd_usuario) VALUES (SQ_peso.NEXTVAL, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, peso.getAfericao());
			stmt.setDate(2, new java.sql.Date(peso.getDataMedicao().getTime()));
			stmt.setInt(3, peso.getCodigoUsuario());

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
	 * @return pesos - Retorna a lista de pesos
	 */
	public List<Peso> listar() {
		List<Peso> lista = new ArrayList<Peso>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT cd_peso, vl_peso, dt_medicao, cd_usuario FROM t_ht_peso");
			rs = stmt.executeQuery();

			while (rs.next()) {

				int codigo = rs.getInt("cd_peso");
				int codigoUsuario = rs.getInt("cd_usuario");
				double afericao = rs.getDouble("vl_peso");
				java.util.Date dataMedicao = rs.getDate("dt_medicao");

				Peso peso = new Peso(codigo, codigoUsuario, afericao, dataMedicao, true);

				lista.add(peso);
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

	public void atualizar(Peso peso) {

		PreparedStatement stmt = null;
		try {
			conexao = DbManager.obterConexao();
			String sql = "UPDATE t_ht_peso SET vl_peso = ?, dt_medicao = ? WHERE cd_peso = ? AND cd_usuario = ?";

			stmt = conexao.prepareStatement(sql);

			stmt.setDouble(1, peso.getAfericao());
			stmt.setDate(2, new java.sql.Date(peso.getDataMedicao().getTime()));
			stmt.setInt(3, peso.getCodigoPeso());
			stmt.setInt(4, peso.getCodigoUsuario());

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
			String sql = "DELETE FROM t_ht_peso WHERE cd_peso = ?";
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

	public Peso buscarPorCodigo(int codigoBusca) {
		Peso peso = new Peso();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT cd_peso, vl_peso, dt_medicao, cd_usuario FROM t_ht_peso WHERE cd_peso = ?");
			stmt.setInt(1, codigoBusca);
			rs = stmt.executeQuery();
			if (rs.next()) {
				
				int codigo = rs.getInt("cd_peso");
				int codigoUsuario = rs.getInt("cd_usuario");
				double afericao = rs.getDouble("vl_peso");
				java.util.Date dataMedicao = rs.getDate("dt_medicao");

				peso = new Peso(codigo, codigoUsuario, afericao, dataMedicao, true);
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

		return peso;
	};
	
	public Peso ultimoPeso(int codigoBusca) {
		Peso peso = new Peso();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT cd_peso, vl_peso, dt_medicao, cd_usuario FROM t_ht_peso WHERE ROWNUM = 1 AND cd_usuario = ? ORDER BY dt_medicao DESC");
			stmt.setInt(1, codigoBusca);
			rs = stmt.executeQuery();
			if (rs.next()) {
				
				int codigo = rs.getInt("cd_peso");
				int codigoUsuario = rs.getInt("cd_usuario");
				double afericao = rs.getDouble("vl_peso");
				java.util.Date dataMedicao = rs.getDate("dt_medicao");

				peso = new Peso(codigo, codigoUsuario, afericao, dataMedicao, true);
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

		return peso;
	};

}
