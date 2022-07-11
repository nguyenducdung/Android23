package com.dungnd.android23

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(var array: ArrayList<fileitem>) : RecyclerView.Adapter<RecyclerViewAdapter.ItemHolder>() {
    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvtitle : TextView = itemView.findViewById(R.id.tv_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var fileitem = array.get(position)
        holder.tvtitle.text = fileitem.title
    }

    override fun getItemCount(): Int {
        return array.size
    }
}