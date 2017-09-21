package com.app.eateapplication.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.eateapplication.Interface.ItemClickListener;
import com.app.eateapplication.R;

/**
 * Created by best tech on 9/7/2017.
 */

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView food_tV;
    public ImageView food_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public FoodViewHolder(View itemView) {
        super(itemView);
        food_tV = (TextView) itemView.findViewById(R.id.food_tv);
        food_image = (ImageView) itemView.findViewById(R.id.food_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);

    }
}
