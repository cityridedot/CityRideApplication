package com.example.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
public class bus_detail_cart extends  RecyclerView.Adapter<bus_detail_cart.bus_detail_cartViewholder> {
    private final RecyclerViewInterFace recyclerViewInterFace;
    ArrayList<bus> list;
    Context context;

    public bus_detail_cart(Context context, ArrayList<bus> list, RecyclerViewInterFace recyclerViewInterFace)
    {
        this.context = context;
        this.list = list;
        this.recyclerViewInterFace = recyclerViewInterFace;
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    /*@Override
    protected void
    onBindViewHolder(@NonNull bus_detail_cartViewholder holder, int position, @NonNull person model)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        //holder.firstname.setText(model.getFirstname());
        holder.Busid.setText(model.getBusid());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        //holder.lastname.setText(model.getLastname());
        holder.stardes.setText(model.getStardes());

        // Add age from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        //holder.age.setText(model.getAge());
        holder.enddes.setText(model.getEnddes());
        holder.ticketp.setText(model.getTicketp());
    }*/

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public bus_detail_cartViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.bus_detail_cart, parent, false);
        return new bus_detail_cartViewholder(view,recyclerViewInterFace);
    }

    @Override
    public void onBindViewHolder(@NonNull bus_detail_cartViewholder holder, int position) {
        bus b1=list.get(position);
        holder.Busid.setText(b1.getBusid());
        holder.stardes.setText(b1.getStardes());
        holder.enddes.setText(b1.getEnddes());
        holder.ticketp.setText(b1.getTicketp());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    public static class bus_detail_cartViewholder
            extends RecyclerView.ViewHolder {
        TextView Busid, stardes, enddes,ticketp;
        public bus_detail_cartViewholder(@NonNull View itemView,RecyclerViewInterFace recyclerViewInterFace)
        {
            super(itemView);

            stardes = itemView.findViewById(R.id.startdes);
            enddes = itemView.findViewById(R.id.desend);
            Busid= itemView.findViewById(R.id.busid);
            ticketp=itemView.findViewById(R.id.txtp);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterFace!=null){
                        int pos=getAdapterPosition();

                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterFace.onItemClick(pos);
                        }
                    }
                }
            });

        }

        /*public bus_detail_cartViewholder(@NonNull View itemView) {
            super(itemView);
            Busid= itemView.findViewById(R.id.busid);

        }*/
//        TextView firstname, lastname, age;
//        public personsViewholder(@NonNull View itemView)
//        {
//            super(itemView);
//
//            firstname = itemView.findViewById(R.id.firstname);
//            lastname = itemView.findViewById(R.id.lastname);
//            age = itemView.findViewById(R.id.age);
//        }
    }
}