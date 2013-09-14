package com.mikedhock.boilermenu;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragCheckPanelExpand extends Fragment implements OnClickListener {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frag_check_panel_expanded, container, false);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Set up button 
		Button buRadioSubmit = (Button) getActivity().findViewById(R.id.radio_submit_button);
		buRadioSubmit.setOnClickListener(this);
	}

	public void onClick(View view) {
		switch (view.getId()) {
		
		case R.id.radio_submit_button:
			// We animate the movement of the fragment transaction which takes place
			FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
			transaction.setCustomAnimations(android.R.anim.fade_in, R.anim.frag_collapse_up);
			transaction.detach(this);
			transaction.replace(R.id.main_checkpanel_collapsed, new FragCheckPanelCollapse());
			transaction.commit();
			break;
		}
		
	}
	
	
	
	

}
