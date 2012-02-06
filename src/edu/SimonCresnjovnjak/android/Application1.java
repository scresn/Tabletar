package edu.SimonCresnjovnjak.android;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.ResultSet;

import android.R.integer;
import android.text.format.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;





import edu.SimonCresnjovnjak.alarm.MyAlarmService;
import edu.SimonCresnjovnjak.data3.DBAdapterOpomniki;
import edu.SimonCresnjovnjak.data3.DBAdapterZdravila;
import edu.SimonCresnjovnjak.parsanje.razpoznava;
import edu.SimonCresnjovnjak.web.DeloZWebService;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.util.Printer;
import android.webkit.ConsoleMessage;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;

public class Application1 extends Application{
	public ArrayList<Zdravila> lista;
	public ArrayList<Opomnik> listao;
	ZdravilaArrayAdapter zd;
	ParsanjeArrayAdapter pr;
	ParsanjeArrayAdapter2 pr2;
	OpomnikArrayAdapter op;
	Zdravila MojaZdravila;
	public String zdravilo, kolicina;
	razpoznava opi;
	Date dt;
	private PendingIntent mAlarmSender;
	private PendingIntent pendingIntent;
	Opomnik MojOpomnik;
	DBAdapterOpomniki DBOp;
	DBAdapterZdravila DBZd;
	DeloZWebService DWeb=new DeloZWebService();;
	public ArrayList<String> array_spinner1;
	public String[] poljestringov;
	public int stevec2;
	pars a =new pars();
	public ArrayList<pars> lista_pars;
	public ArrayList<pars> lista_pars2;
	
	public boolean isMediaRunning;
	boolean isFound;
	boolean isFirst;
	Intent alarmIntent;
	int trenutnaUra, trenutnaMinuta, sekunda;
	String name="test";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private List<String> news;
	private int stevec;
	public List<String> getNews() {
		return news;
	}
	public void setNews(List<String> news) {
		this.news = news;
	}
	public int getStevec() {
		return stevec;
	}
	public void setStevec(int stevec) {
		this.stevec = stevec;
	}
	
	
	public int getStevec2() {
		return stevec2;
	}

	public void setStevec2(int stevec) {
		if(stevec==poljestringov.length)
		{
			this.stevec2=0;
		}
		else
		{
		this.stevec2=stevec;
		}
	}

	public void onCreate() {
        super.onCreate(); //ne pozabi
        DBOp = new DBAdapterOpomniki(this); 
        DBZd= new DBAdapterZdravila(this);
        opi=new razpoznava();
        //DWeb=new DeloZWebService();
        lista = new ArrayList<Zdravila>(); //inicializirat
        listao= new ArrayList<Opomnik>();
        lista_pars=new ArrayList<pars>();

        lista_pars2=new ArrayList<pars>();
        array_spinner1= new ArrayList<String>();
        
        zdravilo="";
        kolicina="";
        sekunda = 0;
		trenutnaUra = 0;
		trenutnaMinuta = 0;
//		
//		alarmService = new AlarmService();
//		alarmIntent = new Intent(Application1.this, alarmService.getClass());
//		mAlarmSender = PendingIntent.getService(Application1.this,
//				0, alarmIntent, 0);
        
         init();
         DobiNaziviKolicinaZWeb();
         DobiOP();
         //fillFromDB();
        DobiNaziviKolicinaZWeb();
        polniPars();
         
        zd = new ZdravilaArrayAdapter(this, R.layout.zdravila_layout,lista); //Step 4.10 Globalna lista
        op = new OpomnikArrayAdapter(this,R.layout.opomniki_layout,listao);
        pr = new ParsanjeArrayAdapter(this,R.layout.pars_layout,lista_pars);
        pr2 = new ParsanjeArrayAdapter2(this,R.layout.pars_layout2,lista_pars2);
        
        mAlarmSender = PendingIntent.getService(Application1.this,
                0, new Intent(Application1.this, MyAlarmService.class), 0);
	}
	
public String getZdravilo() {
		return zdravilo;
	}
	public void setZdravilo(String zdravilo) {
		this.zdravilo = zdravilo;
	}
	public String getKolicina() {
		return kolicina;
	}
	public void setKolicina(String kolicina) {
		this.kolicina = kolicina;
	}
	//	public void setupNextAlarm() {
//	}
//	
	public void mAlarmStop() {
		
        AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
        am.cancel(mAlarmSender);

		
		
		
        Toast.makeText(Application1.this, "STOPPED!!!",
                Toast.LENGTH_LONG).show();
	}

public void mAlarmStart(int nastavljenaUra, int nastavljenaMinuta, String imezdr, String kolzdr) {		
		
	setKolicina(kolzdr);
	setZdravilo(imezdr);
	
		dt = new Date();
		trenutnaUra = dt.getHours();
		trenutnaMinuta = dt.getMinutes();

		 Intent myIntent = new Intent(Application1.this, MyAlarmService.class);
		   pendingIntent = PendingIntent.getService(Application1.this, 0, myIntent, 0);

		            AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

		            if(nastavljenaUra == trenutnaUra && nastavljenaMinuta == trenutnaMinuta) {
		    			sekunda = 0;
		    		}
		    		else if(((nastavljenaUra == trenutnaUra) && (nastavljenaMinuta > trenutnaMinuta)) || (nastavljenaUra > trenutnaUra)) {
		    			sekunda = ((nastavljenaUra*60)+nastavljenaMinuta) - ((trenutnaUra*60)+trenutnaMinuta);
		    		}
		    		else if (nastavljenaUra < trenutnaUra) {
		    			sekunda = (1440 - ((trenutnaUra*60)+trenutnaMinuta)) + ((nastavljenaUra * 60) + nastavljenaMinuta);
		    		}
		    		else sekunda = 0;
		    
		    		sekunda = sekunda * 60;
		            Calendar calendar = Calendar.getInstance();
		            calendar.setTimeInMillis(System.currentTimeMillis());
		            calendar.add(Calendar.SECOND, sekunda);
		            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
		         
		   Toast.makeText(Application1.this, "Opomnik nastavljen", Toast.LENGTH_LONG).show();
		  
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
//				System.out.println(a[i]);
				lista.add(tmp2);
				//Log.v("listazdr", lista.toString());
				tmp2 = new Zdravila();
			}
			else
			{
//				System.out.println(a[i]);
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
	public void polniPars()
	{
		lista_pars.addAll(opi.pozeni());
	}
	public void polnicrke(String a)
	{
		lista_pars.clear();
		lista_pars.addAll(opi.pozenicrke(a));
	}
	public void polnicrke2(String a)
	{
		lista_pars2.clear();
		lista_pars2.addAll(opi.pozenicrke(a));
	}
	public void polniiskanje(String a)
	{
		lista_pars.clear();
		lista_pars.addAll(opi.isci(a));
	}
	public void polniiskanje2(String a)
	{
		lista_pars2.clear();
		lista_pars2.addAll(opi.isci(a));
	}
	public void DobiOP()
	{
		int c=0;
		 listao.clear();
		String tmp;
		int x=1;
		int b;

		
		Opomnik tmp2;
		tmp= DWeb.DobiOpomnik().toString();
		tmp2 = new Opomnik();
		//for ()
		
		
		
			String a[]=tmp.split("\\,");
		for(int i = 0; i < a.length; i++){
		//a[i]=tmp.split("\\,");
			
		}
		poljestringov= new String[a.length/3];
		poljestringov[0]="";
		if((a.length !=0) )
		{
		for(int i=0;i<a.length;i++)
		{
			
			if(x == 2)
			{
				//System.out.println(a[i]);
				Time t = new Time();
				String  bazaCas =a[i]; 
				t.parse(bazaCas); //pretvori string v time
				String bb=t.format2445();
				Time tt =new Time();
				tt.hour=t.hour;
				tt.minute=t.minute;
				tt.timezone="null";
				poljestringov[c]+=t.hour+":"+ t.minute+" ";
//				poljestringov.add(c, object))(t.hour+":"+ t.minute+" ");
				
//				Log.v("cas",poljestringov[c] );
				tmp2.setCas(tt);
				
			}
			else if(x == 3)
			{
				
				poljestringov[c]+=a[i].toString() + "X ";
				//poljestringov
				//Log.v("koncni", poljestringov[c]);
				x=0;
				c++;
				b=Integer.parseInt(a[i]);
//				Log.v("kolicina",String.valueOf(b) );
				tmp2.setKolicina(b);
				listao.add(tmp2);
				//Log.v("lista", listao.toString());
				tmp2 = new Opomnik();
				
//				poljestringov[c]="";
			}
			else
			{
				poljestringov[c]="";
				poljestringov[c]+=a[i] + " ";
				tmp2.setZdravilo(a[i]);
//				Log.v("zdravilo",poljestringov[c] );
			}
							
			x++;
		}
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
				//System.out.println(c.getString(DBAdapterZdravila.POS_NAZIV));
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
