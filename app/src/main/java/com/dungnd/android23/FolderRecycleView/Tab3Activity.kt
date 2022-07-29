package com.dungnd.android23.FolderRecycleView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.dungnd.android23.R

class Tab3Activity : AppCompatActivity() {
    var tvluu: TextView? = null
    var edttenthumuc : EditText? = null
    var edtmota : EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab3)
        tvluu = findViewById(R.id.tvluu)
        edttenthumuc = findViewById(R.id.edttitle)
        edtmota = findViewById(R.id.edtcontent)
        val tenthumuc : String = edttenthumuc?.text.toString()
        val motathumuc : String = edtmota?.text.toString()
        tvluu?.setOnClickListener {
            val intent: Intent = Intent()
            intent.putExtra("datatenthumuc", tenthumuc)
            intent.putExtra("datamota", motathumuc)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}