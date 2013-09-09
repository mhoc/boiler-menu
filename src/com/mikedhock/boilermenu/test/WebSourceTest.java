package com.mikedhock.boilermenu.test;

import java.util.GregorianCalendar;

import com.mikedhock.boilermenu.data.Meal;
import com.mikedhock.boilermenu.data.WebSource;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

public class WebSourceTest extends Fragment {
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		WebSource ws = new WebSource(getActivity(), new GregorianCalendar(2013,9,9), Meal.Location.earhart);
		
	}

	
	
	
}
