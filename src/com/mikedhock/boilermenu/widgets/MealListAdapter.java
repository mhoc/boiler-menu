package com.mikedhock.boilermenu.widgets;

import com.mikedhock.boilermenu.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MealListAdapter extends ArrayAdapter {
	
	Context context;
	String[] mealNames;
	Bitmap[] bitmaps;
	
	public MealListAdapter(Context context, String[] mealNames, Bitmap[] bitmaps) {
		super(context, R.id.meal_list_item_layout, mealNames);
		this.mealNames = mealNames;
		this.bitmaps = bitmaps;
		this.context = context;
	}
	
	public View getView(int pos, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.meal_list_item, parent, false);
		
		ImageView iv = (ImageView) row.findViewById(R.id.meal_list_item_image);
		iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
		iv.setImageBitmap(bitmaps[pos]);
		
		TextView tv = (TextView) row.findViewById(R.id.meal_list_item_label);
		tv.setText(mealNames[pos]);
		
		return row;
	}
	
	

}
