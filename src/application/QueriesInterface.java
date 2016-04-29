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
}
