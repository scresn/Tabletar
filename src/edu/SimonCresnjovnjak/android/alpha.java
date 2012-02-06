package edu.SimonCresnjovnjak.android;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;



public class alpha extends Activity{
	Application1 app;
	  
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parslist_activity2);
		
		app = (Application1) getApplication();
	}
}
