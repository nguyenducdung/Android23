package com.dungnd.android23.FolderRecycleView

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R

class Tab1Activity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList:ArrayList<Ql>

    lateinit var imageId: Array<Int>
    lateinit var heading:Array<String>
    lateinit var cmt: Array<String>
    lateinit var ql: Array<String>
    private var tvthem : TextView? = null
    private var tenthumuc : String? = null
    private var motathumuc : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab1)

        imageId = arrayOf(
            R.drawable.ic_book,
            R.drawable.ic_book,
            R.drawable.ic_book,
            R.drawable.ic_book,
            R.drawable.ic_book,
            R.drawable.ic_book,
        )
        heading = arrayOf(
            "Tổng hợp tin tức thời sự",
            "Do It Your Self",
            "Cảm hứng sáng tạo",
            "Tổng hợp tin tức thời sự",
            "Do It Your Self",
            "Cảm hứng sáng tạo"
        )
        cmt = arrayOf(
            "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ...",
            "Sơn tùng MTP quá đẹp trai hát hay",
            "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ...",
            "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ...",
            "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ...",
            "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ..."
        )


        newRecyclerView =findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Ql>()
        getQuanlydata()


    }

    private fun getQuanlydata() {
        for (i in imageId.indices){
            val ql = Ql(imageId[i],heading[i],cmt[i])
            newArrayList.add(ql)

        }

        var adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter

        val startForResult1 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK){
                tenthumuc = result.data?.extras?.getString("datatenthumuc")
                motathumuc = result.data?.extras?.getString("datamota")
                arrayOf(heading.toString(),cmt.toString())
                adapter.notifyDataSetChanged()
            }
        }
        tvthem?.setOnClickListener{
            val intent = Intent(this, Tab3Activity::class.java)
            startForResult1.launch(intent)
        }


    }
}