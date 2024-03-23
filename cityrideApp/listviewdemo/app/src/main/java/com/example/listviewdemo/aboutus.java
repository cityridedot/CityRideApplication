package com.example.listviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
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
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();
        if (itemId==android.R.id.home){
            Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}