package com.mikedhock.boilermenu;

import com.mikedhock.boilermenu.data.Meal;
import com.mikedhock.boilermenu.widgets.*;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class FragTimeList extends Fragment implements OnItemClickListener {
	
	String[] times = {"Breakfast", "Lunch", "Dinner"};
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frag_meal_list, container, false);
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// Create the grid view which will house the location images
		final ListView list = (ListView) getActivity().findViewById(R.id.listview_meallist);
		
		LargeImageLabelAdapter adapter = new LargeImageLabelAdapter(getActivity(), 
				times,
				ActivityMainMenu.mealBitmaps);
		
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		switch (position) {
		case 0:
			ActivityMainMenu.timeSelected = Meal.Time.breakfast;
			break;
		case 1:
			ActivityMainMenu.timeSelected = Meal.Time.lunch;
			break;
		case 2:
			ActivityMainMenu.timeSelected = Meal.Time.dinner;
			break;
		}
		
		if (ActivityMainMenu.locationSelected == null) {
			FragmentManager m = getActivity().getFragmentManager();
			getActivity().getActionBar().setTitle(times[position]);
			m.beginTransaction().replace(R.id.main_content_frame, new FragLocationList()).commit();
		} else {
			// Launch the new fragment
		}
	}

}
