package com.dungnd.android23.btvn_buoi8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R
import com.dungnd.android23.buoi7.Buoi7BarActivity
import com.dungnd.android23.buoi7.SeventData
import com.dungnd.android23.recycleview.Student

class BtvnBuoi8Activity : AppCompatActivity() {

    private var imgAddUser : ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btvn_buoi8)

        val rcvData = findViewById<RecyclerView>(R.id.rcvData)
        imgAddUser = findViewById<ImageView>(R.id.imgAdd)
        val adapter = BtvnBuoi8Adapter(createUserList())
        adapter.onClickItem= { user ->
            openUpdateUser()
        }
        rcvData.adapter = adapter
        imgAddUser?.setOnClickListener(){
            openAddUser()
        }
    }

    private fun createUserList(): List<User> {
        val userList : MutableList<User> = ArrayList()

        userList.add(User().apply {
            this.Name="Ten: Vo Huu Thinh"
            this.Address="Dia chi: Trieu Khuc, Thanh Xuan, Ha noi"
            this.Phone="Phone: 0123456789"
        })
        userList.add(User().apply {
            this.Name="Ten: Vo Huu Thinh"
            this.Address="Dia chi: Trieu Khuc, Thanh Xuan, Ha noi"
            this.Phone="Phone: 0123456789"
        })
        userList.add(User().apply {
            this.Name="Ten: Vo Huu Thinh"
            this.Address="Dia chi: Trieu Khuc, Thanh Xuan, Ha noi"
            this.Phone="Phone: 0123456789"
        })
        userList.add(User().apply {
            this.Name="Ten: Vo Huu Thinh"
            this.Address="Dia chi: Trieu Khuc, Thanh Xuan, Ha noi"
            this.Phone="Phone: 0123456789"
        })
        userList.add(User().apply {
            this.Name="Ten: Vo Huu Thinh"
            this.Address="Dia chi: Trieu Khuc, Thanh Xuan, Ha noi"
            this.Phone="Phone: 0123456789"
        })
        userList.add(User().apply {
            this.Name="Ten: Vo Huu Thinh"
            this.Address="Dia chi: Trieu Khuc, Thanh Xuan, Ha noi"
            this.Phone="Phone: 0123456789"
        })
        return userList
    }
    private fun openAddUser() {
            val intent = Intent(this, BtvnBuoi8OneActivity::class.java)
            startActivity(intent)
    }
    private fun openUpdateUser(){
        val intent = Intent(this, BtvnBuoi8OneActivity::class.java)
        startActivity(intent)
    }
}