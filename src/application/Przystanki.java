package application;

public class Przystanki {
	private int PR_KEY;
	private int MIE_KEY;
	private String PR_Ulica;


	
	public Przystanki(){
		this.PR_KEY = 0;
		this.MIE_KEY = 0;
		this.PR_Ulica = "";

		
	}
	
	public  Przystanki(	int PR_KEY, int MIE_KEY, String PR_Ulica)
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

	public int getMIE_KEY() {
		return MIE_KEY;
	}

	public void setMIE_KEY(int mIE_KEY) {
		MIE_KEY = mIE_KEY;
	}

	public String getPR_Ulica() {
		return PR_Ulica;
	}

	public void setPR_Ulica(String pR_Ulica) {
		PR_Ulica = pR_Ulica;
	}

}
