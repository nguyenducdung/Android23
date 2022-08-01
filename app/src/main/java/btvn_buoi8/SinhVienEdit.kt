package btvn_buoi8

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.dungnd.android23.R

class SinhVienEdit : AppCompatActivity() {
    private var btnSave: Button? = null
    private var edtName: EditText? = null
    private var edtAdress: EditText? = null
    private var edtPhone: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi8_edit)
        btnSave = findViewById(R.id.btnSave)
        edtName = findViewById(R.id.edtName)
        edtAdress = findViewById(R.id.edtAdress)
        edtPhone = findViewById(R.id.edtPhone)
        val SinhVien = intent.extras?.get("SinhVien") as? SinhVien
        if (SinhVien != null) {
            edtName?.setText(SinhVien.tvName)
            edtAdress?.setText(SinhVien.tvAdress)
            edtPhone?.setText(SinhVien.tvPhone)

        }
        btnSave?.setOnClickListener {
            SinhVien?.tvName = edtName?.text?.toString() ?: ""
            SinhVien?.tvAdress = edtAdress?.text?.toString() ?: ""
            SinhVien?.tvPhone = edtPhone?.text?.toString() ?: ""
            val intent: Intent = Intent()
            intent.putExtra("SinhVien", SinhVien)
            intent.putExtra(SinhVienActivity.KEY, SinhVienActivity.TYPE_EDIT)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}