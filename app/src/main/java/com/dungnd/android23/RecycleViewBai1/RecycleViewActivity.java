package com.dungnd.android23.RecycleViewBai1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dungnd.android23.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {
    private RecyclerView rcvData;
    private BookAdapter bookAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        rcvData =findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);

        bookAdapter = new BookAdapter(getListBook());
        rcvData.setAdapter(bookAdapter);
    }

    private List<Book> getListBook() {
        List<Book> list = new ArrayList<>();
       list.add(new Book(R.drawable.ic_phone,"Mua bán có tâm","8K Fan","+10 Bài Viết","Nhóm Đóng"));
        list.add(new Book(R.drawable.ic_an,"Ăn để lăn","8K Fan","+10 Bài Viết","Nhóm Kín"));
        list.add(new Book(R.drawable.ic_be,"Chia sẻ kiến thức tài liệu Montessori","1,7K Fan","+10 Bài Viết","Nhóm Mở"));
        list.add(new Book(R.drawable.ic_eat,"Thực đơn Eat-Clean giảm cân khỏe đẹp","11K Fan","+20 Bài Viết","Nhóm Mở"));
        list.add(new Book(R.drawable.ic_easy,"Easy Kento For busy People","8K Fan","+10 Bài Viết","Nhóm Kín"));
        list.add(new Book(R.drawable.ic_car,"OFFB","8K Fan","+10 Bài Viết","Nhóm Mở"));
        list.add(new Book(R.drawable.ic_eat,"Thực đơn Eat-Clean giảm cân khỏe đẹp","11K Fan","+20 Bài Viết","Nhóm Mở"));
        list.add(new Book(R.drawable.ic_easy,"Easy Kento For busy People","8K Fan","+10 Bài Viết","Nhóm Kín"));
         return list;

    }
}