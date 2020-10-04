package com.example.mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class stef_MainActivity extends AppCompatActivity {

    EditText txtpid,txtname,txtprice,txtcolors,txtsizes;
    Button butpost,butsave;
    DatabaseReference dbRef;
    Product prd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stef_activity_main);

        txtpid = findViewById(R.id.pid);
        txtname = findViewById(R.id.name);
        txtprice = findViewById(R.id.price);
        txtsizes = findViewById(R.id.sizes);
        txtcolors = findViewById(R.id.colors);

        butpost=findViewById(R.id.post);
        butsave=findViewById(R.id.save);

        prd = new Product();

        butpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Product/prd");
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChildren()) {
                            txtpid.setText(dataSnapshot.child("pid").getValue().toString());
                            txtname.setText(dataSnapshot.child("name").getValue().toString());
                            txtprice.setText(dataSnapshot.child("price").getValue().toString());
                            txtsizes.setText(dataSnapshot.child("sizes").getValue().toString());
                            txtcolors.setText(dataSnapshot.child("colors").getValue().toString());
                        } else
                            Toast.makeText(getApplicationContext(), "No Sourse to display", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
            }
        });

        butsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Product");
                try {
                    if (TextUtils.isEmpty(txtpid.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty product ID", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty product name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtprice.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty product price", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtsizes.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty product sizes", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtcolors.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty product colors", Toast.LENGTH_SHORT).show();
                    else {
                        prd.setPid(txtpid.getText().toString().trim());
                        prd.setName(txtname.getText().toString().trim());
                        prd.setPrice(Integer.parseInt(txtprice.getText().toString().trim()));
                        prd.setSizes(txtsizes.getText().toString().trim());
                        prd.setSizes(txtcolors.getText().toString().trim());

                        dbRef.push().setValue(prd);
                        //dbRef.child("prd1").setValue(prd);

                        Toast.makeText(getApplicationContext(), "Data saved success", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid price", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    public void setButpost(View view) {
//        Intent intent1=new  Intent(this, product_display.class);
//        startActivity(intent1);
    }

    private void clearControls(){
        txtpid.setText("");
        txtname.setText("");
        txtprice.setText("");
        txtsizes.setText("");
        txtcolors.setText("");
    }
}