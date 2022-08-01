package btvn_buoi8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import buoi7.Buoi7
import buoi7.Buoi7Activity_Add
import com.dungnd.android23.R

class SinhVienAdd : AppCompatActivity() {
    private var btnSave: Button? = null
    private var edtName: EditText? = null
    private var edtAdress: EditText? = null
    private var edtPhone: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi8_add)
        btnSave = findViewById(R.id.btnSave)
        edtName = findViewById(R.id.edtName)
        edtAdress = findViewById(R.id.edtAdress)
        edtPhone = findViewById(R.id.edtPhone)
        btnSave?.setOnClickListener {
            val buoi8item = SinhVien().apply {
                this.id = System.currentTimeMillis().toInt()
                this.tvName = edtName?.text.toString()
                this.tvAdress = edtAdress?.text.toString()
                this.tvPhone = edtPhone?.text.toString()
            }
            val intent = Intent()
            intent.putExtra("SinhVien", buoi8item)
            intent.putExtra(SinhVienActivity.KEY, SinhVienActivity.TYPE_ADD)
            setResult(RESULT_OK, intent)
            finish()

        }
    }

}