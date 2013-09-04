package com.mikedhock.boilermenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FragLocationList extends Fragment implements OnItemClickListener {

	int gridviewWidth = 720, gridviewHeight = 1280;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frag_location_list, container, false);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// Create the grid view which will house the location images
		final GridView grid = (GridView) getActivity().findViewById(R.id.gridview_locationlist);
		final RelativeLayout gridItem = (RelativeLayout) getActivity().findViewById(R.id.location_list_item_layout);
		
		// Get the width of the gridview so we can adjust the size of the pictures. 
		// This is different than the screen width bc we might want to expand to a tablet layout later.
		grid.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			public void onGlobalLayout() {
				gridviewWidth = grid.getWidth();
				gridviewHeight = grid.getHeight();
				
				grid.setColumnWidth(gridviewWidth / 3);
				LocationListAdapter adapter = new LocationListAdapter(getActivity(), gridviewWidth);
				grid.setAdapter(adapter);
				
				grid.getViewTreeObserver().removeGlobalOnLayoutListener(this);
			}
		});
		
		grid.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		
	}
	
	
	
	

	
	
}
