package application;

public class Kursy {
	private int KUR_KEY;
	private String AUT_KEY;
	private String KIE_KEY;
	private String KUR_Sygnatura_Kursu;
	private String KUR_Opis;
	private String KUR_Czas_Odjazdu;
	private String KUR_Czas_Przyjazdu;
	private String KUR_Miejsc_Konco;

	public Kursy() {

		this.KUR_KEY = 0;
		this.AUT_KEY = null;
		this.KIE_KEY = null;
		this.KUR_Sygnatura_Kursu = "";
		this.KUR_Opis = "";
		this.KUR_Czas_Odjazdu = "";
		this.KUR_Czas_Przyjazdu = "";
		this.KUR_Miejsc_Konco = null;
	}

	public Kursy(int KUR_KEY, String AUT_KEY, String KIE_KEY, String KUR_Sygnatura_Kursu, String KUR_Opis,
			String KUR_Miejsc_Konco, String KUR_Czas_Odjazdu, String KUR_Czas_Przyjazdu) {

		this.KUR_KEY = KUR_KEY;
		this.AUT_KEY = AUT_KEY;
		this.KIE_KEY = KIE_KEY;
		this.KUR_Sygnatura_Kursu = KUR_Sygnatura_Kursu;
		this.KUR_Miejsc_Konco = KUR_Miejsc_Konco;
		this.KUR_Opis = KUR_Opis;
		this.KUR_Czas_Odjazdu = KUR_Czas_Odjazdu;
		this.KUR_Czas_Przyjazdu = KUR_Czas_Przyjazdu;

	}

	public int getKUR_KEY() {
		return KUR_KEY;
	}

	public void setKUR_KEY(int kUR_KEY) {
		KUR_KEY = kUR_KEY;
	}

	public String getAUT_KEY() {
		return AUT_KEY;
	}

	public String setAUT_KEY(String aUT_KEY) {
		return AUT_KEY = aUT_KEY;
	}

	public String getKIE_KEY() {
		return KIE_KEY;
	}

	public String setKIE_KEY(String kIE_KEY) {
		return KIE_KEY = kIE_KEY;
	}

	public String getKUR_Sygnatura_Kursu() {
		return KUR_Sygnatura_Kursu;
	}

	public String setKUR_Sygnatura_Kursu(String kUR_Sygnatura_Kursu) {
		return KUR_Sygnatura_Kursu = kUR_Sygnatura_Kursu;
	}

	public String getKUR_Opis() {
		return KUR_Opis;
	}

	public String setKUR_Opis(String kUR_Opis) {
		return KUR_Opis = kUR_Opis;
	}
	public String setKUR_Miejsc_Konco(String KUR_Miejsc_Konco) {
		return KUR_Miejsc_Konco;
	}

	public String getKUR_Miejsc_Konco() {
		return KUR_Miejsc_Konco;
	}

	public String getKUR_Czas_Odjazdu() {
		return KUR_Czas_Odjazdu;
	}

	public String setKUR_Czas_Odjazdu(String kUR_Czas_Odjazdu) {
		return KUR_Czas_Odjazdu = kUR_Czas_Odjazdu;
	}

	public String getKUR_Czas_Przyjazdu() {
		return KUR_Czas_Przyjazdu;
	}

	public String setKUR_Czas_Przyjazdu(String kUR_Czas_Przyjazdu) {
		return KUR_Czas_Przyjazdu = kUR_Czas_Przyjazdu;
	}
}
