package com.mikedhock.boilermenu.widgets;

import com.mikedhock.boilermenu.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LargeImageLabelAdapter extends BaseAdapter {

	Bitmap[] images;
	Context context;
	String[] labels;
	
	/** Default constructor. Provide context, the resourceID of the list item you want to inflate, 
	 *  a string array of labels for each picture, and a bitmap array of pictures. Make sure the string
	 *  array and the bitmap array are of the same length and its items are in the same order. */
	public LargeImageLabelAdapter(Context context, String[] labels, Bitmap[] bitmaps) {
		if (labels.length != bitmaps.length) {
			throw new RuntimeException("Array of labels and bitmaps are not the same length.");
		}
		
		this.context = context;
		this.labels = labels;
		this.images = bitmaps;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.large_image_label_adapter_item, parent, false);
		
		ImageView iv = (ImageView) row.findViewById(R.id.large_image_item_image);
		iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
		iv.setImageBitmap(images[position]);
		
		TextView tv = (TextView) row.findViewById(R.id.large_image_item_label);
		tv.setText(labels[position]);
		
		return row;
	}

	@Override
	public int getCount() {
		return labels.length;
	}

	@Override
	public Object getItem(int arg0) {
		return labels[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		return -1;
	}
	
	

}
