package com.example.mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class osh_delete extends AppCompatActivity {
    EditText txtName,txtNic,txtAddress,txtAge,txtCNo;
    Button butDelete,butShow;
    DatabaseReference dbRef;
    details DT;

    private void clearControls() {
        txtName.setText("");
        txtNic.setText("");
        txtAddress.setText("");
        txtAge.setText("");
        txtCNo.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.osh_activity_delete);


        txtName=findViewById(R.id.delname);
        txtNic =findViewById(R.id.DNic);
        txtAddress =findViewById(R.id.deladdress);
        txtAge =findViewById(R.id.delage);
        txtCNo =findViewById(R.id.delcno);

        butDelete=findViewById(R.id.dltbutton);
        butShow=findViewById(R.id.butshoww);

        DT = new details();

        butDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Oshan").child("dt2");
               // updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                   // @Override
                    //public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                      //  if (dataSnapshot.hasChild("dt2")) {
                            dbRef = FirebaseDatabase.getInstance().getReference().child("Oshan").child("dt2");
                            dbRef.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(), "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                       // } else
                           // Toast.makeText(getApplicationContext(), "No source to delete", Toast.LENGTH_SHORT).show();
                    }

                   // @Override
                   // public void onCancelled(@NonNull DatabaseError databaseError) {

                   // }

                //});
                

            //}
        });

        butShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Oshan").child("dt2");
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChildren()) {
                            txtName.setText(dataSnapshot.child("name").getValue().toString());
                            txtNic.setText(dataSnapshot.child("nic").getValue().toString());
                            txtAddress.setText(dataSnapshot.child("eddress").getValue().toString());
                            txtAge.setText(dataSnapshot.child("age").getValue().toString());
                            txtCNo.setText(dataSnapshot.child("cno").getValue().toString());
                        } else
                            Toast.makeText(getApplicationContext(), "No Sourse to display", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
            }
        });


    }
}