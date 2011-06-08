package edu.SimonCresnjovnjak.android;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.ResultSet;
import android.text.format.Time;
import java.util.ArrayList;



import edu.SimonCresnjovnjak.data3.DBAdapterOpomniki;
import edu.SimonCresnjovnjak.data3.DBAdapterZdravila;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Printer;
import android.webkit.ConsoleMessage;
import android.widget.ArrayAdapter;

import android.app.Application;

public class Application1 extends Application{
	public ArrayList<Zdravila> lista;
	public ArrayList<Opomnik> listao;
	ZdravilaArrayAdapter zd;
	OpomnikArrayAdapter op;
	Zdravila MojaZdravila;
	Opomnik MojOpomnik;
	DBAdapterOpomniki DBOp;
	DBAdapterZdravila DBZd;
	public ArrayList<String> array_spinner1;
	
	public void onCreate() {
        super.onCreate(); //ne pozabi
        DBOp = new DBAdapterOpomniki(this); 
        DBZd= new DBAdapterZdravila(this);
        lista = new ArrayList<Zdravila>(); //inicializirat
        listao = new ArrayList<Opomnik>();
        array_spinner1= new ArrayList<String>();
         init();
         fillFromDB();
        zd = new ZdravilaArrayAdapter(this, R.layout.zdravila_layout,lista); //Step 4.10 Globalna lista
        op = new OpomnikArrayAdapter(this,R.layout.opomniki_layout,listao);
	}
	public void testadd()
	{
	
	}
	public void fillFromDB() {
		DBZd.open();
		Cursor c = DBZd.getAll();
		Zdravila tmp;
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			tmp = new Zdravila();
			tmp.setName(c.getString(DBAdapterZdravila.POS_NAZIV));
			tmp.setKolicina(c.getInt(DBAdapterZdravila.POS_KOLICINA));
			//tmp.setDbID(c.getLong(DBAdapterZdravila.POS__ID));
			lista.add(tmp); 
		}
		c.close();
		DBZd.close();
		//----------------------------------
		DBOp.open();
		c = DBOp.getAll();
		Opomnik tmpO;
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			tmpO = new Opomnik();
			tmpO.setDbID(c.getLong(DBAdapterOpomniki.POS__ID));
			tmpO.setZdravilo(c.getString(DBAdapterOpomniki.POS_NAME));
			Time t = new Time();
			String  bazaCas =c.getString(DBAdapterOpomniki.POS_TIME); 
			t.parse(bazaCas); //pretvori string v time
			tmpO.setCas(t);
			listao.add(tmpO); 
		}
		c.close();
		DBOp.close();
	}
	public void init() {
		 MojaZdravila = new Zdravila();
		//mojRezultat.setName();
		lista.add(MojaZdravila);
		
		
	}
	public void addDBOP(Opomnik s) {
		DBOp.open();
		s.setDbID(DBOp.insertOpomnik(s));
		DBOp.close();	
	}
	public void addOp(Opomnik a) {
		Opomnik tmp = new Opomnik(a);
		addDBOP(tmp); //Step 4.10 Globalna lista
		
	}
	public void addZd(Zdravila a) {
		Zdravila tmp = new Zdravila(MojaZdravila);
		addDBZd(tmp);
		  //Step 4.10 Globalna lista
		
	}
	public void remove(Zdravila a) {
		//lista.add(a);
		if (a!=null)
		zd.remove(a); //Step 4.10 Globalna lista
	}
	public void addDBZd(Zdravila s) {
		DBZd.open();
		s.setDbID(DBZd.insertZdravila(s));
		DBZd.close();	
	}
	public void getnazivi()
	{
		DBZd.open();
		Cursor c = DBZd.getAll();
		//array_spinner1.add("Lekadol");
		array_spinner1.clear();
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) 
		{
			array_spinner1.add(c.getString(DBAdapterZdravila.POS_NAZIV));
		}
		c.close();
		DBZd.close();
	}
	public void DodajZal(String zdravilo, int kolicina)
	{
		DBZd.open();
		Cursor c = DBZd.getAll();
		String naz;
		Zdravila tmp = new Zdravila(MojaZdravila);
		int i=1;
		int kol=0;
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) 
		{
			//System.out.println(zdravilo);
			naz=c.getString(DBAdapterZdravila.POS_NAZIV);
			//System.out.println(zdravilo);
			//System.out.println(naz);
			if(naz.contentEquals(zdravilo))
			{
				System.out.println(c.getString(DBAdapterZdravila.POS_NAZIV));
				kol=c.getInt(DBAdapterZdravila.POS_KOLICINA);
				DBZd.deleteZdravila(c.getLong(c.getPosition()));
				tmp.setKolicina(kol+kolicina);
				tmp.setName(zdravilo);
				tmp.setDbID(c.getPosition());
				addDBZd(tmp);
			}
		}
		c.close();
	}
}
