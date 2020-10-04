package com.example.mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class stef_UpdateProduct extends AppCompatActivity {

    EditText txtpid,txtname,txtprice,txtcolors,txtsizes;
    Button bupdate,bdelete;
    DatabaseReference dbRef;
    Product prd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stef_activity_update_product);

        txtpid = findViewById(R.id.pid);
        txtname = findViewById(R.id.name);
        txtprice = findViewById(R.id.price);
        txtsizes = findViewById(R.id.sizes);
        txtcolors = findViewById(R.id.colors);

        bupdate=findViewById(R.id.update);
        bdelete=findViewById(R.id.delete);

        prd = new Product();

        bupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Student");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("prd1")) {
                            try {
                                prd.setPid(txtpid.getText().toString().trim());
                                prd.setName(txtname.getText().toString().trim());
                                prd.setSizes(txtsizes.getText().toString().trim());
                                prd.setPrice(Integer.parseInt(txtprice.getText().toString().trim()));
                                prd.setColors(txtcolors.getText().toString().trim());

                                dbRef = FirebaseDatabase.getInstance().getReference().child("Student").child("std1");
                                dbRef.setValue(prd);
                                //clearControls();
                                Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();

                            } catch (NumberFormatException e) {
                                Toast.makeText(getApplicationContext(), "Invalid price type", Toast.LENGTH_SHORT).show();
                            }
                        } else
                            Toast.makeText(getApplicationContext(), "No Source to update", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
            }
        });


        bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Student");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("prd1")) {
                            dbRef = FirebaseDatabase.getInstance().getReference().child("Product").child("prd1");
                            dbRef.removeValue();
                           // clearControl();
                            Toast.makeText(getApplicationContext(), "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(getApplicationContext(), "No source to delete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
            }
        });



    }

    public void updateproduct(View view) {
        Intent intent1=new Intent(this, stef_ProductMain.class);
        startActivity(intent1);
    }

    /*public void delete(View view) {
        Intent intent1=new Intent(this,ProductMain.class);
        startActivity(intent1);
    }*/
}