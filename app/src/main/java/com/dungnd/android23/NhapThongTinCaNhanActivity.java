package com.dungnd.android23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class NhapThongTinCaNhanActivity extends AppCompatActivity {
        private TextView txtThongBao;
        private EditText edtNhapSDT, edtNhapEmail, edtNhapTenDD, edtNhapTenCQ, edtNhapMK;
        private Button btnTiepTuc, btnChuyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_thong_tin_ca_nhan);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NhapThongTinCaNhanActivity.this, MayTinhActivity.class);
                startActivity(intent);
            }
        });
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNhapSDT.getText().toString().trim().equals("") && edtNhapEmail.getText().toString().trim().equals("") && edtNhapTenDD.getText().toString().trim().equals("") && edtNhapTenCQ.getText().toString().trim().equals("") && edtNhapMK.getText().toString().trim().equals("")){
                    Toast.makeText(NhapThongTinCaNhanActivity.this, "Vui lòng nhập thông tin vào", Toast.LENGTH_SHORT).show();
                }else {
                    if (edtNhapSDT.getText().toString().trim().equals("")) {
                        Toast.makeText(NhapThongTinCaNhanActivity.this, "Vui lòng nhập số điện thoại vào", Toast.LENGTH_SHORT).show();
                    }
                    if (edtNhapTenDD.getText().toString().trim().equals("")) {
                        Toast.makeText(NhapThongTinCaNhanActivity.this, "Vui lòng nhập tên vào", Toast.LENGTH_SHORT).show();
                    }
                    if (edtNhapTenCQ.getText().toString().trim().equals("")) {
                        Toast.makeText(NhapThongTinCaNhanActivity.this, "Vui lòng nhập tên cơ quan vào", Toast.LENGTH_SHORT).show();
                    }
                    if (edtNhapMK.getText().toString().trim().equals("")) {
                        Toast.makeText(NhapThongTinCaNhanActivity.this, "Vui lòng nhập mật khẩu vào", Toast.LENGTH_SHORT).show();
                    } else if (edtNhapMK.getText().toString().trim().length() <= 5) {
                        txtThongBao.setText("Mật khẩu của bạn quá ngắn. Vui lòng nhập lại");
                    }

                    String emailAddress = edtNhapEmail.getText().toString().trim();
                    if (emailAddress.equals("")) {
                        Toast.makeText(NhapThongTinCaNhanActivity.this, "Vui lòng nhập email vào", Toast.LENGTH_SHORT).show();
                    } else {
                        if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
                            //Toast.makeText(NhapThongTinCaNhanActivity.this, "Email hợp lệ", Toast.LENGTH_SHORT).show();
                        } else {
                            txtThongBao.setText("Email của bạn không đúng. Vui lòng nhập lại");
                        }
                    }
                }
            }
        });
    }

    private void addControls() {
        btnChuyen =  findViewById(R.id.btnChuyen);
        txtThongBao = findViewById(R.id.txtThongBao);
        edtNhapSDT = findViewById(R.id.edtNhapSDT);
        edtNhapEmail = findViewById(R.id.edtNhapEmail);
        edtNhapTenDD = findViewById(R.id.edtNhapTenDD);
        edtNhapTenCQ = findViewById(R.id.edtNhapTenCQ);
        edtNhapMK = findViewById(R.id.edtNhapMK);
        btnTiepTuc = findViewById(R.id.btnTiepTuc);
    }
}