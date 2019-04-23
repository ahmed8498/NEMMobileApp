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
               "image text not null,"+
               "username text," +
               "constraint fk_1 foreign key (username)  references mUsers(username)" +
               ")";

       String createQuery3 = "CREATE TABLE LeisureTour( " +
               "tourID integer  primary key autoincrement , " +
               "tourName text, " +
               "tourLocation text not null, " +
               "tourTotalTickets integer not null," +
               "ticketPrice real not null," +
               "image text not null"+
        ")";
        db.execSQL(createQuery1);
        db.execSQL(createQuery2);
        db.execSQL(createQuery3);
        System.out.println("On create");


        String insertCar = "INSERT INTO Car(CarBrand,CarModel,PricePerDay,isTaken,image) VALUES ('Toyota','Corolla',500,0,'https://bit.ly/2HtGCK9')";
        db.execSQL(insertCar);
        insertCar = "INSERT INTO Car(CarBrand,CarModel,PricePerDay,isTaken,image) VALUES ('Mercedez','Bendz',500,0,'https://bit.ly/2TX6C6b')";
        db.execSQL(insertCar);
        insertCar = "INSERT INTO Car(CarBrand,CarModel,PricePerDay,isTaken,image) VALUES ('Toyota','FG Cruiser',800,0,'https://bit.ly/2TXqTcQ')";
        db.execSQL(insertCar);


        String insertTour = "INSERT INTO LeisureTour(tourName,tourLocation,tourTotalTickets,ticketPrice,image) VALUES ('Safari desert','Dubai',50,150,'https://bit.ly/2Dhk4Iy')";
        db.execSQL(insertTour);


         insertTour = "INSERT INTO LeisureTour(tourName,tourLocation,tourTotalTickets,ticketPrice,image) VALUES ('Bruno Mars Concert','Dubai',500,350,'https://bit.ly/2ZhoVTN')";
        db.execSQL(insertTour);

        insertTour = "INSERT INTO LeisureTour(tourName,tourLocation,tourTotalTickets,ticketPrice,image) VALUES ('Scuba diving','Ras Al Khaimah',100,25,'https://bit.ly/2CrnwAc')";
        db.execSQL(insertTour);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public void addUser(String username,String firstName,String lastName,String walledAddress,String email)
    {
       String query = "INSERT INTO mUsers values('" +
       username + "','" + firstName + "', '" + lastName + "', '" + walledAddress + "', '" + email+ "');";
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

    public ArrayList<Car> getCarsArray()
    {
        ArrayList<Car> cars= new ArrayList<Car>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + "Car" + " WHERE isTaken = 0 ;";
        Cursor c =  db.rawQuery(query,null);
        c.moveToFirst();

        while(!c.isAfterLast())
        {

           Car temp = new Car(c.getInt(0),c.getString(1),c.getString(2),c.getDouble(3),c.getInt(4),c.getString(5));


                cars.add(temp);


            c.moveToNext();
        }
        c.close();
        db.close();
        return cars;
    }

    public ArrayList<Tour> getToursArray()
    {
        ArrayList<Tour> tours= new ArrayList<Tour>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + "LeisureTour" +" where tourTotalTickets > 0"+ ";";
        Cursor c =  db.rawQuery(query,null);
        c.moveToFirst();

        while(!c.isAfterLast())
        {

            Tour temp = new Tour(c.getInt(0),c.getString(1),c.getString(2),c.getInt(3),c.getDouble(4),c.getString(5));


            tours.add(temp);


            c.moveToNext();
        }
        c.close();
        db.close();
        return tours;
    }


    public boolean validUser(String walletAddress)
    {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + "mUsers" + ";";
        Cursor c =  db.rawQuery(query,null);
        c.moveToFirst();
        boolean valid = false;

        while(!c.isAfterLast())
        {
            if(c.getString(3).equals(walletAddress))
                valid = true;

            c.moveToNext();
        }
c.close();
        db.close();
        return valid;
    }


    public void reserveCar(int mycarID)
    {
        SQLiteDatabase db = getWritableDatabase();
        String update = "UPDATE Car set isTaken = 1 where carID =  " + mycarID+ ";";
        db.execSQL(update);
        db.close();

    }

}