package edu.SimonCresnjovnjak.alarm;


import edu.SimonCresnjovnjak.android.DodajOpomnik;
import edu.SimonCresnjovnjak.android.R;
import edu.SimonCresnjovnjak.android.Ring;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyAlarmService extends Service {
	NotificationManager mNM;
@Override
public void onCreate() {
 // TODO Auto-generated method stub
// Toast.makeText(this, "MyAlarmService.onCreate()", Toast.LENGTH_LONG).show();
 mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
// showNotification();
}
private void showNotification() {
	// In this sample, we'll use the same text for the ticker and the
	// expanded notification

	// Set the icon, scrolling text and timestamp
	Notification notification = new Notification(R.drawable.pill_icon_hy,
			"ALARM !!!", System.currentTimeMillis());

	// The PendingIntent to launch our activity if the user selects this
	// notification
	PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
			new Intent(this, Ring.class), 0); // alarmActivity

	// Set the info for the views that show in the notification panel.
	notification.setLatestEventInfo(this, "Tabletar",
			"Vzami zdavilo", contentIntent);

	// Send the notification.
	// We use a layout id because it is a unique number. We use it later to
	// cancel.
	mNM.notify(R.string.alarm_start, notification);
}
@Override
public IBinder onBind(Intent intent) {
 // TODO Auto-generated method stub
// Toast.makeText(this, "MyAlarmService.onBind()", Toast.LENGTH_LONG).show();
 return null;
}

@Override
public void onDestroy() {
 // TODO Auto-generated method stub
 super.onDestroy();
// Toast.makeText(this, "MyAlarmService.onDestroy()", Toast.LENGTH_LONG).show();
}

@Override
public void onStart(Intent intent, int startId) {
 // TODO Auto-generated method stub
 super.onStart(intent, startId);
// Toast.makeText(this, "MyAlarmService.onStart()", Toast.LENGTH_LONG).show();
 showNotification();
}

@Override
public boolean onUnbind(Intent intent) {
 // TODO Auto-generated method stub
// Toast.makeText(this, "MyAlarmService.onUnbind()", Toast.LENGTH_LONG).show();
 return super.onUnbind(intent);
}

}