package com.dungnd.android23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MayTinhActivity extends AppCompatActivity {
        EditText edtSo1, edtSo2;
        TextView txtKetQua;
        Button btnCong, btnTru, btnNhan, btnChia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_may_tinh);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi1 = edtSo1.getText().toString().trim();
                String chuoi2 = edtSo2.getText().toString().trim();

                if (chuoi1.equals("") || chuoi2.equals("")){
                    Toast.makeText(MayTinhActivity.this, "Vui lòng nhập số vào", Toast.LENGTH_SHORT).show();
                }else {
                    int so1 = Integer.parseInt(chuoi1);
                    int so2 = Integer.parseInt(chuoi2);
                    txtKetQua.setText(String.valueOf(so1 + so2));
                }
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi1 = edtSo1.getText().toString().trim();
                String chuoi2 = edtSo2.getText().toString().trim();

                if (chuoi1.equals("") || chuoi2.equals("")){
                    Toast.makeText(MayTinhActivity.this, "Vui lòng nhập số vào", Toast.LENGTH_SHORT).show();
                }else {
                    int so1 = Integer.parseInt(chuoi1);
                    int so2 = Integer.parseInt(chuoi2);
                    txtKetQua.setText(String.valueOf(so1 - so2));
                }
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi1 = edtSo1.getText().toString().trim();
                String chuoi2 = edtSo2.getText().toString().trim();

                if (chuoi1.equals("") || chuoi2.equals("")){
                    Toast.makeText(MayTinhActivity.this, "Vui lòng nhập số vào", Toast.LENGTH_SHORT).show();
                }else {
                    int so1 = Integer.parseInt(chuoi1);
                    int so2 = Integer.parseInt(chuoi2);
                    txtKetQua.setText(String.valueOf(so1 * so2));
                }
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi1 = edtSo1.getText().toString().trim();
                String chuoi2 = edtSo2.getText().toString().trim();

                if (chuoi1.equals("") || chuoi2.equals("")){
                    Toast.makeText(MayTinhActivity.this, "Vui lòng nhập số vào", Toast.LENGTH_SHORT).show();
                }else {
                    int so1 = Integer.parseInt(chuoi1);
                    int so2 = Integer.parseInt(chuoi2);
                    txtKetQua.setText(String.valueOf(so1 / so2));
                }
            }
        });
    }

    private void addControls() {
        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        txtKetQua = findViewById(R.id.txtKetQua);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
    }
}