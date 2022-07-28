package com.dungnd.android23

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class Man3Activity : AppCompatActivity() {
    var tvluu : TextView? = null
    var edttenthumuc : EditText? = null
    var edtmota : EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man3)
        tvluu = findViewById(R.id.tv_luu)
        edttenthumuc = findViewById(R.id.edt_tenthumuc)
        edtmota = findViewById(R.id.edt_motathumuc)
        tvluu?.setOnClickListener {
            val tenthumuc : String = edttenthumuc?.text.toString()
            val motathumuc : String = edtmota?.text.toString()
            val intent : Intent = Intent()
            intent.putExtra("datatenthumuc", tenthumuc)
            intent.putExtra("datamota", motathumuc)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}