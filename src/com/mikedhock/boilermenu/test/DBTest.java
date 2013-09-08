package com.mikedhock.boilermenu.test;

import com.mikedhock.boilermenu.data.DBHelper;
import com.mikedhock.boilermenu.data.Meal;

import android.app.Fragment;
import android.os.Bundle;

public class DBTest extends Fragment {

	public void onActivityCreated(Bundle savedInstanceState) {
		DBHelper db = new DBHelper(getActivity(), null, null, 1);
		
		// Clear out the database.
		db.clear();
		
		// Add some test data.
		
	}
	
}
