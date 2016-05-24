package application;

public class Rejestr_przejazdow {
	private int REJ_KEY;
	private String KUR_Miejsc_Startowa;
	private String PR_Ulica;
	private String REJ_data_start;
	private String REJ_data_konc;
	private int REJ_iloscOsob;

	public Rejestr_przejazdow() {
		this.REJ_KEY = 0;
		this.KUR_Miejsc_Startowa = null;
		this.PR_Ulica = "";
		this.REJ_data_start = null;
		this.REJ_data_konc = null;
		this.REJ_iloscOsob = 0;
	}

	public Rejestr_przejazdow(int REJ_KEY, String KUR_Miejsc_Startowa, String PR_Ulica, String REJ_data_start,
			String REJ_data_konc, int REJ_iloscOsob) {

		this.REJ_KEY = REJ_KEY;
		this.KUR_Miejsc_Startowa = KUR_Miejsc_Startowa;
		this.PR_Ulica = PR_Ulica;
		this.REJ_data_start = REJ_data_start;
		this.REJ_data_konc = REJ_data_konc;
		this.REJ_iloscOsob = REJ_iloscOsob;
	}

	public int getREJ_KEY() {
		return REJ_KEY;
	}

	public void setREJ_KEY(int rEJ_KEY) {
		REJ_KEY = rEJ_KEY;
	}

	public String getKUR_Miejsc_Startowa() {
		return KUR_Miejsc_Startowa;
	}

	public String setKUR_Miejsc_Startowa(String kUR_Miejsc_Startowa) {
		return KUR_Miejsc_Startowa = kUR_Miejsc_Startowa;
	}

	public String getPR_Ulica() {
		return PR_Ulica;
	}

	public String setPR_Ulica(String pR_Ulica) {
		return PR_Ulica = pR_Ulica;
	}

	public String getREJ_data_start() {
		return REJ_data_start;
	}

	public String setREJ_data_start(String rEJ_data_start) {
		return REJ_data_start = rEJ_data_start;
	}

	public String getREJ_data_konc() {
		return REJ_data_konc;
	}

	public String setREJ_data_konc(String rEJ_data_konc) {
		return REJ_data_konc = rEJ_data_konc;
	}

	public int getREJ_iloscOsob() {
		return REJ_iloscOsob;
	}

	public int setREJ_iloscOsob(int rEJ_iloscOsob) {
		return REJ_iloscOsob = rEJ_iloscOsob;
	}

}
