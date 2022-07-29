package com.dungnd.android23.FolderRecycleView

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.widget.EditText
import android.widget.TextView
import com.dungnd.android23.R

class Tab2Activity : AppCompatActivity() {
    var edttitle: EditText? = null
    var edtcontent : EditText? = null
    var tvsua:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab2)
        edttitle = findViewById(R.id.edttitle)
        edtcontent = findViewById(R.id.edtcontent)
        tvsua = findViewById(R.id.tvluu)
        val intent : Intent = intent
        val title : String? = intent.getStringExtra("datatitle")
        val edittabletitle : Editable = SpannableStringBuilder(title)
        val content : String? = intent.getStringExtra("datacontent")
        val editablecontent : Editable = SpannableStringBuilder(content)
        edttitle?.text = edittabletitle
        edtcontent?.text = editablecontent
        tvsua?.setOnClickListener {
            val intent : Intent = Intent()
            intent.putExtra("datatitle2", edttitle?.text.toString())
            intent.putExtra("datacontent2", edtcontent?.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}