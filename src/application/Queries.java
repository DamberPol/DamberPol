package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries extends ConnectionToDB implements QueriesInterface {
	String user = "sa";

	public ResultSet showAllTableKierowcy() throws SQLException {
		Statement stmt = makeStatement();
		stmt.execute("SELECT * FROM KIEROWCY");
		ResultSet rsKierowcy = stmt.getResultSet();

		return rsKierowcy;
	}

	public ResultSet showAllTableAutokary() throws SQLException {
		Statement stmt = makeStatement();
		stmt.execute("SELECT  * FROM AUTOKARY");
		ResultSet rsAutokary = stmt.getResultSet();

		return rsAutokary;
	}

	public ResultSet showAllTableKursy() throws SQLException {
		Statement stmt = makeStatement();
		stmt.execute("SELECT * FROM KURSY");
		ResultSet rsKursy = stmt.getResultSet();

		return rsKursy;
	}

	public ResultSet showAllTableMiejscowosci() throws SQLException {
		Statement stmt = makeStatement();
		stmt.execute("SELECT * FROM MIEJSCOWOSCI");
		ResultSet rsMiejscowosci = stmt.getResultSet();

		return rsMiejscowosci;
	}

	public ResultSet showAllTablePrzystanki() throws SQLException {
		Statement stmt = makeStatement();
		stmt.execute("SELECT * FROM PRZYSTANKI");
		ResultSet rsPrzystanki = stmt.getResultSet();

		return rsPrzystanki;
	}

	public ResultSet showAllTableRejestrPrzejazdow() throws SQLException {
		Statement stmt = makeStatement();
		stmt.execute(
				"SELECT REJESTR_PRZEJAZDOW.REJ_KEY, KURSY.KUR_Miejsc_Startowa, PRZYSTANKI.PR_Ulica, REJESTR_PRZEJAZDOW.REJ_data_start, REJESTR_PRZEJAZDOW.REJ_data_konc,  REJESTR_PRZEJAZDOW.REJ_iloscOsob FROM REJESTR_PRZEJAZDOW INNER JOIN KURSY ON REJESTR_PRZEJAZDOW.KUR_KEY = KURSY.KUR_KEY INNER JOIN TRASA ON KURSY.KUR_KEY = TRASA.KUR_KEY INNER JOIN PRZYSTANKI ON TRASA.PR_KEY = PRZYSTANKI.PR_KEY");
		ResultSet rsRejestrPrzejazdow = stmt.getResultSet();

		return rsRejestrPrzejazdow;
	}

	public ResultSet showAllTableTrasy() throws SQLException {
		Statement stmt = makeStatement();
		String query = "SELECT TRASA.TR_KEY, KURSY.KUR_Sygnatura_Kursu, MIEJSCOWOSCI.MIE_Nazwa_Miejscow, PRZYSTANKI.PR_Ulica, TRASA.TR_Godzina, TRASA.TR_Dzieñ_tyg, TRASA.TR_Uwagi FROM TRASA INNER JOIN KURSY ON TRASA.KUR_KEY = KURSY.KUR_KEY INNER JOIN PRZYSTANKI ON TRASA.PR_KEY = PRZYSTANKI.PR_KEY INNER JOIN MIEJSCOWOSCI ON PRZYSTANKI.MIE_KEY = MIEJSCOWOSCI.MIE_KEY";
		System.out.println(query);
		stmt.execute(query);

		ResultSet rsTrasy = stmt.getResultSet();

		return rsTrasy;
	}

	@Override
	public void insertDataToAutokary(String AUT_Marka, String AUT_Model, int AUT_Rok_Prod, int AUT_Poj_Silnik,
			int AUT_Spalanie, String AUT_Kategoria, int AUT_Ilosc_Miejsc, String AUT_NR_Rej) {

		getConnection(user);
		try {

			String insertAutokar = "INSERT INTO [dbo].[AUTOKARY]([AUT_Marka]," + "[AUT_Model]," + "[AUT_Rok_Prod],"
					+ "[AUT_Poj_silnik]," + "[AUT_Spalanie_l/km]," + "[AUT_Kat_autokaru]," + "[AUT_Iloœæ_miejsc],"
					+ "[AUT_Nr_rejestracji])" + "VALUES " + "(" + AUT_Marka + "," + AUT_Model + "," + AUT_Rok_Prod + ","
					+ AUT_Poj_Silnik + "," + AUT_Spalanie + "," + AUT_Kategoria + "," + AUT_Ilosc_Miejsc + ","
					+ AUT_NR_Rej;
			System.out.println(insertAutokar);
			Statement stmt = connectionToDB.createStatement();
			stmt.executeUpdate(insertAutokar);

			System.out.println("Dane poprawnie dodane do tabeli");
		} catch (SQLException e) {
			System.out.println("Dane nie dodane do tabeli");
			System.out.println(e);
		}
	}

	@Override
	public void insertDataToMiejscowosci(String MIE_Nazwa_Miejscow, String MIE_Wojewodztwo, String MIE_Powiat,
			String MIE_Gmina) {
		getConnection(user);
		try {

			String insertMiejscowosci = "INSERT INTO [dbo].[MIEJSCOWOSCI]([MIE_Nazwa_Miejscow],[MIE_Województwo],[MIE_Powiat],[MIE_Gmina]) VALUES ("
					+ MIE_Nazwa_Miejscow + "," + MIE_Wojewodztwo + "," + MIE_Powiat + "," + MIE_Gmina + ")";
			Statement stmt = connectionToDB.createStatement();
			System.out.println(insertMiejscowosci);
			stmt.executeUpdate(insertMiejscowosci);

			System.out.println("Dane poprawnie dodane do tabeli");
		} catch (SQLException e) {
			System.out.println("Dane nie dodane do tabeli");
			System.out.println(e);
		}
	}

	@Override
	public void insertDataToRaport(int KUR_KEY, String REJ_data_start, String REJ_data_konc, int REJ_iloscOsob)
			throws SQLException {
		getConnection(user);
		try {

			String insertRaport = "INSERT INTO [dbo].[REJESTR_PRZEJAZDOW] ([KUR_KEY], [REJ_data_start],[REJ_data_konc],[REJ_iloscOsob]) VALUES ("
					+ KUR_KEY + "," + REJ_data_start + "," + REJ_data_konc + "," + REJ_iloscOsob + ")";
			Statement stmt = connectionToDB.createStatement();
			System.out.println(insertRaport);
			stmt.executeUpdate(insertRaport);
			System.out.println("Raport z³o¿ony poprawnie");
		} catch (Exception e) {
			System.out.println("Wyst¹pi³ b³¹d podczas sk³adania raportu");
			System.out.println(e);
		}
	}
	
	@Override
	public void deleteByIdAutokary(int id) throws SQLException {
		getConnection(user);
		Statement stmt = connectionToDB.createStatement();
		System.out.println(id);
		try {
			stmt.execute("DELETE FROM [master].[dbo].[AUTOKARY] WHERE AUT_KEY= " + id);
			System.out.println("Rejestr o podanym ID poprawnie usuniêty");
		} catch (Exception e) {
			System.out.println("Problem z usunieciem rekordu");
			System.out.println(e);
		}

	}

	@Override
	public void deleteByIdKierowcy(int id) throws SQLException {
		getConnection(user);
		Statement stmt = connectionToDB.createStatement();
		System.out.println(id);
		try {
			stmt.execute("DELETE FROM [master].[dbo].[KIEROWCY] WHERE KIE_KEY= " + id);
			System.out.println("Rejestr o podanym ID poprawnie usuniêty");
		} catch (Exception e) {
			System.out.println("Problem z usunieciem rekordu");
			System.out.println(e);
		}

	}

	@Override
	public void deleteByIdKursy(int id) throws SQLException {
		getConnection(user);
		Statement stmt = connectionToDB.createStatement();
		System.out.println(id);
		try {
			stmt.execute("DELETE FROM [master].[dbo].[KURSY] WHERE KUR_KEY= " + id);
			System.out.println("Rejestr o podanym ID poprawnie usuniêty");
		} catch (Exception e) {
			System.out.println("Problem z usunieciem rekordu");
			System.out.println(e);
		}

	}

	@Override
	public void deleteByIdMiejscowosci(int id) throws SQLException {
		getConnection(user);
		Statement stmt = connectionToDB.createStatement();
		System.out.println(id);
		try {
			stmt.execute("DELETE FROM [master].[dbo].[MIEJSCOWOSCI] WHERE MIE_KEY= " + id);
			System.out.println("Rejestr o podanym ID poprawnie usuniêty");
		} catch (Exception e) {
			System.out.println("Problem z usunieciem rekordu");
			System.out.println(e);
		}

	}

	@Override
	public void deleteByIdPrzystanki(int id) throws SQLException {
		getConnection(user);
		Statement stmt = connectionToDB.createStatement();
		System.out.println(id);
		try {
			stmt.execute("DELETE FROM [master].[dbo].[PRZYSTANKI] WHERE PR_KEY= " + id);
			System.out.println("Rejestr o podanym ID poprawnie usuniêty");
		} catch (Exception e) {
			System.out.println("Problem z usunieciem rekordu");
			System.out.println(e);
		}

	}

	@Override
	public void deleteByIdTrasy(int id) throws SQLException {
		getConnection(user);
		Statement stmt = connectionToDB.createStatement();
		System.out.println(id);
		try {
			stmt.execute("DELETE FROM [master].[dbo].[TRASA] WHERE TR_KEY= " + id);
			System.out.println("Rejestr o podanym ID poprawnie usuniêty");
		} catch (Exception e) {
			System.out.println("Problem z usunieciem rekordu");
			System.out.println(e);
		}

	}

	public void deleteByIdRejestrPrzejazdow(int id) throws SQLException {
		getConnection(user);
		Statement stmt = connectionToDB.createStatement();
		System.out.println(id);
		try {
			stmt.execute("DELETE FROM [master].[dbo].[REJESTR_PRZEJAZDOW] WHERE REJ_KEY= " + id);
			System.out.println("Rejestr o podanym ID poprawnie usuniêty");
		} catch (Exception e) {
			System.out.println("Problem z usunieciem rekordu");
			System.out.println(e);
		}
		
	}

}
