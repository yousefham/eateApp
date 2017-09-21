package com.app.eateapplication;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.eateapplication.Database.DB;
import com.app.eateapplication.model.Food;
import com.app.eateapplication.model.Order;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class food_details extends AppCompatActivity {
    TextView food_name, food_price, food_description;
    ImageView foodImage;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;
    String foodId = "";
    FirebaseDatabase database;
    DatabaseReference foods;
    Food currentfood ;
    DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        database = FirebaseDatabase.getInstance();
        foods = database.getReference("Foods");
        db = new DB(this);
        numberButton = (ElegantNumberButton)findViewById(R.id.number_button);
        btnCart = (FloatingActionButton)findViewById(R.id.btncart);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.addtocart(new Order(foodId,
                        currentfood.getName(),
                        numberButton.getNumber(),
                        currentfood.getPrice(),
                        currentfood.getDiscount()));

                Toast.makeText(food_details.this, "Add to Cart...", Toast.LENGTH_SHORT).show();

            }
        });


        food_name = (TextView)findViewById(R.id.foodname);
        food_description = (TextView)findViewById(R.id.food_description);
        food_price= (TextView)findViewById(R.id.food_price);
        foodImage = (ImageView)findViewById(R.id.image_fooddetails);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandeAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedAppbar);

        if(getIntent() !=null)
            foodId = getIntent().getStringExtra("FoodId");
        if(!foodId.isEmpty()){
            getDetailsFood(foodId);
        }

    }

    private void getDetailsFood(String foodId) {

        foods.child(foodId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                currentfood = dataSnapshot.getValue(Food.class);

                Picasso.with(getBaseContext()).load(currentfood.getImage()).into(foodImage);
                collapsingToolbarLayout.setTitle(currentfood.getName());

                food_price.setText(currentfood.getPrice());
                food_name.setText(currentfood.getName());
                food_description.setText(currentfood.getDescription());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
