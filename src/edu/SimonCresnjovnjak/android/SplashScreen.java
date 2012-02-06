package edu.SimonCresnjovnjak.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class SplashScreen extends Activity {
	
	//how long until we go to the next activity
	protected int _splashTime = 6000;
	
	private Thread splashTread;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		final SplashScreen sPlashScreen = this;
		
		// thread for displaying the SplashScreen
		splashTread = new Thread() {
			@Override
			public void run() {
				try {
					synchronized (this) {
						//wait
						wait(_splashTime);
					}
				}
				catch(InterruptedException e) {}
				finally {
					
					
					//start a new activity
					Intent i = new Intent();
					i.setClass(sPlashScreen, Tab.class);
					startActivity(i);
					finish();
					stop();
				}
			}
		};
		splashTread.start();
	}
	
	// function that will handle the touch
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			synchronized(splashTread){
				splashTread.notifyAll();
			}
		}
		return true;
	}
}
