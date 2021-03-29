package br.com.fiap.helthtrack.model.dao;

import br.com.fiap.helthtrack.infra.DbManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.fiap.helthtrack.model.entities.PressaoArterial;

/**
 * Classe PressaoArterialDaoOracle
 * @author Armando Costa
 * @version 1.00
 * @since 12/09/2018
 */
public class PressaoArterialDaoOracle implements PressaoArterialDao {

	private Connection conexao;
	
	public PressaoArterialDaoOracle() {
		super();
	}

	public void cadastrar(PressaoArterial pressao) {
		PreparedStatement stmt = null;
		try {
			conexao = DbManager.obterConexao();
			String sql = "INSERT INTO t_ht_pressao_arterial (cd_pressao, cd_usuario, vl_pressao_sistolica, vl_pressao_diastolica, dt_medicao) VALUES (SQ_pressao_arterial.NEXTVAL, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, pressao.getCodigoUsuario());
			stmt.setDouble(2, pressao.getSistolica());
			stmt.setDouble(3, pressao.getDiastolica());
			stmt.setDate(4, new java.sql.Date(pressao.getDataMedicao().getTime()));

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
	}

	/**
	 * @return pesos - Retorna a lista de pressoes
	 */
	public List<PressaoArterial> listar() {
		List<PressaoArterial> lista = new ArrayList<PressaoArterial>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT cd_pressao, cd_usuario, vl_pressao_sistolica, vl_pressao_diastolica, dt_medicao FROM t_ht_pressao_arterial");
			rs = stmt.executeQuery();

			while (rs.next()) {

				int codigo = rs.getInt("cd_pressao");
				int codigoUsuario = rs.getInt("cd_usuario");
				double sistolica = rs.getDouble("vl_pressao_sistolica");
				double diastolica = rs.getDouble("vl_pressao_diastolica");
				java.util.Date dataMedicao = rs.getDate("dt_medicao");

				PressaoArterial pressao = new PressaoArterial(codigo, codigoUsuario, sistolica, diastolica, dataMedicao, true);

				lista.add(pressao);
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

	public void atualizar(PressaoArterial pressao) {

		PreparedStatement stmt = null;
		try {
			conexao = DbManager.obterConexao();
			String sql = "UPDATE t_ht_pressao_arterial SET vl_pressao_sistolica = ?, vl_pressao_diastolica = ?, dt_medicao = ? WHERE cd_pressao = ? AND cd_usuario = ?";

			stmt = conexao.prepareStatement(sql);

			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, pressao.getSistolica());
			stmt.setDouble(2, pressao.getDiastolica());
			stmt.setDate(3, new java.sql.Date(pressao.getDataMedicao().getTime()));
			stmt.setInt(4, pressao.getCodigoPressaoArterial());
			stmt.setInt(5, pressao.getCodigoUsuario());

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
			String sql = "DELETE FROM t_ht_pressao_arterial WHERE cd_pressao = ?";
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
	}

	public PressaoArterial buscarPorCodigo(int codigoBusca) {
		PressaoArterial pressao = new PressaoArterial();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT cd_pressao, cd_usuario, vl_pressao_sistolica, vl_pressao_diastolica, dt_medicao FROM t_ht_pressao_arterial WHERE cd_pressao = ?");
			stmt.setInt(1, codigoBusca);
			rs = stmt.executeQuery();
			if (rs.next()) {
				
				int codigo = rs.getInt("cd_pressao");
				int codigoUsuario = rs.getInt("cd_usuario");
				double sistolica = rs.getDouble("vl_pressao_sistolica");
				double diastolica = rs.getDouble("vl_pressao_diastolica");
				java.util.Date dataMedicao = rs.getDate("dt_medicao");

				pressao = new PressaoArterial(codigo, codigoUsuario, sistolica, diastolica, dataMedicao, true);
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

		return pressao;
	}
	
	public PressaoArterial ultimaPressao(int codigoBusca) {
		PressaoArterial pressao = new PressaoArterial();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT cd_pressao, cd_usuario, vl_pressao_sistolica, vl_pressao_diastolica, dt_medicao FROM t_ht_pressao_arterial WHERE ROWNUM = 1 AND cd_usuario = ? ORDER BY dt_medicao DESC");
			stmt.setInt(1, codigoBusca);
			rs = stmt.executeQuery();
			if (rs.next()) {
				
				int codigo = rs.getInt("cd_pressao");
				int codigoUsuario = rs.getInt("cd_usuario");
				double sistolica = rs.getDouble("vl_pressao_sistolica");
				double diastolica = rs.getDouble("vl_pressao_diastolica");
				java.util.Date dataMedicao = rs.getDate("dt_medicao");

				pressao = new PressaoArterial(codigo, codigoUsuario, sistolica, diastolica, dataMedicao, true);
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

		return pressao;
	}
}
