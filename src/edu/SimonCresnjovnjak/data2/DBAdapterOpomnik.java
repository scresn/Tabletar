package edu.SimonCresnjovnjak.data2;



import edu.SimonCresnjovnjak.android.Zdravila;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class DBAdapterOpomnik implements BaseColumns {
	public static final  String TAG="DBAdapterOpomnik";

	public static final  String IME_ZDRAVILA = "i_value";
	public static final  String CAS_OP = "s_name";
	public static final  int POS__ID=0;
	public static final  int POS_IME_ZDRAVILA=1;
	public static final  int POS_CAS_OP=2;

	public static final  String TABLE="OPOMNIK";



	private final Context context;

	private DatabaseHelper DBHelper;
	private SQLiteDatabase DBOpomnik;

	public DBAdapterOpomnik(Context ctx) 
	{
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}


	//---opens the database---
	public DBAdapterOpomnik open() throws SQLException 
	{
		DBOpomnik = DBHelper.getWritableDatabase();
		return this;
	}

	//---closes the database---    
	public void close() 
	{
		DBHelper.close();
	}

	//---insert a stevec
	public long insertOpomnik(Zdravila stevec) 
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put(IME_ZDRAVILA, stevec.getName()); 
		initialValues.put(CAS_OP, stevec.GetKolicina()); 
		return DBOpomnik.insert(TABLE, null, initialValues);
	}

	//---deletes a particular title---
	public boolean deleteOpomnik(long rowId) 
	{
		return DBOpomnik.delete(TABLE, _ID + "=" + rowId, null) > 0;
	}

	//---retrieves all the titles---
	public Cursor getAll() 
	{
		return DBOpomnik.query(TABLE, new String[] {
				_ID,       //POS__ID=0;
				IME_ZDRAVILA,      //POS_NAME=1
				CAS_OP},    //POS_VALUE =2
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
			DBOpomnik.query(true, TABLE, new String[] {
					_ID, 
					IME_ZDRAVILA,
					CAS_OP}, 
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
	public boolean updateOpomnik(Zdravila tmp) 
	{
		ContentValues args = new ContentValues();
		args.put(IME_ZDRAVILA, tmp.getName());
		args.put(CAS_OP, tmp.GetKolicina());
		return DBOpomnik.update(TABLE, args, 
				_ID + "=" + tmp.getDbID(), null) > 0;
	}
	
}
