package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class NewArrivals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_arrivals);
    }

    public void shoppingCart(View view){
        Intent intent3= new Intent(this, ShoppingCart.class);
        startActivity(intent3);
    }
}