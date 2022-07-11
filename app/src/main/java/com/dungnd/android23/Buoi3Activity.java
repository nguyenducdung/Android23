package com.dungnd.android23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Buoi3Activity extends AppCompatActivity {
    private EditText edtNumber;
    private EditText edtText;
    private TextView tvNumber;
    private TextView tvText;
    private CheckBox cbCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buoi3);
        edtNumber = findViewById(R.id.edtNumber);
        edtText = findViewById(R.id.edtText);
        tvNumber = findViewById(R.id.tvNumber);
        tvText = findViewById(R.id.tvText);
        cbCheck = findViewById(R.id.cbCheck);

        //Lắng nghe sự kiện người dùng nhập cái gì vào ô edittext
        edtNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Trước khi người dùng nhập
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Người dùng đang nhập
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Sau khi người dùng nhập
                //Dùng nhiều ở đây
                //Lấy dữ liệu người dùng đã nhập và hiển thị ở textView
//                tvNumber.setText(editable.toString());


                //trim là xoá khoảng trắng ở đầu và cuối
                //Lấy dữ liệu người dùng đã nhập và hiển thị ở textView
                tvNumber.setText(edtNumber.getText().toString().trim());
            }
        });

        //Trả về true - khi checkbox được tích
        cbCheck.isChecked();

        //Lắng nghe sự kiện người dùng tích vào checkbox
        cbCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    Toast.makeText(Buoi3Activity.this, "Bạn đã tích", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Buoi3Activity.this, "Bạn không tích", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}