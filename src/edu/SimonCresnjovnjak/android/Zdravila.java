package edu.SimonCresnjovnjak.android;

public class Zdravila {
	private String name="Simon";
	private int Kolicina;
	private long dbID; //id  v tabeli
	
	
	public long getDbID() {
		return dbID;
	}

	public void setDbID(long dbID) {
		this.dbID = dbID;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Zdravila() 
	{
	  Kolicina=0;
	 
	  
	}
	public Zdravila(Zdravila mojaZdravila) {
		Kolicina=mojaZdravila.Kolicina;
		name=mojaZdravila.name;
	}

	
	public int GetKolicina()
	{
		return Kolicina;
	}
	
	
	
	public void setCas(int i) {
		  Kolicina=i;
	  }
	
}
