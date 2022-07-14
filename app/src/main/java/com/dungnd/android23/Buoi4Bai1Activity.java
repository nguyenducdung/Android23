package com.dungnd.android23;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.dungnd.android23.buoi4.AdapterBuoi4Bai1;
import com.dungnd.android23.buoi4.AdapterBuoi4Bai3;
import com.dungnd.android23.buoi4.Buoi4Bai1;

import java.util.ArrayList;
import java.util.List;

public class Buoi4Bai1Activity extends AppCompatActivity {
        private RecyclerView rcvBuoi4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buoi4);
        addControls();
        addEvents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuCM:
                Intent intent = new Intent(Buoi4Bai1Activity.this, Buoi4Bai3Activity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addEvents() {
        AdapterBuoi4Bai1 adapterBuoi4 = new AdapterBuoi4Bai1(createBuoi4List());
        rcvBuoi4.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcvBuoi4.setAdapter(adapterBuoi4);
    }

    private List<Buoi4Bai1> createBuoi4List(){
        List<Buoi4Bai1> buoi4List = new ArrayList<>();
        buoi4List.add(new Buoi4Bai1(R.drawable.dienthoai, "Mua bán có tâm", "8K Fan", "+ 10 bài viết mới nhất", "NHÓM ĐÓNG"));
        buoi4List.add(new Buoi4Bai1(R.drawable.andelan, "Ăn để lăn", "8K Fan", "+10 bài viết mới nhất", "NHÓM KÍN"));
        buoi4List.add(new Buoi4Bai1(R.drawable.embe, "Chia sẻ kiến thức tài liệu Montessori", "1,7K Fan", "+10 bài viết mới nhất", "NHÓM MỞ"));
        buoi4List.add(new Buoi4Bai1(R.drawable.thucdon, "Thực đơn Eat-Clean giảm cân khỏe đẹp", "11K Fan", "+20 bài viết mới nhất", "NHÓM MỞ"));
        buoi4List.add(new Buoi4Bai1(R.drawable.easy, "Easy Kento for busy People", "8K Fan", "+10 bài viết mới nhất", "NHÓM KÍN"));
        buoi4List.add(new Buoi4Bai1(R.drawable.offb, "OFFB", "8K Fan", "+10 bài viết mới nhất", "NHÓM MỞ"));
        buoi4List.add(new Buoi4Bai1(R.drawable.thucdon, "Thực đơn Eat-Clean giảm cân khỏe đẹp", "11K Fan", "+20 bài viết mới nhất", "NHÓM MỞ"));
        buoi4List.add(new Buoi4Bai1(R.drawable.easy, "Easy Kento for busy People", "8K Fan", "+10 bài viết mới nhất", "NHÓM KÍN"));


        return buoi4List;
    }

    private void addControls() {
        rcvBuoi4 = findViewById(R.id.rcvBuoi4);
    }
}