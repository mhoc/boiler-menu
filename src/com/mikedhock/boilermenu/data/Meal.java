package com.mikedhock.boilermenu.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Meal {

	/** ===== ENUMS ===== **/
	
	// Locations the meal could be served at.
	public enum Location {
			earhart,
			ford,
			hillenbrand,
			wiley,
			windsor
	};
	
	// Times the meal is served at.
	public enum Time {
			breakfast,
			lunch,
			dinner
	};
	
	/** ===== OBJECT FIELDS ===== **/
	
	// Title of the meal as given by the website.
	private String title;
	
	// Location and time the meal is served.
	private Location loc;
	private Time time;
	
	// The small "sub-resturant" the meal is served at.
	// Just copy straight from the website. 
	private String restaurant; 
	
	// Date the meal was served on.
	private GregorianCalendar date;
	
	/** ===== STATIC METHODS ===== **/
	
	/** Converts a location enum to an appropriate string. */
	public static String convertLoc(Location loc) {
		switch (loc) {
		case earhart:
			return "Earhart";
		case ford:
			return "Ford";
		case hillenbrand:
			return "Hillenbrand";
		case wiley:
			return "Wiley";
		case windsor:
			return "Windsor";
		default:
			return null;
		}
	}
	
	/** Converts a time enum to an appropriate string. */
	public static String convertTime(Time time) {
		switch(time) {
		case breakfast:
			return "Breakfast";
		case lunch:
			return "Lunch";
		case dinner:
			return "Dinner";
		default:
			return null;
		}
	}
	
	/** Converts a Date object to an appropriate string.
	 *  This is done here so it is standardized across the whole app. */
	public static String convertDate(GregorianCalendar date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		return sdf.format(date);
	}
	
	/** ===== OBJECT METHODS ===== **/
	
	/** @param date: A GregorianCalendar object of the date. Like new GregorianCalendar(2013,12,31);.
	 * 	@param time: Enum taken from Meal.Time. Either breakfast, lunch, or dinner.
	 * 	@param location: Enum taken from Meal.Locations. Earhart, Ford, etc.
	 * 	@param restaurant: The name of the "sub-restuarnat" in the food court. Like Granite Grill, etc.
	 * 	@param title: The title of the meal. "Hamburgers", etc. */
	public Meal(GregorianCalendar date, Time time, Location location, String restaurant, String title) {
		this.title = title;
		this.loc = location;
		this.time = time;
		this.date = date;
		this.restaurant = restaurant;
	}

	public GregorianCalendar getDateDate() {
		return date;
	}
	
	public String getDateStr() {
		return convertDate(this.date);
	}
	
	public Time getTimeEnum() {
		return time;
	}
	
	public String getTimeStr() {
		return convertTime(time);
	}
	
	public Location getLocationEnum() {
		return loc;
	}
	
	public String getLocationStr() {
		return convertLoc(loc);
	}
	
	public String getRestaurantStr() {
		return this.restaurant;
	}
	
	public String getTitle() {
		return title;
	}
	
}
