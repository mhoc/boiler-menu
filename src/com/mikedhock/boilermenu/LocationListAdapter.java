package com.mikedhock.boilermenu;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LocationListAdapter extends ArrayAdapter {

	private static int[] filenames = {
		R.drawable.earhart_outside,
		R.drawable.ford_outside,
		R.drawable.hillenbrand_outside,
		R.drawable.wiley_outside,
		R.drawable.windsor_outside
	};
	
	Context context;
	int parentWidth;
	String[] locationNames = null;
	
	public LocationListAdapter(Context context, String[] locationNames) {
		super(context, R.id.location_list_item_layout, locationNames);
		this.locationNames = locationNames;
		this.context = context;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.location_list_item, parent, false);
		
		ImageView iv = (ImageView) row.findViewById(R.id.location_list_item_image);
		iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
		iv.setImageResource(filenames[pos]);
		
		TextView tv = (TextView) row.findViewById(R.id.location_list_item_label);
		tv.setText(locationNames[pos]);
		
		return row;
	}
	
	

}
