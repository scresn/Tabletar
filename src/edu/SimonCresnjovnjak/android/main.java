package edu.SimonCresnjovnjak.android;




import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
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
        setContentView(R.layout.tab2);
    	app = (Application1) getApplication();
    	app.DobiOP();
    	setListAdapter(app.op);

    	
    		Intent moj3=new Intent(this,NovoZdr.class);
    		
    		this.startActivityForResult(moj3, DODAJ_NOVO_ACTIVITY_ID);
    	
    	
    	
    }
    @Override
    public void onResume() {
    super.onResume();
    app.DobiOP();
    setListAdapter(app.op);

    }
    @Override
    public void onPause() {
    super.onPause();
    app.DobiOP();
    setListAdapter(app.op);
    app.fillFromDB();
    }
   
    
    


@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if ((keyCode == KeyEvent.KEYCODE_BACK)) {
    	showDialog(EXIT_DIALOG);
        return true;
    }
    return super.onKeyDown(keyCode, event);
}


@Override  

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