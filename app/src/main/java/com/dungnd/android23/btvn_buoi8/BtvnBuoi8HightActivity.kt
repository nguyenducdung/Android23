package com.dungnd.android23.btvn_buoi8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.dungnd.android23.R

class BtvnBuoi8HightActivity : AppCompatActivity() {
    private var edtName :EditText? = null
    private var edtPhone :EditText? = null
    private var edtAddr :EditText? = null
    private var tvSave : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btvn_buoi8_hight)


        edtName = findViewById(R.id.edtName)
        edtAddr = findViewById(R.id.edtAddr)
        edtPhone = findViewById(R.id.edtPhone)
        tvSave = findViewById(R.id.tvSave)

        val user = intent.extras?.get("user") as? User
        if(user != null){
            edtName?.setText(user.Name)
            edtAddr?.setText(user.Address)
            edtPhone?.setText(user.Phone)
        }

        tvSave?.setOnClickListener{
            user?.Name = edtName?.text.toString()
            user?.Address = edtAddr?.text.toString()
            user?.Phone = edtPhone?.text.toString()
            val intent = Intent()
            intent.putExtra("user",user)
            intent.putExtra("Man1","TYPE_UPDATE")
            setResult(RESULT_OK,intent)
            finish()
        }

    }
}