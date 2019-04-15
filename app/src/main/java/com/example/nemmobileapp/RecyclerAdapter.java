package com.example.nemmobileapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context mContext;
    List<Service> mData;

    public RecyclerAdapter(Context mContext, List<Service> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.single_card_item,viewGroup,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.background.setImageResource(mData.get(i).getImage());
        myViewHolder.title.setText(mData.get(i).getTitle());
        myViewHolder.description.setText(mData.get(i).getDescription());

        if(mData.get(i).getTitle().equals("Rent a car"))
        {
            myViewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext.getApplicationContext(), CarList.class));
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView background;
        TextView title,description;
        Button button;


        public MyViewHolder(View itemView)
        {
            super(itemView);
            background = itemView.findViewById(R.id.card_image);
            title = itemView.findViewById(R.id.card_title);
            description = itemView.findViewById(R.id.card_description);
            button = itemView.findViewById(R.id.card_button);

        }

    }
}
