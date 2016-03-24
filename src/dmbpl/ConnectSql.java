package dmbpl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSql {

	public Connection getConnection() throws Exception {

		Connection conn = null;
		try {
			String Connectionurl = "jdbc:sqlserver://localhost:1433;DatabaseName=master;user=sa;Password=haslo";
			/*
			 * String host = "jdbc:sqlserver://MAMUSIA\\SQLEXPRESS"; 
			 * String user = "sa"; 
			 * String pass = "haslo";
			 */
			conn = DriverManager.getConnection(Connectionurl);
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
			}

		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return null;
	}

}
