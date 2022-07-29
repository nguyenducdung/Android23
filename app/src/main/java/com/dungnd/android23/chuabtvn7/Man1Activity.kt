package com.dungnd.android23.chuabtvn7

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R
import com.dungnd.android23.RecyclerviewAdapter

class Man1Activity : AppCompatActivity() {
    companion object {
        //Những hằng số sẽ được khai báo ở đây, chúng ta có thể dùng ở mọi chỗ
        const val KEY = "KEY"
        const val TYPE_EDIT = "TYPE_EDIT"
        const val TYPE_ADD = "TYPE_ADD"
    }
    private var recyclerView : RecyclerView? = null
    private var tvthem : TextView? = null
    private var tenthumuc : String? = null
    private var motathumuc : String? = null
    private val array : ArrayList<Folder> = ArrayList()
    private var reyclerviewAdapter: RecyclerviewAdapter? = null
    private val startForResult1 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val type = result.data?.extras?.getString(KEY)
            if (type == TYPE_ADD) {
                val folder = result.data?.extras?.get("folder") as? Folder
                if (folder != null) {
                    array.add(0, folder)
                }
                reyclerviewAdapter?.notifyDataSetChanged()
            } else if (type == TYPE_EDIT) {
                val folder = result.data?.extras?.get("folder") as? Folder
                if (folder != null) {
                    //Cập nhật lại dữ liệu cho array
                    for (item in array) {
                        if (item.id == folder.id) {
                            item.title = folder.title
                            item.content = folder.content
                            break
                        }
                    }
                    reyclerviewAdapter?.notifyDataSetChanged()
                }
            }
        }
    }

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
        array.add(Folder(1, "Tổng hợp tin tức thời sự", "tổng hợp tin tức thời sự nóng hổi nhất của tất cả các miền trên dất nước"))
        array.add(Folder(2, "Do It Your Self", "Sơn Tùng M-TP đẹp trai hát hay"))
        array.add(Folder(3, "Cảm hứng sáng tạo","tổng hợp tin tức thời sự nóng hổi nhất của tất cả các miền trên dất nước"))
        array.add(Folder(4, "Cảm hứng sáng tạo","tổng hợp tin tức thời sự nóng hổi nhất của tất cả các miền trên dất nước"))
        array.add(Folder(5, "Cảm hứng sáng tạo","tổng hợp tin tức thời sự nóng hổi nhất của tất cả các miền trên dất nước"))
        array.add(Folder(6, "Cảm hứng sáng tạo","tổng hợp tin tức thời sự nóng hổi nhất của tất cả các miền trên dất nước"))
        reyclerviewAdapter = RecyclerviewAdapter(this, array)
        recyclerView?.adapter = reyclerviewAdapter
        reyclerviewAdapter?.onItemClick = { folder, position ->
            val intent = Intent(this, Man2Activity::class.java)
            intent.putExtra("folder", folder)
            startForResult1.launch(intent)
        }
        reyclerviewAdapter?.onItemClick2 = {

        }

        tvthem?.setOnClickListener{
            val intent = Intent(this, Man3Activity::class.java)
            startForResult1.launch(intent)
        }
    }
}