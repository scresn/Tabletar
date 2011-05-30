package edu.SimonCresnjovnjak.android;






import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;


public class ZdravilaListActivity extends ListActivity implements OnItemClickListener  {
	Application1 app;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zdravilalist_activity);
		app = (Application1) getApplication();
		setListAdapter(app.zd);
		this.getListView().setOnItemClickListener(this);
		app.lista.clear();
		app.fillFromDB();
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
	
} 

