package com.app.eateapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button signUp, signIn;
    TextView txtcenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtcenter = (TextView) findViewById(R.id.TvcenterParent);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/Occupied.ttf");
        txtcenter.setTypeface(type);
        signUp = (Button) findViewById(R.id.btnsign);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });
        signIn = (Button) findViewById(R.id.btnsignin);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sign_In.class);
                startActivity(intent);

            }
        });
    }
}
