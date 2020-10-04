package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class customerHome extends AppCompatActivity{

    private ImageView LogoutIcon;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        LogoutIcon = (ImageView) findViewById(R.id.signOut);

        LogoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(customerHome.this,SignUp.class);
                startActivity(intent);
            }
        });

        }

    public void shoppingCart(View view){
        Intent intent1= new Intent(this, ShoppingCart.class);
        startActivity(intent1);
    }

    public void newArrivalButton(View view){
        Intent intent2= new Intent(this, NewArrivals.class);
        startActivity(intent2);
    }
    public void userProfile(View view){
        Intent intent3= new Intent(this, CustomerDetails.class);
        startActivity(intent3);
    }

}