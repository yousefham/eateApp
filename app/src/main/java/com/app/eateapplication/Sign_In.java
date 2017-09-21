package com.app.eateapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.eateapplication.commen.Common;
import com.app.eateapplication.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Sign_In extends AppCompatActivity {
    MaterialEditText phone, password;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //Init Firebase
        final FirebaseDatabase firebase = FirebaseDatabase.getInstance();
        final DatabaseReference database = firebase.getReference("User");
        final ProgressDialog prpgress = new ProgressDialog(Sign_In.this);
        prpgress.setMessage("Please Waiting....");
        prpgress.show();

        phone = (MaterialEditText) findViewById(R.id.editsignin);
        password = (MaterialEditText) findViewById(R.id.editsigninPass);
        btnSignIn = (Button) findViewById(R.id.btnsignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prpgress.dismiss();
                database.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(phone.getText().toString()).exists()) {
                            prpgress.dismiss();
                            User user = dataSnapshot.child(phone.getText().toString()).getValue(User.class);
                            user.setPhone(phone.getText().toString());
                            if (user.getPassword().equals(password.getText().toString())) {
                                Intent intent = new Intent(Sign_In.this,home.class);
                                Common.currentuser = user;
                                startActivity(intent);
                                finish();
                            } else {
                                prpgress.dismiss();
                                Toast.makeText(Sign_In.this, "Failed", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });

    }
}
