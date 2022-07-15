package com.dungnd.android23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai3buoi3 extends AppCompatActivity {
    EditText edso1, edso2, edkq;

    Button btnCong, btnTru, btnNhan, btnChia,btnR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3buoi3);
        addControls();
        addEvents();
    }
    private void addEvents() {

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi1 = edso1.getText().toString().trim();
                String chuoi2 = edso2.getText().toString().trim();

                if (chuoi1.equals("") || chuoi2.equals("")){
                    Toast.makeText(Bai3buoi3.this, "Vui lòng nhập số ", Toast.LENGTH_SHORT).show();
                }else {
                    int so1 = Integer.parseInt(chuoi1);
                    int so2 = Integer.parseInt(chuoi2);
                    edkq.setText(String.valueOf(so1 + so2));
                }
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi1 = edso1.getText().toString().trim();
                String chuoi2 = edso2.getText().toString().trim();

                if (chuoi1.equals("") || chuoi2.equals("")){
                    Toast.makeText(Bai3buoi3.this, "Vui lòng nhập số ", Toast.LENGTH_SHORT).show();
                }else {
                    int so1 = Integer.parseInt(chuoi1);
                    int so2 = Integer.parseInt(chuoi2);
                    edkq.setText(String.valueOf(so1 - so2));
                }
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi1 = edso1.getText().toString().trim();
                String chuoi2 = edso2.getText().toString().trim();

                if (chuoi1.equals("") || chuoi2.equals("")){
                    Toast.makeText(Bai3buoi3.this, "Vui lòng nhập số ", Toast.LENGTH_SHORT).show();
                }else {
                    int so1 = Integer.parseInt(chuoi1);
                    int so2 = Integer.parseInt(chuoi2);
                    edkq.setText(String.valueOf(so1 * so2));
                }
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi1 = edso1.getText().toString().trim();
                String chuoi2 = edso2.getText().toString().trim();

                if (chuoi1.equals("") || chuoi2.equals("")){
                    Toast.makeText(Bai3buoi3.this, "Vui lòng nhập số ", Toast.LENGTH_SHORT).show();
                }else {
                    int so1 = Integer.parseInt(chuoi1);
                    int so2 = Integer.parseInt(chuoi2);
                    edkq.setText(String.valueOf(so1 / so2));
                }
            }
        });
    }

    private void addControls() {
        edso1 = findViewById(R.id.edso1);
        edso2 = findViewById(R.id.edso2);
        edkq = findViewById(R.id.edkq);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
    }
}