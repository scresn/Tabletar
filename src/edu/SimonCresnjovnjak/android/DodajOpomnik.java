package edu.SimonCresnjovnjak.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;


public class DodajOpomnik extends Activity{
	
		Application1 app;
		TimePicker tipck;
		Spinner spi1, spi2;
		Opomnik op=new Opomnik();
		private static final int OPOMNIK_LIST_ID = 1;
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.dodaj_opomnik);
			app = (Application1) getApplication();
			
			
			spi1=(Spinner) findViewById(R.id.spinner1);
			spi2=(Spinner) findViewById(R.id.spinner2);
			tipck=(TimePicker) findViewById(R.id.timePicker1);
			
			app.SpinnerImenaZdravil();
			
			 tipck.setIs24HourView(true);
			   
			    	ArrayList<String> zacasni=new ArrayList<String>();
			    	ArrayList<String> zacasni2=new ArrayList<String>();
			    	
			    	zacasni.add("1");
			    	zacasni.add("2");
			    	zacasni.add("3");
			    	zacasni.add("4");
			    	zacasni.add("5");
			    	zacasni.add("6");
			    	zacasni.add("7");
			    	
			    	
			    	
			    	ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, zacasni);
			    	adapter.setNotifyOnChange(true);
					spi1.setAdapter(adapter);
					
					ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, app.array_spinner1);
			    	adapter2.setNotifyOnChange(true);
					spi2.setAdapter(adapter2);
					

	}
		
		
		 public void KlikDodajOpomnik(View v) {
		    	switch (v.getId()) {
				case R.id.imageButton1:
				{
					Toast.makeText(this, "Vaš opomnik je bil dodan", Toast.LENGTH_SHORT)
					.show(); 
					int kl=Integer.parseInt(spi1.getSelectedItem().toString());
					String aa=spi2.getSelectedItem().toString();
				
					Time caaas=new Time();
					
					
					
					caaas.hour=tipck.getCurrentHour();
					caaas.minute=tipck.getCurrentMinute();
					op.setCas(caaas);
					
				
					op.setKolicina(kl);
					op.setZdravilo(aa);
					
					app.array_spinner1.clear();
					//app.fillFromDB();
					app.DWeb.InsertOpomnik(aa,caaas.format2445(),kl);
				}
		    	}
		 }
}

