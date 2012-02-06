package edu.SimonCresnjovnjak.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class iskanje extends Activity{
	Application1 app;
	EditText et;
	private static final int a = 1;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.iskan);
		
		et=(EditText) findViewById(R.id.edit);
		app = (Application1) getApplication();
	}
	public void Klik(View v) {
    	switch (v.getId()) {
		case R.id.pozeni:
		{
			
			
			
			
			
			
			
			if(et.getText() != null || et.getText().toString() !="")
			{
			String aa=et.getText().toString();
			app.polniiskanje2(aa);
			;
			Intent moj2=new Intent(this,ParsanjeListActivity2.class);
			
			this.startActivityForResult(moj2, a);
			finish();
			}
			else
			{
				Toast.makeText(this, "Vnosno polje ne sme biti prazno", Toast.LENGTH_SHORT)
				.show(); 
			}
			
			break;
		}
		}
 }
}
