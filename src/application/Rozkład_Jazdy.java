package application;

public class Rozk³ad_Jazdy {
		private String RJ_Marka;
		private String RJ_Model;
		private String RJ_Relacja;
		private String RJ_Przyjazd;
		private String RJ_odjazd;


		
		public  Rozk³ad_Jazdy(){
			this.RJ_Marka= "";
			this.RJ_Model = "";
			this.RJ_Relacja= "";
			this.RJ_Przyjazd= "";
			this.RJ_odjazd = "";
		}
		
	public   Rozk³ad_Jazdy( String RJ_Marka, String RJ_Model, String RJ_Relacja, String RJ_Przyjazd, String RJ_odjazd)
		{
	 
		this.RJ_Marka= RJ_Marka;
		this.RJ_Model = RJ_Model;
		this.RJ_Relacja= RJ_Relacja;
		this.RJ_Przyjazd= RJ_Przyjazd;
		this.RJ_odjazd = RJ_odjazd;

			
		}

	public String getRJ_Marka() {
		return RJ_Marka;
	}

	public void setRJ_Marka(String rJ_Marka) {
		RJ_Marka = rJ_Marka;
	}

	public String getRJ_Model() {
		return RJ_Model;
	}

	public void setRJ_Model(String rJ_Model) {
		RJ_Model = rJ_Model;
	}

	public String getRJ_Relacja() {
		return RJ_Relacja;
	}

	public void setRJ_Relacja(String rJ_Relacja) {
		RJ_Relacja = rJ_Relacja;
	}

	public String getRJ_Przyjazd() {
		return RJ_Przyjazd;
	}

	public void setRJ_Przyjazd(String rJ_Przyjazd) {
		RJ_Przyjazd = rJ_Przyjazd;
	}

	public String getRJ_odjazd() {
		return RJ_odjazd;
	}

	public void setRJ_odjazd(String rJ_odjazd) {
		RJ_odjazd = rJ_odjazd;
	}

}
