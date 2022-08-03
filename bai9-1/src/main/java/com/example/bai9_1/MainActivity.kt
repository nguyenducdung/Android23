package com.example.bai9_1

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var edtName: EditText?=null
    private var edtAddress: EditText?=null
    private var edtPhone: EditText?=null
    private var btn: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initview()
    }
    private fun initview(){
        edtName=findViewById(R.id.edt_folder_name)
        edtAddress=findViewById(R.id.edt_sv_address)
        edtPhone=findViewById(R.id.edt_sv_phone)
        btn=findViewById(R.id.btn_save)
        btn?.setOnClickListener {
            clickSendBroadcast()
        }
    }

    private fun clickSendBroadcast() {
        val intent=Intent(ACTION)

        intent.putExtra(NAME,edtName?.text.toString())
        intent.putExtra(ADDRESS,edtAddress?.text.toString())
        intent.putExtra(PHONE,edtPhone?.text.toString())
        sendBroadcast(intent)
        Toast.makeText(this, "gửi thành công", Toast.LENGTH_SHORT).show()
    }
    private companion object{
        const val ACTION="action"
        const val NAME="name"
        const val ADDRESS="address"
        const val PHONE="phone"
    }
}