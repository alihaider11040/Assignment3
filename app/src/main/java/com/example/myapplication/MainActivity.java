package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.adapter.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    String[] names;
    String[] contacts;
     RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView.findViewById(R.id.recyclerviewinside);
        names= getResources().getStringArray(R.array.names);
        contacts= getResources().getStringArray(R.array.app_contacts);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, names,contacts);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}