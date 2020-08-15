package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
}
    public void assignRider(View view){
        Intent intent1= new Intent(this, MainActivity2.class);
        startActivity(intent1);
}
public void addRider(View view){
        Intent intent2= new Intent(this, MainActivity3.class);
        startActivity(intent2);
}

}