package com.mikedhock.boilermenu;

import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class FragLocationList extends Fragment implements OnItemClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frag_location_list, container, false);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// Create the grid view which will house the location images
		GridView grid = (GridView) getActivity().findViewById(R.id.gridview_locationlist);
		
		DisplayMetrics metrics = new DisplayMetrics(); 
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int screenW = metrics.widthPixels;
		int screenH = metrics.heightPixels;
		
		grid.setColumnWidth(screenW / 3);
		
		LocationListAdapter adapter = new LocationListAdapter(getActivity());
		grid.setAdapter(adapter);
		grid.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		
	}
	
	
	
	

	
	
}
