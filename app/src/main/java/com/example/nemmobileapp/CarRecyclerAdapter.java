package com.example.nemmobileapp;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CarRecyclerAdapter extends RecyclerView.Adapter<CarRecyclerAdapter.MyViewHolder> {


    private Context mContext;
    private List<Car> mData;

    public CarRecyclerAdapter(Context mContext, List<Car> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.cardview_item_car,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.carBrand.setText(mData.get(i).getBrand());
        // myViewHolder.carAgency.setText("Agency");
        myViewHolder.carPrice.setText("Price per day: " + String.valueOf(mData.get(i).getPricePerDay()));
        //myViewHolder.carImage.setImageResource(mData.get(i).getImage());

        Glide.with(mContext)
                .load(mData.get(i).getImageURL())
                .into(myViewHolder.carImage);

        final int id = (i+1);
        myViewHolder.carButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(mContext)
                        .setTitle("Confirm payment")
                        .setMessage("Are you sure you want to rent this car?")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                DBHandler db = new DBHandler(mContext,1);
                                db.reserveCar(id);
                                Toast.makeText(mContext,"Payment done",Toast.LENGTH_LONG).show();
                                ((Activity)mContext).finish();
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView carBrand;
        // TextView carAgency;
        TextView carPrice;
        ImageView carImage;
        Button carButton;

        public MyViewHolder(View itemView)
        {
            super(itemView);

            carBrand = (TextView) itemView.findViewById(R.id.car_brand);

            //carAgency = (TextView) itemView.findViewById(R.id.car_agency);

            carPrice = (TextView) itemView.findViewById(R.id.car_price);

            carImage = (ImageView) itemView.findViewById(R.id.car_image);

            carButton = (Button) itemView.findViewById(R.id.card_button);
        }
    }

    public void filterCars(ArrayList<Car> list)
    {
        this.mData = list;
        notifyDataSetChanged();
    }
}

