package application;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface QueriesInterface {

	public ResultSet showAllTableKierowcy() throws SQLException;

	public ResultSet showAllTableAutokary() throws SQLException;

	public ResultSet showAllTableKursy() throws SQLException;

	public ResultSet showAllTableMiejscowosci() throws SQLException;

	public ResultSet showAllTablePrzystanki() throws SQLException;

	public ResultSet showAllTableRejestrPrzejazdow() throws SQLException;

	public ResultSet showAllTableTrasy() throws SQLException;

	public void insertDataToAutokary(String AUT_Marka, String AUT_Model, int AUT_Rok_Prod, int AUT_Poj_Silnik,
			int AUT_Spalanie, String AUT_Kategoria, int AUT_Ilosc_Miejsc, String AUT_NR_Rej) throws SQLException;

	public void insertDataToMiejscowosci(String MIE_Nazwa_Miejscow, String MIE_Wojewodztwo, String MIE_Powiat,
			String MIE_Gmina) throws SQLException;

	public void insertDataToRaport(int KUR_KEY, String REJ_data_start, String REJ_data_konc, int REJ_iloscOsob)
			throws SQLException;

	public void deleteByIdAutokary(int id) throws SQLException;

	public void deleteByIdKierowcy(int id) throws SQLException;

	public void deleteByIdKursy(int id) throws SQLException;

	public void deleteByIdMiejscowosci(int id) throws SQLException;

	public void deleteByIdPrzystanki(int id) throws SQLException;

	public void deleteByIdTrasy(int id) throws SQLException;
}
