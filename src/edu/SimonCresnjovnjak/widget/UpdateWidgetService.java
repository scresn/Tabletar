package edu.SimonCresnjovnjak.widget;

import java.util.Random;

import edu.SimonCresnjovnjak.android.Application1;
import edu.SimonCresnjovnjak.android.R;
import edu.SimonCresnjovnjak.parsanje.razpoznava;
import android.R.integer;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

public class UpdateWidgetService extends Service {
	
	Application1 app= new Application1();
	
	@Override
	public void onStart(Intent intent, int startId) {
		

//		String fakeUpdate = "Random: ";
//		Random random = new Random();
//		int nextInt = random.nextInt(100);
//		fakeUpdate += String.valueOf(nextInt);
		razpoznava op = new razpoznava();
		if(app.getNews()==null || app.getNews().size()==0)
			app.setNews(op.pozeninaslovi());
		
		
		AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this
				.getApplicationContext());
		
		
		
		int[] appWidgetIds = intent
				.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS);
		if (appWidgetIds.length > 0) {
			for (int widgetId : appWidgetIds) {
				RemoteViews remoteViews = new RemoteViews(getPackageName(),
						R.layout.widget_layout);
				remoteViews.setTextViewText(R.id.TextView01,app.getNews().get(app.getStevec()%app.getNews().size()));
				app.setStevec(app.getStevec()+1);
				
				appWidgetManager.updateAppWidget(widgetId, remoteViews);
			}
			stopSelf();
		}
		super.onStart(intent, startId);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
