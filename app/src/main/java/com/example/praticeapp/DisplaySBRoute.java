package com.example.praticeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.praticeapp.Adapters.FatchDataAdapter;
import com.example.praticeapp.Models.FatchDataModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplaySBRoute extends AppCompatActivity {

    //getting firebase database reference to communicate with firebase
    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    //creating list of myItems to store user details
    private final List<FatchDataModel> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sbroute);

                final RecyclerView recyclerView = findViewById(R.id.fatchdataRV);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplaySBRoute.this));

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                items.clear();
                for (DataSnapshot RouteData : snapshot.child("RouteData").getChildren())
                {
                    if(RouteData.hasChild("RouteDate") && RouteData.hasChild("BusTime") && RouteData.hasChild("PickUp") && RouteData.hasChild("Drop"));
                    {
                        final String getroutedate = RouteData.child("RouteDate").getValue(String.class);
                        final String getbustime = RouteData.child("BusTime").getValue(String.class);
                        final String getpickup = RouteData.child("PickUp").getValue(String.class);
                        final String getdrop = RouteData.child("Drop").getValue(String.class);

                        FatchDataModel fdmodel = new FatchDataModel(getroutedate, getbustime, getpickup, getdrop);

                        items.add(fdmodel);
                    }
                }
                recyclerView.setAdapter(new FatchDataAdapter(items,DisplaySBRoute.this));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}