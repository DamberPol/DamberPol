package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionToDB {
	Connection connectionToDB = null;

	public Connection getConnection(String user) {

		try {
			String Connectionurl = "jdbc:sqlserver://localhost:1433;DatabaseName=master;user= " + user
					+ ";Password=haslo";
			connectionToDB = DriverManager.getConnection(Connectionurl);
			if (connectionToDB != null) {
				System.out.println("Poprawnie polaczono z baza danych");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return connectionToDB;
	}

	public Statement makeStatement() {
		Statement stmt = null;
		try {
			String user = "sa";
			getConnection(user);
			stmt = connectionToDB.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
}
