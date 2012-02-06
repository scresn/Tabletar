package edu.SimonCresnjovnjak.android;

import java.util.ArrayList;

import edu.SimonCresnjovnajk.maps.KjeSemActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Spinner;


public class ParsanjeListActivity2 extends ListActivity implements OnItemClickListener  {
	Application1 app;
	 Menu mMenu;
	 private static final int isk = 1;
	    private static final int crk = 2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parslist_activity);
		app = (Application1) getApplication();
		setListAdapter(app.pr2);
		this.getListView().setOnItemClickListener(this);
		//app.lista.clear(); 
		//app.fillFromDB();
		// System.out.print(app.DWeb.GetData());



	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

} 

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.crke:
			//showDialog(EXIT_DIALOG);
			Intent moj1=new Intent(this,abec.class);
		
			
			this.startActivityForResult(moj1, crk);
			
			break;
			
		case R.id.isci:
			
			Intent moj2=new Intent(this,iskanje.class);
			
			this.startActivityForResult(moj2, isk);
		
			break;
			
		
		
//		default:// Generic catch all for all the other menu resources
//			if (!item.hasSubMenu()) {
//				Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT)
//				.show();
//				return true;
//			}
//			break;
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
	    public void onPause() {
	    super.onPause();
	

	    }
}

