package edu.SimonCresnjovnjak.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Ring extends Activity {

	ImageButton btn;
	Application1 app;
	TextView tx;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ring);
		app = (Application1) getApplication(); 
		btn = (ImageButton) findViewById(R.id.izkl);
		btn.setOnClickListener(klik);
		tx=(TextView) findViewById(R.id.txalarm);
		tx.setText("Vzami "+ app.getZdravilo()+ " "+ app.getKolicina()+"X");
		
	}
	
	private OnClickListener klik = new OnClickListener() {
        public void onClick(View v) {
        	app.DWeb.ZamnjsajZdravilo(app.getZdravilo(),Integer.parseInt(app.getKolicina()));
        	app.mAlarmStop();
//        	Tab.class.notifyAll();
        	finish();
        }
    };
}
