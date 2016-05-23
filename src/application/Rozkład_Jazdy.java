package application;

public class Rozk³ad_Jazdy {
	private int TR_KEY;
	private String KUR_Sygnatura;
	private String TR_Skad;
	private String TR_Dokad;
	private String TR_Przystanek;
	private String TR_Dni_Tygodnia;
	private String TR_Godzina_Odjazdu;
	private String TR_Godzina_Przyjazdu;
	private String TR_Uwagi;

	public Rozk³ad_Jazdy() {
		this.TR_KEY = 0;
		this.KUR_Sygnatura = "";
		this.TR_Skad = "";
		this.TR_Dokad = "";
		this.TR_Przystanek = "";
		this.TR_Dni_Tygodnia = "";
		this.TR_Godzina_Odjazdu = "";
		this.TR_Godzina_Przyjazdu = "";
		this.TR_Uwagi = "";

	}

	public Rozk³ad_Jazdy(int TR_KEY, String KUR_Sygnatura, String TR_Skad, String TR_Dokad, String TR_Przystanek,
			String TR_Dni_Tygodnia, String TR_Godzina_Odjazdu, String TR_Godzina_Przyjazdu, String TR_Uwagi) {

		this.TR_KEY = TR_KEY;
		this.KUR_Sygnatura = KUR_Sygnatura;
		this.TR_Skad = TR_Skad;
		this.TR_Dokad = TR_Dokad;
		this.TR_Przystanek = TR_Przystanek;
		this.TR_Dni_Tygodnia = TR_Dni_Tygodnia;
		this.TR_Godzina_Odjazdu = TR_Godzina_Odjazdu;
		this.TR_Godzina_Przyjazdu = TR_Godzina_Przyjazdu;
		this.TR_Uwagi = TR_Uwagi;

	}

	public int getTR_KEY() {
		return TR_KEY;
	}

	public void setTR_KEY(int tR_KEY) {
		TR_KEY = tR_KEY;
	}

	public String getKUR_Sygnatura() {
		return KUR_Sygnatura;
	}

	public void setKUR_Sygnatura(String kUR_Sygnatura) {
		KUR_Sygnatura = kUR_Sygnatura;
	}

	public String getTR_Skad() {
		return TR_Skad;
	}

	public void setTR_Skad(String tR_Skad) {
		TR_Skad = tR_Skad;
	}

	public String getTR_Dokad() {
		return TR_Dokad;
	}

	public void setTR_Dokad(String tR_Dokad) {
		TR_Dokad = tR_Dokad;
	}

	public String getTR_Przystanek() {
		return TR_Przystanek;
	}

	public void setTR_Przystanek(String tR_Przystanek) {
		TR_Przystanek = tR_Przystanek;
	}

	public String getTR_Dni_Tygodnia() {
		return TR_Dni_Tygodnia;
	}

	public void setTR_Dni_Tygodnia(String tR_Dni_Tygodnia) {
		TR_Dni_Tygodnia = tR_Dni_Tygodnia;
	}

	public String getTR_Godzina_Odjazdu() {
		return TR_Godzina_Odjazdu;
	}

	public void setTR_Godzina_Odjazdu(String tR_Godzina_Odjazdu) {
		TR_Godzina_Odjazdu = tR_Godzina_Odjazdu;
	}

	public String getTR_Godzina_Przyjazdu() {
		return TR_Godzina_Przyjazdu;
	}

	public void setTR_Godzina_Przyjazdu(String tR_Godzina_Przyjazdu) {
		TR_Godzina_Przyjazdu = tR_Godzina_Przyjazdu;
	}

	public String getTR_Uwagi() {
		return TR_Uwagi;
	}

	public void setTR_Uwagi(String tR_Uwagi) {
		TR_Uwagi = tR_Uwagi;
	}

}
