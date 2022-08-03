package com.dungnd.android23.btvn_buoi8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.dungnd.android23.R

class BtvnBuoi8OneActivity : AppCompatActivity() {
    //Them thu muc
    private var edtName :EditText? = null
    private var edtAddr :EditText? = null
    private var edtPhone :EditText? = null
    private var tvSave :TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btvn_buoi8_one)
        // anh xa cac view

        edtName = findViewById(R.id.edtName)
        edtAddr = findViewById(R.id.edtAddr)
        edtPhone = findViewById(R.id.edtPhone)
        tvSave = findViewById(R.id.tvSave)

        //get data tu view
        val name = edtName?.text.toString()
        val address = edtAddr?.text.toString()
        val phone = edtPhone?.text.toString()

        tvSave?.setOnClickListener {
            val intent = Intent()
            val user = User(
                    System.currentTimeMillis().toInt(), name,
                    address, phone)
            intent.putExtra("user",user)
            intent.putExtra("Man1","TYPE_ADD")
            setResult(RESULT_OK,intent)
            finish()
        }

    }
}