package com.example.nemmobileapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Ahmed on 09/03/2018.
 */

public class DBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Services";

    public DBHandler(Context context, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

       String createQuery1 = "CREATE TABLE mUsers( " +
               " username text primary key, " +
               " firstName text not null, " +
               " lastName text not null, " +
               " walletAddress text not null, " +
               "email text not null " +
               ");";


       String createQuery2 = "CREATE TABLE Car ( " +
               "carID integer primary key autoincrement, " +
               "carBrand text not null, " +
               "carModel text not null, " +
               "pricePerDay real not null," +
               "isTaken integer not null, " +
               "username text," +
               "constraint fk_1 foreign key (username)  references mUsers(username)" +
               ")";

       String createQuery3 = "CREATE TABLE LeisureTour( " +
               "tourID integer  primary key autoincrement , \n" +
               "tourName text, \n" +
               "tourLocation integer not null, \n" +
               "tourTotalTickets integer not null,\n" +
               "ticketPrice real not null\n" +
               ")";
        db.execSQL(createQuery1);
        db.execSQL(createQuery2);
        db.execSQL(createQuery3);
        System.out.println("On create");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public void addUser(String username,String firstName,String lastName,String walledAddress,String email)
    {
       String query = "INSERT INTO mUsers values("+
       username + "," + firstName + ", " + lastName + ", " + walledAddress + ", " + email+ ");";
        Log.e("TEST", "addUser: in here");
       SQLiteDatabase db = getWritableDatabase();
       db.execSQL(query);



    }


//    public void addVideo(Video video)
//    {
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_URL,video.get_url().toString());
//        values.put(COLUMN_TITLE,video.get_title().toString());
//        SQLiteDatabase db = getWritableDatabase();
//        db.insertOrThrow(TABLE_VIDEOS, null, values);
//        System.out.println(video.get_url());
//        System.out.println(video.get_title());
//
//        db.close();
//    }


//    public void deleteVideo(String url)
//    {
//
//        SQLiteDatabase db = getWritableDatabase();
//        db.execSQL(" DELETE FROM " + TABLE_VIDEOS + " WHERE " + COLUMN_URL + " = \"" + url + "\";");
//        db.close();
//
//    }


//    public String databaseToString()
//    {
//        String dbString = "";
//        SQLiteDatabase db = getWritableDatabase();
//        String query = "SELECT * FROM " + TABLE_VIDEOS + " WHERE 1 ;";
//
//        Cursor c =  db.rawQuery(query,null);
//        c.moveToFirst();
//
//
//        while(!c.isAfterLast())
//        {
//
//            if(c.getString(c.getColumnIndex("_url")) != null)
//
//            {
//
//                dbString += c.getString(c.getColumnIndex("_url"));
//                dbString += "\n";
//            }
//
//            c.moveToNext();
//        }
//
//        System.out.println(dbString);
//        db.close();
//        return dbString;
//    }

//    public ArrayList<String> getTitlesArray()
//    {
//        ArrayList<String> titles = new ArrayList<String>();
//        SQLiteDatabase db = getWritableDatabase();
//        String query = "SELECT * FROM " + TABLE_VIDEOS + " WHERE 1 ;";
//        Cursor c =  db.rawQuery(query,null);
//        c.moveToFirst();
//
//        while(!c.isAfterLast())
//        {
//            if(c.getString(c.getColumnIndex("_title")) != null)
//
//            {
//                titles.add(c.getString(c.getColumnIndex("_title")));
//            }
//
//            c.moveToNext();
//        }
//        return titles;
//    }
//    public ArrayList<String> getUrlArray()
//    {
//        ArrayList<String> url = new ArrayList<String>();
//        SQLiteDatabase db = getWritableDatabase();
//        String query = "SELECT * FROM " + TABLE_VIDEOS + " WHERE 1 ;";
//        Cursor c =  db.rawQuery(query,null);
//        c.moveToFirst();
//
//        while(!c.isAfterLast())
//        {
//            if(c.getString(c.getColumnIndex("_url")) != null)
//
//            {
//                url.add(c.getString(c.getColumnIndex("_url")));
//            }
//
//            c.moveToNext();
//        }
//        return url;
//    }
}