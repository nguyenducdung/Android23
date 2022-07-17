package com.dungnd.android23;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Bai3Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> array;
    private RecyclerviewAdapterBai3 recyclerviewAdapterBai3;
    private ImageView imageViewedit;
    private ImageView imageViewcancel;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        recyclerView = findViewById(R.id.recyclerview_bai3);
        toolbar = findViewById(R.id.toolbar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        array = new ArrayList<>();
        array.add("Video");
        array.add("Android");
        array.add("Applock");
        array.add("Books");
        array.add("Map");
        array.add("Authenticate Using Google...");
        array.add("New folder");
        array.add("New folder1");
        recyclerviewAdapterBai3 = new RecyclerviewAdapterBai3(this, array);
        recyclerView.setAdapter(recyclerviewAdapterBai3);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuitem, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_add:
                array.add("this is file 1");
                recyclerviewAdapterBai3.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }
}