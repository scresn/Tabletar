package edu.SimonCresnjovnjak.data3;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public  class DatabaseHelper extends SQLiteOpenHelper 
{	

	public static final  String TAG="DatabaseHelper";
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME1 = "ZDRAVILA";
	private static final String DATABASE_NAME2 = "OPOMNIKI";
	private static final String DATABASE_CREATE1 =
		"create table "+DBAdapterZdravila.TABLE+" ("+DBAdapterZdravila._ID+" integer primary key autoincrement, "
		+ DBAdapterZdravila.NAZIV+" TEXT not null, "+DBAdapterZdravila.KOLICINA+" INTEGER );";
	
	private static final String DATABASE_CREATE2 =
		"create table "+DBAdapterOpomniki.TABLE+" ("+DBAdapterOpomniki._ID+" integer primary key autoincrement, "
		+ DBAdapterOpomniki.NAME+" TEXT not null, "+DBAdapterOpomniki.VALUE+" INTEGER, " + DBAdapterOpomniki.TIME+" TEXT not null);";

	DatabaseHelper(Context context) 
	{
		super(context, DATABASE_NAME1, null, DATABASE_VERSION);
		
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		try {
		db.execSQL(DATABASE_CREATE1);
		db.execSQL("DROP TABLE IF EXISTS "+DBAdapterOpomniki.TABLE);
		db.execSQL(DATABASE_CREATE2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, 
			int newVersion) 
	{
		Log.w(TAG, "Upgrading database from version " + oldVersion 
				+ " to "
				+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS "+DBAdapterZdravila.TABLE);
		//db.execSQL("DROP TABLE IF EXISTS "+DBAdapterZdravila.TABLE);
		onCreate(db);
		/*
		Log.w(TAG, "Upgrading database from version " + oldVersion 
				+ " to "
				+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS "+DBAdapterOpomniki.TABLE);
		//db.execSQL("DROP TABLE IF EXISTS "+DBAdapterZdravila.TABLE);
		onCreate(db);
		*/
	}
}
