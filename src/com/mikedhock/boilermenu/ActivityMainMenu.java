package com.mikedhock.boilermenu;

import com.mikedhock.boilermenu.data.*;
import com.mikedhock.boilermenu.test.*;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ActivityMainMenu extends Activity {
	
	/** Fragment manager to handle all the fragment transactions. */
	FragmentManager manager;
	
	/** Information about which location/time the user has selected in the drop-down fragment. */
	static Meal.Location lSelected;
	static Meal.Time tSelected;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Get the fragment manager which will be used to commit fragment transactions to the main view.
        manager = getFragmentManager();
        
        // Set the default fragment state
        manager.beginTransaction().replace(R.id.main_checkpanel_expanded, new FragCheckPanelExpand()).commit();
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
