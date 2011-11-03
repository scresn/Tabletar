package edu.SimonCresnjovnjak.android;

import java.util.ArrayList;

import org.xml.sax.Parser;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class DodajZalogo extends Activity{
	
		Application1 app;
		Spinner spi1, spi2;
		
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.dodaj_zalogo);
			app = (Application1) getApplication();
			
			
			spi2=(Spinner) findViewById(R.id.spinner2);
			spi1=(Spinner) findViewById(R.id.spinner1);
			app.SpinnerImenaZdravil();
			//app.getnazivi();
			
			
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
		 public void KlikZaloga(View v) {
		    	switch (v.getId()) {
				case R.id.imageButton1:
				{
					Toast.makeText(this, "Vaša zaloga je bila dodana", Toast.LENGTH_SHORT)
					.show(); 
					int a=Integer.parseInt(spi2.getSelectedItem().toString());
					//System.out.println(spi1.getSelectedItem().toString());
					//app.DodajZal(spi1.getSelectedItem().toString(),a );
					app.DWeb.InsertZdravilo(spi1.getSelectedItem().toString(),a );
					app.array_spinner1.clear();
					//app.fillFromDB();
					app.DobiNaziviKolicinaZWeb();
				}
		    	}
		 }
}
