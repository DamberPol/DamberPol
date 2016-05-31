package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FillingTables extends Main {

	public ObservableList<Kierowcy> fillTableKierowcy() throws SQLException {
		ObservableList<Kierowcy> products = FXCollections.observableArrayList();
		ResultSet rsKierowcy = queries.showAllTableKierowcy();
		int id = 0;
		String imie = null;
		String nazwisko = null;
		String pesel = null;
		String dataZatr = null;
		while (rsKierowcy.next()) {
			id = rsKierowcy.getInt(1);
			imie = rsKierowcy.getString(2);
			nazwisko = rsKierowcy.getString(3);
			pesel = rsKierowcy.getString(4);
			dataZatr = rsKierowcy.getString(5);
			products.add(new Kierowcy(id, imie, nazwisko, pesel, dataZatr));
		}

		return products;
	}

	public ObservableList<Przystanki> fillTablePrzystanki() throws SQLException {
		ObservableList<Przystanki> products = FXCollections.observableArrayList();
		ResultSet rsPrzystanki = queries.showAllTablePrzystanki();
		int PR_KEY = 0;
		String MIE_KEY = null;
		String PR_Ulica = null;

		while (rsPrzystanki.next()) {
			PR_KEY = rsPrzystanki.getInt(1);
			MIE_KEY = rsPrzystanki.getString(2);
			PR_Ulica = rsPrzystanki.getString(3);
			products.add(new Przystanki(PR_KEY, MIE_KEY, PR_Ulica));
		}

		return products;
	}

	public ObservableList<Trasa> fillTableTrasa() throws SQLException {
		ObservableList<Trasa> products = FXCollections.observableArrayList();
		ResultSet rsPrzystanki = queries.showAllTableTrasy();
		int TR_KEY = 0;
		String KUR_Sygnatura = null;
		String MIE_Nazwa_Miejscow = null;
		String TR_Skad = null;
		String PR_Ulica = null;
		String TR_Godzina_odjazdu = null;
		String TR_Godzina = null;
		String TR_Dzien_tyg = null;
		String TR_Uwagi = null;

		while (rsPrzystanki.next()) {
			TR_KEY = rsPrzystanki.getInt(1);
			KUR_Sygnatura = rsPrzystanki.getString(2);
			TR_Skad = rsPrzystanki.getString(3);
			MIE_Nazwa_Miejscow = rsPrzystanki.getString(4);
			PR_Ulica = rsPrzystanki.getString(5);
			TR_Godzina_odjazdu = rsPrzystanki.getString(6);
			TR_Godzina = rsPrzystanki.getString(7);
			TR_Dzien_tyg = rsPrzystanki.getString(8);
			TR_Uwagi = rsPrzystanki.getString(9);
			products.add(new Trasa(TR_KEY, KUR_Sygnatura, MIE_Nazwa_Miejscow, TR_Skad, PR_Ulica, TR_Godzina_odjazdu,
					TR_Godzina, TR_Dzien_tyg, TR_Uwagi));
		}
		return products;
	}

	public ObservableList<Autokary> fillTableAutokary() throws SQLException {
		ObservableList<Autokary> products = FXCollections.observableArrayList();
		ResultSet rsAutokary = queries.showAllTableAutokary();
		int AUT_KEY = 0;
		String AUT_Marka = null;
		String AUT_Model = null;
		int AUT_Rok_Prod = 0;
		int AUT_Poj_silnik = 0;
		int AUT_Spalanie = 0;
		String AUT_Kat_autokaru = null;
		int AUT_Ilosc_miejsc = 0;
		String AUT_Nr_rejestracji = null;

		while (rsAutokary.next()) {
			AUT_KEY = rsAutokary.getInt(1);
			AUT_Marka = rsAutokary.getString(2);
			AUT_Model = rsAutokary.getString(3);
			AUT_Rok_Prod = rsAutokary.getInt(4);
			AUT_Poj_silnik = rsAutokary.getInt(5);
			AUT_Spalanie = rsAutokary.getInt(6);
			AUT_Kat_autokaru = rsAutokary.getString(7);
			AUT_Ilosc_miejsc = rsAutokary.getInt(8);
			AUT_Nr_rejestracji = rsAutokary.getString(9);
			products.add(new Autokary(AUT_KEY, AUT_Marka, AUT_Model, AUT_Rok_Prod, AUT_Poj_silnik, AUT_Spalanie,
					AUT_Kat_autokaru, AUT_Ilosc_miejsc, AUT_Nr_rejestracji));
		}
		return products;
	}

	public ObservableList<Kursy> fillTableKursy() throws SQLException {
		ObservableList<Kursy> products = FXCollections.observableArrayList();
		ResultSet rsKursy = queries.showAllTableKursy();
		int KUR_KEY = 0;
		String AUT_KEY = null;
		String KIE_KEY = null;
		String KUR_Sygnatura_Kursu = null;
		String KUR_Opis = null;
		String KUR_Miejsc_Konco = null;
		String KUR_Czas_Odjazdu = null;
		String KUR_Czas_Przyjazdu = null;
		while (rsKursy.next()) {
			KUR_KEY = rsKursy.getInt(1);
			AUT_KEY = rsKursy.getString(2);
			KIE_KEY = rsKursy.getString(3);
			KUR_Sygnatura_Kursu = rsKursy.getString(4);
			KUR_Opis = rsKursy.getString(5);
			KUR_Miejsc_Konco = rsKursy.getString(6);
			KUR_Czas_Odjazdu = rsKursy.getString(7);
			KUR_Czas_Przyjazdu = rsKursy.getString(8);
			products.add(new Kursy(KUR_KEY, AUT_KEY, KIE_KEY, KUR_Sygnatura_Kursu, KUR_Opis, KUR_Miejsc_Konco,
					KUR_Czas_Odjazdu, KUR_Czas_Przyjazdu));
		}

		return products;
	}

	public ObservableList<Miejscowosci> fillTableMiejscowosci() throws SQLException {
		ObservableList<Miejscowosci> products = FXCollections.observableArrayList();
		ResultSet rsMiejscowosci = queries.showAllTableMiejscowosci();
		int MIE_KEY = 0;
		String MIE_Nazwa_Miejscow = null;
		String MIE_Wojewodztwo = null;
		String MIE_Powiat = null;
		String MIE_Gmina = null;

		while (rsMiejscowosci.next()) {
			MIE_KEY = rsMiejscowosci.getInt(1);
			MIE_Nazwa_Miejscow = rsMiejscowosci.getString(2);
			MIE_Wojewodztwo = rsMiejscowosci.getString(3);
			MIE_Powiat = rsMiejscowosci.getString(4);
			MIE_Gmina = rsMiejscowosci.getString(5);
			products.add(new Miejscowosci(MIE_KEY, MIE_Nazwa_Miejscow, MIE_Wojewodztwo, MIE_Powiat, MIE_Gmina));
		}
		return products;
	}

	public ObservableList<Rejestr_przejazdow> fillTableRejestrPrzejazdow() throws SQLException {
		ObservableList<Rejestr_przejazdow> products = FXCollections.observableArrayList();

		int REJ_KEY = 0;
		String KUR_Miejsc_Startowa = null;
		String PR_Ulica = null;
		String REJ_data_start = null;
		String REJ_data_konc = null;
		int REJ_iloscOsob = 0;

		ResultSet rsRejestrPrzejazdow = queries.showAllTableRejestrPrzejazdow();
		while (rsRejestrPrzejazdow.next()) {
			REJ_KEY = rsRejestrPrzejazdow.getInt(1);
			KUR_Miejsc_Startowa = rsRejestrPrzejazdow.getString(2);
			PR_Ulica = rsRejestrPrzejazdow.getString(3);
			REJ_data_start = rsRejestrPrzejazdow.getString(4);
			REJ_data_konc = rsRejestrPrzejazdow.getString(5);
			REJ_iloscOsob = rsRejestrPrzejazdow.getInt(6);
			products.add(new Rejestr_przejazdow(REJ_KEY, KUR_Miejsc_Startowa, PR_Ulica, REJ_data_start, REJ_data_konc,
					REJ_iloscOsob));
		}
		return products;
	}

	public ObservableList<RozkladJazdy> getProduct8(String miejscowoscStartowa, String miejscowoscKoncowa) {
		ObservableList<RozkladJazdy> products = FXCollections.observableArrayList();
		RozkladJazdy rozklad = new RozkladJazdy();
		int TR_KEY = 0;
		String KUR_Sygnatura = null;
		String TR_Skad = null;
		String TR_Dokad = null;
		String TR_Przystanek = null;
		String TR_Dni_Tygodnia = null;
		String TR_Godzina_Odjazdu = null;
		String TR_Godzina_Przyjazdu = null;
		String TR_Uwagi = null;

		ResultSet rsToSort = queries.getResultForUser(miejscowoscStartowa, miejscowoscKoncowa);
		try {
			while (rsToSort.next()) {
				TR_KEY = rsToSort.getInt(1);
				KUR_Sygnatura = rsToSort.getString(2);
				TR_Skad = rsToSort.getString(3);
				TR_Dokad = rsToSort.getString(4);
				TR_Przystanek = rsToSort.getString(5);
				TR_Dni_Tygodnia = rsToSort.getString(6);
				TR_Godzina_Odjazdu = rsToSort.getString(7);
				TR_Godzina_Przyjazdu = rsToSort.getString(8);
				TR_Uwagi = rsToSort.getString(9);

				products.add(new RozkladJazdy(TR_KEY, KUR_Sygnatura, TR_Skad, TR_Dokad, TR_Przystanek, TR_Dni_Tygodnia,
						TR_Godzina_Odjazdu, TR_Godzina_Przyjazdu, TR_Uwagi));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}
}
