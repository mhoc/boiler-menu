package com.mikedhock.boilermenu;

import com.mikedhock.boilermenu.data.Meal;
import com.mikedhock.boilermenu.test.*;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ActivityMainMenu extends Activity {

	/** Fragments the Activity is managing */
	FragCheckPanelExpand fragExpanded;
	
	/** Fragment manager to handle all the fragment transactions. */
	FragmentManager manager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Get the fragment manager which will be used to commit fragment transactions to the main view.
        manager = getFragmentManager();
        
        // Set the default fragment state
        fragExpanded = new FragCheckPanelExpand();
        manager.beginTransaction().replace(R.id.main_checkpanel_expanded, fragExpanded).commit();
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
