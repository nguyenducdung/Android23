package com.dungnd.android23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dungnd.android23.buoi4.AdapterBuoi4Bai3;
import com.dungnd.android23.buoi4.Buoi4Bai3;

import java.util.ArrayList;
import java.util.List;

public class Buoi4Bai3Activity extends AppCompatActivity {
        private RecyclerView rcvBuoi4Bai3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buoi4_bai3);
        addControls();
        addEvents();
    }

    private void addEvents() {
        AdapterBuoi4Bai3 adapterBuoi4Bai3 = new AdapterBuoi4Bai3(createBuoi4Bai3List());
        rcvBuoi4Bai3.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcvBuoi4Bai3.setAdapter(adapterBuoi4Bai3);
    }

    private List<Buoi4Bai3> createBuoi4Bai3List(){
        List<Buoi4Bai3> buoi4Bai3List = new ArrayList<>();
        buoi4Bai3List.add(new Buoi4Bai3(R.drawable.thumuc, "Video", R.drawable.sua, R.drawable.xoa));
        buoi4Bai3List.add(new Buoi4Bai3(R.drawable.thumuc, "Android", R.drawable.sua, R.drawable.xoa));
        buoi4Bai3List.add(new Buoi4Bai3(R.drawable.thumuc, "Applock", R.drawable.sua, R.drawable.xoa));
        buoi4Bai3List.add(new Buoi4Bai3(R.drawable.thumuc, "Books", R.drawable.sua, R.drawable.xoa));
        buoi4Bai3List.add(new Buoi4Bai3(R.drawable.thumuc, "map", R.drawable.sua, R.drawable.xoa));
        buoi4Bai3List.add(new Buoi4Bai3(R.drawable.thumuc, "Authenticate Using Google", R.drawable.sua, R.drawable.xoa));
        buoi4Bai3List.add(new Buoi4Bai3(R.drawable.thumuc, "New folder", R.drawable.sua, R.drawable.xoa));
        buoi4Bai3List.add(new Buoi4Bai3(R.drawable.thumuc, "New folder 1", R.drawable.sua, R.drawable.xoa));

        return buoi4Bai3List;
    }

    private void addControls() {
        rcvBuoi4Bai3 = findViewById(R.id.rcvBuoi4Bai3);
    }
}