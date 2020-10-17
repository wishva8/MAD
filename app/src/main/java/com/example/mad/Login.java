package com.example.mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.se.omapi.Session;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    EditText username,password;
    ProgressBar pbar;

    DatabaseReference dbrefCus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void CheckLogin(View view){

        pbar=findViewById(R.id.progressBar);
        pbar.setVisibility(View.VISIBLE);

        username= findViewById(R.id.etUserName);
        password=findViewById(R.id.etPassword);


        try{
            if(TextUtils.isEmpty(username.getText().toString()))
                Toast.makeText(this, "Please enter the Username", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(password.getText().toString()))
                Toast.makeText(this, "Please enter the Password", Toast.LENGTH_SHORT).show();
            else {

                dbrefCus= FirebaseDatabase.getInstance().getReference().child("User").child("Customer");
                DatabaseReference dbrefAdmin= FirebaseDatabase.getInstance().getReference().child("User").child("Admin");
                DatabaseReference dbrefStockManager= FirebaseDatabase.getInstance().getReference().child("User").child("StockManager");
                final DatabaseReference readDManager=FirebaseDatabase.getInstance().getReference().child("User").child("deliveryManager");
                readDManager.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String pwd=null,un=null;
                        if(snapshot.hasChildren()){

                            pwd=snapshot.child("password").getValue().toString();
                            un=snapshot.child("username").getValue().toString();
                            if(pwd.equals(password.getText().toString()) && un.equals(username.getText().toString())){
                                Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                password.setText("");
                                username.setText("");
                                startActivity(intent);
                                pbar.setVisibility(View.INVISIBLE);
                            }
                        }

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                dbrefCus.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                       String pwd=null,un=null;
                       if (snapshot.hasChildren()){
                           pwd=snapshot.child("password").getValue().toString();
                           un=snapshot.child("username").getValue().toString();
                           if(pwd.equals(password.getText().toString()) && un.equals(username.getText().toString())){
                               Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                               Intent intent=new Intent(getApplicationContext(),customerHome.class);
                               password.setText("");
                               username.setText("");
                               startActivity(intent);
                               pbar.setVisibility(View.INVISIBLE);
                           }
                       }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                dbrefAdmin.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String pwd=null,un=null;
                        if (snapshot.hasChildren()){
                            pwd=snapshot.child("password").getValue().toString();
                            un=snapshot.child("username").getValue().toString();
                            if(pwd.equals(password.getText().toString()) && un.equals(username.getText().toString())){
                                Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),osh_MainActivity.class);
                                password.setText("");
                                username.setText("");
                                startActivity(intent);
                                pbar.setVisibility(View.INVISIBLE);
                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                dbrefStockManager.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String pwd=null,un=null;
                        if (snapshot.hasChildren()){
                            pwd=snapshot.child("password").getValue().toString();
                            un=snapshot.child("username").getValue().toString();
                            if(pwd.equals(password.getText().toString()) && un.equals(username.getText().toString())){
                                Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),stef_ProductMain.class);
                                password.setText("");
                                username.setText("");
                                startActivity(intent);
                                pbar.setVisibility(View.INVISIBLE);
                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(Login.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                });  }
        }catch (Exception e){
            e.getMessage();
        }



    }
    public void signUp(View view){
        Intent intent1= new Intent(this, SignUp.class);
        startActivity(intent1);
    }

}