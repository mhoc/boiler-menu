package com.mikedhock.boilermenu.widgets;

import com.mikedhock.boilermenu.R;
import com.mikedhock.boilermenu.R.drawable;
import com.mikedhock.boilermenu.R.id;
import com.mikedhock.boilermenu.R.layout;

import android.content.Context;
import android.graphics.Bitmap;
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
	
	Context context;
	String[] locationNames = null;
	Bitmap[] bitmaps = null;
	
	public LocationListAdapter(Context context, String[] locationNames, Bitmap[] bitmaps) {
		super(context, R.id.location_list_item_layout, locationNames);
		this.locationNames = locationNames;
		this.bitmaps = bitmaps;
		this.context = context;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.location_list_item, parent, false);
		
		ImageView iv = (ImageView) row.findViewById(R.id.location_list_item_image);
		iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
		iv.setImageBitmap(bitmaps[pos]);
		
		TextView tv = (TextView) row.findViewById(R.id.location_list_item_label);
		tv.setText(locationNames[pos]);
		
		return row;
	}
	
	

}
