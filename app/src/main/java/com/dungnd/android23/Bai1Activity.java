package com.dungnd.android23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Bai1Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<ItemUser> array;
    private RecyclerviewAdapter recyclerviewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        array = new ArrayList<>();
        array.add(new ItemUser(R.drawable.capheden, "cà phê đen", "8k Fan", "+10 bài viết mới nhất","nhóm đóng"));
        array.add(new ItemUser(R.drawable.caphesuada, "cà phê sữa đá", "8k Fan", "+10 bài viết mới nhất", "nhóm kín"));
        array.add(new ItemUser(R.drawable.comrang, "cơm rang", "1,7k Fan", "+10 bài viết mới nhất", "nhóm mở"));
        array.add(new ItemUser(R.drawable.gaquay, "gà quay", "11k Fan", "+20 bài viết mới nhất", "nhóm mở"));
        array.add(new ItemUser(R.drawable.sinhtobo, "sinh tố bơ", "8k Fan", "+10 bài viết mới nhất", "nhóm kín"));
        array.add(new ItemUser(R.drawable.suachua, "sữa chua", "8k Fan", "+10 bài viết mới nhất", "nhóm mở"));
        array.add(new ItemUser(R.drawable.thitquay, "thịt quay", "11k Fan", "20 bài viết mới nhất", "nhóm mở"));
        array.add(new ItemUser(R.drawable.trasuadau, "trà sữa dâu", "8k Fan", "+10 bài viết mới nhất", "nhóm kín"));
        recyclerviewAdapter = new RecyclerviewAdapter(this, array);
        recyclerView.setAdapter(recyclerviewAdapter);
    }
}