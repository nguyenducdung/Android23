package com.dungnd.android23.BTVN_buoi4;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dungnd.android23.R;

public class ManTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_two);
        EditText editMail = findViewById(R.id.edtEmail);
        EditText editName = findViewById(R.id.edtName);
        EditText editCompany = findViewById(R.id.edtCompany);
        EditText editPass = findViewById(R.id.edtPass);
        TextView tvError = findViewById(R.id.tvError);
        TextView tvError1 = findViewById(R.id.tvError1);
        TextView tvError2 = findViewById(R.id.tvError2);
        TextView tvError3 = findViewById(R.id.tvError3);
        editMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String email = editMail.getText().toString().trim();
                if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    tvError.setText(null);
                } else {
                    tvError.setText("Email của bạn không đúng. Vui lòng nhập lại");
                }
            }
        });

        editName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String name = editName.getText().toString();
                if (name.length() >= 5) {
                    tvError1.setText(null);
                } else {
                    tvError1.setText("Tên của bạn không đúng. Vui lòng nhập lại");
                }
            }
        });

        editCompany.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String name = editName.getText().toString();
                if (name.length() >= 5) {
                    tvError2.setText(null);
                } else {
                    tvError2.setText("Cơ quan của bạn không đúng. Vui lòng nhập lại");
                }
            }
        });

        editPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String pass = editPass.toString().trim();
                if (pass.length() < 8) {
                    tvError3.setText("Mật khẩu của bạn quá ngắn. Vui lòng nhập lại");
                } else {
                    tvError3.setText(null);
                }
            }
        });
    }

}