package com.mikedhock.boilermenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LocationListAdapter extends BaseAdapter {

	private static int[] filenames = {
		R.drawable.earhart_outside,
		R.drawable.ford_outside,
		R.drawable.hillenbrand_outside,
		R.drawable.wiley_outside,
		R.drawable.windsor_outside
	};
	
	Context context;
	int parentWidth;
	String[] locationNames;
	
	public LocationListAdapter(Context context, int parentViewWidth) {
		this.context = context;
		this.parentWidth = parentViewWidth;
		locationNames = context.getResources().getStringArray(R.array.location_list_printable);
	}
	
	@Override
	public int getCount() {
		return locationNames.length;
	}

	@Override
	public Object getItem(int i) {
		return null;
	}

	@Override
	public long getItemId(int i) {
		return 0;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		RelativeLayout cell = (RelativeLayout) inflater.inflate(R.layout.location_list_item, parent, false);
		
		cell.setLayoutParams(new RelativeLayout.LayoutParams(this.parentWidth / 3, this.parentWidth / 3));
		
		ImageView iv = (ImageView) cell.findViewById(R.id.location_list_image);
		iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
		iv.setImageResource(filenames[pos]);
		
		TextView tv = (TextView) cell.findViewById(R.id.location_list_label);
		tv.setText(locationNames[pos]);
		
		return cell;
	}
	
	

}
