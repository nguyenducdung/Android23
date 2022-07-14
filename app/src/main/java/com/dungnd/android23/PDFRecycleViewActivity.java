package com.dungnd.android23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.RecoverySystem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dungnd.android23.R;
import com.dungnd.android23.pdfrecyclerview.AdapterPDF;
import com.dungnd.android23.pdfrecyclerview.PDF;

import java.util.ArrayList;
import java.util.List;

public class PDFRecycleViewActivity extends AppCompatActivity {
    private Button btnClick;
    private RecyclerView rcvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfrecycle_view);
        Init();
        Act();
    }

    private List<PDF> createPDFList(){
        List<PDF> pdfList = new ArrayList<>();
        pdfList.add(new PDF("To Kill a Mockingbird"));
        pdfList.add(new PDF("To Kill a Mockingbird"));
        pdfList.add(new PDF("To Kill a Mockingbird"));
        pdfList.add(new PDF("To Kill a Mockingbird"));
        pdfList.add(new PDF("To Kill a Mockingbird"));
        pdfList.add(new PDF("To Kill a Mockingbird"));
        return pdfList;
    }


    private void Act() {
        AdapterPDF adapterPDF = new AdapterPDF(createPDFList());
        rcvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvData.setAdapter(adapterPDF);

        adapterPDF.setOnItemClick(new AdapterPDF.OnItemClick() {
            @Override
            public void clickName(String name) {
                Toast.makeText(PDFRecycleViewActivity.this, "Ten: " + name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickItem() {
                Toast.makeText(PDFRecycleViewActivity.this, "Item", Toast.LENGTH_SHORT).show();
            }
        });

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PDFRecycleViewActivity.this, DangKyTaiKhoanActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Init() {
        btnClick = findViewById(R.id.btnClick);
        rcvData = findViewById(R.id.rcvData);
    }
}