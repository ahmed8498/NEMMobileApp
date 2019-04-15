package com.example.nemmobileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.ArrayList;

public class CarList extends AppCompatActivity {


    private ArrayList<Car> listOfCars;

    private RecyclerView rv;
    private EditText searchBar;
    private CarRecyclerAdapter carRecyclerAdapter;
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        db = new DBHandler(this,1);
        listOfCars = new ArrayList<>();


        listOfCars = db.getCarsArray();



        rv = (RecyclerView) findViewById(R.id.recycler_cars_list);
        carRecyclerAdapter = new CarRecyclerAdapter(getApplicationContext(), listOfCars);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(carRecyclerAdapter);

    }
}
