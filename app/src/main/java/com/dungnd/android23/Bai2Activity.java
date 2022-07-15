package com.dungnd.android23;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.telephony.PhoneNumberUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Bai2Activity extends AppCompatActivity {
    EditText editTextnhapsodienthoai, editTextnhapemail, editTextnhaptendaydu, editTextnhaptencoquan, editTextnhapmatkhau;
    Button buttontieptuc;
    TextView textView1, textView2, textView3, textView4, textView5;
    Boolean check1 = false;
    Boolean check2 = false;
    Boolean check3 = false;
    Boolean check4 = false;
    Boolean check5 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        editTextnhapsodienthoai = findViewById(R.id.edt_nhapsodienthoai);
        editTextnhapemail = findViewById(R.id.edt_nhapemail);
        editTextnhaptendaydu = findViewById(R.id.edt_nhaptendaydu);
        editTextnhaptencoquan = findViewById(R.id.edt_nhaptencoquan);
        editTextnhapmatkhau = findViewById(R.id.edt_nhappassword);
        buttontieptuc = findViewById(R.id.button_tieptuc);
        textView1 = findViewById(R.id.textview_error1);
        textView2 = findViewById(R.id.textview_error2);
        textView3 = findViewById(R.id.textview_error3);
        textView4 = findViewById(R.id.textview_error4);
        textView5 = findViewById(R.id.textview_error5);
        editTextnhapsodienthoai.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().equals("0867950503")){
                    textView1.setText("");
                    check1 = true;
                }else {
                    textView1.setText("số điện thoại ko đúng");
                }
            }
        });
        editTextnhapemail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String email = "";
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (email.matches(emailPattern)&& email.length()>0) {
                    editTextnhapemail.setBackground(ContextCompat.getDrawable(Bai2Activity.this, R.drawable.shapaedittext));
//                    useremail_layout.setError("valid address");
                } else  {
//                    useremail_layout.setError("invalid email");
//                    ContactsContract.CommonDataKinds.Email.setError(null);
                    editTextnhapemail.setBackground(ContextCompat.getDrawable(Bai2Activity.this, R.drawable.shape_editext_error));
                }
            }
        });
        editTextnhapmatkhau.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(s.length() < 8){
                    textView3.setText("mật khẩu quá ngắn");
                }else {
                    textView3.setText("");
                    check3 = true;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editTextnhaptendaydu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().equals("")){
                    textView4.setText("vui lòng nhập đầy đủ tên");
                }else {
                    textView4.setText("");
                    check4 = true;
                }
            }
        });
        editTextnhaptencoquan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().equals("")){
                    textView5.setText("vui lòng nhập đầy đủ tên cơ quan");
                }else {
                    textView5.setText("");
                    check5 = true;
                }
            }
        });
        buttontieptuc.setOnClickListener(v -> {
            if(check1 && check2 && check3 && check4 && check5){
                Intent intent = new Intent(Bai2Activity.this, Bai3Activity.class);
                startActivity(intent);
            }else if(!check1){
                Toast.makeText(Bai2Activity.this, "nhập thông tin không thành công", Toast.LENGTH_SHORT).show();
            }
            else if(!check2){
                Toast.makeText(Bai2Activity.this, "nhập thông tin không thành công", Toast.LENGTH_SHORT).show();
            }else if(!check3){
                Toast.makeText(Bai2Activity.this, "nhập thông tin không thành công", Toast.LENGTH_SHORT).show();
            }else if(!check4){
                Toast.makeText(Bai2Activity.this, "nhập thông tin không thành công", Toast.LENGTH_SHORT).show();
            }else if(!check5){
                Toast.makeText(Bai2Activity.this, "nhập thông tin không thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}