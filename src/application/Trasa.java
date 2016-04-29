package application;

public class Trasa {
	private int TR_KEY;
	private int KUR_KEY;
	private int PR_KEY;
	private String TR_Dzien_tyg;
	private String TR_Godzina;
	private String TR_Uwagi;



	
	public Trasa(){
		this.TR_KEY = 0;
		this.KUR_KEY = 0;
		this.PR_KEY = 0;
		this.TR_Dzien_tyg = "";
		this.TR_Godzina= "";
		this.TR_Uwagi = "";

		
	}
	
	public Trasa(int TR_KEY, int KUR_KEY, int PR_KEY, String TR_Dzien_tyg, String TR_Godzina, String TR_Uwagi)
	{
		this.TR_KEY = TR_KEY;
		this.KUR_KEY = KUR_KEY;
		this.PR_KEY = PR_KEY;
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

	public int getKUR_KEY() {
		return KUR_KEY;
	}

	public void setKUR_KEY(int kUR_KEY) {
		KUR_KEY = kUR_KEY;
	}

	public int getPR_KEY() {
		return PR_KEY;
	}

	public void setPR_KEY(int pR_KEY) {
		PR_KEY = pR_KEY;
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
