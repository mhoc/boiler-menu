package com.mikedhock.boilermenu.test;

import java.util.GregorianCalendar;
import java.util.List;

import com.mikedhock.boilermenu.data.DBHelper;
import com.mikedhock.boilermenu.data.Meal;
import com.mikedhock.boilermenu.data.WebSource;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

public class WebSourceTest extends Fragment {
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// Clear out the database
		DBHelper db = new DBHelper(getActivity(), null, null, 1);
		db.recreate();
		
		// Run the websource sub-routine.
		// Note: Because of how the downloader is set up, it is basically best that the rest of this
		// test code is located inside the WebSource object. That way it is guaranteed to be called after
		// the download is finished. We could implement a callback and stuff out here, but I don't think
		// its worth it just for a small testing function.
		WebSource ws = new WebSource(getActivity(), new GregorianCalendar(2013,9,9), Meal.Location.earhart);
		
		// If you want to test if WebSource works, copy the following code into the bottom of
		// void parseSource(String s) inside WebSource.java.
		
		/* 	// Testing code
			DBHelper db = new DBHelper(context, null, null, 1);
			List<Meal> meals = db.getMeals(new GregorianCalendar(2013,9,9), Meal.Time.breakfast, Meal.Location.earhart);
			for (Meal m : meals) {
				Log.d("boilermenu.test.WebSourceTest", m.toString());
			}
		  	// End test code */
	}
	
}
