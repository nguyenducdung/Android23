package com.dungnd.android23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bai3Activity extends AppCompatActivity {
    EditText editTextnhapso1, editTextnhapso2, editTextketqua;
    Button buttoncong, buttontru, buttonnhan, buttonchia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        editTextnhapso1 = findViewById(R.id.edt_nhapso1);
        editTextnhapso2 = findViewById(R.id.edt_nhapso2);
        editTextketqua = findViewById(R.id.edt_ketqua);
        buttoncong = findViewById(R.id.btn_cong);
        buttontru = findViewById(R.id.btn_tru);
        buttonnhan = findViewById(R.id.btn_nhan);
        buttonchia = findViewById(R.id.btn_chia);
        buttoncong.setOnClickListener(v -> {
            int sothu1 = Integer.parseInt(editTextnhapso1.getText().toString());
            int sothu2 = Integer.parseInt(editTextnhapso2.getText().toString());
            int ketqua = sothu1 + sothu2;
            editTextketqua.setText(ketqua + "");
        });
        buttontru.setOnClickListener(v -> {
            int sothu1 = Integer.parseInt(editTextnhapso1.getText().toString());
            int sothu2 = Integer.parseInt(editTextnhapso2.getText().toString());
            int ketqua = sothu1 - sothu2;
            editTextketqua.setText(ketqua + "");
        });
        buttonnhan.setOnClickListener(v -> {
            int sothu1 = Integer.parseInt(editTextnhapso1.getText().toString());
            int sothu2 = Integer.parseInt(editTextnhapso2.getText().toString());
            int ketqua = sothu1 * sothu2;
            editTextketqua.setText(ketqua + "");
        });
        buttonchia.setOnClickListener(v -> {
            int sothu1 = Integer.parseInt(editTextnhapso1.getText().toString());
            int sothu2 = Integer.parseInt(editTextnhapso2.getText().toString());
            int ketqua = sothu1 / sothu2;
            editTextketqua.setText(ketqua + "");
        });
    }
}