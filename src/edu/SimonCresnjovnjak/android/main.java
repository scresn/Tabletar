package edu.SimonCresnjovnjak.android;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class main extends ListActivity {
    /** Called when the activity is first created. */
	Application1 app;
    Menu mMenu;
    private static final int DODAJ_OPOMNIK_ACTIVITY_ID = 1;
    private static final int DODAJ_ZALOGO_ACTIVITY_ID = 2;
    private static final int DODAJ_NOVO_ACTIVITY_ID = 3;
    private static final int LISTA_ZDRAVIL_ACTIVITY_ID = 5;
    private static final int EXIT_DIALOG=4; 
    private static final int MAPA=6; 
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opomnikilist_activity);
    	app = (Application1) getApplication();
    	setListAdapter(app.op);
    		Intent moj3=new Intent(this,NovoZdr.class);
    		
    		this.startActivityForResult(moj3, DODAJ_NOVO_ACTIVITY_ID);
    	
    	app.fillFromDB();
    	
    }
    
    
@Override
public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	case R.id.izh:
		//showDialog(EXIT_DIALOG);
		showDialog(EXIT_DIALOG);
		break;
		
	case R.id.dodajzl:
		Intent moj2=new Intent(this,DodajZalogo.class);
		
		this.startActivityForResult(moj2, DODAJ_ZALOGO_ACTIVITY_ID);
	
		break;
	case R.id.novo:
		Intent moj3=new Intent(this,NovoZdr.class);
		
		this.startActivityForResult(moj3, DODAJ_NOVO_ACTIVITY_ID);
		 break;
	case R.id.dodajop:
		Intent moj1=new Intent(this,DodajOpomnik.class);
		this.startActivityForResult(moj1, DODAJ_OPOMNIK_ACTIVITY_ID);
		
		break;
	case R.id.listazdr:
		Intent moj4=new Intent(this,ZdravilaListActivity.class);
		
		this.startActivityForResult(moj4, LISTA_ZDRAVIL_ACTIVITY_ID);
	
		break;
	case R.id.map:
		Intent moj5=new Intent(this,edu.SimonCresnjovnajk.maps.KjeSemActivity.class);
		
		this.startActivityForResult(moj5, MAPA);
	
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
@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if ((keyCode == KeyEvent.KEYCODE_BACK)) {
    	showDialog(EXIT_DIALOG);
        return true;
    }
    return super.onKeyDown(keyCode, event);
}


@Override  //v razredu RezultatiListActivity

protected Dialog onCreateDialog(int id) {

 switch (id) {

  case EXIT_DIALOG:

   AlertDialog.Builder builder = new AlertDialog.Builder(this);

   builder.setMessage("Ali želiti zapustiti aplikacijo?")

    .setCancelable(false)

    .setPositiveButton("Da", new DialogInterface.OnClickListener() {

      public void onClick(DialogInterface dialog, int id) {

        main.this.setResult(RESULT_CANCELED);

       main.this.finish();}

       })

    .setNegativeButton("Ne", new DialogInterface.OnClickListener() {

      public void onClick(DialogInterface dialog, int id) {

        main.this.setResult(RESULT_OK);

        dialog.cancel();

      }

   });

   return builder.create();

  }

  return null;

}
}