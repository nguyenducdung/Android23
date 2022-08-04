package com.codefresher.appa

import android.content.BroadcastReceiver
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var edtName: EditText? = null
    private var edtAddress: EditText? = null
    private var edtPhone: EditText? = null
    private var btnSend: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = this.resources.getColor(R.color.statusbar)

        initView()
        initListener()


    }

    private fun initListener() {
        btnSend?.setOnClickListener {
            sendData()
            Toast.makeText(this,"Send Data", Toast.LENGTH_LONG).show()
        }

    }

    private fun initView() {
        edtName = findViewById(R.id.edtName)
        edtAddress = findViewById(R.id.edtAddress)
        edtPhone = findViewById(R.id.edtPhone)
        btnSend = findViewById(R.id.btnSend)
    }


    private fun sendData() {
        val intent = Intent(send)
        val name: String = edtName?.text.toString()
        val address: String = edtAddress?.text.toString()
        val phone: String = edtPhone?.text.toString()


        intent.putExtra(sendName, name)
        intent.putExtra(sendAddress, address)
        intent.putExtra(sendPhone, phone)
        sendBroadcast(intent)
    }


    companion object {
        const val send = "send"
        const val sendName = "name"
        const val sendAddress = "address"
        const val sendPhone = "phone"
    }
}