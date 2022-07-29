package buoi7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.dungnd.android23.R
import com.google.firebase.firestore.FirebaseFirestore

class Buoi7Activity_Add : AppCompatActivity() {
    lateinit var tvCancel: TextView
    lateinit var edtPost: EditText
    lateinit var edtContent: EditText
    lateinit var tvSaveAdd: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi7_add)
        tvCancel = findViewById(R.id.tvCancel)
        setOnClickCancel()
        edtPost = findViewById(R.id.edtPost)
        edtContent = findViewById(R.id.edtContent)
        tvSaveAdd = findViewById(R.id.tvSaveAdd)

        tvSaveAdd.setOnClickListener {
            val buoi7item = Buoi7().apply {
                this.tvName = edtPost.text.toString()
                this.tvCmt = edtContent.text.toString()
            }
            Activitybuoi7.buoi7List.add(0, buoi7item)
            Toast.makeText(this, "Thêm thành công!", Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    fun setOnClickCancel() {
        tvCancel.setOnClickListener {
            val intent: Intent = Intent(this, Activitybuoi7::class.java)
            startActivity(intent)
        }
    }


}