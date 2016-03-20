package dmbpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSql {

	public Connection getConnection() throws Exception {

		try {

			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306";
			String username = "root";
			String password = "";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);

			System.out.println("Successfully Connected to database");

		} catch (SQLException e) {
			System.err.println(e);

		}
		return null;
	}

}
