package edu.SimonCresnjovnjak.data3;



import edu.SimonCresnjovnjak.android.Opomnik;
import edu.SimonCresnjovnjak.android.Zdravila;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.text.format.Time;

public class DBAdapterOpomniki implements BaseColumns {
	public static final  String TAG="DBAdapterOpomniki";

	public static final  String VALUE = "i_value";
	public static final  String NAME = "s_name";
	public static final  String TIME = "s_time";
	public static final  int POS__ID=0;
	public static final  int POS_NAME=1;
	public static final  int POS_VALUE=2;
	public static final  int POS_TIME=3;

	public static final  String TABLE="OPOMNIK";



	private final Context context;

	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;

	public DBAdapterOpomniki(Context ctx) 
	{
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}


	//---opens the database---
	public DBAdapterOpomniki open() throws SQLException 
	{
		db = DBHelper.getWritableDatabase();
		return this;
	}

	//---closes the database---    
	public void close() 
	{
		DBHelper.close();
	}

	//---insert a stevec
	public long insertOpomnik(Opomnik opomnik ) 
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put(NAME, opomnik.getZdravilo()); 
		initialValues.put(VALUE, opomnik.getInterval()); 
		initialValues.put(TIME, opomnik.getCas().format2445()); 
		return db.insert(TABLE, null, initialValues);
	}

	//---deletes a particular title---
	public boolean deleteOpomnik(long rowId) 
	{
		return db.delete(TABLE, _ID + "=" + rowId, null) > 0;
	}

	//---retrieves all the titles---
	public Cursor getAll() 
	{
		return db.query(TABLE, new String[] {
				_ID,       //POS__ID=0;
				NAME,      //POS_NAME=1
				VALUE,    //POS_VALUE =2
				TIME},
				null,
				null, 
				null, 
				null, 
				null);
	}

	//---retrieves a particular title---
	public Cursor getOpomnik(long rowId) throws SQLException 
	{
		Cursor mCursor =
			db.query(true, TABLE, new String[] {
					_ID, 
					NAME,
					VALUE,
					TIME}, 
					_ID + "=" + rowId, 
					null,
					null, 
					null, 
					null, 
					null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	//---update---
	public boolean updateOpomnik(Opomnik tmp) 
	{
		ContentValues args = new ContentValues();
		args.put(NAME, tmp.getZdravilo());
		args.put(VALUE, tmp.getInterval());
		args.put(TIME, tmp.getCas().toString());
		return db.update(TABLE, args, 
				_ID + "=" + tmp.getDbID(), null) > 0;
	}
	
}
