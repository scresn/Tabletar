package edu.SimonCresnjovnjak.android;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.ResultSet;

import android.R.integer;
import android.text.format.Time;
import java.util.ArrayList;



import edu.SimonCresnjovnjak.data3.DBAdapterOpomniki;
import edu.SimonCresnjovnjak.data3.DBAdapterZdravila;
import edu.SimonCresnjovnjak.web.DeloZWebService;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Printer;
import android.webkit.ConsoleMessage;
import android.widget.ArrayAdapter;
import android.text.format.Time;

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
	DeloZWebService DWeb;
	public ArrayList<String> array_spinner1;
	
	public void onCreate() {
        super.onCreate(); //ne pozabi
        DBOp = new DBAdapterOpomniki(this); 
        DBZd= new DBAdapterZdravila(this);
        DWeb=new DeloZWebService();
        //DWeb=new DeloZWebService();
        lista = new ArrayList<Zdravila>(); //inicializirat
        listao = new ArrayList<Opomnik>();
        array_spinner1= new ArrayList<String>();
         //init();
         DobiNaziviKolicinaZWeb();
         DobiOP();
         //fillFromDB();
        
         
        zd = new ZdravilaArrayAdapter(this, R.layout.zdravila_layout,lista); //Step 4.10 Globalna lista
        op = new OpomnikArrayAdapter(this,R.layout.opomniki_layout,listao);
	}
	
	//+++++++++++++++++++++++++++++ web +++++++++++++++++++++++
	public void DobiNaziviKolicinaZWeb()
	{
		 lista.clear();
		String tmp;
		int x=1;
		int b;
		Zdravila tmp2;
		tmp= DWeb.GetData().toString();
		tmp2 = new Zdravila();
		//for ()
		String a[]=tmp.split("\\,");
		for(int i = 0; i < a.length; i++){
		//a[i]=tmp.split("\\,");
			
		}
		for(int i=0;i<a.length;i++)
		{
			
			if(x == 2)
			{
				x=0;
				b= Integer.parseInt(a[i]);
				tmp2.setKolicina(b);
				//System.out.println(a[i]);
				lista.add(tmp2);
				tmp2 = new Zdravila();
			}
			else
			{
				//System.out.println(a[i]);
				tmp2.setName(a[i]);
			}
							
			x++;
		}
	}
	
	public void SpinnerImenaZdravil()
	{
		array_spinner1.clear();
		String ime= DWeb.GetImeOP().toString();
		String a[]=ime.split("\\,");
		for(int i=0;i<a.length;i++)
		{
			array_spinner1.add(a[i]);
		}
	}
	
	public void DobiOP()
	{
		 listao.clear();
		String tmp;
		int x=1;
		int b;
		Opomnik tmp2;
		tmp= DWeb.DobiOpomnik().toString();
		tmp2 = new Opomnik();
		//for ()
		String a[]=tmp.split("\\;");
		for(int i = 0; i < a.length; i++){
		//a[i]=tmp.split("\\,");
			//System.out.println(a[i]);
			
		}
		for(int i=0;i<a.length;i++)
		{
			
			if(x == 2)
			{
				//System.out.println(a[i]);
				Time t = new Time();
				String  bazaCas =a[i]; 
				
				t.parse(bazaCas); //pretvori string v time
				//System.out.println(t);
				tmp2.setCas(t);
				
			}
			else if(x == 3)
			{
				x=0;
				b=Integer.parseInt(a[i]);
				//System.out.println(b);
				tmp2.setKolicina(b);
				listao.add(tmp2);
				tmp2 = new Opomnik();
			}
			else if(x==1)
			{
				//System.out.println(a[i]);
				tmp2.setZdravilo(a[i]);
			}
							
			x++;
		}
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
		listao.clear();
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			tmpO = new Opomnik();
			tmpO.setKolicina(c.getInt(DBAdapterOpomniki.POS_VALUE));
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
