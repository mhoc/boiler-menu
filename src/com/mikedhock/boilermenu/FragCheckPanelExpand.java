package com.mikedhock.boilermenu;

import com.mikedhock.boilermenu.data.DBHelper;
import com.mikedhock.boilermenu.data.Meal;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RadioGroup;

public class FragCheckPanelExpand extends Fragment implements OnClickListener {

	DBHelper db;
	RadioGroup locations, times;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frag_check_panel_expanded, container, false);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Set up button 
		Button buRadioSubmit = (Button) getActivity().findViewById(R.id.radio_submit_button);
		buRadioSubmit.setOnClickListener(this);
		
		// Set up radios
		locations = (RadioGroup) getActivity().findViewById(R.id.radio_location_group);
		times = (RadioGroup) getActivity().findViewById(R.id.radio_time_group);
		
		// Set up database for future use.
		db = new DBHelper(getActivity(), null, null, -1);
	}

	public void onClick(View view) {
		switch (view.getId()) {
		
		case R.id.radio_submit_button:
			// Get the radio selections the user has made.
			switch (locations.getCheckedRadioButtonId()) {
			case R.id.radio_location_earhart:
				ActivityMainMenu.lSelected = Meal.Location.earhart;
				break;
			case R.id.radio_location_ford:
				ActivityMainMenu.lSelected = Meal.Location.ford;
				break;
			case R.id.radio_location_hillenbrand:
				ActivityMainMenu.lSelected = Meal.Location.hillenbrand;
				break;
			case R.id.radio_location_wiley:
				ActivityMainMenu.lSelected = Meal.Location.wiley;
				break;
			case R.id.radio_location_windsor:
				ActivityMainMenu.lSelected = Meal.Location.windsor;
				break;
			default:
				return;
			}
			switch (times.getCheckedRadioButtonId()) {
			case R.id.radio_time_breakfast:
				ActivityMainMenu.tSelected = Meal.Time.breakfast;
				break;
			case R.id.radio_time_lunch:
				ActivityMainMenu.tSelected = Meal.Time.lunch;
				break;
			case R.id.radio_time_dinner:
				ActivityMainMenu.tSelected = Meal.Time.dinner;
				break;
			default:
				return;
			}
			
			// Load the data the user requests from the database.
			db.getMeals(ActivityMainMenu.dSelected, ActivityMainMenu.tSelected, ActivityMainMenu.lSelected);
			
			
			// Create a fragment transaction which will collapse the check panel.
			FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
			// It will be animated. One is a simple fade_in animation, the other is a slide up animation defined in res/anim
			transaction.setCustomAnimations(android.R.animator.fade_in, R.anim.frag_slide_up);
			// Detach the current fragment from the UI. Pretty much necessary.
			transaction.detach(this);
			// Replace the collapsed check panel with a new fragment.
			ActivityMainMenu.checkboxF = new FragCheckPanelCollapse();
			transaction.replace(R.id.main_checkpanel_collapsed, ActivityMainMenu.checkboxF);
			// Commit the transaction.
			transaction.commit();
			
			
			break;
		}
		
	}
	
	
	
	

}
