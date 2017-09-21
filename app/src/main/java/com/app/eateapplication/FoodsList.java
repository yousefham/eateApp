package com.app.eateapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.app.eateapplication.Interface.ItemClickListener;
import com.app.eateapplication.ViewHolder.FoodViewHolder;
import com.app.eateapplication.model.Food;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class FoodsList extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference foodList;
    TextView title;
    String categoryId = "";
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Food, FoodViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods__list);

        database = FirebaseDatabase.getInstance();
        foodList = database.getReference("Foods");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_foods);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if (getIntent() != null) {
            categoryId = getIntent().getStringExtra("CategoryId");
            if (!categoryId.isEmpty() && categoryId != null) {
                loadfoodList(categoryId);
            }
        }

    }

    private void loadfoodList(String categoryId) {
        adapter = new FirebaseRecyclerAdapter<Food, FoodViewHolder>(Food.class,
                R.layout.foods_item,FoodViewHolder.class,
                foodList.orderByChild("MenuId").equalTo(categoryId)) {
            @Override
            protected void populateViewHolder(FoodViewHolder viewHolder, Food model, int position) {
viewHolder.food_tV.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.food_image);
                final Food local = model ;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean islongClick) {
                        Intent foodlistintent = new Intent(FoodsList.this,food_details.class);
                        foodlistintent.putExtra("FoodId",adapter.getRef(position).getKey());
                        startActivity(foodlistintent);

                    }
                });
            }
        };
        recyclerView.setAdapter(adapter);
    }
}
