package com.dungnd.android23.buoi5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.dungnd.android23.R
import kotlin.math.sqrt

class PhuongTrinhActivity : AppCompatActivity() {
    private var btnTinhNghiem: Button? = null
    private var edtA: EditText? = null
    private var edtB: EditText? = null
    private var edtC: EditText? = null

    private var numberA = ""
    private var numberB = ""
    private var numberC = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phuong_trinh)
        btnTinhNghiem = findViewById(R.id.btn_click)
        edtA = findViewById(R.id.edt_nhapa)
        edtB = findViewById(R.id.edt_nhapb)
        edtC = findViewById(R.id.edt_nhapc)
        btnTinhNghiem?.isEnabled = false
        edtA?.addTextChangedListener {
            numberA = it.toString()
            btnTinhNghiem?.isEnabled = numberA.isNotEmpty() &&
                    numberB.isNotEmpty() &&
                    numberC.isNotEmpty()
        }
        edtB?.addTextChangedListener {
            numberB = it.toString()
            btnTinhNghiem?.isEnabled = numberA.isNotEmpty() &&
                    numberB.isNotEmpty() &&
                    numberC.isNotEmpty()
        }
        edtC?.addTextChangedListener {
            numberC = it.toString()
            btnTinhNghiem?.isEnabled = numberA.isNotEmpty() &&
                    numberB.isNotEmpty() &&
                    numberC.isNotEmpty()
        }
        //Cách khởi tạo interface TextWatcher
//        edtA?.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//                TODO("Not yet implemented")
//            }
//
//        })
        btnTinhNghiem?.setOnClickListener {
            val a = edtA?.text.toString().toDoubleOrNull()
            val b = edtB?.text.toString().toDoubleOrNull()
            val c = edtC?.text.toString().toDoubleOrNull()
            // b ?: giá trị mặc định (khi b = null thì để giá trị mặc định)
            //b != null ? b : 0.0
            timNghiemPhuongTrinhBacHai(a ?:0.0, b ?: 0.0, c ?:0.0)
        }
    }

    //Giá trị a, b, c truyền vào k được bị null
    private fun timNghiemPhuongTrinhBacHai(a: Double, b: Double, c: Double) {
        val denta = b.times(b) - 4.0.div(a).div(c)
        if (denta < 0) {
            Toast.makeText(this, "Phương trình vô nghiệm", Toast.LENGTH_LONG).show()
        } else if (denta == 0.0) {
            Toast.makeText(this,
                "Phương trình có nghiệm kép${(-b)/(2.0.times(a))}",
                Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this,
                "Phương trình có 2 nghiệm\nNghiệm 1:${(-b + sqrt(denta))/(2.0.times(a))}\nNghiệm 2: ${(-b - sqrt(denta))/(2.0.times(a))}",
                Toast.LENGTH_LONG).show()
        }
    }
}
