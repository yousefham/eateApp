package com.app.eateapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.app.eateapplication.ViewHolder.CartAdapter;
import com.app.eateapplication.model.Order;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import info.hoang8f.widget.FButton;

public class Cart extends AppCompatActivity {

    RecyclerView CartRecycler ;
    RecyclerView.LayoutManager layoutManager ;

    FirebaseDatabase database ;
    DatabaseReference request ;

    TextView totalprice ;
    FButton btnPlace ;

    List<Order> orderlist = new ArrayList<>();
    CartAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        database = FirebaseDatabase.getInstance();
        request = database.getReference("Request");

        CartRecycler = (RecyclerView)findViewById(R.id.recycler_cart);
        CartRecycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        CartRecycler.setLayoutManager(layoutManager);


        totalprice = (TextView)findViewById(R.id.total);
        btnPlace = (FButton)findViewById(R.id.btncart);

//        loadlist();


    }

//    private void loadlist() {
//
//        orderlist = new DB(this).getorder();
//        adapter = new CartAdapter(orderlist,this);
//        CartRecycler.setAdapter(adapter);
//
//        int total = 0 ;
//        for(Order order:orderlist){
//            total+=(Integer.parseInt(order.getPrice()))*(Integer.parseInt(order.getQuantity()));
//            Locale locale = new Locale("en", "US");
//            NumberFormat number = NumberFormat.getCurrencyInstance(locale);
//            totalprice.setText(number.format(total));
//        }
//    }
}
