package com.tunanh.bai8

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var tv_center: TextView? = null
    private lateinit var sqlite: Sqlite
    private var cardView: CardView? = null
    private lateinit var rclv: RecyclerView
    private var adapter: StudentAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        cardView?.setOnClickListener {
            val intent = Intent(this, EditConten::class.java)
            intent.putExtra(type, false)
            startActivity(intent)

        }
        sqlite = Sqlite.getDatabase(this)
        initRecyclerView()


    }


//    private fun getFolder() {
//        val fdList=sqlite.folderitemDao().getAllFolder()
//        Log.e("Main","${fdList.size}")
//        adapter?.additem(fdList as ArrayList<FolderModel>)
//    }

    private fun initRecyclerView() {
        rclv.layoutManager = LinearLayoutManager(this)

        val fdList = sqlite.folderitemDao().getAllFolder() as ArrayList<StudentModel>
        Log.e("Main", "${fdList.size}")
        adapter = StudentAdapter(this, fdList)
        rclv.adapter = adapter
        adapter?.onItemClick = { student, position ->
            val intent = Intent(this, EditConten::class.java)
            intent.putExtra(type, true)
            intent.putExtra("id", student.id)
            intent.putExtra("name", student.name)
            intent.putExtra("address", student.address)
            intent.putExtra("phone", student.phone)
            startActivity(intent)
        }
    }


    private fun initView() {
        cardView = findViewById(R.id.addnewstudent)
        tv_center = findViewById(R.id.tv_center)
        tv_center?.text = getText(R.string.manager_student)
        rclv = findViewById(R.id.rclv_btvn_7)
    }


    companion object {
        const val type = "type"
    }
}




