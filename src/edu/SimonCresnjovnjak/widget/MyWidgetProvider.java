package edu.SimonCresnjovnjak.widget;

import java.util.Random;

import edu.SimonCresnjovnjak.android.R;



import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;

public class MyWidgetProvider extends AppWidgetProvider {


	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// Create some random data
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
				R.layout.widget_layout);
		Intent intent = new Intent(context.getApplicationContext(),
				UpdateWidgetService.class);
		intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

		// To react to a click we have to use a pending intent as the
		// onClickListener is
		// excecuted by the homescreen application
		PendingIntent pendingIntent = PendingIntent.getService(
				context.getApplicationContext(), 0, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);
		remoteViews.setOnClickPendingIntent(R.id.TextView01, pendingIntent);

		// Finally update all widgets with the information about the click
		// listener
		appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

		// Update the widgets via the service
		context.startService(intent);
}
}