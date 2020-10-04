package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class UpdateShoppingCart extends AppCompatActivity {

  private Spinner SizeSpinner;
  private TextView SizeTextView;
  private Spinner colorSpinner;
  private TextView colorTextView;
  private Spinner qtySpinner;
  private TextView qtyTextView;

  private Button saveBtn;
  //private EditText ArrivalName;
  private TextView size,color,qty;
  private Spinner spSize,spColor,spQty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_shopping_cart);

        SizeSpinner = findViewById(R.id.SizeSpinner);
        SizeTextView = findViewById(R.id.SizeTextView);

        //ArrivalName = (EditText)findViewById(R.id.)
        size = (TextView)findViewById(R.id.SizeTextView);
        color = (TextView)findViewById(R.id.colorTextView);
        qty = (TextView)findViewById(R.id.qtyTextView);
        spSize = (Spinner)findViewById(R.id.SizeSpinner);
        spColor = (Spinner)findViewById(R.id.colorSpinner);
        spQty = (Spinner)findViewById(R.id.qtySpinner);
        saveBtn = (Button)findViewById(R.id.SaveButton);

        List<String> size = new ArrayList<>();
        //size.add("Size : ");
        size.add("M");
        size.add("L");
        size.add("Xl");
        size.add("XXL");

        ArrayAdapter<String> sizeList = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, size);
        sizeList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SizeSpinner.setAdapter(sizeList);

        SizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String yourSize = SizeSpinner.getSelectedItem().toString();
                if(!yourSize.equals("Choose your size : ")){
                    SizeTextView.setText("Size : "+yourSize);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        colorSpinner = findViewById(R.id.colorSpinner);
        colorTextView = findViewById(R.id.colorTextView);

        List<String> color = new ArrayList<>();
        //color.add("color : ");
        color.add("Yellow");
        color.add("Blue");
        color.add("White");
        color.add("Black");

        ArrayAdapter<String> colorList = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, color);
        colorList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(colorList);

        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String yourColor = colorSpinner.getSelectedItem().toString();
                if(!yourColor.equals("Choose your color : ")){
                    colorTextView.setText("Color : "+yourColor);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        qtySpinner = findViewById(R.id.qtySpinner);
        qtyTextView = findViewById(R.id.qtyTextView);

        List<Integer> qty = new ArrayList<>();
        qty.add(1);
        qty.add(2);
        qty.add(3);
        qty.add(4);
        qty.add(5);

        ArrayAdapter<Integer> qtyList = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,qty);
        qtyList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qtySpinner.setAdapter(qtyList);

        qtySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Integer yourqty = (Integer) qtySpinner.getSelectedItem();
                if(!yourqty.equals("Choose your Qty : ")){
                    qtyTextView.setText("Qty : "+yourqty);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void Save(View view){
        Intent intent1= new Intent(this, ShoppingCart.class);
        startActivity(intent1);
    }

}

