package com.mikedhock.boilermenu.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import android.content.Context;
import android.os.AsyncTask;

public class WebSource {

	Context context;
	String address;
	
	public WebSource(Context context, Date date, Meal.Location loc) {
		this.context = context;
		address = constructWebAddress(date, loc);
		DownloadSource task = new DownloadSource();
		task.execute(address);
	}
	
	private String constructWebAddress(Date date, Meal.Location loc) {
		StringBuilder address = new StringBuilder("");
		address.append("http://www.housing.purdue.edu/Menus/");
		
		switch (loc) {
		case earhart:
			address.append("ERHT/");
			break;
		case ford:
			address.append("FORD/");
			break;
		case hillenbrand:
			address.append("HILL/");
			break;
		case wiley:
			address.append("WILY/");
			break;
		case windsor:
			address.append("WIND/");
			break;
		}
		
		address.append(date.getYear() + "/");
		address.append(date.getMonth() + "/");
		address.append(date.getDay() + "");
		
		return address.toString();
	}
	
	private void parseSource(String s) {
		
		
		
		//addToDatabase(m);
	}
	
	private void addToDatabase(Meal m) {
		DBHelper db = new DBHelper(context, null, null, 1);
		db.addMeal(m);
	}
	
	private class DownloadSource extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... address) {
			URL url;
			InputStream is = null;
			BufferedReader br;
		
			StringBuilder result = new StringBuilder();
			String line;
		
			try {
				url = new URL(address[0]);
				is = url.openStream();
				br = new BufferedReader(new InputStreamReader(is));
				while ((line = br.readLine()) != null) {
					result.append(line);
				}	
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return result.toString();
		}

		@Override
		protected void onPostExecute(String result) {
			parseSource(result);
		}
		
	}
	
}


