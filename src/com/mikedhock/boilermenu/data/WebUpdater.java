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

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/** Handles everything related to downloading new html source code, parsing it, and adding it to the database. 
 *  Create one of these classes, then call update() on it to run the whole thing on each page you want to update. 
 *  The class will construct the proper address and spawn a SourceDownloader AsyncTask which downloads the source.
 *  On completion, it will automatically call the parser method, and it will add it to the database when done parsing. 
 *  To access the data, simply query the database. */
public class WebUpdater {

	Context context;
	
	public WebUpdater(Context context) {
		this.context = context;
	}
	
	/** Primary method. Call this on each date/location pair you want to update */
	public void update(GregorianCalendar date, Meal.Location loc) {
		String address = constructWebAddress(date, loc);
		DownloadSource task = new DownloadSource(date, loc);
		task.execute(address);
	}
	
	/** Constructs a web address from the date/loc passed in to update() */
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
		
		address.append(date.get(GregorianCalendar.YEAR) + "/");
		address.append(date.get(GregorianCalendar.MONTH) + "/");
		address.append(date.get(GregorianCalendar.DAY_OF_MONTH) + "");
		
		return address.toString();
	}
	
	/** Uses Jsoup to parse the html source returned by the SourceDownloader Async task. 
	 *  Automatically adds the things it finds to the database. */
	private void parseSource(String html, GregorianCalendar date, Meal.Location loc) {
		
		// Create the Jsoup document and restaurant string which will be used later.
		Document doc = Jsoup.parse(html);
		String restaurant = null;
		
		// The html page stores each meal under the ID tag Breakfast, Lunch, or Dinner.
		Element breakfast = doc.getElementById("Breakfast");
		// The restaurant name and meal names are all list elements underneath Breakfast.
		for (Element e : breakfast.getElementsByTag("li")) {
			// The restaurant line contains a list-divider, so use that to differentiate it.
			if (e.toString().contains("list-divider")) {
				// Set the restaurant string to the restaurant.
				// It will remain this way until a new restaurant is found in the list.
				restaurant = e.text();
			} else if (e.toString().contains("<li>")) {
				// Otherwise, its a meal item, so create a new meal from all the information we have...
				Meal m = new Meal(date, Meal.Time.breakfast, loc, restaurant, e.text());
				// And add it to the database.
				addToDatabase(m);
			}
		}
		
		// Repeat the procedure for Lunch and Dinner. 
		Element lunch = doc.getElementById("Lunch");
		for (Element e : lunch.getElementsByTag("li")) {
			if (e.toString().contains("list-divider")) {
				Log.d("boilermenu.data.WebSource", "Restaurant: " + e.text());
				restaurant = e.text();
			} else if (e.toString().contains("<li>")) {
				Log.d("boilermenu.data.WebSource", "Menu Item: " + e.text());
				Meal m = new Meal(date, Meal.Time.breakfast, loc, restaurant, e.text());
				addToDatabase(m);
			}
		}
		
		Element dinner = doc.getElementById("Dinner");
		for (Element e : dinner.getElementsByTag("li")) {
			if (e.toString().contains("list-divider")) {
				Log.d("boilermenu.data.WebSource", "Restaurant: " + e.text());
				restaurant = e.text();
			} else if (e.toString().contains("<li>")) {
				Log.d("boilermenu.data.WebSource", "Menu Item: " + e.text());
				Meal m = new Meal(date, Meal.Time.breakfast, loc, restaurant, e.text());
				addToDatabase(m);
			}
		}
	}
	
	/** Adds meal m to the database */
	private void addToDatabase(Meal m) {
		DBHelper db = new DBHelper(context, null, null, 1);
		db.addMeal(m);
	}
	
	/** DownloadSource AsyncTask. Takes in a String url on execute. On
	 *  instantiation, takes in the date and location of the meals we're downloading.
	 *  The only reason I do this is so they can eventually be passed into 
	 *  parseSource() when its complete. They could be stored as member variables of this
	 *  whole class, but then we'd need to create a new WebUpdater for every single page we
	 *  want to update, which could be 10-15. So this way is less object-oriented in design,
	 *  but much easier to implement.  */
	private class DownloadSource extends AsyncTask<String, Void, String> {

		GregorianCalendar date;
		Meal.Location loc;
		
		/** Default constructor */
		public DownloadSource(GregorianCalendar date, Meal.Location loc) {
			this.date = date;
			this.loc = loc;
		}
		
		/** Downloads the web page and returns it as a String */
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

		/** When its done, execute the soruce parsing */
		protected void onPostExecute(String result) {
			parseSource(result, date, loc);
		}
		
	}
	
}


