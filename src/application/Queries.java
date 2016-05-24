package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.glass.ui.GestureSupport;

import sun.rmi.runtime.Log;

public class Queries extends ConnectionToDB implements QueriesInterface {
	Statement stmt = makeStatement();

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.QueriesInterface#getResultForUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public ResultSet getResultForUser(String miejscowoscStartowa, String miejscowoscKoncowa) {
		String getResultQuery = "SELECT TRASA.TR_KEY AS 'Klucz trasy', KURSY.KUR_Sygnatura_Kursu AS 'Sygnatura kursu', TRASA.TR_Skad AS 'Skad', MIEJSCOWOSCI.MIE_Nazwa_Miejscow AS 'Dokad', PRZYSTANKI.PR_Ulica AS 'Przystanek', TRASA.TR_Dzieñ_tyg AS 'W dni tygodnia',TRASA.TR_Godzina_odjazdu AS 'Godzina odjazdu', TRASA.TR_Godzina AS 'Godzina przyjazdu', TRASA.TR_Uwagi AS 'Uwagi do trasy' FROM TRASA INNER JOIN KURSY ON TRASA.KUR_KEY = KURSY.KUR_KEY INNER JOIN PRZYSTANKI ON TRASA.PR_KEY = PRZYSTANKI.PR_KEY INNER JOIN MIEJSCOWOSCI ON PRZYSTANKI.MIE_KEY = MIEJSCOWOSCI.MIE_KEY WHERE(KURSY.KUR_Miejsc_Startowa = '"
				+ miejscowoscStartowa + "') AND(KURSY.KUR_Miejsc_Konco = '" + miejscowoscKoncowa
				+ "') OR(TRASA.TR_Skad = '" + miejscowoscStartowa + "') AND(MIEJSCOWOSCI.MIE_Nazwa_Miejscow = '"
				+ miejscowoscKoncowa + "')";
		ResultSet rsResultForUser = null;
		try {
			stmt.execute(getResultQuery);
			rsResultForUser = stmt.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rsResultForUser;
	}

	public ResultSet selectKluczTrasy(String KUR_Miejsc_Startowa) throws SQLException {
		stmt.execute("SELECT KUR_ID FROM TRASY WHERE KUR_Miejsc_Startowa = " + KUR_Miejsc_Startowa);
		ResultSet rsKluczTrasy = stmt.getResultSet();

		return rsKluczTrasy;
	}

	public ResultSet selectMiejscStartowaByKUR_KEY(String KUR_KEY) throws SQLException {

		stmt.execute("SELECT KUR_Miejsc_Startowa FROM KURSY WHERE KUR_KEY = " + KUR_KEY);
		ResultSet rsMiejscStartowa = stmt.getResultSet();

		return rsMiejscStartowa;
	}

	public ResultSet selectPrzystanekUlicaByPR_KEY(String PR_KEY) throws SQLException {
		stmt.execute("SELECT PR_Ulica FROM PRZYSTANKI WHERE PR_KEY = " + PR_KEY);
		ResultSet rsPrzystanekUlica = stmt.getResultSet();

		return rsPrzystanekUlica;
	}

	public ResultSet showAllTableKierowcy() throws SQLException {
		stmt.execute("SELECT * FROM KIEROWCY");
		ResultSet rsKierowcy = stmt.getResultSet();

		return rsKierowcy;
	}

	public ResultSet showAllTableAutokary() throws SQLException {
		stmt.execute("SELECT  * FROM AUTOKARY");
		ResultSet rsAutokary = stmt.getResultSet();

		return rsAutokary;
	}

	public ResultSet showAllTableKursy() throws SQLException {
		stmt.execute(
				"SELECT KURSY.KUR_KEY, AUTOKARY.AUT_Nr_rejestracji, KIEROWCY.KIE_Pesel, KURSY.KUR_Sygnatura_Kursu, KURSY.KUR_Miejsc_Startowa, KURSY.KUR_Miejsc_Konco, KURSY.KUR_Czas_Odjazdu,  KURSY.KUR_Czas_Przyjazdu FROM KURSY INNER JOIN AUTOKARY ON KURSY.AUT_KEY = AUTOKARY.AUT_KEY INNER JOIN KIEROWCY ON KURSY.KIE_KEY = KIEROWCY.KIE_KEY");
		ResultSet rsKursy = stmt.getResultSet();

		return rsKursy;
	}

	public ResultSet showAllTableMiejscowosci() throws SQLException {
		stmt.execute("SELECT * FROM MIEJSCOWOSCI");
		ResultSet rsMiejscowosci = stmt.getResultSet();

		return rsMiejscowosci;
	}

	public ResultSet showAllTablePrzystanki() throws SQLException {
		stmt.execute(
				"SELECT PRZYSTANKI.PR_KEY, MIEJSCOWOSCI.MIE_Nazwa_Miejscow, PRZYSTANKI.PR_Ulica FROM PRZYSTANKI INNER JOIN MIEJSCOWOSCI ON PRZYSTANKI.MIE_KEY = MIEJSCOWOSCI.MIE_KEY");
		ResultSet rsPrzystanki = stmt.getResultSet();

		return rsPrzystanki;
	}

	public ResultSet showAllTableRejestrPrzejazdow() throws SQLException {
		stmt.execute(
				"SELECT REJESTR_PRZEJAZDOW.REJ_KEY, KURSY.KUR_Miejsc_Startowa, KURSY.KUR_Miejsc_Konco, REJESTR_PRZEJAZDOW.REJ_data_start, REJESTR_PRZEJAZDOW.REJ_data_konc,  REJESTR_PRZEJAZDOW.REJ_iloscOsob FROM REJESTR_PRZEJAZDOW INNER JOIN KURSY ON REJESTR_PRZEJAZDOW.KUR_KEY = KURSY.KUR_KEY");
		ResultSet rsRejestrPrzejazdow = stmt.getResultSet();

		return rsRejestrPrzejazdow;
	}

	public ResultSet showAllTableTrasy() throws SQLException {
		String query = "SELECT TRASA.TR_KEY, KURSY.KUR_Sygnatura_Kursu, TRASA.TR_Skad, MIEJSCOWOSCI.MIE_Nazwa_Miejscow, PRZYSTANKI.PR_Ulica, TRASA.TR_Dzieñ_tyg,TRASA.TR_Godzina_odjazdu, TRASA.TR_Godzina, TRASA.TR_Uwagi FROM TRASA INNER JOIN KURSY ON TRASA.KUR_KEY = KURSY.KUR_KEY INNER JOIN PRZYSTANKI ON TRASA.PR_KEY = PRZYSTANKI.PR_KEY INNER JOIN MIEJSCOWOSCI ON PRZYSTANKI.MIE_KEY = MIEJSCOWOSCI.MIE_KEY";
		stmt.execute(query);

		ResultSet rsTrasy = stmt.getResultSet();

		return rsTrasy;
	}

	@Override
	public void deleteByIdAutokary(int id) throws SQLException {
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
		//getConnection(user);
		//Statement stmt = connectionToDB.createStatement();
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
		//getConnection(user);
		//Statement stmt = connectionToDB.createStatement();
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
		//getConnection(user);
		//Statement stmt = connectionToDB.createStatement();
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
		System.out.println(id);
		try {
			stmt.execute("DELETE FROM [master].[dbo].[REJESTR_PRZEJAZDOW] WHERE REJ_KEY= " + id);
			System.out.println("Rejestr o podanym ID poprawnie usuniêty");
		} catch (Exception e) {
			System.out.println("Problem z usunieciem rekordu");
			System.out.println(e);
		}

	}

	@Override
	public void insertDataToAutokary(String AUT_Marka, String AUT_Model, int AUT_Rok_Prod, int AUT_Poj_Silnik,
			int AUT_Spalanie, String AUT_Kategoria, int AUT_Ilosc_Miejsc, String AUT_NR_Rej) {
		try {

			String insertAutokar = "INSERT INTO [dbo].[AUTOKARY]([AUT_Marka]," + "[AUT_Model]," + "[AUT_Rok_Prod],"
					+ "[AUT_Poj_silnik]," + "[AUT_Spalanie]," + "[AUT_Kat_autokaru]," + "[AUT_Iloœæ_miejsc],"
					+ "[AUT_Nr_rejestracji])" + "VALUES " + "(" + AUT_Marka + "," + AUT_Model + "," + AUT_Rok_Prod + ","
					+ AUT_Poj_Silnik + "," + AUT_Spalanie + "," + AUT_Kategoria + "," + AUT_Ilosc_Miejsc + ","
					+ AUT_NR_Rej;
			// System.out.println(insertAutokar);
			//Statement stmt = connectionToDB.createStatement();
			stmt.executeUpdate(insertAutokar);

			System.out.println("Dane poprawnie dodane do tabeli");
		} catch (SQLException e) {
			System.out.println("Dane nie dodane do tabeli");
			System.out.println(e);
		}
	}

	@Override
	public void insertDataToKierowcy(String KIE_Imie, String KIE_Nazwisko, String KIE_Pesel, String KIE_Data_zatr) {
		try {

			String insertKierowcy = "INSERT INTO [dbo].[KIEROWCY] ([KIE_Imie],[KIE_Nazwisko],[KIE_Pesel],[KIE_Data_zatr]) VALUES ("
					+ KIE_Imie + "," + KIE_Nazwisko + "," + KIE_Pesel + "," + KIE_Data_zatr + ")";
			System.out.println(insertKierowcy);
			stmt.executeUpdate(insertKierowcy);

			System.out.println("Dane poprawnie dodane do tabeli");
		} catch (SQLException e) {
			System.out.println("Dane nie dodane do tabeli");
			System.out.println(e);
		}
		/*
		FillingTables fillTable = new FillingTables();
		try {
			fillTable.getProduct();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	@Override
	public void insertDataToKursy(String KIE_Pesel, String numerRejAutokary, String KUR_Sygnatura_Kursu,
			String KUR_Miejsc_Start, String KUR_Miejsc_Konco, String KUR_Czas_Odjazdu, String KUR_Czas_Przyjazdu) {
		try {

			String KIE_KEY = "SELECT KIE_KEY FROM [dbo].KIEROWCY WHERE KIE_Pesel = " + KIE_Pesel;
			String AUT_KEY = "SELECT AUT_KEY FROM [dbo].AUTOKARY WHERE AUT_Nr_rejestracji = " + numerRejAutokary;


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

			String insertKursy = "INSERT INTO [dbo].[KURSY] ([AUT_KEY],[KIE_KEY] ,[KUR_Sygnatura_Kursu] ,[KUR_Miejsc_Startowa] ,[KUR_Miejsc_Konco] ,[KUR_Czas_Odjazdu] ,[KUR_Czas_Przyjazdu]) VALUES ("
					+ inAUT_KEY + "," + inKIE_KEY + "," + KUR_Sygnatura_Kursu + "," + KUR_Miejsc_Start + ","
					+ KUR_Miejsc_Konco + "," + KUR_Czas_Odjazdu + "," + KUR_Czas_Przyjazdu + ")";

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
		try {

			String insertMiejscowosci = "INSERT INTO [dbo].[MIEJSCOWOSCI]([MIE_Nazwa_Miejscow],[MIE_Województwo],[MIE_Powiat],[MIE_Gmina]) VALUES ("
					+ MIE_Nazwa_Miejscow + "," + MIE_Wojewodztwo + "," + MIE_Powiat + "," + MIE_Gmina + ")";
			stmt.executeUpdate(insertMiejscowosci);

			System.out.println("Dane poprawnie dodane do tabeli");
		} catch (SQLException e) {
			System.out.println("Dane nie dodane do tabeli");
			System.out.println(e);
		}
	}

	@Override
	public void insertDataToPrzystanki(String MIE_Nazwa_Miejscow, String PR_Ulica) {
		try {

			String MIE_KEY = "SELECT MIE_KEY FROM [dbo].[MIEJSCOWOSCI] WHERE MIE_Nazwa_Miejscow = "
					+ MIE_Nazwa_Miejscow;

			stmt.execute(MIE_KEY);
			ResultSet rsMIE_KEY = stmt.getResultSet();
			int inMIE_KEY = 0;
			while (rsMIE_KEY.next()) {
				inMIE_KEY = rsMIE_KEY.getInt("MIE_KEY");
			}

			String insertPrzystanki = "INSERT INTO [dbo].[PRZYSTANKI]([MIE_KEY],[PR_Ulica]) VALUES (" + inMIE_KEY + ","
					+ PR_Ulica + ")";
			stmt.executeUpdate(insertPrzystanki);

			System.out.println("Dane poprawnie dodane do tabeli");
		} catch (SQLException e) {
			System.out.println("Dane nie dodane do tabeli");
			System.out.println(e);
		}
	}

	@Override
	public void insertDataToTrasy(String trasaKursStartowa, String trasaKursKoncowa, String TR_Skad,
			String MIE_Nazwa_Miejscow, String TR_Dzien_tyg, String TR_Godzina_odjazdu, String TR_Godzina,
			String TR_Uwagi) {
		try {
			String queryPR_KEY = "SELECT DISTINCT PR_KEY FROM PRZYSTANKI INNER JOIN MIEJSCOWOSCI ON PRZYSTANKI.MIE_KEY = MIEJSCOWOSCI.MIE_KEY WHERE MIE_Nazwa_Miejscow = "
					+ MIE_Nazwa_Miejscow;
			System.out.println(queryPR_KEY);
			stmt.execute(queryPR_KEY);
			ResultSet rsPR_KEY = stmt.getResultSet();
			int PR_KEY = 0;
			while (rsPR_KEY.next()) {
				PR_KEY = rsPR_KEY.getInt("PR_KEY");
			}
			String queryKUR_KEY = "SELECT [KUR_KEY] FROM [dbo].[KURSY] WHERE [KUR_Miejsc_Startowa] = "
					+ trasaKursStartowa + "AND [KUR_Miejsc_Konco] = " + trasaKursKoncowa;
			stmt.execute(queryKUR_KEY);
			System.out.println(queryKUR_KEY);
			ResultSet rsKUR_KEY = stmt.getResultSet();
			int KUR_KEY = 0;
			while (rsKUR_KEY.next()) {
				KUR_KEY = rsKUR_KEY.getInt("KUR_KEY");
			}

			String insertTrasy = "INSERT INTO [dbo].[TRASA]([KUR_KEY],[TR_Skad],[PR_KEY],[TR_Dzieñ_tyg],[TR_Godzina_Odjazdu],[TR_Godzina],[TR_Uwagi]) VALUES ("
					+ KUR_KEY + "," + TR_Skad + "," + PR_KEY + "," + TR_Dzien_tyg + "," + TR_Godzina_odjazdu + ","
					+ TR_Godzina + "," + TR_Uwagi + ")";
			System.out.println(insertTrasy);
			stmt.executeUpdate(insertTrasy);

			System.out.println("Dane poprawnie dodane do tabeli");
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Dane nie dodane do tabeli");
		}

	}

	@Override
	public void insertDataToRaport(String KUR_Miejsc_Startowa, String KUR_Miejsc_Konco, String REJ_data_start,
			String REJ_data_konc, int REJ_iloscOsob) {
		try {
			int KUR_KEY = 0;


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

			System.out.println("Raport z³o¿ony poprawnie");

		} catch (Exception e) {
			System.out.println("Wyst¹pi³ b³¹d podczas sk³adania raportu");
			System.out.println(e);
		}
	}

}
