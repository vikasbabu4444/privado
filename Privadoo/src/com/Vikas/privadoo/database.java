package com.Vikas.privadoo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper
{
	
	public static final String DATABASE_NAME = "notes.db";
	public static final String TABLE_NAME = "notes_table";
	public static final String COL2 = "title";
	public static final String COL3 = "desc";
	

	public database(Context context) {
		super(context, DATABASE_NAME, null, 2);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(  "CREATE TABLE notes_table ( title TEXT PRIMARY KEY NOT NULL , desc TEXT NOT NULL )"  );
		
	}

	@Override
	 public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
	}
	
	public boolean addData(String title,String desc)
	{
		SQLiteDatabase db =this.getWritableDatabase();
		ContentValues v = new ContentValues();
		v.put(COL2,title);
		v.put(COL3, desc);
		long result =db.insert("notes_table",null, v);
		db.close();
		if(result == -1)
			return false;
		else
		{
			return true;
			
		}
		
	}
	public Cursor getlistcontents(){
		
		SQLiteDatabase db =this.getReadableDatabase();
		Cursor data = db.rawQuery("SELECT TITLE FROM " + TABLE_NAME, null);
		return data;
		
	}
	
	public Cursor getnotes(String id)
	{
		SQLiteDatabase db =this.getReadableDatabase();
		Cursor data = db.rawQuery("SELECT TITLE,DESC FROM notes_table WHERE TITLE=?", new String[]{id});
		return data;
		
		
	}
	public boolean delete(String id)
	{
		String where="TITLE=?";
		SQLiteDatabase db =this.getWritableDatabase();
		long v = db.delete(TABLE_NAME, where, new String[]{id});
		if(v==-1)
		{
		return false;
		}
		else
		{
			return true;
		}
	}
	

}
