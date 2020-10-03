package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {

    EditText txtName,txtdrivinLNO,address,tel,experience,qualification;
    Button btnsave;
    DatabaseReference dbRef;
    Rider rider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        txtName=findViewById(R.id.etName);
        txtdrivinLNO=findViewById(R.id.etDrivingLNo);
        address =findViewById(R.id.etAddress);
        tel=findViewById(R.id.etTel);
        experience=findViewById(R.id.etExperience);
        qualification=findViewById(R.id.etQualification);
        btnsave=findViewById(R.id.btnsave);

        rider=new Rider();

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference();

                try {


                    if (TextUtils.isEmpty(txtName.getText().toString()))
                        Toast.makeText(MainActivity3.this, "Enter Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtdrivinLNO.getText().toString()))
                        Toast.makeText(MainActivity3.this, "Enter Driving License No", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(address.getText().toString()))
                        Toast.makeText(MainActivity3.this, "Enter Address", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(tel.getText().toString()))
                        Toast.makeText(MainActivity3.this, "Enter Telephone Number", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(experience.getText().toString()))
                        Toast.makeText(MainActivity3.this, "Enter Experience", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(qualification.getText().toString()))
                        Toast.makeText(MainActivity3.this, "Enter Qualification", Toast.LENGTH_SHORT).show();
                    else {

                        rider.setName(txtName.getText().toString().trim());
                        rider.setDrivinLNO(txtdrivinLNO.getText().toString().trim());
                        rider.setAddress(address.getText().toString().trim());
                        rider.setTel(tel.getText().toString().trim());
                        rider.setExperience(experience.getText().toString().trim());
                        rider.setQualification(qualification.getText().toString().trim());



                        dbRef.child("rider").child(txtdrivinLNO.getText().toString()).setValue(rider);

                        Toast.makeText(MainActivity3.this, "Successfully Inserted", Toast.LENGTH_SHORT).show();
                        ClearField();
                    }
                }
                catch (Exception e){

                    e.getMessage();
                }
            }
        } );


    }
    private void ClearField(){
        txtName.setText("");
        txtdrivinLNO.setText("");
        address.setText("");
        tel.setText("");
        experience.setText("");
        qualification.setText("");
    }

}