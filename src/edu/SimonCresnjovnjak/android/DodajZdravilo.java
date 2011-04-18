package edu.SimonCresnjovnjak.android;

import android.app.Activity;
import android.os.Bundle;

public class DodajZdravilo extends Activity{
	public class win extends Activity{
		Application1 app;
		
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.dodaj_zdravilo);
			app = (Application1) getApplication();
			
			
	}
	}
}
