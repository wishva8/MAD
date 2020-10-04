package com.example.mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity4 extends AppCompatActivity {

    DatabaseReference dbRef;
    TextView details;
    Button deleteAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        details=findViewById(R.id.txtview);


        details.setMovementMethod(new ScrollingMovementMethod());
        dbRef= FirebaseDatabase.getInstance().getReference().child("rider");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()){

                    details.setText(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void DeleteAll(View view){

        deleteAll=findViewById(R.id.deleteAllBtn);
        DatabaseReference dbref= FirebaseDatabase.getInstance().getReference().child("rider");
        dbref.removeValue();
        details.setText("");
        Toast.makeText(this, "All Rider Details Deleted", Toast.LENGTH_SHORT).show();

    }
    public void editRider(View view){
        Intent intent2= new Intent(this, MainActivity5.class);
        startActivity(intent2);

    }
}