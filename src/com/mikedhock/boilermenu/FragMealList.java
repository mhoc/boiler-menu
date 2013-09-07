package com.mikedhock.boilermenu;

import com.mikedhock.boilermenu.widgets.*;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class FragMealList extends Fragment implements OnItemClickListener {
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frag_meal_list, container, false);
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// Create the grid view which will house the location images
		final ListView list = (ListView) getActivity().findViewById(R.id.listview_meallist);
		final RelativeLayout listItem = (RelativeLayout) getActivity().findViewById(R.id.meal_list_item_layout);
		
		MealListAdapter adapter = new MealListAdapter(getActivity(), 
				new String[]{"Breakfast", "Lunch", "Dinner"},
				ActivityMainMenu.mealBitmaps);
		
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

}
