package br.com.fiap.helthtrack.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.helthtrack.infra.DbManager;
import br.com.fiap.helthtrack.model.entities.AtividadeFisica;
import br.com.fiap.helthtrack.model.entities.TipoAtividadeFisica;

/**
 * Classe AtividadeFisicaDaoOracle
 * 
 * @author Armando Costa
 * @version 1.00
 * @since 05/10/2018
 */
public class AtividadeFisicaDaoOracle implements AtividadeFisicaDao{
	
	private Connection conexao;

	public AtividadeFisicaDaoOracle() {
		super();
	}

	public void cadastrar(AtividadeFisica atividadeFisica) {
		PreparedStatement stmt = null;
		try {
			conexao = DbManager.obterConexao();
			String sql = "INSERT INTO t_ht_atividade_fisica (cd_atividade_fisica, nm_atividade_fisica, ds_atividade_fisica, vl_gasto_calorico, dt_realizada, cd_tipo_atividade_fisica, cd_usuario) VALUES (SQ_atividade_fisica.NEXTVAL, ?, ?, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, atividadeFisica.getNome());
			stmt.setString(2, atividadeFisica.getDescricao());
			stmt.setDouble(3, atividadeFisica.getGastoCalorico());
			stmt.setDate(4, new java.sql.Date(atividadeFisica.getDataMedicao().getTime()));
			stmt.setInt(5, atividadeFisica.getTipo().getCodigoTipoAtividadeFisica());
			stmt.setInt(6, atividadeFisica.getCodigoUsuario());
			
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
	 * @return lista - Retorna a lista de atividades
	 */
	public List<AtividadeFisica> listar() {
		List<AtividadeFisica> lista = new ArrayList<AtividadeFisica>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT AT.cd_atividade_fisica, AT.nm_atividade_fisica, AT.ds_atividade_fisica, AT.vl_gasto_calorico, AT.dt_realizada, AT.cd_tipo_atividade_fisica, AT.cd_usuario, TAT.nm_tipo_atividade_fisica FROM t_ht_atividade_fisica AT INNER JOIN  t_ht_tipo_atividade_fisica TAT ON TAT.cd_tipo_atividade_fisica = AT.cd_tipo_atividade_fisica");
			rs = stmt.executeQuery();

			while (rs.next()) {

				int codigo = rs.getInt("cd_atividade_fisica");
				int codigoUsuario = rs.getInt("cd_usuario");
				
				TipoAtividadeFisica tipo = new TipoAtividadeFisica();
				tipo.setCodigoTipoAtividadeFisica(rs.getInt("cd_tipo_atividade_fisica"));
				tipo.setNome(rs.getString("nm_tipo_atividade_fisica"));
				tipo.setAtivo(true);
				
				String nome = rs.getString("nm_atividade_fisica");
				String descricao = rs.getString("ds_atividade_fisica");
				double gastoCalorico = rs.getDouble("vl_gasto_calorico");
				java.util.Date dataMedicao = rs.getDate("dt_realizada");

				AtividadeFisica atividadeFisica = new AtividadeFisica(codigo, codigoUsuario, tipo, nome, descricao, gastoCalorico, dataMedicao, true);

				lista.add(atividadeFisica);
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

	public void atualizar(AtividadeFisica atividadeFisica) {

		PreparedStatement stmt = null;
		try {
			conexao = DbManager.obterConexao();
			String sql = "UPDATE t_ht_atividade_fisica SET nm_atividade_fisica = ?, ds_atividade_fisica = ?, vl_gasto_calorico = ?, dt_realizada = ?, cd_tipo_atividade_fisica = ? WHERE cd_atividade_fisica = ? AND cd_usuario = ?";

			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, atividadeFisica.getNome());
			stmt.setString(2, atividadeFisica.getDescricao());
			stmt.setDouble(3, atividadeFisica.getGastoCalorico());
			stmt.setDate(4, new java.sql.Date(atividadeFisica.getDataMedicao().getTime()));
			stmt.setInt(5, atividadeFisica.getTipo().getCodigoTipoAtividadeFisica());
			stmt.setInt(6, atividadeFisica.getCodigoAtividadeFisica());
			stmt.setInt(7, atividadeFisica.getCodigoUsuario());

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
			String sql = "DELETE FROM t_ht_atividade_fisica WHERE cd_atividade_fisica = ?";
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

	public AtividadeFisica buscarPorCodigo(int codigoBusca) {
		AtividadeFisica atividadeFisica = new AtividadeFisica();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT AT.cd_atividade_fisica, AT.nm_atividade_fisica, AT.ds_atividade_fisica, AT.vl_gasto_calorico, AT.dt_realizada, AT.cd_tipo_atividade_fisica, AT.cd_usuario, TAT.nm_tipo_atividade_fisica FROM t_ht_atividade_fisica AT INNER JOIN  t_ht_tipo_atividade_fisica TAT ON TAT.cd_tipo_atividade_fisica = AT.cd_tipo_atividade_fisica WHERE AT.cd_atividade_fisica = ?");
			stmt.setInt(1, codigoBusca);
			rs = stmt.executeQuery();
			if (rs.next()) {
				
				int codigo = rs.getInt("cd_atividade_fisica");
				int codigoUsuario = rs.getInt("cd_usuario");
				
				TipoAtividadeFisica tipo = new TipoAtividadeFisica();
				tipo.setCodigoTipoAtividadeFisica(rs.getInt("cd_tipo_atividade_fisica"));
				tipo.setNome(rs.getString("nm_tipo_atividade_fisica"));
				tipo.setAtivo(true);
				
				String nome = rs.getString("nm_atividade_fisica");
				String descricao = rs.getString("ds_atividade_fisica");
				double gastoCalorico = rs.getDouble("vl_gasto_calorico");
				java.util.Date dt_realizada = rs.getDate("dt_realizada");

				atividadeFisica = new AtividadeFisica(codigo, codigoUsuario, tipo, nome, descricao, gastoCalorico, dt_realizada, true);

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

		return atividadeFisica;
	};
}
