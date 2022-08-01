package com.tunanh.bai8

//import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

//import androidx.recyclerview.widget.RecyclerView

class EditConten : AppCompatActivity() {

    private var tv_center: TextView? = null

    //    var rclv: RecyclerView? = null
    private var edt_name: EditText? = null
    private var edt_address: EditText? = null
    private var edt_phone: EditText? = null
    private var btn: Button? = null

    //    private var sqlite: Sqlite?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_conten)
        initView()

        val type = intent.extras!!.getBoolean(MainActivity.type)
        if (type) {
            editFolder()

        } else {
            addFolder()

        }

    }

    private fun editFolder() {

        tv_center!!.text = getText(R.string.edit_student)
        val student = StudentModel(
            intent.extras?.getInt("id")!!.toInt(),
            name = intent.extras?.getString("name").toString(),
            address = intent.extras?.getString("address").toString(),
            intent.extras?.getString("phone").toString()
        )
//        folder.title= intent.extras?.getString("title").toString()
//        folder.content=intent.extras?.getString("content").toString()

        edt_name?.setText(student.name)
        edt_address?.setText(student.address)
        edt_phone?.setText(student.address)
        btn!!.setOnClickListener {
            //?:"", nghĩa là khi edttitle?.text?.toString() bị null thì ta để title là rỗng
            //Set lại các giá trị title, content cho biến folder để truyền lại về màn 1
            val name = edt_name?.text.toString()
            val address = edt_address?.text.toString()
            val phone = edt_phone?.text.toString()
            if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, getString(R.string.back), Toast.LENGTH_SHORT).show()
            } else {
                student.name = name
                student.address = address
                student.phone = phone
                Sqlite.getDatabase(this).folderitemDao().update(student)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }

    }

    private fun addFolder() {

        tv_center!!.text = getText(R.string.add_student)
        btn!!.setOnClickListener {
            addFolderToSqlite()
        }

    }

    private fun addFolderToSqlite() {
        val name = edt_name?.text.toString()
        val address = edt_address?.text.toString()
        val phone = edt_phone?.text.toString()

        if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, getString(R.string.back), Toast.LENGTH_SHORT).show()
        } else {
            val fd = StudentModel(
                id = System.currentTimeMillis().toInt(),
                name = name,
                address = address,
                phone = phone
            )
            Sqlite.getDatabase(this).folderitemDao().insert(fd)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

//            if (status>-1){
//                Toast.makeText(this, "Folder Added....", Toast.LENGTH_SHORT).show()
//                val intent=Intent(this,MainActivity::class.java)
//                startActivity(intent)
//            }else{
//                Toast.makeText(this, "Record not saved", Toast.LENGTH_SHORT).show()
//            }
        }
    }


    private fun initView() {
        edt_phone = findViewById(R.id.edt_sv_phone)
        tv_center = findViewById(R.id.tv_center)
        btn = findViewById(R.id.btn_save)
        edt_name = findViewById(R.id.edt_folder_name)
        edt_address = findViewById(R.id.edt_sv_address)
    }


}