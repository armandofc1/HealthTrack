package br.com.fiap.helthtrack.infra;

import br.com.fiap.helthtrack.model.dao.*;


public abstract class DAOFactory {
	
	public static AlimentoDao getAlimentoDAO() {
		return new AlimentoDaoOracle();
	}

	public static AtividadeFisicaDao getAtividadeFisicaDAO() {
		return new AtividadeFisicaDaoOracle();
	}
	
	public static PesoDao getPesoDAO() {
		return new PesoDaoOracle();
	}
	
	public static PressaoArterialDao getPressaoArterialDAO() {
		return new PressaoArterialDaoOracle();
	}
	
	public static UsuarioDao getUsuarioDAO() {
		return new UsuarioDaoOracle();
	}
}
