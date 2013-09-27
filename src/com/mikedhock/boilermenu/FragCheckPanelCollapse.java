package com.mikedhock.boilermenu;

import com.mikedhock.boilermenu.data.Meal;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragCheckPanelCollapse extends Fragment implements OnClickListener {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Create the view and on-click listener for this fragment.
		View v = inflater.inflate(R.layout.frag_check_panel_collapsed, container, false);
		v.setOnClickListener(this);
		return v;
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// Get information about which places the user has selected and create a textview for it.
		TextView tv = (TextView) getActivity().findViewById(R.id.checkpanel_collapsed_summary_tv);
		tv.setText(Meal.convertTime(ActivityMainMenu.tSelected) + " at " + Meal.convertLoc(ActivityMainMenu.lSelected) + ", Today");
	}



	public void onClick(View arg0) {
		FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
		transaction.setCustomAnimations(R.anim.frag_slide_down, android.R.animator.fade_out);
		transaction.detach(this);
		transaction.replace(R.id.main_checkpanel_expanded, new FragCheckPanelExpand());
		transaction.commit();
	}

}
