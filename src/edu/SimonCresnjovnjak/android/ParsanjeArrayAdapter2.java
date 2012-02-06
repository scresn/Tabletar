package edu.SimonCresnjovnjak.android;

import java.util.ArrayList;
import java.util.List;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ParsanjeArrayAdapter2 extends ArrayAdapter<pars> { //Step 4.8 POPRAVI Stevec -> Rezultati
	LayoutInflater mInflater;
	public ParsanjeArrayAdapter2(Context context, int textViewResourceId, ArrayList<pars> lista_pars) { //Step 4.8 POPRAVI Stevec ->Rezultati
		super(context, textViewResourceId,lista_pars);
	    mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		pars tmp = getItem(position);
		ViewHolder holder;
		// When convertView is not null, we can reuse it directly, there is no need
		// to reinflate it. We only inflate a new View when the convertView supplied
		// by ListView is null.
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.pars_layout, null);
			// Creates a ViewHolder and store references to the two children views
			// we want to bind data to.
			holder = new ViewHolder();
			holder.one = (TextView) convertView.findViewById(R.id.tvOne); //Step 4.8 POPRAVI
			//holder.icon = (ImageView) convertView.findViewById(R.id.icon);
			holder.two = (TextView) convertView.findViewById(R.id.tvTwo); //Step 4.8 POPRAVI		
			convertView.setTag(holder);
		} else {
			// Get the ViewHolder back to get fast access to the TextView
			// and the ImageView.
			holder = (ViewHolder) convertView.getTag();
		}
		// Bind the data efficiently with the holder.
		holder.one.setText(""+tmp.getNaslov()); //Step 4.8 POPRAVI
		holder.two.setText(tmp.getOpis()); //Step 4.8 POPRAVI
		//holder.icon.setImageBitmap((position & 1) == 1 ? mIcon1 : mIcon2);
		return convertView;
	}
	static class ViewHolder {
		TextView one; //Step 4.8 POPRAVI
		TextView two; //Step 4.8 POPRAVI
		
	}
}
