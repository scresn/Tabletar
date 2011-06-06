package edu.SimonCresnjovnjak.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.R.string;
import android.app.Activity;
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
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.dodaj_opomnik);
			app = (Application1) getApplication();
			
			
			spi1=(Spinner) findViewById(R.id.spinner1);
			spi2=(Spinner) findViewById(R.id.spinner2);
			tipck=(TimePicker) findViewById(R.id.timePicker1);
			
			app.getnazivi();
			
			 tipck.setIs24HourView(true);
			   
			    	ArrayList<String> zacasni=new ArrayList<String>();
			    	ArrayList<String> zacasni2=new ArrayList<String>();
			    	
			    	zacasni.add("Ponedeljek");
			    	zacasni.add("Torek");
			    	zacasni.add("Sreda");
			    	zacasni.add("Èetrtek");
			    	zacasni.add("Petek");
			    	zacasni.add("Sobota");
			    	zacasni.add("Nedelja");
			    	
			    	
			    	
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
					String a=spi1.getSelectedItem().toString();
					String aa=spi2.getSelectedItem().toString();
					
					Time caaas=new Time();
					//System.out.println(spi1.getSelectedItem().toString());
					caaas.hour=tipck.getCurrentHour();
					caaas.minute=tipck.getCurrentMinute();
					op.setCas(caaas);
					op.setInterval(a);
					op.setZdravilo(aa);
					app.addOp(op);
					app.array_spinner1.clear();
					app.fillFromDB();
				}
		    	}
		 }
}

