package com.mikedhock.boilermenu.data;

import java.text.SimpleDateFormat;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	// Database version
	private static final int DB_VERSION = 1;
	
	// Database name
	private static final String DB_NAME = "db_meals";
	
	// Table names
	private static final String TABLE_MEALS = "t_meals";
	
	// Column names
	private static final String MEALS_ID = "_id";
	private static final String MEALS_DATE = "meals_date";
	private static final String MEALS_LOC = "meals_loc";
	private static final String MEALS_TIME = "meals_time";
	private static final String MEALS_NAME = "meals_name";
	
	public DBHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String create_table_meals = "" +
				"CREATE TABLE " + TABLE_MEALS + "( " +
				MEALS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				MEALS_DATE + " TEXT, " +
				MEALS_LOC + " TEXT, " + 
				MEALS_TIME + " TEXT, " + 
				MEALS_NAME + " TEXT" + ");";
		db.execSQL(create_table_meals);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Destroy the old table and recreate it from scratch.
		// Import that data if we desire. Probably not necessary for this app.
	}
	
	public boolean addMeal(Meal m) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		
		values.put(MEALS_NAME, m.getTitle());
		values.put(MEALS_LOC, m.getLocation());
		values.put(MEALS_TIME, m.getTime());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		values.put(MEALS_DATE, sdf.format(m.getDate()));
		
		long rowid = db.insert(TABLE_MEALS, null, values);
		if (rowid >= 0) {
			return true;
		} else {
			return false;
		}
	}

}
