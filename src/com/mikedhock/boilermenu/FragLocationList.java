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
		
		// Create the grid view which will house the location images
		final ListView list = (ListView) getActivity().findViewById(R.id.listview_locationlist);
		final RelativeLayout listItem = (RelativeLayout) getActivity().findViewById(R.id.location_list_item_layout);
		
		LocationListAdapter adapter = new LocationListAdapter(getActivity(), 
				getActivity().getResources().getStringArray(R.array.location_list_printable));
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		
	}
	
	
	
}
