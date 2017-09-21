package com.app.eateapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.eateapplication.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUp extends AppCompatActivity {
    MaterialEditText phone, password, name;
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        phone = (MaterialEditText) findViewById(R.id.editsignUp);
        password = (MaterialEditText) findViewById(R.id.editsignUpPass);
        name = (MaterialEditText) findViewById(R.id.editsignUPName);
        btnSignup = (Button) findViewById(R.id.btnsignUp);

        //Init Firebase
        final FirebaseDatabase firebase = FirebaseDatabase.getInstance();
        final DatabaseReference database = firebase.getReference("User");

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog prpgress = new ProgressDialog(SignUp.this);
                prpgress.setMessage("Please Waiting....");
                prpgress.show();
                database.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(phone.getText().toString()).exists()) {
                            prpgress.dismiss();
                            Toast.makeText(SignUp.this, "phone already exists", Toast.LENGTH_SHORT).show();
                        } else {
                            prpgress.dismiss();
                            User user = new User(name.getText().toString(), password.getText().toString());
                            database.child(phone.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this, "Done", Toast.LENGTH_SHORT).show();
                            finish();
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
