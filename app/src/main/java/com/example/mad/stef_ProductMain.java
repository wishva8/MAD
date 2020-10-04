package com.example.mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class stef_ProductMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stef_activity_product_main);


       DatabaseReference readRef=FirebaseDatabase.getInstance().getReference().child("Product").child("prd1");
       readRef.addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               if(dataSnapshot.hasChildren()){

               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });


        }
    public void AddProduct(View view) {

        Intent intent1=new Intent(this, stef_MainActivity.class);
        startActivity(intent1);
    }

    public void delete(View view) {

        Intent intent1=new Intent(this, stef_UpdateProduct.class);
        startActivity(intent1);
    }

    public void updateproduct(View view) {

        Intent intent1=new Intent(this, stef_UpdateProduct.class);
        startActivity(intent1);
    }
}