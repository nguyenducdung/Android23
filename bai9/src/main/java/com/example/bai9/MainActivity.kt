package com.example.bai9


import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private var edtName: EditText? = null
    private var edtAddress: EditText? = null
    private var edtPhone: EditText? = null
    private var broadcastReceiver = MyBroadcastRecevier()
    private var users: Users? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initview()

    }

    override fun onResume() {
        super.onResume()
        settext()
    }

    private fun settext() {
        users = broadcastReceiver.users
        edtName?.setText(users?.name)
        edtAddress?.setText(users?.address)
        edtPhone?.setText(users?.phone)

    }

    private fun initview() {
        edtName = findViewById(R.id.edt_folder_name)
        edtAddress = findViewById(R.id.edt_sv_address)
        edtPhone = findViewById(R.id.edt_sv_phone)


    }

    override fun onStart() {
        super.onStart()
        val intentfilter = IntentFilter(ACTION)
        registerReceiver(broadcastReceiver, intentfilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcastReceiver)
    }

    companion object {
        val ACTION = "action"
//        val USER="user"
    }
}