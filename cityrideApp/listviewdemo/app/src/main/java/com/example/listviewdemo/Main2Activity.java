package com.example.listviewdemo;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements RecyclerViewInterFace {
    private TextView textviewst,textviewend;
    //ListView listView;
    String[] arr=new String[2];
    RecyclerView recyclerView;
    bus_detail_cart adapter; // Create Object of the Adapter class
    DatabaseReference mbase; // Create object of the
    // Firebase Realtime Database
//    Button trackBtn;
    ArrayList<bus> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textviewst = findViewById(R.id.textviewst);
        textviewend = findViewById(R.id.textviewend);

        String start = getIntent().getStringExtra("keystart");
        String end = getIntent().getStringExtra("keyend");

        textviewst.setText(start);
        textviewend.setText(end);

        arr[0] = start;
        arr[1] = end;

        Toolbar toolbar;
        toolbar=findViewById(R.id.toolbar);

        //step 1
        setSupportActionBar(toolbar);

        //step 2 enable back button
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Search Result");

        }
        //toolbar.setTitle("My Toolbar");//low priority than default in manifest
        //toolbar.setSubtitle("sub title");

        /*listView = findViewById(R.id.listview);
//        using builtin array adapter
//        ArrayAdapter ad= new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
//        listView.setAdapter(ad);

        //using custom array adapter
        bus_detail_cart c= new bus_detail_cart(this,R.layout.bus_detail_cart,arr);
        listView.setAdapter(c);*/
        // Create a instance of the database and get
        // its reference
        recyclerView = findViewById(R.id.recycler1);
        mbase = FirebaseDatabase.getInstance().getReference().child("contact");

        //for onclick item/card
        recyclerView.setHasFixedSize(true);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data
        //FirebaseRecyclerOptions<person> options= new FirebaseRecyclerOptions.Builder<person>().setQuery(mbase, person.class).build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        list = new ArrayList<>();
        //adapter = new bus_detail_cart();
        // Connecting Adapter class with the Recycler view*/
        adapter = new bus_detail_cart(this, list, this);
        recyclerView.setAdapter(adapter);

        mbase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    bus b1 = dataSnapshot.getValue(bus.class);
                    list.add(b1);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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
            Intent intent=new Intent(Main2Activity.this,timetable.class);
            startActivity(intent);
            Toast.makeText(this, "Available Timetable", Toast.LENGTH_SHORT).show();
        }
        else if(itemId==R.id.feedback){
            Intent intent=new Intent(Main2Activity.this,feedback.class);
            startActivity(intent);
            Toast.makeText(this, "Give your feedback", Toast.LENGTH_SHORT).show();
        }
        else if(itemId==R.id.aboutus){
            Intent intent=new Intent(Main2Activity.this,aboutus.class);
            startActivity(intent);
            Toast.makeText(this, "Developer information", Toast.LENGTH_SHORT).show();
        }
        else if (itemId==R.id.contactus){
            Intent intent=new Intent(Main2Activity.this,contactus.class);
            startActivity(intent);
            Toast.makeText(this, "Contact information", Toast.LENGTH_SHORT).show();
        }
        else if (itemId==android.R.id.home){
            Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onItemClick(int position){
        Intent intent = new Intent(Main2Activity.this, onclick.class);
        intent.putExtra("busid", list.get(position).getBusid());
        intent.putExtra("source", list.get(position).getStardes());
        intent.putExtra("stop1", list.get(position).getStop1());
        intent.putExtra("stop2", list.get(position).getStop2());
        intent.putExtra("stop3", list.get(position).getStop3());
        intent.putExtra("stop4", list.get(position).getStop4());
        intent.putExtra("stop5", list.get(position).getStop5());
        intent.putExtra("stop6", list.get(position).getStop6());
        intent.putExtra("stop7", list.get(position).getStop7());
        intent.putExtra("stop8", list.get(position).getStop8());
        intent.putExtra("stop9", list.get(position).getStop9());
        intent.putExtra("stop10", list.get(position).getStop10());
        intent.putExtra("des", list.get(position).getEnddes());
        intent.putExtra("times", list.get(position).getTimes());
        intent.putExtra("time1", list.get(position).getTime1());
        intent.putExtra("time2", list.get(position).getTime2());
        intent.putExtra("time3", list.get(position).getTime3());
        intent.putExtra("time4", list.get(position).getTime4());
        intent.putExtra("time5", list.get(position).getTime5());
        intent.putExtra("time6", list.get(position).getTime6());
        intent.putExtra("time7", list.get(position).getTime7());
        intent.putExtra("time8", list.get(position).getTime8());
        intent.putExtra("time9", list.get(position).getTime9());
        intent.putExtra("time10", list.get(position).getTime10());
        intent.putExtra("timed", list.get(position).getTimed());
        intent.putExtra("ticketp",list.get(position).getTicketp());
        startActivity(intent);
    }

       /* button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });*/
//for map
/*        trackBtn = findViewById(R.id.idBtnTrack);
        // adding on click listener to our button.
        trackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to draw a track on google maps.
                drawTrack(arr[0],arr[1]);
            }
        });

    }
    private void drawTrack(String source, String destination) {
        try {
            // create a uri
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + source + "/" + destination);

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
    }*/

    /*public void openNewActivity(){
        Intent intent = new Intent(this,MapsActivity .class);
        startActivity(intent);
    }*/


    // Function to tell the app to start getting
    // data from database on starting of the activity
/*
    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stopping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }
*/



}
