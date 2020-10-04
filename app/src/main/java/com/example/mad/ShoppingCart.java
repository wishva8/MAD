package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShoppingCart extends AppCompatActivity {

    TextView price,name,size,color,quantity,id;
    Button placeOrderButton;
    DatabaseReference dbRef;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        name = findViewById(R.id.itemName);
        id = findViewById(R.id.CodeNum);
        price = findViewById(R.id.priceRs);
        color = findViewById(R.id.colortype);
        size = findViewById(R.id.sizeType);
        quantity = findViewById(R.id.QtyNumber);
        placeOrderButton = findViewById(R.id.placeOrderBtn);

        order = new Order();

        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference();

                try {
                    if (TextUtils.isEmpty(name.getText().toString()))
                        Toast.makeText(ShoppingCart.this,"Enter Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(id.getText().toString()))
                        Toast.makeText(ShoppingCart.this,"Enter Id", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(price.getText().toString()))
                        Toast.makeText(ShoppingCart.this,"Enter Price", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(color.getText().toString()))
                        Toast.makeText(ShoppingCart.this,"Enter Color", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(size.getText().toString()))
                        Toast.makeText(ShoppingCart.this,"Enter Size", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(quantity.getText().toString()))
                        Toast.makeText(ShoppingCart.this,"Enter Quantity",Toast.LENGTH_SHORT).show();
                    else {
                        order.setItemName(name.getText().toString());
                        order.setItemCode(id.getText().toString());
                        order.setClothSize(size.getText().toString());
                        order.setItemPrice(price.getText().toString());
                        order.setItemColor(color.getText().toString());
                        order.setItemQty(quantity.getText().toString());


                        dbRef.child("Order").child(id.getText().toString()).setValue(order);

                        Toast.makeText(ShoppingCart.this,"Successfully Inserted", Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });
    }

    private void ClearField(){
        name.setText("");
        id.setText("");
        price.setText("");
        size.setText("");
        color.setText("");
        quantity.setText("");
    }

    public void editItems(View view){
        Intent intent1= new Intent(this, UpdateShoppingCart.class);
        startActivity(intent1);
    }



}