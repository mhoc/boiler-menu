package com.mikedhock.boilermenu;

import com.mikedhock.boilermenu.widgets.LocationListAdapter;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FragLocationList extends Fragment implements OnItemClickListener {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frag_location_list, container, false);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// Create the list view.
		final ListView list = (ListView) getActivity().findViewById(R.id.listview_locationlist);
		
		// Create the adapter which will fill the list view.
		LocationListAdapter adapter = new LocationListAdapter(getActivity(), 
				getActivity().getResources().getStringArray(R.array.location_list_printable),
				ActivityMainMenu.locationBitmaps);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		
	}
	
	
	
}
