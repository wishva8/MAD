package com.example.mad;


import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CustomerDetails extends AppCompatActivity {
    DatabaseReference dbRef;
    TextView CustomerDetails;
    Button deleteAllDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);


        CustomerDetails=findViewById(R.id.cusDetailsTextView);

        CustomerDetails.setMovementMethod(new ScrollingMovementMethod());

        dbRef= FirebaseDatabase.getInstance().getReference().child("Customers");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                CustomerDetails.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void shoppingCart(View view){
        Intent intent1= new Intent(this, ShoppingCart.class);
        startActivity(intent1);
    }
    public void DeleteAll(View view){

        deleteAllDetails=findViewById(R.id.DeleteButton);
        DatabaseReference dbref= FirebaseDatabase.getInstance().getReference().child("Customers");
        dbref.removeValue();
        CustomerDetails.setText("");
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
        Toast.makeText(this, "Deleted!", Toast.LENGTH_SHORT).show();
    }
}