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
			
			Spinner spi1;
			spi1=(Spinner) findViewById(R.id.spinner2);
			ArrayList<String> a= new ArrayList<String>();
			a.add("5");
			a.add("10");
			a.add("15");
			a.add("20");
			
			ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, a);
		    adapter.setNotifyOnChange(true);
		    spi1.setAdapter(adapter);
	
	}
}
