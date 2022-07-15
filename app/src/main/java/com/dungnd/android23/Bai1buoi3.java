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

public class Bai1buoi3 extends AppCompatActivity {
    private TextView tvThongBao;
    private EditText edTTK, edmk, edNmk;
    private Button btnTT, btnbai2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1buoi3);
        addControls();
        addEvents();

    }

    private void addEvents() {
        btnbai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bai1buoi3.this, bai2buoi3.class);
                startActivity(intent);
            }
        });
        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edmk.getText().toString().trim().equals(edNmk.getText().toString().trim())) {
                    Toast.makeText(Bai1buoi3.this, "Đã Hợp lệ", Toast.LENGTH_SHORT).show();
                } else {
                    tvThongBao.setText("Mật khẩu không trùng khớp");
                    edmk.setBackgroundColor(Color.RED);
                }
            }
        });
    }

    private void addControls() {
        tvThongBao = findViewById(R.id.tvThongBao);
        edTTK = findViewById(R.id.edTTK);
        edmk = findViewById(R.id.edmk);
        edNmk = findViewById(R.id.edNmk);
        btnTT = findViewById(R.id.btnTT);
        btnbai2 = findViewById(R.id.btnbai2);
    }
}
