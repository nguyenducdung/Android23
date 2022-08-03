package com.example.tuananh;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class EditConten : AppCompatActivity() {
    var imgback: ImageView? = null
    var tv_left: TextView? = null
    var tv_center: TextView? = null
    var tv_right: TextView? = null
    var rclv: RecyclerView? = null
    var edt_title:EditText?=null
    var edt_description:EditText?=null
    private lateinit var sqlite: Sqlite
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_conten)
        initView()
        sqlite=Sqlite(this)
        val type = intent.extras!!.getBoolean(MainActivity.type)
        if (type) {
            addFolder()

        }

    }

    private fun addFolder() {
        imgback!!.visibility = View.GONE
        tv_left!!.visibility = View.VISIBLE
        tv_left!!.setOnClickListener {
            super.onBackPressed()
        }
        tv_center!!.text=getText(R.string.add_folder)
        tv_right!!.text=getText(R.string.save)
        tv_right!!.setOnClickListener {
            addFolderToSqlite()
        }
    }

    private fun addFolderToSqlite() {
        val name= edt_title?.text.toString()
        val description= edt_description?.text.toString()
        if (name.isEmpty()||description.isEmpty()){
            Toast.makeText(this, getString(R.string.back), Toast.LENGTH_SHORT).show()
        }else{
            val fd=FolderModel(title = name, content = description)
            val status= sqlite.insertFolder(fd)
            if (status>-1){
                Toast.makeText(this, "Folder Added....", Toast.LENGTH_SHORT).show()
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Record not saved", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun initView() {
        imgback = findViewById(R.id.img_back)
        tv_left = findViewById(R.id.tv_left)
        tv_center = findViewById(R.id.tv_center)
        tv_right = findViewById(R.id.tv_right)
        edt_title=findViewById(R.id.edt_folder_name)
        edt_description=findViewById(R.id.edt_folder_description)
    }

    override fun onBackPressed() {
        Toast.makeText(this, getString(R.string.back), Toast.LENGTH_SHORT).show()
    }
}