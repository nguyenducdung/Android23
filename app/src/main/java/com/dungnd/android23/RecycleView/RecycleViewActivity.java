package com.dungnd.android23.RecycleView;

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
        list.add(new Book(R.drawable.ic_book,"To Kill a Mockingbird "));
        list.add(new Book(R.drawable.ic_book,"To Kill a Mockingbird "));
        list.add(new Book(R.drawable.ic_book,"To Kill a Mockingbird "));
        list.add(new Book(R.drawable.ic_book,"To Kill a Mockingbird "));
        list.add(new Book(R.drawable.ic_book,"To Kill a Mockingbird "));
        return list;

    }
}