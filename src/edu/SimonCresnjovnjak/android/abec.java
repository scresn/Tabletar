package edu.SimonCresnjovnjak.android;

import java.util.ArrayList;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class abec extends Activity{
	
	Spinner spin;
	Application1 app;
	private static final int a = 1;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.abeceda);
		
		app = (Application1) getApplication();
		spin=(Spinner) findViewById(R.id.spin);
		ArrayList<String> zacasni=new ArrayList<String>();
		zacasni.add("A");
    	zacasni.add("B");
    	zacasni.add("C");
    	zacasni.add("D");
    	zacasni.add("E");
    	zacasni.add("F");
    	zacasni.add("G");
    	zacasni.add("H");
    	zacasni.add("I");
    	zacasni.add("J");
    	zacasni.add("K");
    	zacasni.add("M");
    	zacasni.add("N");
    	zacasni.add("O");
    	zacasni.add("P");
    	zacasni.add("Q");
    	zacasni.add("R");
    	zacasni.add("S");
    	zacasni.add("T");
    	zacasni.add("U");
    	zacasni.add("V");
    	zacasni.add("W");
    	zacasni.add("X");
    	zacasni.add("Y");
    	zacasni.add("Z");
    	ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, zacasni);
    	adapter.setNotifyOnChange(true);
		spin.setAdapter(adapter);
	}
	 public void Klik(View v) {
	    	switch (v.getId()) {
			case R.id.pozeni:
			{
				String aa=spin.getSelectedItem().toString();
				
				app.polnicrke2(aa);
				Intent moj2=new Intent(this,ParsanjeListActivity2.class);
				
				this.startActivityForResult(moj2, a);
				
				finish();
				break;
			}
			}
	 }
}
