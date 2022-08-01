package com.dungnd.android23.chuabtnv8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.dungnd.android23.R

class Man2Activity : AppCompatActivity() {
    private var edtname : EditText? = null
    private var edtaddress : EditText? = null
    private var edtphone : EditText? = null
    private var btnluu : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man2)
        edtname = findViewById(R.id.edt_name)
        edtaddress = findViewById(R.id.edt_address)
        edtphone = findViewById(R.id.edt_phone)
        btnluu = findViewById(R.id.btn_luu)
        btnluu?.setOnClickListener {
            val addname : String = edtname?.text.toString()
            val addaddress : String = edtaddress?.text.toString()
            val addphone : String = edtphone?.text.toString()
            val intent = Intent()
            intent.putExtra("name", addname)
            intent.putExtra("address", addaddress)
            intent.putExtra("phone", addphone)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}