package com.dungnd.android23

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Man1Activity() : AppCompatActivity() {
    private var recyclerView : RecyclerView? = null
    private var tvthem : TextView? = null
    private var tenthumuc : String? = null
    private var motathumuc : String? = null
    var content : String? = null
    var title : String? = null
    private val array : ArrayList<Folder> = ArrayList()
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man1)
        recyclerView = findViewById(R.id.recyclerview)
        tvthem = findViewById(R.id.tv_them)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = linearLayoutManager
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView?.addItemDecoration(dividerItemDecoration)
        array.add(Folder("Tổng hợp tin tức thời sự", "tổng hợp tin tức thời sự nóng hổi nhất của tất cả các miền trên dất nước"))
        array.add(Folder("Do It Your Self", "Sơn Tùng M-TP đẹp trai hát hay"))
        array.add(Folder("Cảm hứng sáng tạo","tổng hợp tin tức thời sự nóng hổi nhất của tất cả các miền trên dất nước"))
        array.add(Folder("Cảm hứng sáng tạo","tổng hợp tin tức thời sự nóng hổi nhất của tất cả các miền trên dất nước"))
        array.add(Folder("Cảm hứng sáng tạo","tổng hợp tin tức thời sự nóng hổi nhất của tất cả các miền trên dất nước"))
        array.add(Folder("Cảm hứng sáng tạo","tổng hợp tin tức thời sự nóng hổi nhất của tất cả các miền trên dất nước"))
        val reyclerviewAdapter = RecyclerviewAdapter(this, array)
        recyclerView?.adapter = reyclerviewAdapter
        val startForResult1 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                tenthumuc = result.data?.extras?.getString("datatenthumuc")
                motathumuc = result.data?.extras?.getString("datamota")
                array.add(Folder(tenthumuc.toString(), motathumuc.toString()))
                reyclerviewAdapter.notifyDataSetChanged()
            }
        }
        tvthem?.setOnClickListener{
            val intent = Intent(this, Man3Activity::class.java)
            startForResult1.launch(intent)
        }
        title = intent.getStringExtra("datatitle2")
        content = intent.getStringExtra("datacontent2")
    }
}