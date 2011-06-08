package edu.SimonCresnjovnjak.data3;



import edu.SimonCresnjovnjak.android.Zdravila;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
 
public class DBAdapterZdravila implements BaseColumns {
	public static final  String TAG="DBAdapterZdravila";

	public static final  String KOLICINA = "i_value";
	public static final  String NAZIV = "s_name";
	public static final  int POS__ID=0;
	public static final  int POS_NAZIV=1;
	public static final  int POS_KOLICINA=2;

	public static final  String TABLE="ZDRAVILO";



	private final Context context;

	private DatabaseHelper DBHelper;
	private SQLiteDatabase DBZdravila;

	public DBAdapterZdravila(Context ctx) 
	{
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}


	//---opens the database---
	public DBAdapterZdravila open() throws SQLException 
	{
		DBZdravila = DBHelper.getWritableDatabase();
		return this;
	}

	//---closes the database---    
	public void close() 
	{
		DBHelper.close();
	}

	//---insert a stevec
	public long insertZdravila(Zdravila stevec) 
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put(NAZIV, stevec.getName()); 
		initialValues.put(KOLICINA, stevec.GetKolicina()); 
		return DBZdravila.insert(TABLE, null, initialValues);
	}

	//---deletes a particular title---
	public boolean deleteZdravila(long rowId) 
	{
		return DBZdravila.delete(TABLE, _ID + "=" + rowId, null) > 0;
	}

	//---retrieves all the titles---
	public Cursor getAll() 
	{
		return DBZdravila.query(TABLE, new String[] {
				_ID,       //POS__ID=0;
				NAZIV,      //POS_NAME=1
				KOLICINA},    //POS_VALUE =2
				null, 
				null, 
				null, 
				null, 
				null);
	}
	
	//---retrieves a particular title---
	public Cursor getRezultat(long rowId) throws SQLException 
	{
		Cursor mCursor =
			DBZdravila.query(true, TABLE, new String[] {
					_ID, 
					NAZIV,
					KOLICINA}, 
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
	public boolean updateZdravila(Zdravila tmp) 
	{
		ContentValues args = new ContentValues();
		args.put(NAZIV, tmp.getName());
		args.put(KOLICINA, tmp.GetKolicina());
		return DBZdravila.update(TABLE, args, 
				_ID + "=" + tmp.getDbID(), null) > 0;
	}
	
}
