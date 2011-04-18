package edu.SimonCresnjovnjak.android;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zdravila_layout);
    }
    Application1 app;
    Menu mMenu;
    private static final int DODAJ_OPOMNIK_ACTIVITY_ID = 1;
    private static final int DODAJ_ZDRAVILO_ACTIVITY_ID = 2;
@Override
public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	case R.id.izh:
		//showDialog(EXIT_DIALOG);
		break;
		
	case R.id.dodajzd:
		Intent moj2=new Intent(this,DodajZdravilo.class);
		this.startActivityForResult(moj2, DODAJ_ZDRAVILO_ACTIVITY_ID);
	
		break;
	case R.id.odstrani:
		
		 break;
	case R.id.dodajop:
		Intent moj1=new Intent(this,DodajOpomnik.class);
		this.startActivityForResult(moj1, DODAJ_OPOMNIK_ACTIVITY_ID);
		
		break;
	default:// Generic catch all for all the other menu resources
		if (!item.hasSubMenu()) {
			Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT)
			.show();
			return true;
		}
		break;
	}

	return false;
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
	mMenu = menu;
	MenuInflater inflater = getMenuInflater();
	inflater.inflate(R.menu.menu, mMenu);
	return true;
}
}