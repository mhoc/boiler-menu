package com.mikedhock.boilermenu;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class FragCheckPanelCollapse extends Fragment implements OnClickListener {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.frag_check_panel_collapsed, container, false);
		v.setOnClickListener(this);
		return v;
	}

	public void onClick(View arg0) {
		FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
		transaction.setCustomAnimations(R.anim.frag_slide_down, android.R.animator.fade_out);
		transaction.detach(this);
		transaction.replace(R.id.main_checkpanel_expanded, new FragCheckPanelExpand());
		transaction.commit();
	}
	
	

}
