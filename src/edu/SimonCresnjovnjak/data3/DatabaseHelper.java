package edu.SimonCresnjovnjak.data3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public  class DatabaseHelper extends SQLiteOpenHelper 
{	

	public static final  String TAG="DatabaseHelper1";
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "ZDRAVILA";
	private static final String DATABASE_CREATE =
		"create table "+DBAdapterZdravila.TABLE+" ("+DBAdapterZdravila._ID+" integer primary key autoincrement, "
		+ DBAdapterZdravila.NAZIV+" TEXT not null, "+DBAdapterZdravila.KOLICINA+" INTEGER );";

	DatabaseHelper(Context context) 
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, 
			int newVersion) 
	{
		Log.w(TAG, "Upgrading database from version " + oldVersion 
				+ " to "
				+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS "+DBAdapterZdravila.TABLE);
		onCreate(db);
	}
}