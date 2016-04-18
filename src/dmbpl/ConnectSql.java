package dmbpl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSql {

	public Connection getConnection() throws Exception {

		Connection conn = null;
		try {
			String Connectionurl = "jdbc:sqlserver://localhost:1433;DatabaseName=master;user=sa;Password=haslo";

			conn = DriverManager.getConnection(Connectionurl);
			if (conn != null) {
				System.out.println("Polaczenie z DB poprawne");
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT [KIE_KEY],[KIE_Imie],[KIE_Nazwisko],[KIE_Pesel],[KIE_Data_zatr] FROM [master].[dbo].[KIEROWCY]");
	            while ( rs.next() ) {
	                String lastName = rs.getString("KIE_KEY,KIE_Imie,KIE_Nazwisko,KIE_Pesel,KIE_Data_zat]");
	                System.out.println(lastName);
	            }
	            conn.close();
			}

		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return null;
	}

}
