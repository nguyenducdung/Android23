package buoi7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R

class Activitybuoi7 : AppCompatActivity() {
    lateinit var rcvData: RecyclerView

    companion object {
        val buoi7List: MutableList<Buoi7> = ArrayList()
    }


    lateinit var tvAdd: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)
        rcvData = findViewById(R.id.rcvData)
        tvAdd = findViewById(R.id.tvAdd)
        addData()
        initRecyclerView()
        setOnClickAdd()
    }


    fun addData() {
        val buoi7item1 = Buoi7().apply {
            this.tvName = "Tổng hợp tin tức thời sự"
            this.tvCmt = "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các"
        }
        val buoi7item2 = Buoi7().apply {
            this.tvName = "Do It Your Self"
            this.tvCmt = "Sơn tùng MTP quá đẹp trai hát hay"
        }
        val buoi7item3 = Buoi7().apply {
            this.tvName = "Cảm hứng sáng tạo"
            this.tvCmt = "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các"
        }
        val buoi7item4 = Buoi7().apply {
            this.tvName = "Tổng hợp tin tức thời sự"
            this.tvCmt = "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các"
        }
        val buoi7item5 = Buoi7().apply {
            this.tvName = "Do It Your Self"
            this.tvCmt = "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các"
        }
        val buoi7item6 = Buoi7().apply {
            this.tvName = "Cảm hứng sáng tạo"
            this.tvCmt = "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các"
        }
        buoi7List.add(buoi7item1)
        buoi7List.add(buoi7item2)
        buoi7List.add(buoi7item3)
        buoi7List.add(buoi7item4)
        buoi7List.add(buoi7item5)
        buoi7List.add(buoi7item6)

    }


    fun initRecyclerView() {
        val adapter = Buoi7Adapter(buoi7List)
        rcvData.adapter = adapter
        adapter.onClickitem = { Buoi7 ->
            Toast.makeText(this, "${Buoi7.tvName}", Toast.LENGTH_SHORT).show();
        }
    }

    fun setOnclickEdit() {
        val intent: Intent = Intent(this@Activitybuoi7, Buoi7Activity_Edit::class.java)
        startActivity(intent)
    }


    fun setOnClickAdd() {
        tvAdd.setOnClickListener {
            val intent: Intent = Intent(this@Activitybuoi7, Buoi7Activity_Add::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        rcvData.adapter?.notifyDataSetChanged()
    }
}


