package com.dungnd.android23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class pdfreader extends AppCompatActivity {
    RecyclerView recyclerView;
    Button buttonthem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfreader);
        recyclerView = findViewById(R.id.recyclerview);
        buttonthem = findViewById(R.id.btn_them);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<FileItem> array = new ArrayList<>();
        array.add(new FileItem("this is file 1"));
        array.add(new FileItem("this is file 2"));
        array.add(new FileItem("this is file 3"));
        array.add(new FileItem("this is file 4"));
        array.add(new FileItem("this is file 5"));
        array.add(new FileItem("this is file 6"));
        array.add(new FileItem("this is file 7"));
        array.add(new FileItem("this is file 8"));
        array.add(new FileItem("this is file 9"));
        array.add(new FileItem("this is file 10"));
        recyclerviewadapter recyclerviewadapter = new recyclerviewadapter(array);
        recyclerView.setAdapter(recyclerviewadapter);
        buttonthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array.add(new FileItem("this is file new"));
                recyclerviewadapter.notifyDataSetChanged();
            }
        });
    }
}