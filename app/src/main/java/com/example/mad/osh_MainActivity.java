package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class osh_MainActivity extends AppCompatActivity {
    EditText txtName,txtNic,txtAddress,txtAge,txtCNo;
    Button butAdd,butUpdate,butDelete;
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
        setContentView(R.layout.osh_activity_main);


        txtName=findViewById(R.id.TName);
        txtNic =findViewById(R.id.NIC);
        txtAddress =findViewById(R.id.Address);
        txtAge =findViewById(R.id.Age);
        txtCNo =findViewById(R.id.CNO);

        butAdd=findViewById(R.id.BAdd);
        butUpdate=findViewById(R.id.BUpdate);
        butDelete=findViewById(R.id.BDelete);

        DT = new details();

        butAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Oshan");
                try {
                    if (TextUtils.isEmpty(txtName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter  name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtNic .getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter NIC", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtAddress.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter an address", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtAge.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter an age", Toast.LENGTH_SHORT).show();
                    else {
                        DT.setName(txtName.getText().toString().trim());
                        DT.setNIC(txtNic.getText().toString().trim());
                        DT.setEddress(txtAddress.getText().toString().trim());
                        DT.setAge(txtAge.getText().toString().trim());
                        DT.setCNo(Integer.parseInt(txtCNo.getText().toString().trim()));

                       // dbRef.push().setValue(DT);
                       dbRef.child("dt2").setValue(DT);
                           // dbRef.setValue(DT);
                        Toast.makeText(getApplicationContext(), "Data saved success", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }



    public void  Update(View view){
        Intent intent1 = new Intent(this, osh_Updatepart1.class);
        startActivity(intent1);
    }

    public void  Delete(View view){
        Intent intent1 = new Intent(this, osh_delete.class);
        startActivity(intent1);
    }

}