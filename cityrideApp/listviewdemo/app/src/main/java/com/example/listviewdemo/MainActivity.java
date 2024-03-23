package com.example.listviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    String start,end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar;
        toolbar=findViewById(R.id.toolbar);

        //step 1
        setSupportActionBar(toolbar);

        //step 2 enable back button
        if(getSupportActionBar()!=null){
            //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setTitle("Home");

        }
        //toolbar.setTitle("My Toolbar");//low priority than default in manifest
        //toolbar.setSubtitle("sub title");



        Button button2;

        //final EditText startdes,enddes;
        final Spinner spinner=findViewById(R.id.spinnerstartdestination);
        final Spinner spinner2=findViewById(R.id.spinnerenddestination);

        ArrayAdapter<CharSequence>adapter= ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<CharSequence>adapter2=ArrayAdapter.createFromResource(this, R.array.languages2, android.R.layout.simple_spinner_item);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter2);

        //button=findViewById(R.id.button);
        //startdes=findViewById(R.id.edittextstartdes);
        //enddes=findViewById(R.id.edittextenddes);
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                startdes.setText(spinner.getSelectedItem().toString());
                enddes.setText(spinner2.getSelectedItem().toString());
            }
        });*/

        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start=spinner.getSelectedItem().toString();
                end=spinner2.getSelectedItem().toString();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("keystart",start);
                intent.putExtra("keyend",end);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();
        if(itemId==R.id.timetable){
            Intent intent=new Intent(MainActivity.this,timetable.class);
            startActivity(intent);
            Toast.makeText(this, "Available Timetable", Toast.LENGTH_SHORT).show();
        }
        else if(itemId==R.id.feedback){
            Intent intent=new Intent(MainActivity.this,feedback.class);
            startActivity(intent);
            Toast.makeText(this, "Give your feedback", Toast.LENGTH_SHORT).show();
        }
        else if(itemId==R.id.aboutus){
            Intent intent=new Intent(MainActivity.this,aboutus.class);
            startActivity(intent);
            Toast.makeText(this, "Developer information", Toast.LENGTH_SHORT).show();
        }
        else if (itemId==R.id.contactus){
            Intent intent=new Intent(MainActivity.this,contactus.class);
            startActivity(intent);
            Toast.makeText(this, "Contact information", Toast.LENGTH_SHORT).show();
        }
        /*else if (itemId==android.R.id.home){
            Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }*/
        return super.onOptionsItemSelected(item);
    }
}
