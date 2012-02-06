package edu.SimonCresnjovnjak.android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class OpomnikiListActivity extends ListActivity implements OnItemClickListener  {

	Application1 app;
   
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.opomnikilist_activity);
		app = (Application1) getApplication();
		setListAdapter(app.op);
		this.getListView().setOnItemClickListener(this);
		app.listao.clear();
		//app.fillFromDB();
		app.DWeb.DobiOpomnik();
		app.DobiOP();
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
	

}
