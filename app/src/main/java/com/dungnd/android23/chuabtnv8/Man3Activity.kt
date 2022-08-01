package com.dungnd.android23.chuabtnv8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.dungnd.android23.R

class Man3Activity : AppCompatActivity() {
    private var edteditname : EditText? = null
    private var edteditaddress : EditText? = null
    private var edteditphone : EditText? = null
    private var btnedit : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man3)
        edteditname = findViewById(R.id.edt_editname)
        edteditaddress = findViewById(R.id.edt_editaddress)
        edteditphone = findViewById(R.id.edt_editphone)
        btnedit = findViewById(R.id.btn_edit)
        val bundle = intent.getBundleExtra("data")
        val user : User = bundle?.get("user") as User
        edteditname?.setText(user.name)
        edteditaddress?.setText(user.address)
        edteditphone?.setText(user.phone)
        btnedit?.setOnClickListener {
            val namenew : String = edteditname?.text.toString()
            val addressnew : String = edteditaddress?.text.toString()
            val phonenew : String = edteditphone?.text.toString()
            user.apply {
                this.name = namenew
                this.address = addressnew
                this.phone = phonenew
            }
            val intent = Intent()
            intent.putExtra("dulieu", user)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}