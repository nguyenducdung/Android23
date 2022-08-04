package com.codefresher.appb

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var edtName: EditText? = null
    private var edtAddress: EditText? = null
    private var edtPhone: EditText? = null
    private var broadcastReceiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = this.resources.getColor(R.color.statusbar)

        initView()



    }

    override fun onResume() {
        super.onResume()
        initBroadCast()
    }


    private fun initBroadCast() {
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, p1: Intent?) {
                val name = p1?.getStringExtra(sendName).toString()
                val address = p1?.getStringExtra(sendAddress).toString()
                val phone = p1?.getStringExtra(sendPhone).toString()

                edtName?.setText(name)
                edtAddress?.setText(address)
                edtPhone?.setText(phone)
            }

        }
        val intentFilter = IntentFilter(send)
        registerReceiver(broadcastReceiver, intentFilter)
    }

    private fun initView() {
        edtName = findViewById(R.id.edtName)
        edtAddress = findViewById(R.id.edtAddress)
        edtPhone = findViewById(R.id.edtPhone)
    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcastReceiver)
    }

    companion object {
        const val send = "send"
        const val sendName = "name"
        const val sendAddress = "address"
        const val sendPhone = "phone"
    }
}