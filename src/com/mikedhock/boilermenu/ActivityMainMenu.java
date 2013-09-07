package com.mikedhock.boilermenu;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class ActivityMainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Get the fragment manager which will be used to commit fragment transactions to the main view.
        FragmentManager manager = getFragmentManager();
        
        // We'll make the default fragment by-location, so set that up.
        FragLocationList byLocationListFrag = new FragLocationList();
        manager.beginTransaction().replace(R.id.main_content_frame, byLocationListFrag).commit();        
        
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}
    
    
    
    

}
