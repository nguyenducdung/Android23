package com.dungnd.android23.FolderRecycleView

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R

class MyAdapter(private val QlList: ArrayList<Ql>,var context: Context) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = QlList[position]
        holder.img.setImageResource(currentItem.img)
        holder.title.setText(currentItem.title)
        holder.cmt.setText(currentItem.cmt)
        holder.itemView.setOnClickListener {
            val title : String = holder.title.text.toString()
            val cmt : String = holder.cmt.text.toString()
            val intent: Intent = Intent(context,Tab2Activity :: class.java)
            intent.putExtra("datatitle", title)
            intent.putExtra("datacontent", cmt)
            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return QlList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       val title: TextView = itemView.findViewById(R.id.tvTitle)
        val img : ImageView = itemView.findViewById(R.id.imgfolder)
        val cmt : TextView = itemView.findViewById(R.id.tvCmt)
    }
}