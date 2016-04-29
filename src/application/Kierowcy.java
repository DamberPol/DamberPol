package application;

public class Kierowcy {
	private int Id;
	private String name;
	private String nazwisko;
	private String pesel;
	private String datazatrudnienia;

	
	public Kierowcy(){
		this.Id=0;
		this.name="";
		this.nazwisko="";
		this.pesel= null;
		this.datazatrudnienia="";
		
	}
	
	public Kierowcy(int Id, String name, String nazwisko, String pesel, String datazatrudnienia)
	{

		this.Id= Id;
		this.name=name;
		this.nazwisko=nazwisko;
		this.pesel= pesel;
		this.datazatrudnienia=datazatrudnienia;
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getDatazatrudnienia() {
		return datazatrudnienia;
	}

	public void setDatazatrudnienia(String datazatrudnienia) {
		this.datazatrudnienia = datazatrudnienia;
	}


	
}
