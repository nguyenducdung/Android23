package com.dungnd.android23.btvnbuoi3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.TextView;

import com.dungnd.android23.R;

public class ManOneActivity extends AppCompatActivity {

    private String passInput = "";
    private String passInputAgain = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_one);

        EditText edtName = findViewById(R.id.edtName);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtPhone = findViewById(R.id.edtPhone);
        EditText edtPass = findViewById(R.id.edtPass);
        EditText edtPassAgain = findViewById(R.id.edtPassAgain);
        TextView tvError = findViewById(R.id.tvError);
        TextView tvNext = findViewById(R.id.tvNext);

        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            //Sử dụng hàm afterTextChanged để quan sát dữ liệu người dùng nhập vào
            @Override
            public void afterTextChanged(Editable editable) {
                //Lấy dữ liệu người dùng nhập
                String name = editable.toString().trim();
                if (name.length() < 6) {
                    edtName.setError("Tên tài khoản tối thiểu 6 ký tự");
                } else {
                    //mất error
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
                    //mất error
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
                    //mất error
                    edtPassAgain.setError(null);
                }
                passInputAgain = editable.toString().trim();

                if (passInput.equals(passInputAgain)) {
                    edtPass.setBackground(ContextCompat.getDrawable(ManOneActivity.this, R.drawable.shape_editext));
                    tvError.setText("Mật khẩu hợp lệ");
                } else {
                    edtPass.setBackground(ContextCompat.getDrawable(ManOneActivity.this, R.drawable.shape_edittext_erro));
                    tvError.setText("Mật khẩu không trùng khớp");
                }
            }
        });

        tvNext.setOnClickListener(v -> {
            startActivity(new Intent(ManOneActivity.this, ManTwoActivity.class));
        });

        edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String email = edtEmail.getText().toString().trim();
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    edtEmail.setError("Email hợp lý");
                } else {
                    edtEmail.setError("Không hợp lệ");
                }
            }
        });
        edtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String phone = edtPhone.getText().toString().trim();
                if (Patterns.PHONE.matcher(phone).matches() && phone.length() == 10) {
                    edtPhone.setError("Phone hợp lệ");
                } else {
                    edtPhone.setError("Không hợp lệ");
                }
            }
        });
        //Có thể bấm được true, false là k thể bấm được
        tvNext.setEnabled(true);
    }
}