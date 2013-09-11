package com.mikedhock.boilermenu;

import com.mikedhock.boilermenu.data.Meal;
import com.mikedhock.boilermenu.widgets.LargeImageLabelAdapter;

import android.app.Fragment;
import android.app.FragmentManager;
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
	
	String[] locations = {
			"Earhart", "Ford", "Hillenbrant", "Wiley", "Windsor"
	};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frag_location_list, container, false);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// Create the list view.
		final ListView list = (ListView) getActivity().findViewById(R.id.listview_locationlist);
		
		// Create the adapter which will fill the list view.
		LargeImageLabelAdapter adapter = new LargeImageLabelAdapter(getActivity(), 
				locations,
				ActivityMainMenu.locationBitmaps);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// Store the choice the user selected in ActivityMainMenu.
		switch (position) {
		case 0:
			ActivityMainMenu.locationSelected = Meal.Location.earhart;
			break;
		case 1:
			ActivityMainMenu.locationSelected = Meal.Location.ford;
			break;
		case 2:
			ActivityMainMenu.locationSelected = Meal.Location.hillenbrand;
			break;
		case 3:
			ActivityMainMenu.locationSelected = Meal.Location.wiley;
			break;
		case 4:
			ActivityMainMenu.locationSelected = Meal.Location.windsor;
			break;
		}
		
		// If the other static field in the activity is null, then launch the next step of the menu.
		if (ActivityMainMenu.timeSelected == null) {
			FragmentManager m = getActivity().getFragmentManager();
			getActivity().getActionBar().setTitle(locations[position]);
			m.beginTransaction().replace(R.id.main_content_frame, new FragTimeList()).commit();
		} else {
			// Else, launch the actual menu fragment.
		}
		
	}
	
	
	
}
