package com.example.listviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class feedback extends AppCompatActivity {
    private EditText fname1,femail1,fdesciption1;
    private Button button;
    //public int i=0;

    DatabaseReference mbase;

    feedinfo feedinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

        Toolbar toolbar;
        toolbar=findViewById(R.id.toolbar);

        //step 1
        setSupportActionBar(toolbar);

        //step 2 enable back button
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setTitle("Search Result");

        }
        //toolbar.setTitle("My Toolbar");//low priority than default in manifest
        //toolbar.setSubtitle("sub title");

        fname1=findViewById(R.id.fname);
        femail1=findViewById(R.id.femail);
        fdesciption1=findViewById(R.id.fdescription);
        int i=1;


        mbase = FirebaseDatabase.getInstance().getReference().child("feedback");

        feedinfo=new feedinfo();
        /*String fname2=fname1.getText().toString().trim();
        String femail2=femail1.getText().toString().trim();
        String fdesciption2=fdesciption1.getText().toString().trim();

        feedinfo obj=new feedinfo(fname2,femail2,fdesciption2);*/

        button=findViewById(R.id.fbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting text from our edittext fields.
                String fname = fname1.getText().toString();
                String femail = femail1.getText().toString();
                String fdescription = fdesciption1.getText().toString();
                //i++;

                // below line is for checking weather the
                // edittext fields are empty or not.
                if (TextUtils.isEmpty(fname) && TextUtils.isEmpty(femail) && TextUtils.isEmpty(fdescription)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(feedback.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    addDatatoFirebase(fname, femail, fdescription);
                    
                }
            }
        });

    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();
        if (itemId==android.R.id.home){
            Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void addDatatoFirebase(String name, String phone, String address) {
        // below 3 lines of code is used to set
        // data in our object class.
        feedinfo.setFname(name);
        feedinfo.setFemail(phone);
        feedinfo.setFdescription(address);

        // we are use add value event listener method
        // which is called with database reference.
        mbase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                mbase.child(name).setValue(feedinfo);
                fname1.setText("");
                femail1.setText("");
                fdesciption1.setText("");

                // after adding this data we are showing toast message.
                Toast.makeText(feedback.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(feedback.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*public void process(View view){
        int i=1;
        fname1=findViewById(R.id.fname);
        femail1=findViewById(R.id.femail);
        fdesciption1=findViewById(R.id.fdescription);
        String fname2=fname1.getText().toString().trim();
        String femail2=femail1.getText().toString().trim();
        String fdesciption2=fdesciption1.getText().toString().trim();

        feedinfo obj=new feedinfo(fname2,femail2,fdesciption2);
        mbase = FirebaseDatabase.getInstance().getReference().child("feedback");
        mbase.child(String.valueOf(i)).setValue(obj);
        i++;
        fname1.setText("");
        femail1.setText("");
        fdesciption1.setText("");

    }*/
}