package application;

public class Autokary {
	private int AUT_KEY;
	private String AUT_Marka;
	private String AUT_Model;
	private int AUT_Rok_Prod;
	private int AUT_Poj_silnik;
	private int AUT_Spalamie_lkm;
	private String AUT_Kat_autokaru;
	private int AUT_Ilosc_miejsc;
	private String AUT_Nr_rejestracji;

	
	public Autokary(){
		this.AUT_KEY = 0;
		this.AUT_Marka = "";
		this.AUT_Model = "";
		this.AUT_Rok_Prod = 0;
		this.AUT_Poj_silnik = 0;
		this.AUT_Spalamie_lkm =0;
		this.AUT_Kat_autokaru = "";
		this.AUT_Ilosc_miejsc = 0;
		this.AUT_Nr_rejestracji = "";
	}
	
public  Autokary( int AUT_KEY, String AUT_Marka, String AUT_Model, int AUT_Rok_Prod,  int AUT_Poj_silnik, int AUT_Spalamie_lkm, String AUT_Kat_autokaru, int AUT_Ilosc_miejsc, String AUT_Nr_rejestracji)
	{
 
	this.AUT_KEY =AUT_KEY;
	this.AUT_Marka = AUT_Marka;
	this.AUT_Model = AUT_Model;
	this.AUT_Rok_Prod =	AUT_Rok_Prod;
	this.AUT_Poj_silnik = AUT_Poj_silnik;
	this.AUT_Spalamie_lkm =AUT_Spalamie_lkm;
	this.AUT_Kat_autokaru = AUT_Kat_autokaru;
	this.AUT_Ilosc_miejsc = AUT_Ilosc_miejsc;
	this.AUT_Nr_rejestracji = AUT_Nr_rejestracji;

		
	}

public int getAUT_KEY() {
	return AUT_KEY;
}

public void setAUT_KEY(int aUT_KEY) {
	AUT_KEY = aUT_KEY;
}

public String getAUT_Marka() {
	return AUT_Marka;
}

public String setAUT_Marka(String aUT_Marka) {
	return AUT_Marka = aUT_Marka;
}

public String getAUT_Model() {
	return AUT_Model;
}

public String setAUT_Model(String aUT_Model) {
	return AUT_Model = aUT_Model;
}

public int getAUT_Rok_Prod() {
	return AUT_Rok_Prod;
}

public int setAUT_Rok_Prod(int aUT_Rok_Prod) {
	return AUT_Rok_Prod = aUT_Rok_Prod;
}

public int getAUT_Poj_silnik() {
	return AUT_Poj_silnik;
}

public int setAUT_Poj_silnik(int aUT_Poj_silnik) {
	return AUT_Poj_silnik = aUT_Poj_silnik;
}

public int getAUT_Spalamie_lkm() {
	return AUT_Spalamie_lkm;
}

public int setAUT_Spalamie_lkm(int aUT_Spalamie_lkm) {
	return AUT_Spalamie_lkm = aUT_Spalamie_lkm;
}

public String getAUT_Kat_autokaru() {
	return AUT_Kat_autokaru;
}

public String setAUT_Kat_autokaru(String aUT_Kat_autokaru) {
	return AUT_Kat_autokaru = aUT_Kat_autokaru;
}

public int getAUT_Ilosc_miejsc() {
	return AUT_Ilosc_miejsc;
}

public int setAUT_Ilosc_miejsc(int aUT_Ilosc_miejsc) {
	return AUT_Ilosc_miejsc = aUT_Ilosc_miejsc;
}

public String getAUT_Nr_rejestracji() {
	return AUT_Nr_rejestracji;
}

public String setAUT_Nr_rejestracji(String aUT_Nr_rejestracji) {
	return AUT_Nr_rejestracji = aUT_Nr_rejestracji;
}


}
