package com.example.nemmobileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.ArrayList;

public class TourList extends AppCompatActivity {

    private ArrayList<Tour> listofTours;

    private RecyclerView rv;
    private TourRecyclerAdapter tourRecyclerAdapter;
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_list);

        db = new DBHandler(this,1);
        listofTours = new ArrayList<>();


        listofTours = db.getToursArray();



        rv = (RecyclerView) findViewById(R.id.recycler_tours_list);
        tourRecyclerAdapter = new TourRecyclerAdapter(this, listofTours);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(tourRecyclerAdapter);

    }
}
