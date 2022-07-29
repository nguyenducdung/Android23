package com.dungnd.android23.a

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R

class QlAdapter(var array: ArrayList<Quanly>) : RecyclerView.Adapter<QlAdapter.QuanlyVH>() {
     class QuanlyVH(view: View): RecyclerView.ViewHolder(view){
        var title = view.findViewById<TextView>(R.id.tvTitle)
         var Cmt = view.findViewById<TextView>(R.id.tvCmt)
         var img : ImageView = itemView.findViewById(R.id.imgfolder)

        }
    private var title = arrayOf("Tổng hợp tin tức thời sự",
        "Do It Your Self",
        "Cảm hứng sáng tạo",
        "Tổng hợp tin tức thời sự",
        "Do It Your Self",
        "Cảm hứng sáng tạo")
    private var Cmt = arrayOf("Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ...",
    "Sơn tùng MTP quá đẹp trai hát hay",
    "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ...",
    "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ...",
    "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ...",
    "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ...",)
    private val img = intArrayOf(R.drawable.ic_food,
        R.drawable.ic_food,
        R.drawable.ic_food,
        R.drawable.ic_food,
        R.drawable.ic_food,
        R.drawable.ic_food,)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuanlyVH {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_quanly,parent,false)
            return QuanlyVH(view)
    }
    var onClick : ((String) -> Unit)? = null

    override fun onBindViewHolder(holder: QuanlyVH, position: Int) {
        val quanly : Quanly = array.get(position)
        holder.img.setImageResource(quanly.image)
        holder.title.setText(quanly.title)
        holder.Cmt.setText(quanly.cmt)
        holder.itemView.setOnClickListener {
            onClick?.invoke("Ban Da click chon")
        }

    }

    override fun getItemCount(): Int {
        return title.size
    }
}

