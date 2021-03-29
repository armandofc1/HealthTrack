package br.com.fiap.helthtrack.infra;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbManager {
	public static synchronized Connection obterConexao() {
		Connection conexao = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conexao = DriverManager.getConnection(

					"jdbc:oracle:thin:@DESKTOP-RIC0A5K:1521:XE", "xe", "xe");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}

}
