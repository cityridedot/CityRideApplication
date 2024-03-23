package com.example.listviewdemo;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class onclick extends AppCompatActivity {
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10,textView11,textView12,textView13,textView14,textView15,textView16,textView17,textView18,textView19,textView20,textView21,textView22,textView23,textView24,textView25;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onclick);

        Toolbar toolbar;
        toolbar=findViewById(R.id.toolbar);

        //step 1
        setSupportActionBar(toolbar);

        //step 2 enable back button
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Route Details");

        }
        //toolbar.setTitle("My Toolbar");//low priority than default in manifest
        //toolbar.setSubtitle("sub title");

        String bus = getIntent().getStringExtra("busid");
        String source = getIntent().getStringExtra("source");
        String stop1 = getIntent().getStringExtra("stop1");
        String stop2 = getIntent().getStringExtra("stop2");
        String stop3 = getIntent().getStringExtra("stop3");
        String stop4 = getIntent().getStringExtra("stop4");
        String stop5 = getIntent().getStringExtra("stop5");
        String stop6 = getIntent().getStringExtra("stop6");
        String stop7 = getIntent().getStringExtra("stop7");
        String stop8 = getIntent().getStringExtra("stop8");
        String stop9 = getIntent().getStringExtra("stop9");
        String stop10 = getIntent().getStringExtra("stop10");
        String des = getIntent().getStringExtra("des");

        String times = getIntent().getStringExtra("times");
        String time1 = getIntent().getStringExtra("time1");
        String time2 = getIntent().getStringExtra("time2");
        String time3 = getIntent().getStringExtra("time3");
        String time4 = getIntent().getStringExtra("time4");
        String time5 = getIntent().getStringExtra("time5");
        String time6 = getIntent().getStringExtra("time6");
        String time7 = getIntent().getStringExtra("time7");
        String time8 = getIntent().getStringExtra("time8");
        String time9 = getIntent().getStringExtra("time9");
        String time10 = getIntent().getStringExtra("time10");
        String timed = getIntent().getStringExtra("timed");
//        String times = getIntent().getStringExtra("stop4");


        textView1 = findViewById(R.id.textViewbusid);
        textView2 = findViewById(R.id.textViewsource);
        textView3 = findViewById(R.id.textViewstop1);
        textView4 = findViewById(R.id.textViewstop2);
        textView5 = findViewById(R.id.textViewstop3);
        textView6 = findViewById(R.id.textViewstop4);
        textView7 = findViewById(R.id.textViewstop5);
        textView8 = findViewById(R.id.textViewstop6);
        textView9 = findViewById(R.id.textViewstop7);
        textView10 = findViewById(R.id.textViewstop8);
        textView11 = findViewById(R.id.textViewstop9);
        textView12 = findViewById(R.id.textViewstop10);
        textView13 = findViewById(R.id.textViewdestination);
        textView14 = findViewById(R.id.textViewtimes);
        textView15 = findViewById(R.id.textViewtime1);
        textView16 = findViewById(R.id.textViewtime2);
        textView17 = findViewById(R.id.textViewtime3);
        textView18 = findViewById(R.id.textViewtime4);
        textView19 = findViewById(R.id.textViewtime5);
        textView20 = findViewById(R.id.textViewtime6);
        textView21 = findViewById(R.id.textViewtime7);
        textView22 = findViewById(R.id.textViewtime8);
        textView23 = findViewById(R.id.textViewtime9);
        textView24 = findViewById(R.id.textViewtime10);
        textView25 = findViewById(R.id.textViewtimed);



        textView1.setText(bus);
        textView2.setText(source);
        textView3.setText(stop1);
        textView4.setText(stop2);
        textView5.setText(stop3);
        textView6.setText(stop4);
        textView7.setText(stop5);
        textView8.setText(stop6);
        textView9.setText(stop7);
        textView10.setText(stop8);
        textView11.setText(stop9);
        textView12.setText(stop10);
        textView13.setText(des);
        textView14.setText(times);
        textView15.setText(time1);
        textView16.setText(time2);
        textView17.setText(time3);
        textView18.setText(time4);
        textView19.setText(time5);
        textView20.setText(time6);
        textView21.setText(time7);
        textView22.setText(time8);
        textView23.setText(time9);
        textView24.setText(time10);
        textView25.setText(timed);


        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawTrack(textView2.getText().toString(), textView3.getText().toString(),textView4.getText().toString(),textView5.getText().toString(),textView6.getText().toString(), textView7.getText().toString(),textView8.getText().toString(),textView9.getText().toString(),textView10.getText().toString(), textView11.getText().toString(),textView13.getText().toString());
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
            Intent intent=new Intent(onclick.this,timetable.class);
            startActivity(intent);
            Toast.makeText(this, "Available Timetable", Toast.LENGTH_SHORT).show();
        }
        else if(itemId==R.id.feedback){
            Intent intent=new Intent(onclick.this,feedback.class);
            startActivity(intent);
            Toast.makeText(this, "Give your feedback", Toast.LENGTH_SHORT).show();
        }
        else if(itemId==R.id.aboutus){
            Intent intent=new Intent(onclick.this,aboutus.class);
            startActivity(intent);
            Toast.makeText(this, "Developer information", Toast.LENGTH_SHORT).show();
        }
        else if (itemId==R.id.contactus){
            Intent intent=new Intent(onclick.this,contactus.class);
            startActivity(intent);
            Toast.makeText(this, "Contact information", Toast.LENGTH_SHORT).show();
        }
        else if (itemId==android.R.id.home){
            Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    private void drawTrack(String source, String s1, String s2,String s3, String s4, String s5, String s6, String s7, String s8, String s9, String des) {
        try {
            // create a uri
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + source + "/" + s1+ "/" +s2+ "/" +s3+ "/" + s4+ "/" +s5+ "/" +s6+ "/" + s7+ "/" +s8+ "/" +s9+"/"+des);

            // initializing a intent with action view.
            Intent i = new Intent(Intent.ACTION_VIEW, uri);

            // below line is to set maps package name
            i.setPackage("com.google.android.apps.maps");

            // below line is to set flags
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // start activity
            startActivity(i);
        } catch (ActivityNotFoundException e) {
            // when the google maps is not installed on users device
            // we will redirect our user to google play to download google maps.
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");

            // initializing intent with action view.
            Intent i = new Intent(Intent.ACTION_VIEW, uri);

            // set flags
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // to start activity
            startActivity(i);
        }

    }

}
