package com.example.nemmobileapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class TourRecyclerAdapter extends RecyclerView.Adapter<TourRecyclerAdapter.MyViewHolder>{


    private Context mContext;
    private List<Tour> mData;

    public TourRecyclerAdapter(Context mContext, List<Tour> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public TourRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.cardview_item_tour,viewGroup,false);
        return new TourRecyclerAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourRecyclerAdapter.MyViewHolder myViewHolder, int i) {

        myViewHolder.tourTitle.setText(mData.get(i).getTourName());
        // myViewHolder.carAgency.setText("Agency");
        myViewHolder.tourPrice.setText("Ticket price: " + String.valueOf(mData.get(i).getTicketPrice()));
        //myViewHolder.carImage.setImageResource(mData.get(i).getImage());

        Glide.with(mContext)
                .load(mData.get(i).getImage())
                .into(myViewHolder.tourImage);

        myViewHolder.tourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(mContext)
                        .setTitle("Confirm payment")
                        .setMessage("Are you sure you want to book a ticket in this tour?")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mContext,"Ticket booked",Toast.LENGTH_LONG).show();
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

        TextView tourTitle;
        TextView tourPrice;
        ImageView tourImage;
        Button tourButton;

        public MyViewHolder(View itemView)
        {
            super(itemView);

            tourTitle = (TextView) itemView.findViewById(R.id.tour_title);

            //carAgency = (TextView) itemView.findViewById(R.id.car_agency);

            tourPrice = (TextView) itemView.findViewById(R.id.tour_price);

            tourImage= (ImageView) itemView.findViewById(R.id.tour_image);

            tourButton = (Button) itemView.findViewById(R.id.tour_button);
        }
    }
}
