package edu.SimonCresnjovnjak.android;

import java.util.ArrayList;



import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NovoZdr extends Activity {
	Application1 app;
	Spinner spi1;
	EditText text1;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.novo_zdravilo);
		app = (Application1) getApplication();
		text1=(EditText)findViewById(R.id.editText1);
		
		spi1=(Spinner) findViewById(R.id.spinner1);
		ArrayList<String> a= new ArrayList<String>();
		a.add("5");
		a.add("10");
		a.add("15");
		a.add("20");
		
		ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, a);
	    adapter.setNotifyOnChange(true);
	    spi1.setAdapter(adapter);
	}

	 public void klik(View v) {
	    	switch (v.getId()) {
			case R.id.imageButton1:
				
					String b=text1.getText().toString();
					if(!b.contentEquals(""))
					{
						app.MojaZdravila.setName(b);
						Toast.makeText(this, "Vaše zdravilo je bilo dodano", Toast.LENGTH_SHORT)
						.show();
						String a=spi1.getItemAtPosition(spi1.getSelectedItemPosition()).toString();
						int aa= Integer.parseInt(a);
						app.MojaZdravila.setKolicina(aa);
						app.addZd(app.MojaZdravila);
					}
					else
					{
						Toast.makeText(this, "Ime zdravila nesme biti prazno !!!!!", Toast.LENGTH_SHORT)
						.show();
					}
						
					break;
				
	    	}
	 }
}
