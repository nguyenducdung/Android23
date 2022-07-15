package com.dungnd.android23;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Bai1Activity extends AppCompatActivity {
    EditText editTexttentaikhoan;
    EditText editTextnhapmatkhau;
    EditText editTextnhaplaimatkhau;
    Button buttontieptuc;
    TextView textViewerror;
    Boolean check1 = false;
    Boolean check2 = false;
    Boolean check3 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        editTexttentaikhoan = findViewById(R.id.edt_tentaikhoan);
        editTextnhapmatkhau = findViewById(R.id.edt_nhapmatkhau);
        editTextnhaplaimatkhau = findViewById(R.id.edt_nhaplaimatkhau);
        buttontieptuc = findViewById(R.id.btn_tieptuc);
        textViewerror = findViewById(R.id.tv_error);
        editTexttentaikhoan.addTextChangedListener(new TextWatcher() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == ' ') {
                        count++;
                    }
                }
                if (count > 0 || s.length() < 6) {
                    textViewerror.setText("tài khoản không hợp lệ");
                }else{
                    textViewerror.setText("");
                    check1 = true;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editTextnhapmatkhau.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(s.length() < 8){
                    textViewerror.setText("mật khẩu không hợp lệ");
                }else{
                    textViewerror.setText("");
                    check2 = true;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        buttontieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check1 && check2){
                    Intent intent = new Intent(Bai1Activity.this, Bai2Activity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(Bai1Activity.this, "vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}