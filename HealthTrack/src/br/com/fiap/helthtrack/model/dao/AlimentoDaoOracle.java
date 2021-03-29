package br.com.fiap.helthtrack.model.dao;

import br.com.fiap.helthtrack.infra.DbManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.fiap.helthtrack.model.entities.Alimento;
import br.com.fiap.helthtrack.model.entities.TipoAlimentacao;

/**
 * Classe AlimentoDaoOracle
 * 
 * @author Armando Costa
 * @version 1.00
 * @since 05/10/2018
 */
public class AlimentoDaoOracle implements AlimentoDao{
	
	private Connection conexao;

	public AlimentoDaoOracle() {
		super();
	}

	public void cadastrar(Alimento alimento) {
		PreparedStatement stmt = null;
		try {
			conexao = DbManager.obterConexao();
			String sql = "INSERT INTO t_ht_alimentacao (cd_alimentacao, cd_usuario, nm_alimento, ds_alimento, vl_calorias, dt_consumo, cd_tipo_alimentacao) VALUES (SQ_alimentacao.NEXTVAL, ?, ?, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, alimento.getCodigoUsuario());
			stmt.setString(2, alimento.getNome());
			stmt.setString(3, alimento.getDescricao());
			stmt.setDouble(4, alimento.getCalorias());
			stmt.setDate(5, new java.sql.Date(alimento.getDataConsumo().getTime()));
			stmt.setInt(6, alimento.getTipo().getCodigoTipoAlimentacao());
			
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
	 * @return lista - Retorna a lista de alimentos
	 */
	public List<Alimento> listar() {
		List<Alimento> lista = new ArrayList<Alimento>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT AL.cd_alimentacao, AL.cd_usuario, AL.nm_alimento, AL.ds_alimento, AL.vl_calorias, AL.dt_consumo, AL.cd_tipo_alimentacao,  ALT.nm_tipo_alimentacao FROM t_ht_alimentacao AL INNER JOIN t_ht_tipo_alimentacao ALT ON ALT.cd_tipo_alimentacao = AL.cd_tipo_alimentacao");
			rs = stmt.executeQuery();

			while (rs.next()) {

				int codigo = rs.getInt("cd_alimentacao");
				int codigoUsuario = rs.getInt("cd_usuario");
				
				TipoAlimentacao tipo = new TipoAlimentacao();
				tipo.setCodigoTipoAlimentacao(rs.getInt("cd_tipo_alimentacao"));
				tipo.setNome(rs.getString("nm_tipo_alimentacao"));
				tipo.setAtivo(true);
				
				String nome = rs.getString("nm_alimento");
				String descricao = rs.getString("ds_alimento");
				double calorias = rs.getDouble("vl_calorias");
				java.util.Date dataConsumo = rs.getDate("dt_consumo");

				Alimento alimento = new Alimento(codigo, codigoUsuario, tipo, nome, descricao, calorias, dataConsumo, true);

				lista.add(alimento);
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

	public void atualizar(Alimento alimento) {

		PreparedStatement stmt = null;
		try {
			conexao = DbManager.obterConexao();
			String sql = "UPDATE t_ht_alimentacao SET nm_alimento = ?, ds_alimento = ?, vl_calorias = ?, dt_consumo = ?, cd_tipo_alimentacao = ? WHERE cd_alimentacao = ? AND cd_usuario = ?";

			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, alimento.getNome());
			stmt.setString(2, alimento.getDescricao());
			stmt.setDouble(3, alimento.getCalorias());
			stmt.setDate(4, new java.sql.Date(alimento.getDataConsumo().getTime()));
			stmt.setInt(5, alimento.getTipo().getCodigoTipoAlimentacao());
			stmt.setInt(6, alimento.getCodigoAlimentacao());
			stmt.setInt(7, alimento.getCodigoUsuario());

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
			String sql = "DELETE FROM t_ht_alimentacao WHERE cd_alimentacao = ?";
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

	public Alimento buscarPorCodigo(int codigoBusca) {
		Alimento alimento = new Alimento();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = DbManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT AL.cd_alimentacao, AL.cd_usuario, AL.nm_alimento, AL.ds_alimento, AL.vl_calorias, AL.dt_consumo, AL.cd_tipo_alimentacao,  ALT.nm_tipo_atividade_fisica FROM t_ht_alimentacao AL INNER JOIN t_ht_tipo_alimentacao ALT ON ALT.cd_tipo_alimentacao = AL.cd_tipo_alimentacao WHERE AL.cd_alimentacao = ?");
			stmt.setInt(1, codigoBusca);
			rs = stmt.executeQuery();
			if (rs.next()) {
				
				int codigo = rs.getInt("cd_alimentacao");
				int codigoUsuario = rs.getInt("cd_usuario");
				
				TipoAlimentacao tipo = new TipoAlimentacao();
				tipo.setCodigoTipoAlimentacao(rs.getInt("cd_tipo_alimentacao"));
				tipo.setNome(rs.getString("nm_tipo_atividade_fisica"));
				tipo.setAtivo(true);
				
				String nome = rs.getString("nm_alimento");
				String descricao = rs.getString("ds_alimento");
				double calorias = rs.getDouble("vl_calorias");
				java.util.Date dataConsumo = rs.getDate("dt_consumo");

				alimento = new Alimento(codigo, codigoUsuario, tipo, nome, descricao, calorias, dataConsumo, true);

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

		return alimento;
	};
}
