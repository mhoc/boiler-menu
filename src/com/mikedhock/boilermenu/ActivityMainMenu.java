package com.mikedhock.boilermenu;

import com.mikedhock.boilermenu.data.Meal;
import com.mikedhock.boilermenu.test.*;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class ActivityMainMenu extends Activity {

	// Basically, which fragment is currently being displayed in the view. 
	// This way we can track it for switching fragments and for the back button.
	FragmentContext fragContext;
	enum FragmentContext {
		frag_location_list,
		frag_meal_list
	}
	
	// When the user makes choices in the menu structure, they will be stored here so 
	// they can be accessed later when populating the menu list. I don't like this way of 
	// doing it, but for now it will work.
	public static Meal.Location locationSelected = null;
	public static Meal.Time timeSelected = null;
	
	// Fragment manager to handle all the fragment transactions.
	FragmentManager manager;
	
	// The bitmaps for all the menu items are pre-generated in onCreate.
	// This way the app doesn't feel laggy when the user wants to switch views.
	public static Bitmap[] locationBitmaps;
	public static Bitmap[] mealBitmaps;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Get the fragment manager which will be used to commit fragment transactions to the main view.
        manager = getFragmentManager();
        
        // Pre-generate all the bitmaps that we want to use for the menus
        generateBitmaps();
        
        // We'll make the default fragment by-location, so set that up.
        FragLocationList byLocationListFrag = new FragLocationList();
        this.fragContext = FragmentContext.frag_location_list;
        manager.beginTransaction().replace(R.id.main_content_frame, byLocationListFrag).commit();
        
        // Testing framework. Its pretty official.
        // Comment out the test fragment you want to run, then comment the three lines above. 
        // manager.beginTransaction().replace(R.id.main_content_frame, new DBTest()).commit();
        // manager.beginTransaction().replace(R.id.main_content_frame, new WebSourceTest()).commit();
        
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu bar located at the top of the screen.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_main_switch_views:
			if (this.fragContext == FragmentContext.frag_location_list) {
				FragTimeList byMealListFrag = new FragTimeList();
				this.fragContext = FragmentContext.frag_meal_list;
				manager.beginTransaction().replace(R.id.main_content_frame, byMealListFrag).commit();
			} else if (this.fragContext == FragmentContext.frag_meal_list) {
				FragLocationList byLocationListFrag = new FragLocationList();
				this.fragContext = FragmentContext.frag_location_list;
				manager.beginTransaction().replace(R.id.main_content_frame, byLocationListFrag).commit();
			}
			break;
		}
		
		return true;
	}
	
	/** Generates all the bitmaps which will be used in the app. 
	 *  It is done here and stored as a static class variable in memory so that all the heavy lifting in
	 *  the app is done while it is launching. */
	private void generateBitmaps() {
		Resources r = getResources();
		
		locationBitmaps = new Bitmap[5];
		locationBitmaps[0] = BitmapFactory.decodeResource(r, R.drawable.loc_earhart_outside);
		locationBitmaps[1] = BitmapFactory.decodeResource(r, R.drawable.loc_ford_outside);
		locationBitmaps[2] = BitmapFactory.decodeResource(r, R.drawable.loc_hillenbrand_outside);
		locationBitmaps[3] = BitmapFactory.decodeResource(r, R.drawable.loc_wiley_outside);
		locationBitmaps[4] = BitmapFactory.decodeResource(r, R.drawable.loc_windsor_outside);
		
		mealBitmaps = new Bitmap[3];
		mealBitmaps[0] = BitmapFactory.decodeResource(r, R.drawable.meal_breakfast);
		mealBitmaps[1] = BitmapFactory.decodeResource(r, R.drawable.meal_lunch);
		mealBitmaps[2] = BitmapFactory.decodeResource(r, R.drawable.meal_dinner);
	}
    
    
    
    

}
