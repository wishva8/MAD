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

public class osh_Updatepart1 extends AppCompatActivity {

   EditText txtName,txtNic,txtAddress,txtAge,txtCNo;
    Button udbtn,butShow;
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
        setContentView(R.layout.osh_activity_updatepart1);


        txtName=findViewById(R.id.txname);
        txtNic =findViewById(R.id.txtnicc);
        txtAddress =findViewById(R.id.Uaddress);
        txtAge =findViewById(R.id.uage);
        txtCNo =findViewById(R.id.ucNO);

        udbtn=findViewById(R.id.udtbtn);
        butShow=findViewById(R.id.butshoww);


        udbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference();
                dbRef.child("Oshan").child("dt1").child("name").setValue(txtName.getText().toString().trim());
                dbRef.child("Oshan").child("dt1").child("age").setValue(txtName.getText().toString().trim());
                dbRef.child("Oshan").child("dt1").child("cno").setValue(txtName.getText().toString().trim());
                dbRef.child("Oshan").child("dt1").child("eddress").setValue(txtName.getText().toString().trim());
                dbRef.child("Oshan").child("dt1").child("nic").setValue(txtName.getText().toString().trim());
                Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();

            }
        });

       /* udbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Oshan");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("dt1")) {
                            try {
                                DT.setName(txtName.getText().toString().trim());
                                DT.setNIC(txtNic.getText().toString().trim());
                                DT.setEddress(txtAddress.getText().toString().trim());
                                DT.setCNo(Integer.parseInt(txtCNo.getText().toString().trim()));

                                dbRef = FirebaseDatabase.getInstance().getReference().child("Oshan").child("dt1");
                                dbRef.setValue(DT);
                                clearControls();
                                Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();

                            } catch (NumberFormatException e) {
                                Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
                            }
                        } else
                            Toast.makeText(getApplicationContext(), "No Source to update", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
            }
        });*/

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


   /* public void  Updatepart(View view){
        Intent intent1 = new Intent(this, osh_display.class);
        startActivity(intent1);
    }*/
}