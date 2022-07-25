package com.dungnd.android23.buoi7

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dungnd.android23.R

class Buoi7HaiActivity : AppCompatActivity() {

    //Hiển thị dữ liệu từ màn trước truyền sang
    private var tvShowData: TextView? = null
    //Bấm vào sẽ back lại màn trước và truyền dữ liệu ngược lại
    private var btnBack: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi7_hai)
        tvShowData = findViewById(R.id.tvShowData)
        btnBack = findViewById(R.id.btnBack)
        //Nhận dữ liệu
//        val so = intent.extras?.getInt("key1")
        val so = intent.extras?.getInt("key1", -1)
        val text = intent.extras?.getString("key2", "")
        val data = intent.extras?.get("key3") as? SeventData
        val textString = "$text _ $so \n ${data?.title} \n ${data?.content}"
        tvShowData?.text = textString

        btnBack?.setOnClickListener {
            //Truyền ngược lại màn trước
            val intent = Intent()
            intent.putExtra("key4", 1)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}