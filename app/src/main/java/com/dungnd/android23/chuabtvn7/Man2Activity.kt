package com.dungnd.android23.chuabtvn7

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.widget.EditText
import android.widget.TextView
import com.dungnd.android23.MainActivity
import com.dungnd.android23.R

class Man2Activity : AppCompatActivity() {
    var edttitle : EditText? = null
    var edtcontent : EditText? = null
    var tvsua : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man2)
        edttitle = findViewById(R.id.edt_edittitle)
        edtcontent = findViewById(R.id.edt_editcontent)
        tvsua = findViewById(R.id.tv_sua)

        val folder = intent.extras?.get("folder") as? Folder
        if (folder != null) {
            edttitle?.setText(folder.title)
            edtcontent?.setText(folder.content)
        }
        tvsua?.setOnClickListener {
            //?:"", nghĩa là khi edttitle?.text?.toString() bị null thì ta để title là rỗng
            //Set lại các giá trị title, content cho biến folder để truyền lại về màn 1
            folder?.title = edttitle?.text?.toString() ?:""
            folder?.content = edtcontent?.text?.toString() ?:""
            val intent : Intent = Intent()
            intent.putExtra("folder", folder)
            intent.putExtra(Man1Activity.KEY, Man1Activity.TYPE_EDIT)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}