package edu.SimonCresnjovnjak.android;

import java.util.ArrayList;

import edu.SimonCresnjovnjak.data1.DBAdapterZdravila;
import edu.SimonCresnjovnjak.data2.DBAdapterOpomnik;
import android.database.Cursor;

import android.app.Application;

public class Application1 extends Application{
	public ArrayList<Zdravila> lista;
	ZdravilaArrayAdapter stevci;
	Zdravila MojaZdravila;
	DBAdapterOpomnik DBOp;
	
	public void onCreate() {
        super.onCreate(); //ne pozabi
        DBOp = new DBAdapterOpomnik(this); 
        lista = new ArrayList<Zdravila>(); //inicializirat
         init();
         fillFromDB();
        stevci = new ZdravilaArrayAdapter(this, R.layout.zdravila_layout,lista); //Step 4.10 Globalna lista
       
	}
	
	public void fillFromDB() {
		DBOp.open();
		Cursor c = DBOp.getAll();
		Zdravila tmp;
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			tmp = new Zdravila();
			tmp.setName(c.getString(DBAdapterZdravila.POS_NAZIV));
			tmp.setCas(c.getInt(DBAdapterZdravila.POS_KOLICINA));
			tmp.setDbID(c.getLong(DBAdapterZdravila.POS__ID));
			lista.add(tmp); 
		}
		c.close();
		DBOp.close();
	}
	public void init() {
		 MojaZdravila = new Zdravila();
		//mojRezultat.setName();
		lista.add(MojaZdravila);
		
		
	}
	
	public void add(Zdravila a) {
		Zdravila tmp = new Zdravila(MojaZdravila);
		addDB(tmp);
		lista.add(a);
		stevci.add(a);  //Step 4.10 Globalna lista
		
	}
	public void remove(Zdravila a) {
		//lista.add(a);
		if (a!=null)
		stevci.remove(a); //Step 4.10 Globalna lista
	}
	public void addDB(Zdravila s) {
		DBOp.open();
		s.setDbID(DBOp.insertOpomnik(s));
		DBOp.close();	
	}
	
	
}
