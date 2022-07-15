package com.dungnd.android23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bai2buoi3 extends AppCompatActivity {
    private TextView tvThongBao;
    private EditText edsdt,edemail,edname,edCoquan,edmk;
    private Button btnTT, btnbai3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2buoi3);
        addControls();
        addEvents();
    }
    private void addEvents() {
        btnbai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bai2buoi3.this, Bai3buoi3.class);
                startActivity(intent);
            }
        });
        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edsdt.getText().toString().trim().equals("") && edemail.getText().toString().trim().equals("") &&
                        edname.getText().toString().trim().equals("") && edCoquan.getText().toString().trim().equals("") && edmk.getText().toString().trim().equals("")){
                    Toast.makeText(bai2buoi3.this, "Vui lòng nhập thông tin vào", Toast.LENGTH_SHORT).show();
                }else {
                    if (edsdt.getText().toString().trim().equals("")) {
                        Toast.makeText(bai2buoi3.this, "Vui lòng nhập số điện thoại vào", Toast.LENGTH_SHORT).show();
                    }
                    if (edname.getText().toString().trim().equals("")) {
                        Toast.makeText(bai2buoi3.this, "Vui lòng nhập tên của bạn vào", Toast.LENGTH_SHORT).show();
                    }
                    if (edCoquan.getText().toString().trim().equals("")) {
                        Toast.makeText(bai2buoi3.this, "Vui lòng nhập tên cơ quan của bạn vào", Toast.LENGTH_SHORT).show();
                    }
                    if (edmk.getText().toString().trim().equals("")) {
                        Toast.makeText(bai2buoi3.this, "Vui lòng nhập mật khẩu của bạn vào", Toast.LENGTH_SHORT).show();
                    } else if (edmk.getText().toString().trim().length() <= 5) {
                        tvThongBao.setText("Mật khẩu của bạn quá ngắn. Vui lòng nhập lại");

                    }

                    String emailAddress = edemail.getText().toString().trim();
                    if (emailAddress.equals("")) {
                        Toast.makeText(bai2buoi3.this, "Vui lòng nhập email của bạn vào", Toast.LENGTH_SHORT).show();
                    } else {
                        if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
                            //Toast.makeText(NhapThongTinCaNhanActivity.this, "Email hợp lệ", Toast.LENGTH_SHORT).show();
                        } else {
                            tvThongBao.setText("Email của bạn không đúng. Vui lòng nhập lại");

                        }
                    }
                }
            }
        });
    }

    private void addControls() {
        btnbai3 =  findViewById(R.id.btnbai3);
        tvThongBao = findViewById(R.id.tvThongBao);
        edsdt = findViewById(R.id.edsdt);
        edemail = findViewById(R.id.edemail);
        edname = findViewById(R.id.edname);
        edCoquan = findViewById(R.id.edCoquan);
        edmk = findViewById(R.id.edmk);
        btnTT = findViewById(R.id.btnTT);
    }
}