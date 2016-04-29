package application;

public class Trasa {
	private int TR_KEY;
	private String KUR_Sygnatura_Kursu;
	private String MIE_Nazwa_Miejscow;
	private String PR_Ulica;
	private String TR_Dzien_tyg;
	private String TR_Godzina;
	private String TR_Uwagi;

	public Trasa() {
		this.TR_KEY = 0;
		this.KUR_Sygnatura_Kursu = null;
		this.MIE_Nazwa_Miejscow = null;
		this.TR_Dzien_tyg = null;
		this.TR_Godzina = null;
		this.TR_Uwagi = null;

	}

	public Trasa(int TR_KEY, String KUR_Sygnatura_Kursu, String MIE_Nazwa_Miejscow, String PR_Ulica, String TR_Godzina,
			String TR_Dzien_tyg, String TR_Uwagi) {
		this.TR_KEY = TR_KEY;
		this.KUR_Sygnatura_Kursu = KUR_Sygnatura_Kursu;
		this.MIE_Nazwa_Miejscow = MIE_Nazwa_Miejscow;
		this.PR_Ulica = PR_Ulica;
		this.TR_Dzien_tyg = TR_Dzien_tyg;
		this.TR_Godzina = TR_Godzina;
		this.TR_Uwagi = TR_Uwagi;

	}

	public int getTR_KEY() {
		return TR_KEY;
	}

	public void setTR_KEY(int tR_KEY) {
		TR_KEY = tR_KEY;
	}

	public String getKUR_Sygnatura_Kursu() {
		return KUR_Sygnatura_Kursu;
	}

	public void setKUR_Sygnatura_Kursu(String kUR_Sygnatura_Kursu) {
		KUR_Sygnatura_Kursu = kUR_Sygnatura_Kursu;
	}

	public String getMIE_Nazwa_Miejscow() {
		return MIE_Nazwa_Miejscow;
	}

	public void setMIE_Nazwa_Miejscow(String mIE_Nazwa_Miejscow) {
		MIE_Nazwa_Miejscow = mIE_Nazwa_Miejscow;
	}

	public String getPR_Ulica() {
		return PR_Ulica;
	}

	public void setPR_Ulica(String pR_Ulica) {
		PR_Ulica = pR_Ulica;
	}

	public String getTR_Dzien_tyg() {
		return TR_Dzien_tyg;
	}

	public void setTR_Dzien_tyg(String tR_Dzien_tyg) {
		TR_Dzien_tyg = tR_Dzien_tyg;
	}

	public String getTR_Godzina() {
		return TR_Godzina;
	}

	public void setTR_Godzina(String tR_Godzina) {
		TR_Godzina = tR_Godzina;
	}

	public String getTR_Uwagi() {
		return TR_Uwagi;
	}

	public void setTR_Uwagi(String tR_Uwagi) {
		TR_Uwagi = tR_Uwagi;
	}

}
