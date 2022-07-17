package com.dungnd.android23.buoi4bai3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dungnd.android23.R;
import com.dungnd.android23.buoi4bai3.Folder;
import com.dungnd.android23.buoi4bai3.FolderAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity2 extends AppCompatActivity {
    private RecyclerView rcvData;
    private FolderAdapter folderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view2);

        rcvData = findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);

        folderAdapter = new FolderAdapter(getListFolder());
        rcvData.setAdapter(folderAdapter);
    }

    private List<Folder> getListFolder() {
        List<Folder> list = new ArrayList<>();
        list.add(new Folder(R.drawable.ic_folder,"Video"));
        list.add(new Folder(R.drawable.ic_folder,"Android"));
        list.add(new Folder(R.drawable.ic_folder,"Applock"));
        list.add(new Folder(R.drawable.ic_folder,"Books"));
        list.add(new Folder(R.drawable.ic_folder,"Map"));
        list.add(new Folder(R.drawable.ic_folder,"Authenticate Using Google"));
        list.add(new Folder(R.drawable.ic_folder,"New folder"));
        list.add(new Folder(R.drawable.ic_folder,"New folder 1"));


        return list;


    }
}