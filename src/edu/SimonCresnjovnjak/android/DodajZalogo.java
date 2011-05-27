package edu.SimonCresnjovnjak.android;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DodajZalogo extends Activity{
	
		Application1 app;
		
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.dodaj_zalogo);
			app = (Application1) getApplication();
			
			Spinner spi1, spi2;
			spi2=(Spinner) findViewById(R.id.spinner2);
			spi1=(Spinner) findViewById(R.id.spinner1);
			
			app.getnazivi();
			
			
			ArrayList<String> araylist2 = new ArrayList<String>();
			
			
			araylist2.add("5");
			araylist2.add("10");
			araylist2.add("15");
			araylist2.add("20");
			
			ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, araylist2);
		    adapter1.setNotifyOnChange(true);
		    spi2.setAdapter(adapter1);
			
			ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, app.array_spinner1);
		    adapter1.setNotifyOnChange(true);
		    spi1.setAdapter(adapter2);
	
	}
}
