package com.mikedhock.boilermenu.test;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.mikedhock.boilermenu.data.DBHelper;
import com.mikedhock.boilermenu.data.Meal;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

public class DBTest extends Fragment {

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// Create the database from the DBHelper class. 
		DBHelper db = new DBHelper(getActivity(), null, null, 1);
		
		// Clear out the database.
		db.clear();
		
		// Add some test data.
		
		// Query the database for the meals we added.
		List<Meal> meals = db.getMeals(new GregorianCalendar(2013, 8, 9), Meal.Time.lunch, Meal.Location.earhart);
		
		// Print to the log
		for (Meal m : meals) {
			Log.d("boilermenu_dbtest", "Meal " + m.getTitle() + " | " + m.getDateStr() + " | " + m.getTimeStr() + " | " + m.getLocationStr());
		}
		
	}
	
}
