package com.dungnd.android23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import BTVN_buoi3_bai1.RecycleViewBai1;
import BTVN_buoi3_bai2.RecycleViewBai2;
import BTVN_buoi3_bai3.RecycleViewBai3;

public class MainActivity extends AppCompatActivity {
    private Button Clickme;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Clickme = findViewById(R.id.btnClickMe);
        tvName = findViewById(R.id.TVname);

        Clickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecycleViewBai1.class);
                startActivity(intent);


            }
        });
    }
}