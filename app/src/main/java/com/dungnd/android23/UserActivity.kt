package com.dungnd.android23

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.widget.addTextChangedListener
import java.text.SimpleDateFormat
import java.util.*

class UserActivity : AppCompatActivity() {
    private var linearlayoutDate : LinearLayout? = null
    private var edtfullname : EditText? = null
    private var edtdate : EditText? = null
    private var edtphonenumber : EditText? = null
    private var edtemail : EditText? = null
    private var edtcmt : EditText? = null
    private var btnconfirm : Button? = null
    private var fullname : String = ""
    private var date : String = ""
    private var sdt : String = ""
    private var email : String = ""
    private var cmt : String = ""
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        linearlayoutDate = findViewById(R.id.linearlayout_date)
        edtfullname = findViewById(R.id.edt_fullname)
        edtdate = findViewById(R.id.edt_date)
        edtphonenumber = findViewById(R.id.edt_phonenumber)
        edtemail = findViewById(R.id.edt_email)
        edtcmt = findViewById(R.id.edt_cmt)
        btnconfirm = findViewById(R.id.btn_confirm)
        btnconfirm?.isEnabled = false
        edtfullname?.addTextChangedListener {
            fullname = it.toString()
            btnconfirm?.isEnabled = fullname.isNotEmpty() && date.isNotEmpty() && sdt.isNotEmpty() && email.isNotEmpty() && cmt.isNotEmpty()
        }
        edtdate?.addTextChangedListener {
            date = it.toString()
            btnconfirm?.isEnabled = fullname.isNotEmpty() && date.isNotEmpty() && sdt.isNotEmpty() && email.isNotEmpty() && cmt.isNotEmpty()
        }
        edtphonenumber?.addTextChangedListener {
            sdt = it.toString()
            if(it?.length!! > 10) {
                edtphonenumber?.error = "số điện thoại không hợp lệ"
            }
            btnconfirm?.isEnabled = fullname.isNotEmpty() && date.isNotEmpty() && sdt.isNotEmpty() && email.isNotEmpty() && cmt.isNotEmpty()
        }
        edtemail?.addTextChangedListener {
            email = it.toString()
            if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            }else{
                edtemail?.error = "email không hợp lệ"
            }
            btnconfirm?.isEnabled = fullname.isNotEmpty() && date.isNotEmpty() && sdt.isNotEmpty() && email.isNotEmpty() && cmt.isNotEmpty()
        }
        edtcmt?.addTextChangedListener {
            cmt = it.toString()
            if(it?.length!! > 12){
                edtcmt?.error = "chứng minh thư không hợp lệ"
            }
            btnconfirm?.isEnabled = fullname.isNotEmpty() && date.isNotEmpty() && sdt.isNotEmpty() && email.isNotEmpty() && cmt.isNotEmpty()
        }
        linearlayoutDate?.setOnClickListener {
            showdatepickerdialog()
        }
        btnconfirm?.setOnClickListener {
            if(btnconfirm?.isEnabled == true){
                Toast.makeText(this, "xác nhận thông tin", Toast.LENGTH_LONG).show()
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.N)
    private fun showdatepickerdialog() {
        val calendar : Calendar = Calendar.getInstance()
        val day : Int = calendar.get(Calendar.DAY_OF_MONTH)
        val month : Int = calendar.get(Calendar.MONTH)
        val year : Int = calendar.get(Calendar.YEAR)
        val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view: DatePicker?, year: Int, month: Int, dayOfMonth: Int ->
            calendar.set(year, month, dayOfMonth)
            val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
            val date : String = simpleDateFormat.format(calendar.time)
            val editable : Editable = SpannableStringBuilder(date)
            edtdate?.text = editable
        }, year, month, day)
        datePickerDialog.show()
    }
}