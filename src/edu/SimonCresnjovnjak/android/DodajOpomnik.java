package edu.SimonCresnjovnjak.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class DodajOpomnik extends Activity{
	
		Application1 app;
		
		
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.dodaj_opomnik);
			app = (Application1) getApplication();
			
			Spinner spi1;
			spi1=(Spinner) findViewById(R.id.spinner1);
			
			//app.getnazivi();
			
			 
			   
			    	ArrayList<String> zacasni=new ArrayList<String>();
			    	zacasni.add("Lekadol");
			    	
			    	ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, zacasni);
			    	adapter.setNotifyOnChange(true);
					spi1.setAdapter(adapter);
			    
			   
			    

	}
	
}

