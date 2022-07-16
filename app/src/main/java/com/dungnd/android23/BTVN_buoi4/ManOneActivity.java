package com.dungnd.android23.BTVN_buoi4;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.dungnd.android23.R;

public class ManOneActivity extends AppCompatActivity {

    private String passInput = "";
    private String passInputAgain = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_one);
        EditText edtName = findViewById(R.id.edtName);
        EditText edtPass = findViewById(R.id.edtPass);
        EditText edtPassAgain = findViewById(R.id.edtPassAgain);
        TextView tvError = findViewById(R.id.tvError);

        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String name = editable.toString().trim();
                if (name.length() < 6) {
                    edtName.setError("Tên tài khoản tối thiểu 6 ký tự");
                } else {
                    edtName.setError(null);
                }
            }
        });

        edtPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String pass = editable.toString().trim();
                if (pass.length() < 8) {
                    edtPass.setError("Mật khẩu tối thiểu 8 ký tự");
                } else {
                    edtPass.setError(null);
                }
                passInput = editable.toString().trim();
            }
        });

        edtPassAgain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String pass = editable.toString().trim();
                if (pass.length() < 8) {
                    edtPassAgain.setError("Mật khẩu tối thiểu 8 ký tự");
                } else {
                    edtPassAgain.setError(null);
                }
                passInputAgain = editable.toString().trim();

                if (passInput.equals(passInputAgain)) {
                    tvError.setText("Mật khẩu hợp lệ");
                } else {
                    tvError.setText("Mật khẩu không trùng khớp");
                }
            }
        });
    }
}