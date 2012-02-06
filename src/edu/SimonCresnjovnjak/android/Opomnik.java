package edu.SimonCresnjovnjak.android;

import android.text.format.Time;

public class Opomnik {
	
		private String zdravilo="Simon";
		//private String interval="Ponedeljek";
		private int kolicina;
		private Time cas;
		private long dbID; //id  v tabeli
		
		public Opomnik() 
		{
		  zdravilo="";
		 // interval="";
		  kolicina=2;
		  
		}
		public long getDbID() {
			return dbID;
		}

		public void setDbID(long dbID) {
			this.dbID = dbID;
		}
		public String getZdravilo() {
			return zdravilo;
		}

		public void setZdravilo(String zdr) {
			this.zdravilo = zdr;
		}
		/*
		public String getInterval() {
			return interval;
		}


		public void setInterval(String inter) {
			this.interval = inter;
		}
		*/
		public Time getCas() {
			return cas;
		}

		public void setCas(Time caas) {
			this.cas = caas;
			
		}
		public void setKolicina(int kol) {
			this.kolicina = kol;
		}
		public int getKolicina() {
			return kolicina;
		}
		public Opomnik(Opomnik mojOpomnik) {
			kolicina=mojOpomnik.kolicina;
			zdravilo=mojOpomnik.zdravilo;
			cas=mojOpomnik.cas;
		}

}
