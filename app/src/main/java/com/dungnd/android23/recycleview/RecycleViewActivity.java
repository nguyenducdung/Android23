package com.dungnd.android23.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.dungnd.android23.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        RecyclerView rcvData = findViewById(R.id.rcvData);

        //Khởi tạo adapter
        StudentAdapter adapter = new StudentAdapter(createStudentList());
        rcvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvData.setAdapter(adapter);
        adapter.setOnItemClick(new StudentAdapter.OnItemClick() {
            @Override
            public void clickName(String name) {
                Toast.makeText(RecycleViewActivity.this, name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickAge(String age) {

            }

            @Override
            public void clickItem() {
                Toast.makeText(RecycleViewActivity.this, "Đây là item", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private List<Student> createStudentList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Dương", 20, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương1", 21, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương2", 22, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương3", 23, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương4", 24, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương5", 25, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương6", 26, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương7", 27, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương8", 28, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương9", 29, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương10", 30, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương11", 31, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương12", 22, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương13", 22, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương14", 20, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương15", 20, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương16", 20, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương17", 20, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương18", 20, "1", "Bắc Ninh"));
        studentList.add(new Student("Dương19", 20, "1", "Bắc Ninh"));
        return studentList;
    }
}