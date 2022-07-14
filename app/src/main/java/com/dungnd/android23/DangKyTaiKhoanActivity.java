package com.dungnd.android23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DangKyTaiKhoanActivity extends AppCompatActivity {
        private TextView txtThongBao;
        private EditText edtTenTK, edtNhapMK, edtNhapLaiMK;
        private Button btnTiepTuc, btnChuyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_tai_khoan);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKyTaiKhoanActivity.this, NhapThongTinCaNhanActivity.class);
                startActivity(intent);
            }
        });
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNhapMK.getText().toString().trim().equals(edtNhapLaiMK.getText().toString().trim())){
                    Toast.makeText(DangKyTaiKhoanActivity.this, "Hợp lệ", Toast.LENGTH_SHORT).show();
                }else {
                    txtThongBao.setText("Mật khẩu không trùng khớp");
                    edtNhapMK.setBackgroundColor(Color.RED);
                }
            }
        });
    }

    private void addControls() {
        txtThongBao = findViewById(R.id.txtThongBao);
        edtTenTK = findViewById(R.id.edtTenTK);
        edtNhapMK = findViewById(R.id.edtNhapMK);
        edtNhapLaiMK = findViewById(R.id.edtNhapLaiMK);
        btnTiepTuc = findViewById(R.id.btnTiepTuc);
        btnChuyen = findViewById(R.id.btnChuyen);
    }
}