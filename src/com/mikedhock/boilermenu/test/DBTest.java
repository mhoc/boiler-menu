package com.mikedhock.boilermenu.test;

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
				
		DBHelper db = new DBHelper(getActivity(), null, null, 1);
		
		// Destroy the database and recreate it from scratch.
		db.recreate();
		
		// Add some test data.
		GregorianCalendar c = new GregorianCalendar(2013, 9, 9);
		db.addMeal(new Meal(c, Meal.Time.breakfast, Meal.Location.earhart, "Granite Grill", "Potatoes"));
		db.addMeal(new Meal(c, Meal.Time.breakfast, Meal.Location.earhart, "Granite Grill", "Stew"));
		db.addMeal(new Meal(c, Meal.Time.breakfast, Meal.Location.earhart, "Granite Grill", "Hamburgers"));
		db.addMeal(new Meal(c, Meal.Time.breakfast, Meal.Location.earhart, "Granite Grill", "Potatoes"));
		
		// Query the database for the meals we added.
		List<Meal> meals = db.getMeals(c, Meal.Time.breakfast, Meal.Location.earhart);
		
		// Print to the log
		for (Meal m : meals) {
			Log.d("boilermenu.test.DBHelper", m.toString());
		}
		
	}
	
}
