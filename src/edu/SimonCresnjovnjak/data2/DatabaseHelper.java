package edu.SimonCresnjovnjak.data2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public  class DatabaseHelper extends SQLiteOpenHelper 
{	

	public static final  String TAG="DatabaseHelper";
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "Mojabaza";
	private static final String DATABASE_CREATE =
		"create table "+DBAdapterOpomnik.TABLE+" ("+DBAdapterOpomnik._ID+" integer primary key autoincrement, "
		+ DBAdapterOpomnik.IME_ZDRAVILA+" TEXT not null, "+DBAdapterOpomnik.CAS_OP+" INTEGER );";

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
		db.execSQL("DROP TABLE IF EXISTS "+DBAdapterOpomnik.TABLE);
		onCreate(db);
	}
}
