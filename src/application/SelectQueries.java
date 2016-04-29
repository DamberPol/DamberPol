package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQueries extends ConnectionToDB implements QueriesInterface {

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
}
