package com.mikedhock.boilermenu;

import java.util.GregorianCalendar;

import com.mikedhock.boilermenu.data.*;
import com.mikedhock.boilermenu.test.*;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ActivityMainMenu extends Activity {
	
	/** Fragment manager to handle all the fragment transactions. */
	FragmentManager manager;
	
	/** Fragment objects to track what is currently being displayed on the screen. */
	static Fragment checkboxF, resultsF;
	
	/** Information about which location/time the user has selected in the drop-down fragment. */
	static GregorianCalendar dSelected;
	static Meal.Location lSelected;
	static Meal.Time tSelected;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Get the fragment manager which will be used to commit fragment transactions to the main view.
        manager = getFragmentManager();
        
        // Create fragments to display on the UI.
        checkboxF = new FragCheckPanelExpand();
        resultsF = new FragResultsList();
        
        // Set the default fragment state
        manager.beginTransaction().replace(R.id.main_checkpanel_expanded, checkboxF).commit();
        manager.beginTransaction().replace(R.id.main_results, resultsF).commit();
        
        // Set a default date for now
        dSelected = new GregorianCalendar();
        dSelected.setTimeInMillis(System.currentTimeMillis());
    }

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu bar located at the top of the screen.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		
		return true;
	}

	
	
	
}
