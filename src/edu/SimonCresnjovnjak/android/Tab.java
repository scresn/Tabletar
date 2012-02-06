package edu.SimonCresnjovnjak.android;



import edu.SimonCresnjovnajk.maps.KjeSemActivity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;

public class Tab extends TabActivity {

	Application1 app;
	
	 public void onCreate(Bundle savedInstanceState) 
	    {
	    		
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.tab2);
	        
	        Resources res = getResources(); // Resource object to get Drawables
			TabHost tabHost = getTabHost(); // The activity TabHost

			app = (Application1) getApplication();
			
			Intent intent1 = new Intent(this, DodajOpomnik.class);
			tabHost.addTab(tabHost.newTabSpec("Ddodajane Opomnikov")
					.setIndicator("Dodaj Opomnik", res.getDrawable(R.drawable.clock_plus))
					.setContent(intent1));

			Intent intent2 = new Intent(this, DodajZalogo.class);
			tabHost.addTab(tabHost.newTabSpec("Dodajanje Zaloge")
					.setIndicator("Dodajanje Zaloge", res.getDrawable(R.drawable.filecabinet_plus))
					.setContent(intent2));
			tabHost.setCurrentTab(0);
			
			Intent intent3 = new Intent(this, OpomnikiListActivity.class);
			tabHost.addTab(tabHost.newTabSpec("Lista opomnikov")
					.setIndicator("Lista opomnikov", res.getDrawable(R.drawable.task_list_alarm))
					.setContent(intent3));
			tabHost.setCurrentTab(0);

			Intent intent4 = new Intent(this, ZdravilaListActivity.class);
			tabHost.addTab(tabHost.newTabSpec("Lista opomnikov")
					.setIndicator("Lista zdravil", res.getDrawable(R.drawable.task_list_zdravila))
					.setContent(intent4));
			tabHost.setCurrentTab(0);
			
			Intent intent5 = new Intent(this, NovoZdr.class);
			tabHost.addTab(tabHost.newTabSpec("Novo Zdravilo")
					.setIndicator("Novo Zdravilo", res.getDrawable(R.drawable.pill_plus))
					.setContent(intent5));
			tabHost.setCurrentTab(0);
			
			Intent intent6 = new Intent(this, ParsanjeListActivity.class);
			tabHost.addTab(tabHost.newTabSpec("Razpoznava")
					.setIndicator("Krka", res.getDrawable(R.drawable.krka))
					.setContent(intent6));
			tabHost.setCurrentTab(0);
			
//		Intent intent7 = new Intent(this, KjeSemActivity.class);
//			tabHost.addTab(tabHost.newTabSpec("Zemljevid")
//					.setIndicator("Zemljevid", res.getDrawable(R.drawable.pill_icon_hy))
//					.setContent(intent7));
//			tabHost.setCurrentTab(0);
			
			// Set tabs Colors
			tabHost.setBackgroundColor(Color.parseColor("#000000"));
			tabHost.getTabWidget().setBackgroundColor(Color.parseColor("#000000"));

	    
	    }
	
	 @Override
		public void onResume() {
			super.onResume();
			//app.listao.clear();
			//app.fillFromDB();
			app.lista.clear();
			app.listao.clear();
//			app.DWeb.DobiOpomnik();
			app.DobiOP();
			app.DobiNaziviKolicinaZWeb();
	}
	 
	 @Override
	    public void onPause() {
	    super.onPause();
	    app.lista.clear();
	    app.listao.clear();
	    app.DobiOP();
	    app.DobiNaziviKolicinaZWeb();
	   

	    }
	

	

}
