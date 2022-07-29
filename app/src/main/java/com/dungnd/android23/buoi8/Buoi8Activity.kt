package com.dungnd.android23.buoi8

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dungnd.android23.R

class Buoi8Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi8)

        val edtName = findViewById<EditText>(R.id.edtName)
        val tvName = findViewById<TextView>(R.id.tvName)
        val btnSave = findViewById<Button>(R.id.btnSave)

        //Lấy dữ liệu name đc lưu ở local và set vào text view
        tvName.text = SharePreferentUtils.getName(this)

        btnSave.setOnSingleClick {
//            val name = edtName.text.toString().trim()
//            SharePreferentUtils.saveName(name, this)
//
//            //Lấy dữ liệu name đc lưu ở local và set vào text view
//            tvName.text = SharePreferentUtils.getName(this)
//
//
            AppRoomDatabase.getDatabase(this).userProfileDao().insert(UserProfile(
                id = System.currentTimeMillis(),
                name = "Nguyễn Đức Dũng ${System.currentTimeMillis()}",
                age = 10,
                gender = "Nam",
                high = "1000",
                weight = "10"
            ))

            tvName.text = AppRoomDatabase.getDatabase(this).userProfileDao().getAllUser().toString()
        }

    }
}