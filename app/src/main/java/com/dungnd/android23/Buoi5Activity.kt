package com.dungnd.android23

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.LocaleList
import android.util.Patterns
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.widget.addTextChangedListener
import com.dungnd.android23.R
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*

class Buoi5Activity : AppCompatActivity() {
    private var edthoten : EditText? = null
    private var edtns : EditText? = null
    private var edtSDT : EditText? = null
    private var edtemail : EditText? =null
    private var edtcmt : EditText? = null
    private var btncapnhap : Button? = null
    private var hoten: String = ""
    private var ns : String = ""
    private var sdt : String = ""
    private var cmt : String = ""
    private var email : String = ""
    private lateinit var btnNgaysinh: Button


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi5)
        edthoten = findViewById(R.id.edtHoTen)
        btnNgaysinh = findViewById(R.id.btnNgaysinh)
        edtSDT = findViewById(R.id.edtSDT)
        edtemail = findViewById(R.id.edtEmail)
        edtcmt = findViewById(R.id.edtSocmt)
        btncapnhap = findViewById(R.id.btnCapnhap)
        btncapnhap?.isEnabled = false



        val myCalendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayofMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayofMonth)
            updateLable(myCalendar)
        }

        btnNgaysinh.setOnClickListener {
            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
        edthoten?.addTextChangedListener {
            hoten = it.toString()
            btncapnhap?.isEnabled = hoten.isNotEmpty() && sdt.isNotEmpty() && email.isNotEmpty() && ns.isNotEmpty() && cmt.isNotEmpty()
        }
        edtns?.addTextChangedListener {
            ns = it.toString()
            btncapnhap?.isEnabled = hoten.isNotEmpty() && sdt.isNotEmpty() && email.isNotEmpty() && ns.isNotEmpty() && cmt.isNotEmpty()
        }
        edtSDT?.addTextChangedListener{
            sdt = it.toString()
           btncapnhap?.isEnabled = hoten.isNotEmpty() && sdt.isNotEmpty() && email.isNotEmpty()&& ns.isNotEmpty()&& cmt.isNotEmpty()
            if (it?.length !!>10){
                edtSDT?.error = "Nhập tối đa 10 ký tự"
            }else{
                edtSDT?.error = null
            }

        }
        edtemail?.addTextChangedListener{
            email = it.toString()
            btncapnhap?.isEnabled = hoten.isNotEmpty()&& sdt.isNotEmpty()&& email.isNotEmpty()&& ns.isNotEmpty() && cmt.isNotEmpty()
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                edtemail?.error = null
            }else{
                edtemail?.error = "Email của bạn không hợp lệ "

            }
        }
        edtcmt?.addTextChangedListener{
            cmt = it.toString()
            if(it?.length!! > 12){
                edtcmt?.error = "Chứng minh thư không hợp lệ"
            }
            btncapnhap?.isEnabled = hoten.isNotEmpty()&& sdt.isNotEmpty() && email.isNotEmpty() && ns.isNotEmpty()&& cmt.isNotEmpty()
        }

        btncapnhap?.setOnClickListener {
            if (btncapnhap?.isEnabled == true){
                Toast.makeText(this,"Cập nhập thàng công",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        btnNgaysinh.setText(sdf.format(myCalendar.time))
    }

}

    
