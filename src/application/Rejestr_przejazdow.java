package application;

public class Rejestr_przejazdow{
	private int REJ_KEY;
	private int KUR_KEY;
	private String REJ_data;
	private int REJ_iloscOsob;


	
	public Rejestr_przejazdow(){
		this.REJ_KEY=0;
		this.KUR_KEY=0;
		this.REJ_data="";
		this.REJ_iloscOsob=0;
	
		
	}
	
	public Rejestr_przejazdow (	int REJ_KEY, int KUR_KEY,String REJ_data, int REJ_iloscOsob)
	{

		this.REJ_KEY=REJ_KEY;
		this.KUR_KEY=KUR_KEY;
		this.REJ_data=REJ_data;
		this.REJ_iloscOsob=REJ_iloscOsob;
		
	}

	public int getREJ_KEY() {
		return REJ_KEY;
	}

	public void setREJ_KEY(int rEJ_KEY) {
		REJ_KEY = rEJ_KEY;
	}

	public int getKUR_KEY() {
		return KUR_KEY;
	}

	public void setKUR_KEY(int kUR_KEY) {
		KUR_KEY = kUR_KEY;
	}

	public String getREJ_data() {
		return REJ_data;
	}

	public void setREJ_data(String rEJ_data) {
		REJ_data = rEJ_data;
	}

	public int getREJ_iloscOsob() {
		return REJ_iloscOsob;
	}

	public void setREJ_iloscOsob(int rEJ_iloscOsob) {
		REJ_iloscOsob = rEJ_iloscOsob;
	}

}
