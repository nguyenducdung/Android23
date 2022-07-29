package com.dungnd.android23.chuabtvn7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.dungnd.android23.R

//Màn hình thêm thư mục
class Man3Activity : AppCompatActivity() {
    private var tvluu: TextView? = null
    private var edttenthumuc: EditText? = null
    private var edtmota: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man3)
        tvluu = findViewById(R.id.tv_luu)
        edttenthumuc = findViewById(R.id.edt_tenthumuc)
        edtmota = findViewById(R.id.edt_motathumuc)

        tvluu?.setOnClickListener {
            val folder = Folder(
                id = System.currentTimeMillis().toInt(),
                title = edttenthumuc?.text.toString(),
                content = edtmota?.text.toString()
            )
            val intent = Intent()
            intent.putExtra("folder", folder)
            intent.putExtra(Man1Activity.KEY, Man1Activity.TYPE_ADD)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}