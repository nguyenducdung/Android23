package com.example.bai9

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyBroadcastRecevier: BroadcastReceiver() {

    var users: Users? = null

    override fun onReceive(context: Context?, intent: Intent?) {
        if (ACTION.equals(intent?.action)){
             val name=intent?.extras?.getString(NAME).toString()
            val address=intent?.extras?.getString(ADDRESS).toString()
            val phone=intent?.extras?.getString(PHONE).toString()
            users=Users(name,address,phone)
        }
    }
    companion object{
        val ACTION="action"
        const val NAME="name"
        const val ADDRESS="address"
        const val PHONE="phone"
    }
}