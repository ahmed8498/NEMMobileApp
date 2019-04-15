package com.example.nemmobileapp;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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
        myViewHolder.carPrice.setText(String.valueOf(mData.get(i).getPricePerDay()));
        //myViewHolder.carImage.setImageResource(mData.get(i).getImage());

        Glide.with(mContext)
                .load(mData.get(i).getImageURL())
                .into(myViewHolder.carImage);

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

        public MyViewHolder(View itemView)
        {
            super(itemView);

            carBrand = (TextView) itemView.findViewById(R.id.car_brand);

            //carAgency = (TextView) itemView.findViewById(R.id.car_agency);

            carPrice = (TextView) itemView.findViewById(R.id.car_price);

            carImage = (ImageView) itemView.findViewById(R.id.car_image);
        }
    }

    public void filterCars(ArrayList<Car> list)
    {
        this.mData = list;
        notifyDataSetChanged();
    }
}

