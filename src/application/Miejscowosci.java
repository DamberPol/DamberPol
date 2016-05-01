package application;

public class Miejscowosci {
	private int MIE_KEY;
	private String MIE_Nazwa_Miejscow;
	private String MIE_Wojewodztwo;
	private String MIE_Powiat;
	private String MIE_Gmina;

	
	public Miejscowosci(){

		this.MIE_KEY=0;
		this.MIE_Nazwa_Miejscow="";
		this.MIE_Wojewodztwo="";
		this.MIE_Powiat="";
		this.MIE_Gmina="";
	}
	
	public Miejscowosci(int MIE_KEY, String MIE_Nazwa_Miejscow, String MIE_Wojewodztwo, String MIE_Powiat, String MIE_Gmina)
	{
		this.MIE_KEY=MIE_KEY;
		this.MIE_Nazwa_Miejscow=MIE_Nazwa_Miejscow;
		this.MIE_Wojewodztwo=MIE_Wojewodztwo;
		this.MIE_Powiat=MIE_Powiat;
		this.MIE_Gmina=MIE_Gmina;
	}

	public int getMIE_KEY() {
		return MIE_KEY;
	}

	public void setMIE_KEY(int mIE_KEY) {
		MIE_KEY = mIE_KEY;
	}

	public String getMIE_Nazwa_Miejscow() {
		return MIE_Nazwa_Miejscow;
	}

	public String setMIE_Nazwa_Miejscow(String mIE_Nazwa_Miejscow) {
		return MIE_Nazwa_Miejscow = mIE_Nazwa_Miejscow;
	}

	public String getMIE_Wojewodztwo() {
		return MIE_Wojewodztwo;
	}

	public String setMIE_Wojewodztwo(String mIE_Wojewodztwo) {
		return MIE_Wojewodztwo = mIE_Wojewodztwo;
	}

	public String getMIE_Powiat() {
		return MIE_Powiat;
	}

	public String setMIE_Powiat(String mIE_Powiat) {
		return MIE_Powiat = mIE_Powiat;
	}

	public String getMIE_Gmina() {
		return MIE_Gmina;
	}

	public String setMIE_Gmina(String mIE_Gmina) {
		return MIE_Gmina = mIE_Gmina;
	}
	
}
