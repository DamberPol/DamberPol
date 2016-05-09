package application;

public class Przystanki {
	private int PR_KEY;
	private String MIE_KEY;
	private String PR_Ulica;


	
	public Przystanki(){
		this.PR_KEY = 0;
		this.MIE_KEY = null;
		this.PR_Ulica = "";

		
	}
	
	public  Przystanki(	int PR_KEY, String MIE_KEY, String PR_Ulica)
	{
 
		this.PR_KEY = PR_KEY;
		this.MIE_KEY = MIE_KEY;
		this.PR_Ulica = PR_Ulica;

		
	}

	public int getPR_KEY() {
		return PR_KEY;
	}

	public void setPR_KEY(int pR_KEY) {
		PR_KEY = pR_KEY;
	}

	public String getMIE_KEY() {
		return MIE_KEY;
	}

	public String setMIE_KEY(String mIE_KEY) {
		return MIE_KEY = mIE_KEY;
	}

	public String getPR_Ulica() {
		return PR_Ulica;
	}

	public String setPR_Ulica(String pR_Ulica) {
		return PR_Ulica = pR_Ulica;
	}

}
