package com.mikedhock.boilermenu.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.GregorianCalendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class WebSource {

	Context context;
	public String address, webpage;
	
	public WebSource(Context context, GregorianCalendar date, Meal.Location loc) {
		this.context = context;
		
		address = constructWebAddress(date, loc);
		Log.d("boilermenu.test.WebSource", "Downloading: " + address);
		
		DownloadSource task = new DownloadSource();
		task.execute(address);
	}
	
	private String constructWebAddress(GregorianCalendar date, Meal.Location loc) {
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
		
		address.append(date.get(date.YEAR) + "/");
		address.append(date.get(date.MONTH) + "/");
		address.append(date.get(date.DAY_OF_MONTH) + "");
		
		return address.toString();
	}
	
	private void parseSource(String s) {
		Log.d("boilermenu.test.WebSource", "Download complete. Parsing now.");
		
		Document doc = Jsoup.parse(s);
		Element breakfast = doc.getElementById("Breakfast");
		for (Element e : breakfast.getElementsByTag("li")) {
			if (e.toString().contains("list-divider")) {
				Log.d("boilermenu.test.WebSource", "Restaurant: " + e.text());
				String rest = e.text();
				
				
			} else if (e.toString().contains("<li>")){
				Log.d("boilermenu.test.WebSource", "Menu Item: " + e.text());
			}
			
		}
		//
		
		
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


