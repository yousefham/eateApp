package com.app.eateapplication.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.app.eateapplication.Interface.ItemClickListener;
import com.app.eateapplication.R;
import com.app.eateapplication.model.Order;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by best tech on 9/11/2017.
 */


public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    private List<Order> orderList = new ArrayList<>();
    private Context context;

    public CartAdapter(List<Order> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemview = inflater.inflate(R.layout.cart_layout, parent, false);
        return new CartViewHolder(itemview);

    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        TextDrawable drawable = TextDrawable.builder()
                .buildRound("" + orderList.get(position).getQuantity(), Color.RED);
        holder.cart_count.setImageDrawable(drawable);

        Locale locale = new Locale("en", "US");
        NumberFormat number = NumberFormat.getCurrencyInstance(locale);
        int price = (Integer.parseInt(orderList.get(position).getPrice())) * (Integer.parseInt(orderList.get(position).getQuantity()));
        holder.cart_price.setText(number.format(price));
        holder.cart_name.setText(orderList.get(position).getProducrName());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}


class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView cart_name, cart_price;
    public ImageView cart_count;

    private ItemClickListener itemClickListener;

    public CartViewHolder(View itemView) {
        super(itemView);
        cart_name = (TextView) itemView.findViewById(R.id.cart_name);
        cart_price = (TextView) itemView.findViewById(R.id.cart_price);
        cart_count = (ImageView) itemView.findViewById(R.id.cart_count);
    }

    @Override
    public void onClick(View view) {

    }
}
