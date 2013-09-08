package com.mikedhock.boilermenu.data;

import java.util.Date;

public class Meal {

	public final String[] locations = {
			"earhart", "ford", "hillenbrand", "wiley", "windsor"
	};
	
	public final String[] times = {
			"breakfast", "lunch", "dinner"
	};
	
	// Date the meal is served.
	private Date date;
	
	// Title of the meal. For example: Hamburgers with cheese.
	// Location of the mean. Select from the locations array in this class.
	// Time of the meal. Again, select from the array.
	private String title, location, time;
	
	public Meal(String title, String location, String time, Date date) {
		this.title = title;
		this.location = location;
		this.time = time;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
