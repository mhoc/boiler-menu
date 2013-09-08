package com.mikedhock.boilermenu.data;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	// Date the meal was served on.
	private Date date;
	
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
	public static String convertDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		return sdf.format(date);
	}
	
	/** ===== OBJECT METHODS ===== **/
	
	/** Constructor */
	public Meal(String title, Location location, Time time, Date date) {
		this.title = title;
		this.loc = location;
		this.time = time;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}
	
	public Location getLocationEnum() {
		return loc;
	}
	
	public String getLocationStr() {
		return convertLoc(loc);
	}
	
	public Time getTimeEnum() {
		return time;
	}
	
	public String getTimeStr() {
		return convertTime(time);
	}
	
	public Date getDateDate() {
		return date;
	}
	
	public String getDateStr() {
		return convertDate(this.date);
	}
}
