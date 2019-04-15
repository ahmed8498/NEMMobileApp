package com.example.nemmobileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ServicesList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_list);
        Service carRental = new Service(R.drawable.carcard,"Rent a car","This will allow you to rent a car from car agencies");
        Service leisure = new Service(R.drawable.leisurecard,"Book leisure tours","This will allow you to book leisure tours ");
        List<Service> mlist = new ArrayList<>();


        mlist.add(carRental);
        mlist.add(leisure);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this,mlist);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        

    }

}

