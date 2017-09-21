package com.app.eateapplication.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.eateapplication.Interface.ItemClickListener;
import com.app.eateapplication.R;

/**
 * Created by best tech on 9/6/2017.
 */

public class MenuviewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
    public TextView menu_tV;
    public ImageView menu_image;

    private ItemClickListener itemClickListener;

    public MenuviewHolder(View itemView) {
        super(itemView);

        menu_tV = (TextView) itemView.findViewById(R.id.menu_tv);
        menu_image = (ImageView) itemView.findViewById(R.id.menu_image);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);

    }


}
