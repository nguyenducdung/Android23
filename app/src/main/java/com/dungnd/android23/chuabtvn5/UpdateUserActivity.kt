package com.dungnd.android23.chuabtvn5

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.dungnd.android23.R
import java.text.SimpleDateFormat
import java.util.*

class UpdateUserActivity : AppCompatActivity() {
    private var edtFullName: EditText? = null
    private var edtPhone: EditText? = null
    private var tvDate: TextView? = null
    private var btnUpdate: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user)

        edtPhone = findViewById(R.id.edtPhone)
        edtFullName = findViewById(R.id.edtFullName)
        tvDate = findViewById(R.id.tvDate)
        btnUpdate = findViewById(R.id.btnUpdate)

        edtFullName?.addTextChangedListener {
            setEnableButton()
        }
        edtPhone?.addTextChangedListener {
            setEnableButton()
        }
        tvDate?.setOnClickListener {
            openChooseDate()
        }
        setEnableButton()
    }

    private fun openChooseDate() {
        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayofMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayofMonth)
            updateLable(myCalendar)
        }
        DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show()
    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale("vi", "VN"))
        tvDate?.text = sdf.format(myCalendar.time)
        setEnableButton()
    }

    private fun setEnableButton() {
        btnUpdate?.isEnabled = isEnableButtonUpdate()
        if (isEnableButtonUpdate()) {
            btnUpdate?.background = ContextCompat.getDrawable(this, R.drawable.bg_button_enable)
            btnUpdate?.setTextColor(ContextCompat.getColor(this, R.color.white))
        } else {
            btnUpdate?.background = ContextCompat.getDrawable(this, R.drawable.bg_button_disable)
            btnUpdate?.setTextColor(ContextCompat.getColor(this, R.color.black))
        }
    }

    private fun isEnableButtonUpdate() : Boolean {
        return edtFullName?.text.toString().trim().isNotEmpty() &&
                edtPhone?.text.toString().trim().isNotEmpty() &&
                tvDate?.text.toString().trim().isNotEmpty()
    }
}