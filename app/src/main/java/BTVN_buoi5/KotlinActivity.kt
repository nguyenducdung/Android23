package BTVN_buoi5

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

class KotlinActivity : AppCompatActivity() {
    private lateinit var tvDate: TextView
    private lateinit var btnDate: Button

    private var tvNext: TextView? = null
    private var edtName: EditText? = null
    private var edtPhone: EditText? = null
    private var edtEmail: EditText? = null
    private var edtCMT: EditText? = null


    private var fullName = ""
    private var phone = ""
    private var gmail = ""
    private var date = ""
    private var cmt = ""

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        btnDate = findViewById(R.id.btnDate)

        val myCalendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayofMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayofMonth)
            updateLable(myCalendar)
        }

        btnDate.setOnClickListener {
            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        btnDate = findViewById(R.id.btnDate)
        edtName = findViewById(R.id.edtName)
        edtPhone = findViewById(R.id.edtPhone)
        edtEmail = findViewById(R.id.edtEmail)
        edtCMT = findViewById(R.id.edtCMT)
        tvNext = findViewById(R.id.tvNext)
        tvNext?.isEnabled = false
        edtName?.addTextChangedListener {
            fullName = it.toString()
            tvNext?.isEnabled = fullName.isNotEmpty() && phone.isNotEmpty() && gmail.isNotEmpty() && date.isNotEmpty() && cmt.isNotEmpty()
        }
        btnDate?.addTextChangedListener {
            date = it.toString()
            tvNext?.isEnabled = fullName.isNotEmpty() && phone.isNotEmpty() && gmail.isNotEmpty() && date.isNotEmpty() && cmt.isNotEmpty()
        }
        edtPhone?.addTextChangedListener {
            phone = it.toString()
            tvNext?.isEnabled = fullName.isNotEmpty() && phone.isNotEmpty() && gmail.isNotEmpty() && date.isNotEmpty() && cmt.isNotEmpty()
            if (it?.length!! > 10) {
                edtPhone?.error = "Nhập tối đa 10 ký tự"
            } else {
                edtPhone?.error = null
            }

        }
        edtEmail?.addTextChangedListener {
            gmail = it.toString()
            tvNext?.isEnabled = fullName.isNotEmpty() && phone.isNotEmpty() && gmail.isNotEmpty() && date.isNotEmpty() && cmt.isNotEmpty()
            if (Patterns.EMAIL_ADDRESS.matcher(gmail).matches()) {
                edtEmail?.error = null
            } else {
                edtEmail?.error = "Email của bạn không đúng. Vui lòng nhập lại"
            }
        }
        edtCMT?.addTextChangedListener {
            cmt = it.toString()
            tvNext?.isEnabled = fullName.isNotEmpty() && phone.isNotEmpty() && gmail.isNotEmpty() && date.isNotEmpty() && cmt.isNotEmpty()
        }

        tvNext?.setOnClickListener {
            if (tvNext?.isEnabled == true) {
                Toast.makeText(this, "Cập nhật thông tin thành công!", Toast.LENGTH_SHORT).show()
            }
        }


    }


    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        btnDate.setText(sdf.format(myCalendar.time))
    }


}
