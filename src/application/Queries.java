package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.glass.ui.GestureSupport;

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
		String query = "SELECT TRASA.TR_KEY, KURSY.KUR_Sygnatura_Kursu, MIEJSCOWOSCI.MIE_Nazwa_Miejscow, PRZYSTANKI.PR_Ulica, TRASA.TR_Godzina, TRASA.TR_Dzie�_tyg, TRASA.TR_Uwagi FROM TRASA INNER JOIN KURSY ON TRASA.KUR_KEY = KURSY.KUR_KEY INNER JOIN PRZYSTANKI ON TRASA.PR_KEY = PRZYSTANKI.PR_KEY INNER JOIN MIEJSCOWOSCI ON PRZYSTANKI.MIE_KEY = MIEJSCOWOSCI.MIE_KEY";
		System.out.println(query);
		stmt.execute(query);

		ResultSet rsTrasy = stmt.getResultSet();

		return rsTrasy;
	}

	@Override
	public void deleteByIdAutokary(int id) throws SQLException {
		getConnection(user);
		Statement stmt = connectionToDB.createStatement();
		System.out.println(id);
		try {
			stmt.execute("DELETE FROM [master].[dbo].[AUTOKARY] WHERE AUT_KEY= " + id);
			System.out.println("Rejestr o podanym ID poprawnie usuni�ty");
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
			System.out.println("Rejestr o podanym ID poprawnie usuni�ty");
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
			System.out.println("Rejestr o podanym ID poprawnie usuni�ty");
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
			System.out.println("Rejestr o podanym ID poprawnie usuni�ty");
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
			System.out.println("Rejestr o podanym ID poprawnie usuni�ty");
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
			System.out.println("Rejestr o podanym ID poprawnie usuni�ty");
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
			System.out.println("Rejestr o podanym ID poprawnie usuni�ty");
		} catch (Exception e) {
			System.out.println("Problem z usunieciem rekordu");
			System.out.println(e);
		}

	}

	@Override
	public void insertDataToAutokary(String AUT_Marka, String AUT_Model, int AUT_Rok_Prod, int AUT_Poj_Silnik,
			int AUT_Spalanie, String AUT_Kategoria, int AUT_Ilosc_Miejsc, String AUT_NR_Rej) {
		getConnection(user);
		try {

			String insertAutokar = "INSERT INTO [dbo].[AUTOKARY]([AUT_Marka]," + "[AUT_Model]," + "[AUT_Rok_Prod],"
					+ "[AUT_Poj_silnik]," + "[AUT_Spalanie_l/km]," + "[AUT_Kat_autokaru]," + "[AUT_Ilo��_miejsc],"
					+ "[AUT_Nr_rejestracji])" + "VALUES " + "(" + AUT_Marka + "," + AUT_Model + "," + AUT_Rok_Prod + ","
					+ AUT_Poj_Silnik + "," + AUT_Spalanie + "," + AUT_Kategoria + "," + AUT_Ilosc_Miejsc + ","
					+ AUT_NR_Rej;
			// System.out.println(insertAutokar);
			Statement stmt = connectionToDB.createStatement();
			stmt.executeUpdate(insertAutokar);

			System.out.println("Dane poprawnie dodane do tabeli");
		} catch (SQLException e) {
			System.out.println("Dane nie dodane do tabeli");
			System.out.println(e);
		}
	}

	@Override
	public void insertDataToKierowcy(String KIE_Imie, String KIE_Nazwisko, String KIE_Pesel, String KIE_Data_zatr) {
		getConnection(user);
		try {

			String insertKierowcy = "INSERT INTO [dbo].[KIEROWCY] ([KIE_Imie],[KIE_Nazwisko],[KIE_Pesel],[KIE_Data_zatr]) VALUES ("
					+ KIE_Imie + "," + KIE_Nazwisko + "," + KIE_Pesel + "," + KIE_Data_zatr + ")";
			System.out.println(insertKierowcy);
			Statement stmt = connectionToDB.createStatement();
			stmt.executeUpdate(insertKierowcy);

			System.out.println("Dane poprawnie dodane do tabeli");
		} catch (SQLException e) {
			System.out.println("Dane nie dodane do tabeli");
			System.out.println(e);
		}
	}

	@Override
	public void insertDataToKursy(String imieKierowcy, String nazwiskoKierowcy, String numerRejAutokary,
			String KUR_Sygnatura_Kursu, String KUR_Opis, String KUR_Czas_Odjazdu, String KUR_Czas_Przyjazdu)
			throws SQLException {
		getConnection(user);
		try {

			String KIE_KEY = "SELECT KIE_KEY FROM [dbo].KIEROWCY WHERE KIE_Imie = " + imieKierowcy
					+ " AND KIE_Nazwisko=" + nazwiskoKierowcy;
			String AUT_KEY = "SELECT AUT_KEY FROM [dbo].AUTOKARY WHERE AUT_Nr_rejestracji = " + numerRejAutokary;

			Statement stmt = connectionToDB.createStatement();

			stmt.execute(AUT_KEY);
			ResultSet rsAUT_KEY = stmt.getResultSet();
			int inAUT_KEY = 0;
			while (rsAUT_KEY.next()) {
				inAUT_KEY = rsAUT_KEY.getInt("AUT_KEY");
			}

			stmt.execute(KIE_KEY);
			ResultSet rsKIE_KEY = stmt.getResultSet();
			int inKIE_KEY = 0;
			while (rsKIE_KEY.next()) {
				inKIE_KEY = rsKIE_KEY.getInt("KIE_KEY");
			}

			String insertKursy = "INSERT INTO [dbo].[KURSY] ([AUT_KEY],[KIE_KEY],[KUR_Sygnatura_Kursu],[KUR_Opis],[KUR_Czas_Odjazdu],[KUR_Czas_Przyjazdu]) VALUES ("
					+ inAUT_KEY + "," + inKIE_KEY + "," + KUR_Sygnatura_Kursu + "," + KUR_Opis + "," + KUR_Czas_Odjazdu
					+ "," + KUR_Czas_Przyjazdu + ")";

			// System.out.print(insertKursy);
			stmt.executeUpdate(insertKursy);

			System.out.println("Dane poprawnie dodane do tabeli");
			System.out.print(insertKursy);
		} catch (SQLException e) {

			System.out.println(e);
			System.out.println("Dane nie dodane do tabeli");
		}
	}

	@Override
	public void insertDataToMiejscowosci(String MIE_Nazwa_Miejscow, String MIE_Wojewodztwo, String MIE_Powiat,
			String MIE_Gmina) {
		getConnection(user);
		try {

			String insertMiejscowosci = "INSERT INTO [dbo].[MIEJSCOWOSCI]([MIE_Nazwa_Miejscow],[MIE_Wojew�dztwo],[MIE_Powiat],[MIE_Gmina]) VALUES ("
					+ MIE_Nazwa_Miejscow + "," + MIE_Wojewodztwo + "," + MIE_Powiat + "," + MIE_Gmina + ")";
			Statement stmt = connectionToDB.createStatement();
			stmt.executeUpdate(insertMiejscowosci);

			System.out.println("Dane poprawnie dodane do tabeli");
		} catch (SQLException e) {
			System.out.println("Dane nie dodane do tabeli");
			System.out.println(e);
		}
	}

	@Override
	public void insertDataToPrzystanki(String MIE_Nazwa_Miejscow, String PR_Ulica) throws SQLException {
		getConnection(user);
		try {
			String MIE_KEY = "SELECT MIE_KEY FROM [dbo].[MIEJSCOWOSCI] WHERE MIE_Nazwa_Miejscow = "
					+ MIE_Nazwa_Miejscow;
			Statement stmt1 = connectionToDB.createStatement();
			stmt1.execute(MIE_KEY);
			ResultSet rsMIE_KEY = stmt1.getResultSet();
			int inMIE_KEY = 0;
			while (rsMIE_KEY.next()) {
				inMIE_KEY = rsMIE_KEY.getInt("MIE_KEY");
			}

			String insertPrzystanki = "INSERT INTO [dbo].[PRZYSTANKI]([MIE_KEY],[PR_Ulica]) VALUES (" + inMIE_KEY + ","
					+ PR_Ulica + ")";
			Statement stmt = connectionToDB.createStatement();
			stmt.executeUpdate(insertPrzystanki);

			System.out.println("Dane poprawnie dodane do tabeli");
		} catch (SQLException e) {
			System.out.println("Dane nie dodane do tabeli");
			System.out.println(e);
		}
	}

	@Override
	public void insertDataToTrasy(String KUR_Opis, String przystanekUlica, String TR_Dzien_tyg, String TR_Godzina,
			String TR_Uwagi) throws SQLException {
		getConnection(user);
		try {
			Statement stmt = connectionToDB.createStatement();
			String queryPR_KEY = "SELECT [PR_KEY] FROM [dbo].[PRZYSTANKI] WHERE [PR_Ulica] = " + przystanekUlica;
			System.out.println(queryPR_KEY);
			stmt.execute(queryPR_KEY);
			ResultSet rsPR_KEY = stmt.getResultSet();
			int PR_KEY = 0;
			while (rsPR_KEY.next()) {
				PR_KEY = rsPR_KEY.getInt("PR_KEY");
			}
			String queryKUR_KEY = "SELECT [KUR_KEY] FROM [dbo].[KURSY] WHERE [KUR_Opis] = " + KUR_Opis;
			stmt.execute(queryKUR_KEY);
			ResultSet rsKUR_KEY = stmt.getResultSet();
			int KUR_KEY = 0;
			while (rsKUR_KEY.next()) {
				KUR_KEY = rsKUR_KEY.getInt("KUR_KEY");
			}

			String insertTrasy = "INSERT INTO [dbo].[TRASA]([KUR_KEY],[PR_KEY],[TR_Dzie�_tyg],[TR_Godzina],[TR_Uwagi]) VALUES ("
					+ KUR_KEY + "," + PR_KEY + "," + TR_Dzien_tyg + "," + TR_Godzina + "," + TR_Uwagi + ")";
			stmt.executeUpdate(insertTrasy);

			System.out.println(insertTrasy);
			System.out.println("Dane poprawnie dodane do tabeli");
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Dane nie dodane do tabeli");
		}
	}

	@Override
	public void insertDataToRaport(String KUR_Miejsc_Startowa, String KUR_Miejsc_Konco, String REJ_data_start,
			String REJ_data_konc, int REJ_iloscOsob) {
		getConnection(user);
		try {
			int KUR_KEY = 0;

			Statement stmt = connectionToDB.createStatement();

			String queryKUR_KEY = "SELECT KUR_KEY FROM KURSY WHERE KUR_Miejsc_Startowa = " + KUR_Miejsc_Startowa
					+ "AND KUR_Miejsc_Konco = " + KUR_Miejsc_Konco;
			stmt.execute(queryKUR_KEY);

			ResultSet rsKUR_KEY = stmt.getResultSet();
			while (rsKUR_KEY.next())
				KUR_KEY = rsKUR_KEY.getInt("KUR_KEY");

			System.out.println(queryKUR_KEY);
			String insertRaport = "INSERT INTO [dbo].[REJESTR_PRZEJAZDOW] ([KUR_KEY], [REJ_data_start],[REJ_data_konc],[REJ_iloscOsob]) VALUES ("
					+ KUR_KEY + "," + REJ_data_start + "," + REJ_data_konc + "," + REJ_iloscOsob + ")";

			System.out.println(insertRaport);

			stmt.executeUpdate(insertRaport);

			System.out.println("Raport z�o�ony poprawnie");

		} catch (Exception e) {
			System.out.println("Wyst�pi� b��d podczas sk�adania raportu");
			System.out.println(e);
		}
	}

}
